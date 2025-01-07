package code.whil_ejemplo;

import java.util.Scanner;
public class ejemplos2 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int i;
        String palabra, inversa="";
        // ejemplo de decremento
        // escribir una palabra inversa
        System.out.print("Ingrese una palabra: ");
        palabra = entrada.next();
        
        i = palabra.length();
        while (i > 0) {
            inversa = inversa+palabra.charAt(i-1);
            i--;
        }
        entrada.close();
        System.out.println("");
        System.out.println("Palabra normal: " + palabra);
        System.out.println("Palabra inversa: " + inversa);
    }
}
