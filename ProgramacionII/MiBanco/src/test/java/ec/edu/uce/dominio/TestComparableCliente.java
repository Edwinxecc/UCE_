package ec.edu.uce.dominio;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class TestComparableCliente {
    public static void main(String[] args) {
        Set<Cliente> listaCliente = new TreeSet<>();

        listaCliente.add(new Cliente("Palermo", "Suarez", "mail.com", new Date()));
        listaCliente.add(new Cliente("Paco", "Suarez", "mail.com", new Date()));
        listaCliente.add(new Cliente("Pedro", "Suarez", "mail.com", new Date()));
        listaCliente.add(new Cliente("Pancracio", "Suarez", "mail.com", new Date()));
        listaCliente.add(new Cliente("Pamela", "Suarez", "mail.com", new Date()));

        for (Cliente cli:listaCliente){
            System.out.println(cli);
        }
    }
}
