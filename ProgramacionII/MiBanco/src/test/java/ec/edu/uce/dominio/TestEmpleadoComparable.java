package ec.edu.uce.dominio;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class TestEmpleadoComparable {
    public static void main(String[] args) {

        Set<Empleado> listaEmpleado= new TreeSet<>();

        listaEmpleado.add(new Empleado(3,"Paco","Perez","mail.com","sin direccion","000",50.00,"Ventas",new Date()));
        listaEmpleado.add(new Empleado(4,"Maria","Perez","mail.com","sin direccion","000",50.00,"Ventas",new Date()));
        listaEmpleado.add(new Empleado(2,"Pepe","Perez","mail.com","sin direccion","000",50.00,"Ventas",new Date()));
        listaEmpleado.add(new Empleado(1,"Sofia","Perez","mail.com","sin direccion","000",50.00,"Ventas",new Date()));

        for (Empleado emp: listaEmpleado){
            System.out.println(emp);
        }

    }
}
