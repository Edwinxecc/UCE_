package ec.edu.uce.dominio;

import java.util.Date;

/**
 * Clase de prueba para la clase Cuenta asociada a un Cliente.
 * Realiza operaciones básicas de la cuenta como creación, depósito y retiro,
 * y muestra los resultados en consola.
 */
public class TestCuenta {

    /**
     * Método principal para ejecutar las pruebas de Cuenta.
     *
     * @param args argumentos de línea de comandos (no usados)
     */
    public static void main(String[] args) {
        // Crear un cliente con ID, nombre, apellido y género
        Cliente cliente = new Cliente("Luis", "Perez", "mail.com", new Date());

        // Crear una cuenta con saldo inicial de 100
        cliente.agregarCuenta(100.0);
        System.out.println("Saldo inicial de la cuenta:");
        System.out.println(cliente.buscarCuenta(0).getSaldo());

        // Realizar un depósito de 150 en la cuenta
        cliente.buscarCuenta(0).deposito(150.0);
        System.out.println("Saldo después del depósito de 150:");
        System.out.println(cliente.buscarCuenta(0).getSaldo());

        // Realizar un retiro de 100 de la cuenta
        cliente.buscarCuenta(0).retiro(100.0);
        System.out.println("Saldo después del retiro de 100:");
        System.out.println(cliente.buscarCuenta(0).getSaldo());

        // Mostrar la representación en cadena de la cuenta
        System.out.println("Cuenta (toString):");
        System.out.println(cliente.buscarCuenta(0));
    }
}
