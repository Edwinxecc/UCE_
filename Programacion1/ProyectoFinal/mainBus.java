package asientosBus;
import java.util.Scanner;;
public class mainBus {
    public static void main(String[] args) {
        // definimos la parte trasera de 5 asientos en un bus
        int finBus[] = {0,0,0,0,0};
        // con una matriz definimos los asientos normales
        int normales[][] = {
            {1,0,0,0},
            {0,1,0,0},
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0},
            {0,0,1,0},
            {0,0,0,0},
            {0,1,0,0},
            {0,1,0,1}
        };
        Scanner entrada = new Scanner(System.in);
        int option;
        // impresion de bus vacio 
        //BusVacio();
        // 
        boolean asientoPareja;
        System.out.println("Bienvenido al Sistema Code");
        System.out.println("Desea adquirir un asiento ?");
        System.out.println("[1] Asiento Unico.");
        System.out.println("[2] Asiento en Pareja.");
        option = entrada.nextInt();
        switch (option) {
            case 1:
                asientoPareja = false;
                FuncAdquirirAsiento(asientoPareja, normales);
                break;
            case 2:
                asientoPareja = true;
                FuncAdquirirAsiento(asientoPareja, normales);
                break;
            default:
                System.out.println("Ingresa una opcion valida.");
                break;
        }
        ImprimirEstadoBus(normales, finBus);
        entrada.close();
    }

    public static void ImprimirEstadoBus(int [][] normales, int [] finBus){
        System.out.println(" ");
        for (int i = 0; i < normales.length; i++) {
            System.out.print("|");
            for (int j = 0; j < normales[i].length; j++) {
                System.out.print(normales[i][j] + "|");
                if (j==1) {
                    System.out.print(" --- |");
                }
            }
            System.out.println(" ");
        }

        for (int i = 0; i < finBus.length; i++) {
            System.out.print("|");
            System.out.print(finBus[i]);
            System.out.print("|");
        }
    }

    public static void FuncAdquirirAsiento(boolean asientoPareja, int bus[][]){
        
        if (asientoPareja) {
            //buscar asientos juntos
            for (int i = 0; i < bus.length; i++) {
                for (int j = 0; j < bus[i].length; j++) {
                    if (bus[i][j] == 0) {
                        System.out.println("espacio vacio en: " +i+ ", " + j);
                    }
                }
            }
        }
    }
}
