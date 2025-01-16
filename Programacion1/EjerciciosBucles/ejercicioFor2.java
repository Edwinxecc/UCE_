package EjerciciosBucles;
import java.util.Scanner;
public class ejercicioFor2 {
    public static void main(String[] args) {
        // !! Resolver bug cuando se pueda !!



        
        //Ejercicio 2: De 5 palabras secretas, pedir adivinar al usuario la palabra tiene 4 intentos 
        // Por cada intento mostras las letras que si contiene la palabra
        // las palabras solo tienen 5 letras
        Scanner entrada = new Scanner(System.in);
        byte numPal, a=0, e=0, v_i=0, o=0, u=0;
        String palab1= "bache",
            palab2 = "campo",
            palab3 = "redes",
            palab4 = "fallo",
            palab5 = "velas";
        String comp ="", entraString;
        System.out.println("Ingrese un numero del 1 al 5");
        numPal = entrada.nextByte();
        switch (numPal) {
            case 1:
                comp = palab1;
                break;
            case 2:
                comp = palab2;
                break;
            case 3:
                comp = palab3;
                break;
            case 4:
                comp = palab4;
                break;
            case 5:
                comp = palab5;
                break;
            default:
                System.out.println("Ingresa un numero valido.");
                break;
        }
        for (int i = 0; i < 5; i++) {
            
            for (int j = 0; j < 4; j++) {
                entraString = entrada.next();
                if (entraString.equalsIgnoreCase(comp)) {
                    j=5; i=6;
                    System.out.println("Felicidades adivinaste la palabra.");
                }else if (comp.charAt(i) == entraString.charAt(j)) {
                    switch (entraString.charAt(j)+"") {
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
                    System.out.println("a = " + a);
                    System.out.println("e = " + e);
                    System.out.println("i = " + v_i);
                    System.out.println("o = " + o);
                    System.out.println("u = " + u);
                }
            }
        }
        entrada.close();
    }
}
