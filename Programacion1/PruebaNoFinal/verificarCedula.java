/**
 *
 * @author Edwin Caiza
 */
import java.util.Scanner;
public class Prueba02 {

    public static void main(String[] args) {
        //>9 / -9
        Scanner entrada = new Scanner(System.in);
        int cedula[] = new int[9];
        int valoresFijos[] = {2,1,2,1,2,1,2,1,2};
        int multi[] = new int[9];
        int suma = 0;
        int digitoVer = 0;
        
        System.out.println("Prueba ");
        System.out.println("Edwin Caiza");
        
        System.out.println(" ");
        for (int i = 0; i < cedula.length; i++) {
            System.out.print("Ingrese su numero de cedula en " + (i+1) + ": ");
            cedula[i] = entrada.nextInt();
            //multiplico por el arreglo valores
            multi[i] = cedula[i] * valoresFijos[i];
            if(multi[i] > 9){
                multi[i] = multi[i] - 9;
            }
            suma += multi[i];
        }
        // imprimir arreglo multi
        for (int i = 0; i < multi.length; i++) {
            System.out.print(multi[i] + ", ");
        } 
        System.out.println(" ");
        if (suma % 10 == 0) {
            digitoVer = 0;
        }else{
            for (int i = 1; i <= 9; i++) {
                if (suma > (i*10)) {
                    digitoVer = suma - ((i+1) * 10);
                    if (digitoVer < 0) {
                        digitoVer = digitoVer * -1;
                    }
                }
            }
        }
        
        System.out.println(" ");
        System.out.println(suma);
        System.out.println(" ");
        System.out.println("Su digito verificador es: " + digitoVer);
        entrada.close();
    }
}
