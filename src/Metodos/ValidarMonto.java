package Metodos;

public class ValidarMonto {
    public static boolean esNumero(String str) {
        try {
            Double.parseDouble(str); // Intenta convertir a número
            return true;
        } catch (NumberFormatException e) {
            return false; // No es un número
        }
    }

}
