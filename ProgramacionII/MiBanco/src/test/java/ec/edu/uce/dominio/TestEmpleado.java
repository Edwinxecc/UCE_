package ec.edu.uce.dominio;

public class TestEmpleado {
    public static void main(String[] args) {
        // parametros  id, name, cedula, salario
        Empleado empleado = new Empleado(1, "Pedro", "Juarez", 153);
        System.out.println(empleado);

        Manager manager = new Manager();
        manager.incrementarSalario(1000);
        System.out.println(manager);

        Empleado empleado1= new Manager();

    }
}
