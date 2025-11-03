package main;

import model.Carta;

public class Main {
    public static void main(String[] args) {

        // Arreglo de 52 cartas
        Carta [] caja = new Carta[52];

        // Palos con su color
        String[] palos = {"Corazones", "Diamantes", "Picas", "Tréboles"};
        String[] colores = {"rojo", "rojo", "negro", "negro"};

        // Nombres de las cartas
        String[] nombres = {"As", "Dos", "Tres", "Cuatro", "Cinco", "Seis",
                            "Siete", "Ocho", "Nueve", "Diez", "Jota", "Quina", "Ka"};

        int indice = 0;

        // Crear las 52 cartas
        for (int i = 0; i < palos.length; i++) {       // Recorre palos
            for (int j = 0; j < 13; j++) {            // Recorre valores de 1 a 13
                caja[indice] = new Carta(palos[i], colores[i], j + 1, nombres[j]);
                indice++;
            }
        }

        // Mostrar todas las cartas
        for (Carta c : caja) {
            System.out.println(c);
        }
    }
}
