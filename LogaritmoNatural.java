public class LogaritmoNatural implements Operacion {
    @Override
    public int getNumeroOperandos() { return 1; }

    @Override
    public double ejecutar(double... operandos) {
        if (operandos.length < getNumeroOperandos()) {
            throw new IllegalArgumentException("El logaritmo natural requiere 1 operando.");
        }
        if (operandos[0] <= 0) {
            throw new IllegalArgumentException("El logaritmo natural solo está definido para números mayores que cero.");
        }
        return Math.log(operandos[0]);
    }
}
