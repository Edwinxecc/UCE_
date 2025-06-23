package ec.edu.uce.dominio;
/**
 * @author Edwin Caiza
 */

import java.util.Comparator;

public class OrdenarClienteNombre implements Comparator<Cliente> {

    @Override
    public int compare(Cliente o1, Cliente o2) {
        int resultado = o1.getNombre().compareTo(o2.getNombre());

        if (resultado != 0) {
            return resultado;
        } else
            return 0;
    }
}