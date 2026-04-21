import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ValidadorEntrada validador = new ValidadorEntrada();

        // Segregación en mapas distintos basados en su firma/interfaz real
        Map<String, OperacionBinaria> operacionesBinarias = new HashMap<>();
        operacionesBinarias.put("+", new Suma());
        operacionesBinarias.put("-", new Resta());
        operacionesBinarias.put("*", new Multiplicacion());
        operacionesBinarias.put("/", new Division());
        operacionesBinarias.put("^", new Potencia());

        Map<String, OperacionUnaria> operacionesUnarias = new HashMap<>();
        operacionesUnarias.put("raiz", new RaizCuadrada());
        operacionesUnarias.put("ln", new LogaritmoNatural());

        boolean continuar = true;

        System.out.println("=== Calculadora SOLID (SRP + OCP + LSP + ISP) ===");

        while (continuar) {
            System.out.println("\nOperaciones disponibles: +, -, *, /, ^, raiz, ln");
            System.out.println("Escriba 'salir' para terminar.");
            System.out.print("Ingrese la operación que desea realizar: ");
            String opKey = scanner.nextLine().toLowerCase();

            if (opKey.equals("salir")) {
                continuar = false;
                System.out.println("¡Hasta luego!");
                continue;
            }

            try {
                if (operacionesBinarias.containsKey(opKey)) {
                    OperacionBinaria op = operacionesBinarias.get(opKey);
                    double num1 = validador.leerEntero(scanner, "Ingrese el primer operando: ");
                    double num2 = validador.leerEntero(scanner, "Ingrese el segundo operando: ");
                    System.out.println("Resultado: " + op.ejecutar(num1, num2));
                    
                } else if (operacionesUnarias.containsKey(opKey)) {
                    OperacionUnaria op = operacionesUnarias.get(opKey);
                    double num = validador.leerEntero(scanner, "Ingrese el operando: ");
                    System.out.println("Resultado: " + op.ejecutar(num));
                    
                } else {
                    System.out.println("Operación no soportada. Intente de nuevo.");
                }
            } catch (IllegalArgumentException | ArithmeticException e) {
                System.out.println("Error Matemático / Argumentos: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error Inesperado: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
