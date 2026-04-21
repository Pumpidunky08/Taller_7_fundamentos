public class LogaritmoNatural implements OperacionUnaria {
    @Override
    public double ejecutar(double a) {
        if (a <= 0) {
            throw new IllegalArgumentException("El logaritmo natural solo está definido para números mayores que cero.");
        }
        return Math.log(a);
    }
}
