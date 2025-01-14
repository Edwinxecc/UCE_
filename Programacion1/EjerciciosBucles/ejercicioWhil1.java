package EjerciciosBucles;

import java.util.Scanner;
public class ejercicioWhil1 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        short num;
        int i, sum=0;
        //Ejercicos While
        //Ejercicio 1: Realizar la suma de 1 a n con n < 150.
        System.out.print("Ingresa el valor de n: ");
        num = entrada.nextShort();
        if (num <= 150) {
            i=1;
            while (i<=num) {
                sum = sum + i;
                i++;
            }
            System.out.println("La suma es: " + sum); 
        }else {
            System.out.println("Ingrese un numero valido.");
        }
        entrada.close();
    }
}
