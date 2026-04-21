import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class DependencyInversionTest {
    
    @Test
    public void testInyeccionDeDependenciasEnMotor() {
        // En este test, NO dependemos de todas las implementaciones reales.
        // Simulamos o limitamos la inyección para probar que el Motor
        // confía en las abstracciones, sin importar de dónde vengan.
        
        Map<String, OperacionBinaria> mockBinarias = new HashMap<>();
        mockBinarias.put("+", (a, b) -> a + b); // Función anónima simulando la Suma
        
        Map<String, OperacionUnaria> mockUnarias = new HashMap<>();
        mockUnarias.put("abs", (a) -> Math.abs(a)); // Operación arbitraria inyectada

        // Act: Inyectamos mediante el constructor (Inversion de Control)
        MotorCalculadora motor = new MotorCalculadora(mockBinarias, mockUnarias);
        
        // Assert: El motor sabe trabajar con lo que se le inyectó
        assertEquals(5.0, motor.evaluarBinaria("+", 2.0, 3.0), 0.001);
        assertEquals(4.0, motor.evaluarUnaria("abs", -4.0), 0.001);
        
        // Comprobar que no hace 'magic', si no lo inyectamos no lo soporta
        assertThrows(UnsupportedOperationException.class, () -> {
            motor.evaluarBinaria("-", 5, 2);
        });
    }
}
