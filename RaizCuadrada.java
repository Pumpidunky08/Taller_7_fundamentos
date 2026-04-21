public class RaizCuadrada implements Operacion {
    @Override
    public double ejecutar(double... operandos) {
        if (operandos[0] < 0) {
            throw new IllegalArgumentException("No se puede calcular la raíz cuadrada de un número negativo.");
        }
        return Math.sqrt(operandos[0]);
    }
}
