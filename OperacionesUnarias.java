public class OperacionesUnarias {
    public double raizCuadrada(int a) {
        if (a < 0) {
            throw new IllegalArgumentException("No se puede calcular la raíz cuadrada de un número negativo.");
        }
        return Math.sqrt(a);
    }

    public double logaritmoNatural(int a) {
        if (a <= 0) {
            throw new IllegalArgumentException("El logaritmo natural solo está definido para números mayores que cero.");
        }
        return Math.log(a);
    }
}
