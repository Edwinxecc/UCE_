package ec.edu.uce.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static ec.edu.uce.dominio.Genero.FEMENINO;
import static ec.edu.uce.dominio.Genero.MASCULINO;

public class TestComparatorEmpleado {
    public static void main(String[] args) {
        List<Empleado> listaEmpleados = new ArrayList<>(3);
        Comparator<Empleado> ordenNombre = new OrdenarEmpleadoNombre();
        Comparator<Empleado> ordenCodigo = new OrdenarEmpleadoCodigo();
        listaEmpleados.add(new Empleado(7, "Lucas", "Armijo", 800.0, MASCULINO));
        listaEmpleados.add(new Empleado(1, "Valentina", "Gómez", 950.0, FEMENINO));
        listaEmpleados.add(new Empleado(2, "Martín", "Pérez", 1020.0, MASCULINO));
        listaEmpleados.add(new Empleado(3, "Camila", "López", 875.5, FEMENINO));
        listaEmpleados.add(new Empleado(4, "Joaquín", "Sosa", 1100.0, MASCULINO));
        listaEmpleados.add(new Empleado(5, "Lucía", "Martínez", 720.0, FEMENINO));
        listaEmpleados.add(new Empleado(6, "Mateo", "Fernández", 980.0, MASCULINO));
        listaEmpleados.add(new Empleado(8, "Sofía", "Ruiz", 890.0, FEMENINO));
        listaEmpleados.add(new Empleado(9, "Benjamín", "Torres", 1050.0, MASCULINO));
        listaEmpleados.add(new Empleado(10, "Isidora", "Navarro", 930.0, FEMENINO));


        Collections.sort(listaEmpleados, ordenNombre);

        // ordenar nombre
        System.out.println("Ordenar por nombre: ");
        for (Empleado emp: listaEmpleados){
            System.out.println(emp);
        }

        Collections.sort(listaEmpleados, ordenCodigo);
        // ordenar codigo
        System.out.println("Ordenar por codigo: ");
        for (Empleado emp: listaEmpleados){
            System.out.println(emp);
        }
    }
}
