import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InterfaceSegregationTest {

    @Test
    public void testOperacionBinariaFirmaEstricta() {
        OperacionBinaria suma = new Suma();
        // La interfaz es clara: solo recibe 2 parámetros fijos, sin arreglos.
        assertEquals(5.0, suma.ejecutar(2.0, 3.0), 0.001);
    }

    @Test
    public void testOperacionUnariaFirmaEstricta() {
        OperacionUnaria raiz = new RaizCuadrada();
        // La interfaz es clara: recibe exactamente 1 parámetro.
        assertEquals(4.0, raiz.ejecutar(16.0), 0.001);
        
        assertThrows(IllegalArgumentException.class, () -> raiz.ejecutar(-5.0));
    }
}
