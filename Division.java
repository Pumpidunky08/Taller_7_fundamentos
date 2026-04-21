public class Division implements Operacion {
    @Override
    public int getNumeroOperandos() { return 2; }

    @Override
    public double ejecutar(double... operandos) {
        if (operandos.length < getNumeroOperandos()) {
            throw new IllegalArgumentException("La división requiere 2 operandos.");
        }
        if (operandos[1] == 0) {
            throw new ArithmeticException("División por cero no permitida.");
        }
        return operandos[0] / operandos[1];
    }
}
