package EjerciciosBucles;
import java.util.Scanner;
import java.util.Random;
public class ejercicioDowhi1 {
    public static void main(String[] args) {
        //Ejercicio 1: Juego de adivinanza de un numero aleatorio 
        // indicar si el numero ingresado es mayor o menor al numero desconocido
        Scanner entrada = new Scanner(System.in);
        Random rand = new Random(); 
        int numeroAlea = rand.nextInt(100);
        int numEntrada;
        System.out.println("Bienvenido al juego de adivinar el numero.");
        System.out.println("El rango del numero es de 0 a 100");
        System.out.println("");
        do {
            System.out.print("Ingresa tu numero: ");
            numEntrada = entrada.nextInt();
            if (numEntrada > numeroAlea) {
                System.out.println("--- Tu numero es mayor ---");
            }else if(numEntrada < numeroAlea){
                System.out.println("--- Tu numero es menor ---");
            }
        } while (numEntrada != numeroAlea);
        System.out.println("*** Adivinaste el numero ***");
        entrada.close();
    }
}
