import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PotenciaTest {

    private final Operacion potencia = new Potencia();

    @Test
    public void testPotenciaPositiva() {
        assertEquals(8.0, potencia.ejecutar(2, 3), 0.001);
    }

    @Test
    public void testPotenciaCero() {
        assertEquals(1.0, potencia.ejecutar(5, 0), 0.001);
    }
    
    @Test
    public void testPotenciaNegativa() {
        assertEquals(0.25, potencia.ejecutar(2, -2), 0.001);
    }
}
