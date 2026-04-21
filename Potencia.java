public class Potencia implements Operacion {
    @Override
    public int getNumeroOperandos() { return 2; }

    @Override
    public double ejecutar(double... operandos) {
        if (operandos.length < getNumeroOperandos()) {
            throw new IllegalArgumentException("La potencia requiere 2 operandos.");
        }
        return Math.pow(operandos[0], operandos[1]);
    }
}
