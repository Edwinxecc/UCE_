package ec.edu.uce.dominio;

import java.util.Comparator;

public class OrdenarClienteId implements Comparator<Cliente> {

    public int compare(Cliente o1, Cliente o2) {
        return Integer.compare(o1.getClienteId(), o2.getClienteId());  // ascendente
    }

}
