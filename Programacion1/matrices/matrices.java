package matrices;
import java.util.Scanner;
public class matrices {

    public static void main(String[] args) {
        //declaracion de matrices cuadradas de nxn
        // si deseo puedo cambiar mas cosas asi que esta seria la base de una matriz 
        Scanner entrada = new Scanner(System.in);
        System.out.println("Tamaño de la matriz: ");
        int nm = entrada.nextInt(); 
        int matriz[][] = new int[nm][nm];
        
        //guardar datos en la matriz 
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.println("Ingresa el dato en la posicion: " + i +", "+j);
                matriz[i][j] = entrada.nextInt();
            }
        }

        //impresion de la matriz 
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "|");
            }
            System.out.println("");
        }
        entrada.close();
    }
}