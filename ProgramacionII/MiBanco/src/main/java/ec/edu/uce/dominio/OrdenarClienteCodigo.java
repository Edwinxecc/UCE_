package ec.edu.uce.dominio;

import java.util.Comparator;

public class OrdenarClienteCodigo implements Comparator<Cliente> {
    @Override
    public int compare(Cliente o1, Cliente o2){
        if (o1.getId() < o2.getId()){
            return -1;
        }else if (o1.getId() > o2.getId()){
            return 1;
        }
        return 0;
    }
}
