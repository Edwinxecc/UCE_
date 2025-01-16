package EjerciciosBucles;

import java.util.Scanner;;
public class ejercicioFor1 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String palabra, invertidoString="";
        // Ejercicio 1: Pedir 4 palabras por consola e invertir cada palabra.
        for (int i = 1; i <= 4; i++) {
            System.out.print("Ingresa la palabra "+"["+i+"]: ");
            palabra = entrada.next();
            System.out.println("Orginal: "+palabra);
            for (int j = palabra.length()-1; j >= 0; j--) {
                invertidoString = invertidoString + palabra.charAt(j);
                if (invertidoString.length() == palabra.length()) {
                    System.out.println("Invertido: "+invertidoString);
                    invertidoString = "";
                    System.out.println("");
                }
            }
        }
        entrada.close();
    }
}
