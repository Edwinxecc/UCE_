package EjerciciosBucles;

import java.util.Random;
import java.util.Scanner;

public class ejercicioDowhi2 {
    public static void main(String[] args) {
        //Ejercicio 2: Juego de adivinanza de un numero aleatorio 
        // indicar si el numero ingresado es mayor o menor al numero desconocido
        // agregar intentos totales y opcion de salir
        Scanner entrada = new Scanner(System.in);
        Random rand = new Random(); 
        int numeroAlea = rand.nextInt(100);
        int numEntrada,cont=0;
        System.out.println("Bienvenido al juego de adivinar el numero.");
        System.out.println("El rango del numero es de 0 a 100");
        System.out.println("Ingrese [-1] para salir");
        System.out.println("");
        do {
            System.out.print("Ingresa tu numero: ");
            numEntrada = entrada.nextInt();
            if (numEntrada > numeroAlea) {
                System.out.println("--- Tu numero es mayor ---");
                cont++;
            }else if(numEntrada < numeroAlea && numEntrada != -1){
                System.out.println("--- Tu numero es menor ---");
                cont++;
            }
        } while (numEntrada != numeroAlea && numEntrada != -1);
        if (numEntrada == numeroAlea) {
            System.out.println("*** Adivinaste el numero ***");
            System.out.println("Con un total de intentos: " + cont);
        }else {
            System.out.println("Gracias por Intentar");
        }
        entrada.close();
    }
}
