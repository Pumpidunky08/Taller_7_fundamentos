import java.util.Scanner;

/**
 * Clase de Interfaz de Usuario dedicada solo a orquestar el Scanner.
 * Sus dependencias funcionales le son inyectadas.
 */
public class CalculadoraConsola {
    private final MotorCalculadora motor;
    private final ValidadorEntrada validador;
    private final Scanner scanner;

    public CalculadoraConsola(MotorCalculadora motor, ValidadorEntrada validador, Scanner scanner) {
        this.motor = motor;
        this.validador = validador;
        this.scanner = scanner;
    }

    public void iniciar() {
        boolean continuar = true;
        System.out.println("=== Calculadora SOLID (SRP + OCP + LSP + ISP + DIP) ===");

        while (continuar) {
            System.out.println("\nEscriba el símbolo de la operación (+, -, *, /, ^, raiz, ln) o 'salir' para terminar:");
            System.out.print("Símbolo: ");
            String opKey = scanner.nextLine().toLowerCase();

            if (opKey.equals("salir")) {
                continuar = false;
                System.out.println("¡Hasta luego!");
                continue;
            }

            if (!motor.soportaOperacion(opKey)) {
                System.out.println("Operación no soportada. Intente de nuevo.");
                continue;
            }

            try {
                if (motor.esBinaria(opKey)) {
                    double num1 = validador.leerEntero(scanner, "Ingrese el primer operando: ");
                    double num2 = validador.leerEntero(scanner, "Ingrese el segundo operando: ");
                    System.out.println("Resultado: " + motor.evaluarBinaria(opKey, num1, num2));
                } else {
                    double num = validador.leerEntero(scanner, "Ingrese el operando: ");
                    System.out.println("Resultado: " + motor.evaluarUnaria(opKey, num));
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
