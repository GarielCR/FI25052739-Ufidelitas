package model;

public class Carta {

    private String palo;
    private String color;
    private int valor;
    private String nombre;

    public Carta(String simbolo, String color, int valor, String nombre) {
        
        this.palo = simbolo;
        this.color = color;
        this.valor = valor;
        this.nombre = nombre;
    }
    
    public String getPalo() {
        return palo;
    }

    public String getColor() {
        return color;
    }

    public int getValor() {
        return valor;
    }

    public String getNombre() {
        return nombre;
    }

        @Override
    public String toString() {
        return "[" + nombre + " - " + palo + " - " + color + "]";
    }

}
