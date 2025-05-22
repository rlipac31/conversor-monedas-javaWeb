

import java.io.IOException;
import java.util.Scanner;

import Metodos.llamarApi;
import Modelo.MonedaConversion;

public class Principal {


    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura =  new Scanner(System.in);
        llamarApi consultar = new llamarApi();// creamos una instancia
        String  base = "";
        String destino="";
        double  importe = 1;
        // Otra forma de inicializar un array directamente
         String[] monedas = {"Ana", "Carlos", "Sofía", "Mateo", "Isabela"};


        try {



               while (true){
                    System.out.println("******* ***** ******");

                    System.out.println("******* Ingrese la moneda base  entre la siguientes opciones ******");
                    System.out.println();
                    System.out.println("******* ***** ******");
                    String opt = lectura.nextLine();
                    if(opt.equalsIgnoreCase("salir")){
                        break;
                    }
                    System.out.println("ingresse  lista paraa la moneda base");
                    opt =  lectura.nextLine();


                     MonedaConversion moneda= consultar.buscarMoneda(base,destino,importe);//
                     System.out.println("monnda convertita "+ moneda);
                }



        } catch (com.google.gson.JsonSyntaxException e) {
            System.err.println("La respuesta de la API no es un JSON válido: " + e.getMessage());
        }
    }
}
