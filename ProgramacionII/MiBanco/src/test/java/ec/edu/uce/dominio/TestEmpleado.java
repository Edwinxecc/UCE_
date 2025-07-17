package ec.edu.uce.dominio;

import java.util.Date;

/**
 * Clase de prueba para verificar el comportamiento de las clases
 * Empleado, Manager y sus métodos.
 */
public class TestEmpleado {

    /**
     * Método principal para realizar pruebas básicas con Empleado y Manager.
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        // Crear un empleado básico
        Empleado empleado = new Empleado();
        empleado.setNombre("Pedro");
        empleado.setTelefono("17000");
        System.out.println("Empleado: " + empleado);

        // Crear un manager con el constructor por defecto
        Manager manager = new Manager();
        System.out.println("Manager (antes de incremento): " + manager);

        // Incrementar salario
        manager.incrementarSalario(1000.00);
        System.out.println("Manager (después de incremento): " + manager);

        // Polimorfismo: asignar un Manager a una variable tipo Empleado
        Empleado empleado1 = new Manager();
        Empleado empleado2 = new Manager();

        // Esto no es válido directamente, ya que Empleado no tiene getDepartamento():
        // empleado1.getDepartamento(); Error de compilación

        // Para acceder a métodos de Manager, se necesita hacer downcasting
        if (empleado1 instanceof Manager) {
            Manager castedManager = (Manager) empleado1;
            System.out.println("Departamento del manager casteado: " + castedManager.getDepartamento());
        }

        // También se puede hacer en una sola línea:
        System.out.println("Acceso directo al departamento (downcasting): " +
                ((Manager) empleado1).getDepartamento());
        empleado=new Empleado(1,"Felipe","Caicedo","","","",1500,"", new Date());
        empleado1=new Empleado(1,"Paco","Perez","","","",500,"", new Date());
        if (empleado.equals(empleado1)){
            System.out.println("Los empleados son iguales\r\n"+empleado+"\r\n" +
                    "\n "+empleado1);
        } else{
            System.out.println("Los empleados son distintos\r\n"+empleado+"\r\n"+empleado1);
        }
    }
}
