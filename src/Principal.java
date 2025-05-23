import java.io.IOException;
import java.util.Scanner;

import Metodos.llamarApi;
import Modelo.Moneda;
import Modelo.MonedaConversion;
import com.google.gson.JsonSyntaxException;

public class Principal {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
        llamarApi consultar = new llamarApi();// creamos una instancia
        String base = "";
        String destino = "";
        double importe = 0.0;
        String opt = "";

        Moneda[] monedas = new Moneda[10];
        monedas[0] = new Moneda("Usa", "USD");
        monedas[1] = new Moneda("Peru", "PEN");
        monedas[2] = new Moneda("Argentina", "ARS");
        monedas[3] = new Moneda("Brasil", "BRL");
        monedas[4] = new Moneda("Colombia", "COP");
        monedas[5] = new Moneda("Chile", "CLP");
        monedas[6] = new Moneda("Union Europea", "EUR");
        monedas[7] = new Moneda("Japon", "JPY");
        monedas[8] = new Moneda("China", "CNY");
        monedas[9] = new Moneda("Mexico", "MXN");

        try {
            do {
                System.out.println("******* ***** ******");
                System.out.println("******* Ingrese la moneda a cambiar por su simbolo EJEMPLO 'USD' dolares a 'PEN' soles y el monto a cambiar ******");
                System.out.println("******* ***** ******");

                System.out.println("Monedas disponibles:");
                for (Moneda moneda : monedas) {
                    moneda.mostrarLista();
                }
                System.out.println("Si desea salir del programa escriba: SALIR");
                System.out.println("******* ***** ******");

                System.out.print("Ingrese el símbolo de la moneda base: ");
                String elementoABuscarBase;
                boolean encontradoBase = false;
                if (lectura.hasNextLine()) { // Usar hasNextLine para leer la línea completa
                    elementoABuscarBase = lectura.nextLine().toUpperCase().trim(); // Leer, convertir a mayúsculas y quitar espacios
                    if (elementoABuscarBase.equalsIgnoreCase("SALIR")) {
                        break; // Salir del bucle si el usuario escribe SALIR
                    }
                    for (Moneda moneda : monedas) {
                        if (moneda.getSimbolo().equals(elementoABuscarBase)) {
                            encontradoBase = true;
                            base = elementoABuscarBase;
                            break;
                        }
                    }
                    if (!encontradoBase) {
                        System.out.println("SIMBOLO DE MONEDA BASE INCORRECTO.");
                        continue; // Volver al inicio del bucle
                    }
                } else {
                    continue; // Volver al inicio del bucle si no hay entrada
                }

                System.out.print("Ingrese el símbolo de la moneda destino: ");
                String elementoABuscarDestino;
                boolean encontradoDestino = false;
                if (lectura.hasNextLine()) {
                    elementoABuscarDestino = lectura.nextLine().toUpperCase().trim();
                    if (elementoABuscarDestino.equalsIgnoreCase("SALIR")) {
                        break; // Salir del bucle si el usuario escribe SALIR
                    }
                    for (Moneda moneda : monedas) {
                        if (moneda.getSimbolo().equals(elementoABuscarDestino)) {
                            encontradoDestino = true;
                            destino = elementoABuscarDestino;
                            break;
                        }
                    }
                    if (!encontradoDestino) {
                        System.out.println("SIMBOLO DE MONEDA DESTINO INCORRECTO.");
                        continue; // Volver al inicio del bucle
                    }
                } else {
                    continue; // Volver al inicio del bucle si no hay entrada
                }

                System.out.print("Ingrese el monto a cambiar: ");
                if (lectura.hasNextDouble()) {
                    importe = lectura.nextDouble();
                    lectura.nextLine(); // Consumir la nueva línea después de leer el double
                } else {
                    System.out.println("Entrada inválida. Por favor, ingrese un número.");
                    lectura.next(); // Descartar la entrada no válida
                    continue; // Volver al inicio del bucle
                }

                MonedaConversion monedaConversion = consultar.buscarMoneda(base, destino, importe);


                System.out.println("**************************");

                System.out.println("Monto a cambiar: "+importe);
                System.out.println("De :  "+monedaConversion.getBase_code()+" a "+monedaConversion.getTarget_code());
                System.out.println("Resultado:  "+monedaConversion.getConversion_result()
                        + " "+ monedaConversion.getTarget_code());
                System.out.println("**************************");

                System.out.print("Si desea realizar otra conversión, presione ENTER. Para salir, escriba SALIR: ");
                opt = lectura.nextLine().trim();

            } while (!opt.equalsIgnoreCase("salir"));

        } catch (JsonSyntaxException e) {
            System.err.println("La respuesta de la API no es un JSON válido: " + e.getMessage());
        } finally {
            lectura.close(); // Asegurar que el Scanner se cierre
        }
        System.out.println("Saliendo del programa.");
    }
}