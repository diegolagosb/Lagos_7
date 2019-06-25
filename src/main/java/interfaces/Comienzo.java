package interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Diego Lagos
 */
public class Comienzo extends JFrame implements ActionListener{
    
    private JTextField cuadro_ubicacionTexto;
    private JButton boton_cargar;
    private int contador_pulsaciones;
    private Texto ventanaGuardada;
    private JTextField ejemplo;

    public Comienzo() {
        super();
        iniciarVentana();
        iniciarComponentes();
    }

    /**
     * Inicia la ventana con sus valores necesarios.
     *
     * @param void
     * @return void
     */
    private void iniciarVentana() {
        this.setTitle("Tarea7");
        this.setSize(600, 400);
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
        contador_pulsaciones = 0;
        Font fuente = new Font("Times new Roman", 3, 20);
        cuadro_ubicacionTexto = new JTextField("Ingrese la ubicación del texto");
        ejemplo = new JTextField("Ejemplo: archivo1.txt");
        boton_cargar = new JButton("Cargar texto");
        cuadro_ubicacionTexto.setBounds(100, 100, 400, 70);
        ejemplo.setBounds(25, 170, 550, 70);
        boton_cargar.setBounds(200, 250, 190, 80);
        boton_cargar.addActionListener(this);
        boton_cargar.setFont(fuente);
        cuadro_ubicacionTexto.setFont(fuente);
        ejemplo.setFont(fuente);
        boton_cargar.setForeground(Color.red);
        cuadro_ubicacionTexto.setForeground(Color.BLUE);
        ejemplo.setForeground(Color.BLUE);
        this.add(cuadro_ubicacionTexto);
        this.add(ejemplo);
        this.add(boton_cargar);
    }

    /**
     * Guarda la ventana ingresada por parámetros en un atributo.
     *
     * @param ventanaGuardada guarda la ventana de tipo Texto.
     */
    public void guardarVentana(Texto ventanaGuardada) {
        this.ventanaGuardada = ventanaGuardada;
    }

    /**
     * Retorna el estado del objeto perteneciente a esta misma clase.
     *
     * @return Objeto de tipo Inicio
     */
    public Comienzo getVentana() {
        return this;
    }

    /**
     * Devuelve un atributo privado.
     *
     * @return atributo de tipo JTextField
     */
    public JTextField getCuadro() {
        return cuadro_ubicacionTexto;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton_cargar) {
            if (contador_pulsaciones == 0) {
                Texto texto = new Texto(getVentana());
                texto.setVisible(true);
                this.setVisible(false);
            } else {
                ventanaGuardada.setVisible(true);
                this.setVisible(false);
            }
        }
    }
}
