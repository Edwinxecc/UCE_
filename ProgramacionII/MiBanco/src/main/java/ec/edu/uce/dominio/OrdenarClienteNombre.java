package ec.edu.uce.dominio;
/**
 * @author Edwin Caiza
 */

import java.util.Comparator;

public class OrdenarClienteNombre implements Comparator<Cliente> {

    @Override
    public int compare(Cliente o1, Cliente o2) {
        int resultado = o1.getApellido().compareTo(o2.getApellido());

        if (resultado != 0) {
            return resultado;
        } else
            return 0;
    }
}