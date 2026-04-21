import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ValidadorEntrada validador = new ValidadorEntrada();

        // Registro de operaciones (Open/Closed Principle)
        Map<String, Operacion> operaciones = new HashMap<>();
        operaciones.put("+", new Suma());
        operaciones.put("-", new Resta());
        operaciones.put("*", new Multiplicacion());
        operaciones.put("/", new Division());
        operaciones.put("^", new Potencia());
        operaciones.put("raiz", new RaizCuadrada());
        operaciones.put("ln", new LogaritmoNatural());

        boolean continuar = true;

        System.out.println("=== Calculadora SOLID (SRP + OCP) ===");

        while (continuar) {
            System.out.println("\nOperaciones disponibles: +, -, *, /, ^ (potencia), raiz, ln");
            System.out.println("Escriba 'salir' para terminar.");
            System.out.print("Ingrese la operación que desea realizar: ");
            String opKey = scanner.nextLine().toLowerCase();

            if (opKey.equals("salir")) {
                continuar = false;
                System.out.println("¡Hasta luego!");
                continue;
            }

            if (!operaciones.containsKey(opKey)) {
                System.out.println("Operación no soportada. Intente de nuevo.");
                continue;
            }

            Operacion operacion = operaciones.get(opKey);
            
            try {
                double resultado;
                // Simplificación para determinar cantidad de argumentos,
                // idealmente la Interfaz u otro decorador nos diría si es unaria o binaria,
                // pero lo mantenemos simple para el objetivo del ejercicio.
                if (opKey.equals("raiz") || opKey.equals("ln")) {
                    double num = validador.leerEntero(scanner, "Ingrese el número: ");
                    resultado = operacion.ejecutar(num);
                } else {
                    double num1 = validador.leerEntero(scanner, "Ingrese el primer número: ");
                    double num2 = validador.leerEntero(scanner, "Ingrese el segundo número: ");
                    resultado = operacion.ejecutar(num1, num2);
                }
                
                System.out.println("Resultado: " + resultado);
            } catch (Exception e) {
                System.out.println("Error Matemático: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
