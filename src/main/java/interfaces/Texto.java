
package interfaces;

import gestorArchivos.GestorTextos;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Diego Lagos
 */
public class Texto extends JFrame implements ActionListener{
    private JTextArea cuadro_texto;
    private JButton boton_formatear;
    private JButton boton_volver;
    private final Comienzo ventanaInicio;
    private JScrollPane barraDeslizante;
    private JPanel panelInferior;

    public Texto(Comienzo ventanaInicio) {
        super();
        iniciarVentana();
        iniciarComponentes();
        iniciarPanelInferior();
        this.ventanaInicio = ventanaInicio;
    }

    /**
     * Inicia la ventana con sus valores necesarios.
     *
     * @param void
     * @return void
     */
    private void iniciarVentana() {
        this.setTitle("Tarea7");
        this.setSize(800, 500);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Inicia y configura los componentes de la ventana.
     *
     * @param void
     * @return void
     */
    private void iniciarComponentes() {
        boton_formatear = new JButton("Mostrar texto formateado");
        boton_formatear.setBounds(100, 80, 230, 50);
        boton_formatear.addActionListener(this);
        this.add(boton_formatear);
        boton_volver = new JButton("Cargar otro archivo");
        boton_volver.setBounds(470, 80, 230, 50);
        boton_volver.addActionListener(this);
        this.add(boton_volver);
    }

    /**
     * Inicia el panel del inferior de la ventana y también inicia y configura
     * los componentes pertenecientes a dicho panel.
     *
     * @param void
     * @return void
     */
    private void iniciarPanelInferior() {
        panelInferior = new JPanel();
        panelInferior.setBounds(100, 160, 600, 250);
        panelInferior.setLayout(new BorderLayout());
        cuadro_texto = new JTextArea("Aquí aparecerá la información del texto modificado");
        panelInferior.add(cuadro_texto);
        barraDeslizante = new JScrollPane(cuadro_texto, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panelInferior.add(barraDeslizante, BorderLayout.CENTER);
        this.add(panelInferior);
    }

    /**
     * Usa la funcionalidad del gestor de archivos para el contenido del archivo
     * señalado.
     *
     * @throws java.io.IOException
     */
    public void mostrarTexto() throws IOException {
        GestorTextos gestor = new GestorTextos();
        String ubicacion = ventanaInicio.getCuadro().getText();
        switch (ubicacion) {
            case "C:\\Users\\Diego Lagos\\Desktop\\archivos\\archivo1.txt":
                cuadro_texto.setText(gestor.leerTexto1(ubicacion));
                break;
            case "C:\\Users\\Diego Lagos\\Desktop\\archivos\\archivo2.txt":
                cuadro_texto.setText(gestor.leerTexto2(ubicacion));
                break;
            default:
                JOptionPane.showMessageDialog(this, "Introduzca una ruta válida por favor.");
                break;
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton_formatear) {
            try {
                mostrarTexto();
            } catch (IOException ex) {
                Logger.getLogger(Texto.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource() == boton_volver) {
            ventanaInicio.setVisible(true);
            this.setVisible(false);
        }
    }
}
