import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        System.out.println("=== Calculadora en una sola clase ===");
        System.out.println("Nota: Tener todo en una sola clase rompe el principio de Responsabilidad Única (SRP) de SOLID,");
        System.out.println("sin embargo, se ha implementado de esta forma por instrucción explícita del usuario.");

        while (continuar) {
            System.out.println("\nSeleccione el tipo de operación:");
            System.out.println("1. Operación Binaria (+, -, *, /) con enteros");
            System.out.println("2. Operación Unaria (Raíz cuadrada, Logaritmo natural) con un entero");
            System.out.println("3. Salir");
            System.out.print("Opción: ");
            
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    realizarOperacionBinaria(scanner);
                    break;
                case "2":
                    realizarOperacionUnaria(scanner);
                    break;
                case "3":
                    continuar = false;
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        scanner.close();
    }

    private static void realizarOperacionBinaria(Scanner scanner) {
        try {
            System.out.print("Ingrese el primer número entero: ");
            int num1 = Integer.parseInt(scanner.nextLine());

            System.out.print("Ingrese el operador (+, -, *, /): ");
            String operador = scanner.nextLine();

            System.out.print("Ingrese el segundo número entero: ");
            int num2 = Integer.parseInt(scanner.nextLine());

            int resultado = 0;
            switch (operador) {
                case "+":
                    resultado = sumar(num1, num2);
                    break;
                case "-":
                    resultado = restar(num1, num2);
                    break;
                case "*":
                    resultado = multiplicar(num1, num2);
                    break;
                case "/":
                    resultado = dividir(num1, num2);
                    break;
                default:
                    System.out.println("Operador no soportado.");
                    return;
            }
            System.out.println("Resultado: " + resultado);
        } catch (NumberFormatException e) {
            System.out.println("Error: Ingrese números enteros válidos.");
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void realizarOperacionUnaria(Scanner scanner) {
        try {
            System.out.print("Ingrese el número entero: ");
            int num = Integer.parseInt(scanner.nextLine());

            System.out.println("Seleccione la operación:");
            System.out.println("1. Raíz cuadrada");
            System.out.println("2. Logaritmo natural");
            System.out.print("Opción: ");
            String opcion = scanner.nextLine();

            double resultado = 0;
            switch (opcion) {
                case "1":
                    resultado = raizCuadrada(num);
                    break;
                case "2":
                    resultado = logaritmoNatural(num);
                    break;
                default:
                    System.out.println("Opción no válida.");
                    return;
            }
            System.out.println("Resultado: " + resultado);
        } catch (NumberFormatException e) {
            System.out.println("Error: Ingrese un número entero válido.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // --- Operaciones Binarias ---
    private static int sumar(int a, int b) {
        return a + b;
    }

    private static int restar(int a, int b) {
        return a - b;
    }

    private static int multiplicar(int a, int b) {
        return a * b;
    }

    private static int dividir(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("División por cero no permitida.");
        }
        return a / b;
    }

    // --- Operaciones Unarias ---
    private static double raizCuadrada(int a) {
        if (a < 0) {
            throw new IllegalArgumentException("No se puede calcular la raíz cuadrada de un número negativo.");
        }
        return Math.sqrt(a);
    }

    private static double logaritmoNatural(int a) {
        if (a <= 0) {
            throw new IllegalArgumentException("El logaritmo natural solo está definido para números mayores que cero.");
        }
        return Math.log(a);
    }
}
