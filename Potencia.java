public class Potencia implements OperacionBinaria {
    @Override
    public double ejecutar(double a, double b) {
        return Math.pow(a, b);
    }
}
