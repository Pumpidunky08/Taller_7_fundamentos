import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Composition Root (Punto de Entrada).
 * Único lugar donde el "new" está permitido para unir las piezas concretas.
 */
public class Calculadora {

    public static void main(String[] args) {
        
        // 1. CREACIÓN DE LAS PIEZAS CONCRETAS (Implementaciones)
        Map<String, OperacionBinaria> binarias = new HashMap<>();
        binarias.put("+", new Suma());
        binarias.put("-", new Resta());
        binarias.put("*", new Multiplicacion());
        binarias.put("/", new Division());
        binarias.put("^", new Potencia());

        Map<String, OperacionUnaria> unarias = new HashMap<>();
        unarias.put("raiz", new RaizCuadrada());
        unarias.put("ln", new LogaritmoNatural());

        Scanner scanner = new Scanner(System.in);
        ValidadorEntrada validador = new ValidadorEntrada();

        // 2. INYECCIÓN DE DEPENDENCIAS (Wiring)
        MotorCalculadora motor = new MotorCalculadora(binarias, unarias);
        CalculadoraConsola ui = new CalculadoraConsola(motor, validador, scanner);

        // 3. EJECUCIÓN (Arranque del sistema)
        ui.iniciar();
        
        scanner.close();
    }
}
