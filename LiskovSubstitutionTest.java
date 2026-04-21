import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LiskovSubstitutionTest {

    @Test
    public void testOperacionVerificaCantidadOperandos() {
        Operacion suma = new Suma();
        // Si no se proveen suficientes operandos, en lugar de un error de índice,
        // debe fallar siguiendo el contrato (IllegalArgumentException).
        assertThrows(IllegalArgumentException.class, () -> suma.ejecutar(5.0));
    }

    @Test
    public void testRaizCuadradaVerificaContrato() {
        Operacion raiz = new RaizCuadrada();
        assertThrows(IllegalArgumentException.class, () -> raiz.ejecutar());
        assertThrows(IllegalArgumentException.class, () -> raiz.ejecutar(-4.0));
    }

    @Test
    public void testDivisionVerificaContrato() {
        Operacion division = new Division();
        assertThrows(ArithmeticException.class, () -> division.ejecutar(10.0, 0.0));
        assertThrows(IllegalArgumentException.class, () -> division.ejecutar(5.0));
    }
}
