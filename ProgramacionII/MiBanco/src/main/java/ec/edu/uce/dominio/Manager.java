package ec.edu.uce.dominio;

public class Manager extends Empleado {
    protected String deptNombre;

    public Manager() {
        super();
        this.deptNombre = "sin departamento";
    }

    public Manager(int id, String nombre, String apellido, Genero genero,double salario, String departamento ) {
        super(id, nombre, apellido, genero, salario);
        //setDeptNombre(departamento);
        this.deptNombre = departamento;

    }

    public Manager(int empleadoId, String nombre, String apellido, String correo,
                   String direccion, String telefono, Fecha fechaNacimiento, Genero genero,
                   double salario, String puesto, Fecha fechaContratacion, String departamento) {
        super(empleadoId, nombre, apellido, correo, direccion, telefono, fechaNacimiento, genero, salario, puesto, fechaContratacion);
        setDeptNombre(departamento);
    }

    public String getDeptNombre() {
        return deptNombre;
    }

    public void setDeptNombre(String deptNombre) {
        if (deptNombre != null && !deptNombre.trim().isEmpty()) {
            this.deptNombre = deptNombre;
        } else {
            this.deptNombre = "sin departamento";
        }
    }

    @Override
    public double calcularBonoAnual() {
        return getSalario() * 0.40;
    }

    @Override
    public String toString() {
        return super.toString().replace("]", "") +
                ", Departamento = " + deptNombre +
                ", Bono Manager = $" + String.format("%.2f", calcularBonoAnual()) + "]";
    }
}