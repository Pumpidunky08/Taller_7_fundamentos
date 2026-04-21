import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ValidadorEntrada validador = new ValidadorEntrada();

        Map<String, Operacion> operaciones = new HashMap<>();
        operaciones.put("+", new Suma());
        operaciones.put("-", new Resta());
        operaciones.put("*", new Multiplicacion());
        operaciones.put("/", new Division());
        operaciones.put("^", new Potencia());
        operaciones.put("raiz", new RaizCuadrada());
        operaciones.put("ln", new LogaritmoNatural());

        boolean continuar = true;

        System.out.println("=== Calculadora SOLID (SRP + OCP + LSP) ===");

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

            if (!operaciones.containsKey(opKey)) {
                System.out.println("Operación no soportada. Intente de nuevo.");
                continue;
            }

            Operacion operacion = operaciones.get(opKey); // ¡Uso genérico gracias a Liskov!
            
            try {
                int numOperandos = operacion.getNumeroOperandos();
                double[] argumentos = new double[numOperandos];

                for (int i = 0; i < numOperandos; i++) {
                    argumentos[i] = validador.leerEntero(scanner, "Ingrese el operando " + (i + 1) + ": ");
                }
                
                double resultado = operacion.ejecutar(argumentos);
                System.out.println("Resultado: " + resultado);

            } catch (IllegalArgumentException | ArithmeticException e) {
                System.out.println("Error Matemático / Argumentos: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error Inesperado: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
