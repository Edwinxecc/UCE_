package ec.edu.uce.dominio;

/**
 * Clase de prueba para la clase Banco.
 * Crea un banco, añade empleados de diferentes tipos y muestra la lista de empleados.
 */
public class TestBanco {

    /**
     * Método principal para ejecutar la prueba del banco.
     *
     * @param args argumentos de línea de comandos (no usados)
     */
    public static void main(String[] args) {
        // Crear instancia del banco
        Banco banco = new Banco();

        // Agregar empleados de distintas clases
        banco.agregarEmpleado(new Empleado());
        banco.agregarEmpleado(new Manager());
        banco.agregarEmpleado(new Director());

        // Mostrar la lista de empleados del banco
        System.out.println(banco.consultarEmpleados());
    }
}
