package ec.edu.uce.datos;
import ec.edu.uce.dominio.Empleado;

public class EmpleadoDAOMemoryImplementation implements EmpleadoDAO{

    private static Empleado[] staff;
    private static int numEmpleados;

    static {
        staff=new Empleado[0];
        numEmpleados=0;
    }

    @Override
    public void agregarEmpleado(Empleado empleado) {
        boolean respuesta=false;
        if (!validarEmpleado(empleado)){
            if (numEmpleados == staff.length) {
                Empleado[] empaux = staff;
                staff = new Empleado[numEmpleados + 1];
                System.arraycopy(empaux, 0, staff, 0, numEmpleados);
            }
            staff[numEmpleados] = empleado;
            numEmpleados++;
            respuesta=true;
        }
        //return respuesta;
    }

    @Override
    public void editarEmpleado(Empleado empleado) {
        staff[empleado.getId()]=empleado;
    }

    @Override
    public void eliminarEmpleado(int id) {
        staff[id]=null;
    }

    @Override
    public Empleado buscarEmpleadoPorId(int id) {
        if (id<numEmpleados){
            return staff[id];
        }else {
            return null;
        }
    }

    @Override
    public Empleado[] consultarEmpleado() {
        return staff;
    }

    public static boolean validarEmpleado(Empleado empleado){
        for (Empleado e : staff) {
            if (e != null && e.equals(empleado)) {
                return true;
            }
        }
        return false;
    }
}
