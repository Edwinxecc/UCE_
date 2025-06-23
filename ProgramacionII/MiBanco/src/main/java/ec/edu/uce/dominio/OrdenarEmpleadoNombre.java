package ec.edu.uce.dominio;

import java.util.Comparator;

public class OrdenarEmpleadoNombre implements Comparator<Empleado> {
    @Override
    public int compare(Empleado o1, Empleado o2) {
        int resultado = o1.getApellido().compareTo(o2.getApellido());
        if (resultado != 0){
            return resultado;
        }else {
            return 0;
        }
    }
}
