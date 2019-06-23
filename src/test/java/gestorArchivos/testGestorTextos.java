package gestorArchivos;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Diego Lagos
 */
public class testGestorTextos {

    private GestorTextos gestor;

    public testGestorTextos() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Prueba el método leerTexto1 con un archivo que no existe.
     * 
     * @throws Exception
     */
    @Test
    public void testLeerTexto1() throws Exception {
        String resultado = gestor.leerTexto1("C:\\Users\\Diego Lagos\\Desktop\\archivos\\test1.txt");
        String resultadoEsperado = "el archivo se encuentra vacío";
        assertEquals(resultadoEsperado, resultado);
    }

    /**
     * Prueba el método leerTexto2 con un archivo que no existe.
     * 
     * @throws Exception
     */
    @Test
    public void testLeerTexto2() throws Exception {
        String resultado = gestor.leerTexto2("C:\\Users\\Diego Lagos\\Desktop\\archivos\\test2.txt");
        String resultadoEsperado = "el archivo se encuentra vacío";
        assertEquals(resultadoEsperado, resultado);
    }
}
