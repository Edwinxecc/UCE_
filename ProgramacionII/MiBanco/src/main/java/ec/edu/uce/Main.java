/**
 * @author Edwin Caiza
 */
package ec.edu.uce;
import ec.edu.uce.dominio.*;

/**
 * Clase principal para probar las funcionalidades del Banco y Cliente.
 *
 */
public class Main {
    public static void main(String[] args) {
        Banco banco = Banco.getInstance();
        System.out.println(banco);

        String gen = "F";

        switch (gen){
            case "F":{
                banco.agregarCliente(2, "Ana", "Perez", Genero.FEMENINO);
                break;
            }
            case "M":{
                banco.agregarCliente(2, "Juan", "Perez", Genero.MASCULINO);
                break;
            }
        }

        Banco.agregarEmpleado(new Empleado());
        Banco.agregarEmpleado(new Manager("Arturo","Paez"));
        Banco.agregarEmpleado(new Director("Patricio","Villavicencio"));

        System.out.println(Banco.consultarEmpleados());

        for (Empleado empleado:Banco.getStaff()) {
            if (empleado!=null){
                System.out.println("\r\nEmpleado: "+empleado+
                        " \n\rImpuesto: "+Impuesto.calcularImpuesto(empleado));
            }
        }
        /*banco.agregarCliente(2, "Juan", "Perez", Genero.MASCULINO);
        System.out.println(banco.getCliente(0));
        System.out.println(banco.consultarClientes());

        // Cambiado para usar constructor válido
        Cliente cliente = new Cliente(5, "Ana", "Perez", Genero.FEMENINO);
        System.out.println("Cliente " + cliente);

        banco.agregarCliente(1,"Ana","Mera",Genero.FEMENINO);
        Cliente c = banco.getCliente(1);
        c.nuevoCuenta(new CuentaAhorro(100));
        c.nuevoCuenta(new CuentaCorriente(200,100));

        banco.agregarCliente(2,"Juan","Mera",Genero.MASCULINO);
        c = banco.getCliente(2);
        c.nuevoCuenta(new CuentaCorriente(1000,500));
        c.nuevoCuenta(new CuentaAhorro(600));

        System.out.println(ReporteCliente.reporteClientes());*/
    }
}