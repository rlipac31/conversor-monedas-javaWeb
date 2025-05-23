package Modelo;

public class Moneda {
   private String pais;
   private String simbolo;

    public Moneda(String pais, String simbolo) {
        this.pais = pais;
        this.simbolo = simbolo;
    }



    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    @Override
    public String toString() {
        return "Moneda{" +
                "pais=  " + pais +
                ", simbolo= " + simbolo +
                '}';
    }

    // Método para mostrar información
    public void mostrarLista() {
        System.out.println( "Pais: " + pais + ", Moneda => simbolo: " + simbolo);
    }

}
