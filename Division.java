public class Division implements Operacion {
    @Override
    public double ejecutar(double... operandos) {
        if (operandos[1] == 0) {
            throw new ArithmeticException("División por cero no permitida.");
        }
        return operandos[0] / operandos[1];
    }
}
