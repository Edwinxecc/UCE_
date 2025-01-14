package EjerciciosBucles;

import java.util.Scanner;;
public class ejercicioWhil2 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int i;
        short num;
        //Ejercicio 2: Impresion de los numeros pares hasta n.
        System.out.print("Ingresa el valor de n: ");
        num = entrada.nextShort();
        System.out.println("");
        System.out.println("Los numeros pares hasta n son: ");
        i=1; 
        while (i<=num && num <= 150) {
            if (i%2 == 0) {
                System.out.println(i);
            }
            i++;
        }
        entrada.close();
    }    
}
