import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OperacionesBinarias opBinarias = new OperacionesBinarias();
        OperacionesUnarias opUnarias = new OperacionesUnarias();
        ValidadorEntrada validador = new ValidadorEntrada();

        boolean continuar = true;

        System.out.println("=== Calculadora SOLID (SRP) ===");

        while (continuar) {
            System.out.println("\nSeleccione el tipo de operación:");
            System.out.println("1. Operación Binaria (+, -, *, /)");
            System.out.println("2. Operación Unaria (Raíz cuadrada, Logaritmo natural)");
            System.out.println("3. Salir");
            System.out.print("Opción: ");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    manejarOperacionBinaria(scanner, opBinarias, validador);
                    break;
                case "2":
                    manejarOperacionUnaria(scanner, opUnarias, validador);
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

    private static void manejarOperacionBinaria(Scanner scanner, OperacionesBinarias operaciones, ValidadorEntrada validador) {
        int num1 = validador.leerEntero(scanner, "Ingrese el primer número entero: ");
        
        System.out.print("Ingrese el operador (+, -, *, /): ");
        String operador = scanner.nextLine();
        
        int num2 = validador.leerEntero(scanner, "Ingrese el segundo número entero: ");

        try {
            int resultado = 0;
            switch (operador) {
                case "+":
                    resultado = operaciones.sumar(num1, num2);
                    break;
                case "-":
                    resultado = operaciones.restar(num1, num2);
                    break;
                case "*":
                    resultado = operaciones.multiplicar(num1, num2);
                    break;
                case "/":
                    resultado = operaciones.dividir(num1, num2);
                    break;
                default:
                    System.out.println("Operador no soportado.");
                    return;
            }
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Error Matemático: " + e.getMessage());
        }
    }

    private static void manejarOperacionUnaria(Scanner scanner, OperacionesUnarias operaciones, ValidadorEntrada validador) {
        int num = validador.leerEntero(scanner, "Ingrese el número entero: ");

        System.out.println("Seleccione la operación:");
        System.out.println("1. Raíz cuadrada");
        System.out.println("2. Logaritmo natural");
        System.out.print("Opción: ");
        String opcion = scanner.nextLine();

        try {
            double resultado = 0;
            switch (opcion) {
                case "1":
                    resultado = operaciones.raizCuadrada(num);
                    break;
                case "2":
                    resultado = operaciones.logaritmoNatural(num);
                    break;
                default:
                    System.out.println("Opción no válida.");
                    return;
            }
            System.out.println("Resultado: " + resultado);
        } catch (IllegalArgumentException e) {
            System.out.println("Error Matemático: " + e.getMessage());
        }
    }
}
