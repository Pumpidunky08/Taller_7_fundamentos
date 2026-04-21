public class LogaritmoNatural implements Operacion {
    @Override
    public double ejecutar(double... operandos) {
        if (operandos[0] <= 0) {
            throw new IllegalArgumentException("El logaritmo natural solo está definido para números mayores que cero.");
        }
        return Math.log(operandos[0]);
    }
}
