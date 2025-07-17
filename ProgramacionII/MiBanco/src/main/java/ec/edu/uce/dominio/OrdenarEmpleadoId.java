package ec.edu.uce.dominio;

import java.util.Comparator;

public class OrdenarEmpleadoId implements Comparator<Empleado> {

    @Override
    public int compare(Empleado o1, Empleado o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }
}
