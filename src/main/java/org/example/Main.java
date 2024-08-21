package org.example;

import org.example.conjunto.Menu;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Bienvenido a la Calculadora de Conjuntos y Cadenas\n" +
                "\nRecomendaciones:" +
                "\n1: El delimitador usado para separar los elementos de los conjuntos y cadenas es un espacio." +
                "\n2: El menú es interactivo y se presenta en la consola. Sigue las instrucciones cuidadosamente para realizar las operaciones deseadas." +
                "\n3: Puedes navegar entre las opciones y volver al menú principal desde los submenús." +
                "\n4: Para las operaciones con cadenas, ingresa las cadenas o el número de repeticiones según sea necesario.");

        Menu.index();
    }
}
