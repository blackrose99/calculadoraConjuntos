package org.example.conjunto;

public class Cadena {

    public int longitud(String cadena) {
        return cadena.length();
    }

    public String reflexion(String cadena) {
        return new StringBuilder(cadena).reverse().toString();
    }

    public String potenciacion(String cadena, int n) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < n; i++) {
            resultado.append(cadena);
        }
        return resultado.toString();
    }

    public String concatenacion(String cadena1, String cadena2) {
        return cadena1 + cadena2;
    }
}
