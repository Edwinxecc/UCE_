package code.while_ejemplo;
import java.util.Scanner;
public class ejemplos {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        short i, a=0,e=0, v_i=0, o=0, u=0;
        String palabra, temp;
        //ejemplo 1 contador de vocales en una palabra
        
        System.out.print("Ingresa la palabra: ");
        palabra=entrada.next();
        System.out.println("");
        palabra = palabra.toLowerCase(); // para pasar a minusculas

        i=0;
        while (i<palabra.length()) {
            System.out.print(palabra.charAt(i) + " ");
            temp = ""+ palabra.charAt(i);
            switch (temp) {
                case "a":
                    a++;
                    break;
                case "e":
                    e++;
                    break;
                case "i":
                    v_i ++;
                    break;
                case "o":
                    o++;
                    break;
                case "u":
                    u++;
                    break;
                default:
                    break;
            }

            i++; //no tocar del bucle while
        }

        System.out.println(" ");
        System.out.println("");
        System.out.println("Numero de vocales: ");
        
        System.out.println("a = " + a);
        System.out.println("e = " + e);
        System.out.println("i = " + v_i);
        System.out.println("o = " + o);
        System.out.println("u = " + u);
        
        entrada.close();
    }
}
