public class Potencia implements Operacion {
    @Override
    public double ejecutar(double... operandos) {
        return Math.pow(operandos[0], operandos[1]);
    }
}
