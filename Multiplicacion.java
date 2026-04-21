public class Multiplicacion implements Operacion {
    @Override
    public double ejecutar(double... operandos) {
        return operandos[0] * operandos[1];
    }
}
