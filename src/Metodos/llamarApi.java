package Metodos;



import Modelo.MonedaConversion;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class llamarApi {

    public MonedaConversion buscarMoneda(String monedaBase, String monedaDestino, double monto){
        var API_KEY="d28b36a0cd750e98d335c1c0";
        String apiUrl = "https://v6.exchangerate-api.com/v6/"+API_KEY+"/pair/"+monedaBase+"/"+monedaDestino+"/"+monto;//par/ EUR / GBP // Ejemplo de una API pública
      //  String nombreArchivoJson = "respuesta_api.json";
      //  System.out.println("url: "+ apiUrl);
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() >= 200 && response.statusCode() < 300) {
                String json = response.body();

                return new Gson().fromJson(json, MonedaConversion.class);


            } else {
                System.err.println("Error al consumir la API. Código de estado: " + response.statusCode());
            }

        } catch (IOException e) {
            System.err.println("Error de IO al conectar con la API: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("La petición a la API fue interrumpida: " + e.getMessage());
            Thread.currentThread().interrupt();
        } catch (com.google.gson.JsonSyntaxException e) {
            System.err.println("La respuesta de la API no es un JSON válido: " + e.getMessage());
        }

        return null;
    }

}
