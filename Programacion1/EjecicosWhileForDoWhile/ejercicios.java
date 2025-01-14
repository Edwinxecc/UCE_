package EjerciciosWhileForDo;

import java.util.Scanner;
public class ejercicios {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        short num;
        int i, sum=0;

        //Ejercicos While
        //Ejercicio 1: Realizar la suma de 1 a n con n < 150.
        System.out.print("Ingresa el valor de n: ");
        num = entrada.nextShort();
        i=1;
        while (i<=num && num<=150) {
            sum = sum + i;
            System.out.println(i);
            i++;
        }
        if (num > 150) {
            System.out.println("No existe suma.");
        }else {
            System.out.println("La suma es: " + sum);
        }
        
        //Ejercicio 2: Con n ya solicitado ahora realizamos la impresion de los numeros pares hasta n.
        while (i) {
            
        }

        entrada.close();
    }
}