package ec.edu.uce.dominio;

import java.util.*;

public class TestComparator {
    public static void main(String[] args) {
        List<Cliente> listaCliente = new ArrayList<>(3);
        List<Empleado> listaEmpleado= new ArrayList<>(3);

        Comparator<Cliente> ordenNombre = new OrdenarClienteNombre();
        Comparator<Cliente> ordenId = new OrdenarClienteId();
        Comparator<Empleado> ordenNombreEmpleado = new OrdenarEmpleadoNombre();
        Comparator<Empleado> ordenCodigoEmpleado= new OrdenarEmpleadoId()   ;

        listaCliente.add(new Cliente("Juan", "Perez", "mail.com", new Date()));
        listaCliente.add(new Cliente("Sofia", "Perez", "mail.com", new Date()));
        listaCliente.add(new Cliente("Julio", "Perez", "mail.com", new Date()));
        listaCliente.add(new Cliente("Arnold", "Perez", "mail.com", new Date()));

        listaEmpleado.add(new Empleado(3,"Paco","Perez","mail.com","sin direccion","000",50.00,"Ventas",new Date()));
        listaEmpleado.add(new Empleado(4,"Maria","Perez","mail.com","sin direccion","000",50.00,"Ventas",new Date()));
        listaEmpleado.add(new Empleado(2,"Pepe","Perez","mail.com","sin direccion","000",50.00,"Ventas",new Date()));
        listaEmpleado.add(new Empleado(1,"Sofia","Perez","mail.com","sin direccion","000",50.00,"Ventas",new Date()));

        Collections.sort(listaCliente, ordenNombre);
        Collections.sort(listaEmpleado, ordenNombreEmpleado);

        // Ordenar Nombre
        System.out.println("Ordenar por Nombre");
        System.out.println("Cliente:\n");
        for (Cliente cli: listaCliente){
            System.out.println(cli);
        }
        System.out.println("\r\nEmpleado:\n");
        for (Empleado emp: listaEmpleado){
            System.out.println(emp);
        }

        Collections.sort(listaCliente, ordenId);
        Collections.sort(listaEmpleado, ordenCodigoEmpleado);

        // Ordenar Codigo
        System.out.println("\r\nOrdenar por Código");
        System.out.println("Cliente:\n");
        for (Cliente cli: listaCliente){
            System.out.println(cli);
        }
        System.out.println("\r\nEmpleado:\n");

        for (Empleado emp: listaEmpleado){
            System.out.println(emp);
        }

    }
}
