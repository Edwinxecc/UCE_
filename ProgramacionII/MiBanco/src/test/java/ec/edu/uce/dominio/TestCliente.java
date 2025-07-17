package ec.edu.uce.dominio;
import java.util.Date;

/**
 * Clase de prueba para verificar el funcionamiento de la clase Cliente
 * Incluye pruebas de constructores, getters, setters y gestión de cuentas asociadas.
 */
public class TestCliente {
    /**
     * Instancia de cliente a ser utilizada en las pruebas.
     */
    private Cliente cliente;

    /**
     * Prueba el constructor que recibe nombre, apellido, correo y fecha.
     * Imprime el cliente creado utilizando {@code toString()}.
     */
    public void testConstructor() {
        cliente = new Cliente("Jhon", "Avila", "jaavilav@uce.edu.ec", new Date());
        System.out.println("Cliente creado con constructor completo.");
        System.out.println(cliente);
    }

    /**
     * Prueba los métodos {@code set} para modificar los atributos del cliente.
     * Establece un nuevo nombre, apellido, correo y fecha de nacimiento.
     */
    public void testSet() {
        cliente.setNombre("Carlos");
        cliente.setApellido("Lopez");
        cliente.setCorreo("carlos@correo.com");
        cliente.setFecha(new Date(2025 - 1900, 5, 14)); // Año 2025, junio (mes 5 + 1)
        System.out.println("Atributos modificados.");
    }

    /**
     * Prueba los métodos {@code get} para obtener y mostrar los datos del cliente.
     * Muestra en consola nombre, apellido, correo y fecha.
     */
    public void testGet() {
        System.out.println("Nombre: " + cliente.getNombre());
        System.out.println("Apellido: " + cliente.getApellido());
        System.out.println("Correo: " + cliente.getCorreo());
        System.out.println("Fecha: " + cliente.getFecha());
    }

    /**
     * Prueba el constructor de copia de la clase {@code Cliente}.
     * Crea una nueva instancia utilizando otro cliente existente.
     *
     * @param c Cliente a copiar
     */
    public void testConstructor(Cliente c) {
        cliente = new Cliente(c);
        System.out.println("Cliente creado a partir de otro cliente.");
        System.out.println(cliente);
    }

    /**
     * Prueba las operaciones CRUD (crear, editar, eliminar, consultar)
     * sobre las cuentas asociadas a un cliente.
     */
    public void testCuentas() {
        // Crear varias cuentas
        cliente.agregarCuenta(100.0);
        cliente.agregarCuenta(250.0);
        cliente.agregarCuenta(500.0);

        System.out.println("Cuentas creadas:");
        for (Cuenta c : cliente.consultarCuentas()) {
            System.out.println(c);
        }

        // Editar el saldo de la segunda cuenta
        cliente.editarCuenta(1, 300.0);
        System.out.println("Cuenta 1 editada:");
        System.out.println(cliente.buscarCuenta(1));

        // Eliminar la primera cuenta
        cliente.eliminarCuenta(0);
        System.out.println("Cuentas después de eliminar cuenta 0:");
        for (Cuenta c : cliente.consultarCuentas()) {
            System.out.println(c);
        }
    }

    /**
     * Método principal para ejecutar todas las pruebas de la clase
     * Incluye pruebas de atributos, constructor de copia y gestión de cuentas
     *
     * @param args argumentos
     */
    public static void main(String[] args) {
        TestCliente test = new TestCliente();

        // Prueba de constructor y atributos
        test.testConstructor();
        test.testSet();
        test.testGet();

        // Prueba de gestión de cuentas
        test.testCuentas();

        // Prueba del constructor copia
        Cliente copia = new Cliente(test.cliente);
        test.testConstructor(copia);
    }
}
