package ec.edu.uce.dominio;

public class TestEmpleado {
    //ejecutar y hacer contador id autonumerado para empleado, en el contructor por defecto asiganar el salario basico
    public static void main(String[] args) {
        Empleado emp1 = new Empleado();
        System.out.println(emp1);
        // test de auto numerado
        Empleado emp2 = new Empleado();
        System.out.println(emp2);

        Empleado emp3 = new Empleado();
        System.out.println(emp3);
    }
}
