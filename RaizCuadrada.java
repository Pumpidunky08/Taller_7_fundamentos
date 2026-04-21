public class RaizCuadrada implements Operacion {
    @Override
    public int getNumeroOperandos() { return 1; }

    @Override
    public double ejecutar(double... operandos) {
        if (operandos.length < getNumeroOperandos()) {
            throw new IllegalArgumentException("La raíz cuadrada requiere 1 operando.");
        }
        if (operandos[0] < 0) {
            throw new IllegalArgumentException("No se puede calcular la raíz cuadrada de un número negativo.");
        }
        return Math.sqrt(operandos[0]);
    }
}
