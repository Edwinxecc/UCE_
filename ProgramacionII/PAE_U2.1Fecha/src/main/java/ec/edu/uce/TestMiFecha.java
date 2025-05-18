package ec.edu.uce;

/**
 * @author Edwin Caiza
 */

import ec.edu.uce.dominio.MiFecha;
import java.util.Scanner;

public class TestMiFecha {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MiFecha fecha = new MiFecha(); // Por defecto: 01/01/1990
        int opcion;
        do {
            System.out.println("\n\n\nSelecione una opcion: ");
            System.out.println("[1] Contructor Por Defecto");
            System.out.println("[2] Contructor con Parametros");
            System.out.println("[3] Probar Getters");
            System.out.println("[4] Probar Setters");
            System.out.println("[5] Validar Fecha");
            System.out.println("[6] Fibonacci Iterativo");
            System.out.println("[7] Fibonacci Recursivo");
            System.out.println("[0] Salir");
             opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    fecha = probarConstructorPorDefecto();
                    break;
                case 2:
                    fecha = probarConstructorConParametros(sc);
                    break;
                case 3:
                    probarGetters(fecha);
                    break;
                case 4:
                    probarSetters(fecha, sc);
                    break;
                case 5:
                    probarFechaValida(fecha);
                    fecha = new MiFecha(30, 2, 2020);
                    probarFechaValida(fecha);
                    break;
                case 6:
                    int numero;
                    System.out.println("\n\nIngrese un numero: ");
                    numero = sc.nextInt();
                    System.out.println("Fibonacci Iterativo de " + numero + " es: " + fibonacciIterativo(numero));
                    break;
                case 7:
                    int numero2;
                    System.out.println("\n\nIngrese un numero: ");
                    numero2 = sc.nextInt();
                    System.out.println("Fibonacci Recursivo de " + numero2 + " es: " + fibonacciIterativo(numero2));
                    break;
                default:
                    if (opcion == 0) {
                        System.out.println("[*] Saliendo");
                    }
                    else {System.out.println("[*] Opcion incorrecta");}
            }
        }while (opcion != 0);

        sc.close();
    }

    public static MiFecha probarConstructorPorDefecto() {
        System.out.println("\n== Constructor por defecto ==");
        MiFecha f = new MiFecha();
        System.out.println("Fecha: " + f.getDia() + "/" + f.getMes() + "/" + f.getAnio());
        return f;
    }

    public static MiFecha probarConstructorConParametros(Scanner sc) {

        MiFecha f = new MiFecha(15, 3, 2025);
        System.out.println("Fecha creada: " + f.getDia() + "/" + f.getMes() + "/" + f.getAnio());
        return f;
    }

    public static void probarGetters(MiFecha f) {
        System.out.println("\n== Getters ==");
        System.out.println("Día: " + f.getDia());
        System.out.println("Mes: " + f.getMes());
        System.out.println("Año: " + f.getAnio());
    }

    public static void probarSetters(MiFecha f, Scanner sc) {
        System.out.println("\n== Setters ==");

        System.out.println("Set día: " + f.setDia(20));
        System.out.println("Set mes: " + f.setMes(2));
        System.out.println("Set año: " + f.setAnio(2024));
        System.out.println("Nueva fecha: " + f.getDia() + "/" + f.getMes() + "/" + f.getAnio());
    }

    public static void probarFechaValida(MiFecha f) {
        System.out.println("\n== Validación de fecha ==");
        System.out.println("Fecha: " + f.getDia() + "/" + f.getMes() + "/" + f.getAnio());
        System.out.println("¿Es válida? " + f.fechaValida());
    }

    public static int fibonacciIterativo(int n) {
        //sin recursividad
        if (n <= 1) return n;
        int a = 0, b = 1;
        int resultado = 0;
        for (int i = 2; i <= n; i++) {
            resultado = a + b;
            a = b;
            b = resultado;
        }
        return resultado;
    }

    public static int fibonacciRecursivo(int n) {
        if (n <= 1) return n;
        return fibonacciRecursivo(n - 1) + fibonacciRecursivo(n - 2);
    }

}