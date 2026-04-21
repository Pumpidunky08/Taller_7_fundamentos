import java.util.Scanner;

public class ValidadorEntrada {
    
    // Su única responsabilidad es garantizar que se reciba un entero válido de la consola
    public int leerEntero(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor ingrese un número entero válido.");
            }
        }
    }
}
