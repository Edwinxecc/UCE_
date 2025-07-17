package ec.edu.uce.dominio;

import java.util.Date;

/**
 * Clase para ejecutar pruebas con la clase TestCliente y objetos Cliente.
 * Contiene el método main para probar constructores, getters y setters.
 */
public class Test {
    /**
     * Instancia estática de TestCliente para realizar las pruebas
     */
    public static TestCliente testCliente;

    /**
     * Obtiene la instancia de TestCliente.
     *
     * @return instancia de TestCliente
     */
    public TestCliente getTestCliente() {
        return testCliente;
    }

    /**
     * Método principal que ejecuta las pruebas de la clase Cliente mediante TestCliente.
     *
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {
        testCliente = new TestCliente();
        testCliente.testConstructor();
        testCliente.testSet();
        testCliente.testGet();

        Cliente cliente1 = new Cliente("Juan", "Perez", "mail.com", new Date());
        testCliente.testConstructor(cliente1);
        testCliente.testGet();

        Cliente cliente2 = new Cliente("Ana", "Perez", "mail.com", new Date());
        testCliente.testConstructor(cliente2);
        testCliente.testGet();

        Cliente c = new Cliente("Carlos", "Perez", "mail.com", new Date());
        testCliente.testConstructor(c);
        System.out.println(c.getClienteId());
    }
}