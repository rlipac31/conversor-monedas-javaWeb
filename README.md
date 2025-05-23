# Conversor de Monedas Java 17

Este proyecto es un simple conversor de monedas desarrollado en Java 17. Utiliza una API externa para obtener las tasas de cambio y la librería Gson para parsear la respuesta JSON a objetos Java.

## Características

* Permite al usuario ingresar la moneda base, la moneda de destino y el monto a convertir.
* Utiliza una API para obtener las tasas de cambio en tiempo real.
* Maneja la entrada del usuario para asegurar que se ingresen símbolos de moneda válidos y montos numéricos.
* Utiliza la librería Gson para convertir la respuesta JSON de la API a objetos Java, facilitando el acceso a los datos.
* Ofrece la opción de realizar múltiples conversiones hasta que el usuario decida salir.

## Capturas de Pantalla

Aquí puedes ver el proyecto en ejecución:

### Ejemplo de Conversión

![Ejemplo de Conversión]

<img src="https://i.ibb.co/4w1SQtJL/result.png" alt="Imagen del Frontend App-Votar">
*Esta imagen ilustra la lista de monedas disponibles que se muestra al usuario.*

**(Reemplaza `ruta/a/tu/imagen_conversion.png` y `ruta/a/tu/imagen_lista_monedas.png` con las rutas reales a tus archivos de imagen.)**


## Tecnologías Utilizadas

* **Java 17**: El lenguaje de programación utilizado.
* **Gson**: Librería de Google para la manipulación de JSON en Java.
* **Java `HttpClient`**: Para realizar las peticiones HTTP a la API de tasas de cambio (característica de Java 11+).

## Cómo Ejecutar

1.  **Clonar el repositorio:**
    ```bash
    git clone [https://github.com/sindresorhus/del](https://github.com/sindresorhus/del)
    cd [nombre del proyecto]
    ```

2.  **Compilar el proyecto:**
    Si estás usando un sistema de construcción como Maven o Gradle, utiliza el comando correspondiente (ejemplo para Maven):
    ```bash
    mvn clean install
    ```
    Si no estás usando un sistema de construcción, puedes compilar los archivos `.java` manualmente:
    ```bash
    javac src/*.java Modelo/*.java Metodos/*.java Principal.java
    ```

3.  **Ejecutar el programa:**
    Si usaste Maven:
    ```bash
    mvn exec:java -Dexec.mainClass="Principal"
    ```
    Si compilaste manualmente:
    ```bash
    java Principal
    ```

    El programa te guiará para ingresar las monedas y el monto a convertir.

## Uso

Al ejecutar el programa, se te pedirá que ingreses el símbolo de la moneda base, el símbolo de la moneda de destino y el monto que deseas convertir. El programa mostrará el resultado de la conversión. Puedes realizar más conversiones hasta que escribas "SALIR".

## Dependencias

* [Gson](https://github.com/google/gson) - Para la manipulación de JSON. Asegúrate de incluir la dependencia en tu sistema de construcción (si lo usas) o de tener el JAR en el classpath al compilar y ejecutar.

## Créditos

[Rlipac31]

## Licencia

[ MIT License]

