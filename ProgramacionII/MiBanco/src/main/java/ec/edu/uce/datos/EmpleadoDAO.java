package ec.edu.uce.datos;

import ec.edu.uce.dominio.Empleado;

public interface EmpleadoDAO {
    public void agregarEmpleado(Empleado empleado);
    public void editarEmpleado(Empleado empleado);
    public void eliminarEmpleado(int id);
    public Empleado buscarEmpleadoPorId(int id);
    public Empleado[] consultarEmpleado();
}
