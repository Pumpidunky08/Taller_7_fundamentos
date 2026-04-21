/**
 * Interfaz segregada exclusivamente para operaciones unarias (1 número).
 */
public interface OperacionUnaria {
    double ejecutar(double a) throws ArithmeticException, IllegalArgumentException;
}
