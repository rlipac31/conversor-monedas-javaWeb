

import java.io.IOException;
import java.util.Scanner;

import Metodos.llamarApi;
import Modelo.Moneda;
import Modelo.MonedaConversion;

import static Metodos.ValidarMonto.esNumero;

public class Principal {


    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura =  new Scanner(System.in);
        llamarApi consultar = new llamarApi();// creamos una instancia
        String  base = "";
        String destino="";
        double  importe =0.0;
        // Otra forma de inicializar un array directamente

        Moneda [] monedas = new Moneda[10];
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



               while (true) {
                   System.out.println("******* ***** ******");

                   System.out.println("******* Ingrese la monedaas a cambiar ,  por su  y el monto a cambiar simbolo EJEMPLO 'USD' dolares a 'PEN' soles  monto=5 ******");
                   for (Moneda moneda : monedas) {
                       moneda.mostrarLista();

                   }


                   System.out.println("******* ***** ******");

                   System.out.println("ingresse  lista paraa la moneda base");
                   //  String  elmentoABuscar=lectura.nextLine().toUpperCase();
                   String elmentoABuscar;
                   boolean encontrado = false;
                   if (lectura.hasNext()) {
                       elmentoABuscar = lectura.nextLine().toUpperCase();

                       for (Moneda moneda : monedas) {
                           if (moneda.getSimbolo().equals(elmentoABuscar)) {
                               encontrado = true;
                               base = elmentoABuscar;
                               break;
                           }

                       }

                   }
                   if (!encontrado) {

                       System.out.println("SIMBOLO DE MONEDA INCCORRECTO: " );
                       System.out.println("ingresse  lista paraa la moneda base");
                       elmentoABuscar = lectura.nextLine().toUpperCase();
                   }


                   System.out.println("ingresse  lista para la moneda desstino ");
                   String elmentoABuscar2;
                   boolean encontrado2 = false;
                   if (lectura.hasNext()) {
                       elmentoABuscar2 = lectura.nextLine().toUpperCase();
                       for (Moneda moneda : monedas) {
                           if (moneda.getSimbolo().equals(elmentoABuscar2)) {
                               encontrado2 = true;
                               destino = elmentoABuscar2;
                               break;
                           }

                       }

                   }

                   if (!encontrado2) {
                       System.out.println("SIMBOLO DE MONEDA INCCORRECTO: "  );
                       System.out.println("ingresse  lista paraa la moneda de Destino");
                       elmentoABuscar2 = lectura.nextLine().toUpperCase();
                   }


                   System.out.println("ingresse  el monto a cambiar ");
                   if (lectura.hasNextDouble()) {
                       importe = lectura.nextDouble();

                   } else {
                       System.out.println("Entrada inválida. Por favor, ingrese un número.");
                       lectura.next(); // Descartar la entrada no válida del scanner
                   }


                   MonedaConversion moneda = consultar.buscarMoneda(base, destino, importe);//
                   System.out.println("**************************");
                   System.out.println("monnda convertita " + moneda.getBase_code() + " " + moneda.getConversion_result() + ": " + moneda.getTarget_code());

                   System.out.println("**************************");

                   String opt = lectura.nextLine();
                   if (opt.equalsIgnoreCase("salir")) {
                       break;
                   }
               }



        } catch (com.google.gson.JsonSyntaxException e) {
            System.err.println("La respuesta de la API no es un JSON válido: " + e.getMessage());
        }
    }
}
