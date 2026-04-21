import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OperacionesBinariasTest {

    private final OperacionesBinarias operaciones = new OperacionesBinarias();

    @Test
    public void testSumar() {
        assertEquals(5, operaciones.sumar(2, 3), "2 + 3 debe ser 5");
        assertEquals(-1, operaciones.sumar(-4, 3), "-4 + 3 debe ser -1");
        assertEquals(0, operaciones.sumar(0, 0), "0 + 0 debe ser 0");
    }

    @Test
    public void testRestar() {
        assertEquals(1, operaciones.restar(4, 3), "4 - 3 debe ser 1");
        assertEquals(-7, operaciones.restar(-4, 3), "-4 - 3 debe ser -7");
    }

    @Test
    public void testMultiplicar() {
        assertEquals(12, operaciones.multiplicar(4, 3), "4 * 3 debe ser 12");
        assertEquals(-12, operaciones.multiplicar(-4, 3), "-4 * 3 debe ser -12");
        assertEquals(0, operaciones.multiplicar(5, 0), "5 * 0 debe ser 0");
    }

    @Test
    public void testDividir() {
        assertEquals(2, operaciones.dividir(6, 3), "6 / 3 debe ser 2");
        assertEquals(-2, operaciones.dividir(6, -3), "6 / -3 debe ser -2");
    }

    @Test
    public void testDividirPorCero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            operaciones.dividir(5, 0);
        });
        
        String mensajeEsperado = "División por cero no permitida.";
        String mensajeActual = exception.getMessage();
        
        assertTrue(mensajeActual.contains(mensajeEsperado));
    }
}
