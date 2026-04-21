import java.util.Map;

/**
 * Clase de Lógica de Negocio de ALTO NIVEL.
 * Solo depende de interfaces abstractas. NUNCA hace uso de 'new Suma()' directamente.
 */
public class MotorCalculadora {
    private final Map<String, OperacionBinaria> operacionesBinarias;
    private final Map<String, OperacionUnaria> operacionesUnarias;

    // Se inyectan las dependencias en el constructor
    public MotorCalculadora(Map<String, OperacionBinaria> binarias, Map<String, OperacionUnaria> unarias) {
        this.operacionesBinarias = binarias;
        this.operacionesUnarias = unarias;
    }

    public boolean soportaOperacion(String opKey) {
        return operacionesBinarias.containsKey(opKey) || operacionesUnarias.containsKey(opKey);
    }
    
    public boolean esBinaria(String opKey) {
        return operacionesBinarias.containsKey(opKey);
    }

    public double evaluarBinaria(String opKey, double a, double b) {
        if (!operacionesBinarias.containsKey(opKey)) {
            throw new UnsupportedOperationException("Operación binaria no inyectada o soportada.");
        }
        return operacionesBinarias.get(opKey).ejecutar(a, b);
    }

    public double evaluarUnaria(String opKey, double a) {
        if (!operacionesUnarias.containsKey(opKey)) {
            throw new UnsupportedOperationException("Operación unaria no inyectada o soportada.");
        }
        return operacionesUnarias.get(opKey).ejecutar(a);
    }
}
