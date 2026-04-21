public interface Operacion {
    /**
     * Define cuántos operandos requiere esta operación
     * para asegurar que el cliente la invoque correctamente.
     */
    int getNumeroOperandos();

    /**
     * Ejecuta la operación matemática.
     * @throws IllegalArgumentException si la cantidad o el valor de los operandos no cumple las reglas del dominio de la operación
     * @throws ArithmeticException si hay un error aritmético de la operación (ej. División por cero)
     */
    double ejecutar(double... operandos) throws IllegalArgumentException, ArithmeticException;
}
