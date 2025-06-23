package ec.edu.uce.dominio;
import java.util.*;

import static ec.edu.uce.dominio.Genero.FEMENINO;
import static ec.edu.uce.dominio.Genero.MASCULINO;

public class TestComparator {
    public static void main(String[] args) {
        List<Cliente> listaClientes = new ArrayList<>(3);
        Comparator<Cliente> ordenNombre = new OrdenarClienteNombre();
        Comparator<Cliente> ordenCodigo = new OrdenarClienteCodigo();
        listaClientes.add(new Cliente(1, "Lucas", "Dalto", MASCULINO));
        listaClientes.add(new Cliente(5, "Dayana", "Perez", FEMENINO));
        listaClientes.add(new Cliente(3, "Oscar", "Sanchez", MASCULINO));
        listaClientes.add(new Cliente(8, "Robert", "Openheimer", MASCULINO));

        Collections.sort(listaClientes, ordenNombre);

        // ordenar nombre
        System.out.println("Ordenar por nombre: ");
        for (Cliente cli: listaClientes){
            System.out.println(cli);
        }

        Collections.sort(listaClientes, ordenCodigo);
        // ordenar codigo
        System.out.println("Ordenar por codigo: ");
        for (Cliente cli: listaClientes){
            System.out.println(cli);
        }
    }
}
