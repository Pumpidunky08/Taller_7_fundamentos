/**
 * Interfaz segregada exclusivamente para operaciones binarias (2 números).
 */
public interface OperacionBinaria {
    double ejecutar(double a, double b) throws ArithmeticException, IllegalArgumentException;
}
