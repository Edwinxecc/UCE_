package ec.edu.uce.dominio;

import java.util.Comparator;

public class OrdenarEmpleadoCodigo implements Comparator<Empleado> {
    @Override
    public int compare(Empleado o1, Empleado o2) {
        if(o1.getId()<o2.getId()){
            return -1;
        } else if (o1.getId()>o2.getId()) {
            return 1;
        }
        return 0;
    }
}
