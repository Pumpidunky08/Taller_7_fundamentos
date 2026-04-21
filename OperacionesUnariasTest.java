import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OperacionesUnariasTest {

    private final OperacionesUnarias operaciones = new OperacionesUnarias();

    @Test
    public void testRaizCuadrada() {
        assertEquals(3.0, operaciones.raizCuadrada(9), 0.001);
    }

    @Test
    public void testRaizCuadradaNegativa() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            operaciones.raizCuadrada(-4);
        });
        assertTrue(exception.getMessage().contains("negativo"));
    }

    @Test
    public void testLogaritmoNatural() {
        assertEquals(0.0, operaciones.logaritmoNatural(1), 0.001);
    }

    @Test
    public void testLogaritmoNaturalNegativoOCero() {
        assertThrows(IllegalArgumentException.class, () -> {
            operaciones.logaritmoNatural(0);
        });
    }
}
