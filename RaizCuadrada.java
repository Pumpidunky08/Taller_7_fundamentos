public class RaizCuadrada implements OperacionUnaria {
    @Override
    public double ejecutar(double a) {
        if (a < 0) {
            throw new IllegalArgumentException("No se puede calcular la raíz cuadrada de un número negativo.");
        }
        return Math.sqrt(a);
    }
}
