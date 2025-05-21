package ec.edu.uce.dominio;

public class Manager extends Empleado{
    private String departamentoNombre;

    public Manager(){
        super();
        this.departamentoNombre = "Sin departamento";
    }

    public Manager(int id, String nombre, String cedula, double salario, String departamento){
        super(id, nombre, cedula, salario);
        this.departamentoNombre = departamento;
    }

    public String getDepartamentoNombre() {
        return departamentoNombre;
    }

    public void setDepartamentoNombre(String departamentoNombre) {
        this.departamentoNombre = departamentoNombre;
    }

    @Override
    public String toString() {
        return super.toString() + "Departamento: " + this.departamentoNombre;
    }
}
