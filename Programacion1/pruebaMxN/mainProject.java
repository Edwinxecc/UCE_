package pruebaMxN;
import java.util.Scanner;
import java.util.Random;
public class mainProject {
    
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Random randomx = new Random();
        int m, n, option;
        int nfila, ncolumna;
        System.out.print("Ingresa el numero de filas de la matriz: ");
        m = entrada.nextInt();
        System.out.print("Ingresa el numero de columnas de la matriz: ");
        n = entrada.nextInt();
        int matriz[][] = new int[m][n];
        System.out.println("Su matriz es de: " + m + " x " + n);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = randomx.nextInt(100);
            }
        }

        System.out.println("");
        System.out.println("Quieres imprimir filas o columnas de tu matriz: ");
        System.out.println("[1] Filas.");
        System.out.println("[2] Columnas: ");
        option = entrada.nextInt();
        switch (option) {
            case 1:
                System.out.println("Ingresa el numero de fila que quieres imprimir: ");
                nfila = entrada.nextInt();
                for (int i = 0; i < matriz.length; i++) {
                    for (int j = 0; j < matriz[i].length; j++) {
                        if (i == (nfila-1)) {
                            System.out.print("| " + matriz[i][j]);
                        }
                    }
                    System.out.println("");
                }
                break;
        
            default:
                System.out.println("Ingresa el numero de columna que quieres imprimir: ");
                ncolumna = entrada.nextInt();
                for (int i = 0; i < matriz.length; i++) {
                    for (int j = 0; j < matriz[i].length; j++) {
                        if (j == (ncolumna-1)) {
                            System.out.println("| " + matriz[i][j]);
                        }
                    }
                }
                break;
        }
        System.out.println("");
        System.out.println("La matriz original es: ");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("| " + matriz[i][j]);
            }
            System.out.println(" ");
        }
        entrada.close();
    }
}
