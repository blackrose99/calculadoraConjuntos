package org.example.conjunto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Lenguaje {
    private List<String> items;
    public Lenguaje() {}
    public Lenguaje(List<String> items) {}
    public Lenguaje(String[] items) {}


    public Lenguaje Concatenacion(String[] items){
        Lenguaje L = new Lenguaje();
        return L;
    }
    public  Lenguaje Potencia(String[] items){
        Lenguaje L = new Lenguaje();
        return L;
    }

    public Lenguaje Inversa(String[] items){
        Lenguaje L = new Lenguaje();
        return L;
    }
    public Lenguaje Union(String[] items){
        Lenguaje L = new Lenguaje();
        return L;
    }
    public Lenguaje Interseccion(String[] items){
        Lenguaje L = new Lenguaje();
        return L;
    }
    public Lenguaje Resta(String[] items){
        Lenguaje L = new Lenguaje();
        return L;
    }
    public Lenguaje CK(String[] items){
        Lenguaje L = new Lenguaje();
        return L;
    }
    public Lenguaje CP(String[] items){
        Lenguaje L = new Lenguaje();
        return L;
    }

    public void imprimir() {
        if (items.isEmpty()) {
            System.out.println("El Lenguaje está vacío.");
        } else {
            System.out.println("Elementos del Lenguaje:");
            for (String item : items) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}
