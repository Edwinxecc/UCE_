package ec.edu.uce.dominio;
/**
 * Clase que representa a un Manager, que es un tipo de Empleado,
 * con información adicional de cédula y departamento.
 */
public class Manager extends Empleado {
    private String cedula;
    private String departamento;

    /**
     * Constructor por defecto.
     */
    public Manager() {
        super();
        this.cedula = "No definida";
        this.departamento = "Sin departamento";
        this.setPuesto("Manager");  // establecer puesto por defecto
    }

    /**
     * Constructor con parámetros.
     *
     * @param id           Identificador del empleado.
     * @param nombre       Nombre del manager.
     * @param apellido     Apellido del manager.
     * @param genero       Genero del manager.
     * @param correo       correo del manager.
     * @param fechaIngreso fecha de ingreso del manager.
     * @param salario      Salario del manager.
     * @param cedula       Cédula del manager.
     * @param departamento Departamento al que pertenece.
     */
    // Constructor completo con todos los atributos de Empleado + Manager
    public Manager(int id, String nombre, String apellido, Genero genero, String correo,
                   Fecha fechaIngreso, double salario, String cedula, String departamento) {
        super(id, nombre, apellido, genero, correo, fechaIngreso);
        this.setSalario(salario);
        this.setPuesto("Manager");
        this.cedula = cedula;
        this.departamento = departamento;
    }

    // Getters y setters

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        if (cedula == null || cedula.trim().isEmpty()) {
            throw new IllegalArgumentException("La cédula no puede estar vacía.");
        }
        this.cedula = cedula;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        if (departamento == null || departamento.trim().isEmpty()) {
            throw new IllegalArgumentException("El departamento no puede estar vacío.");
        }
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Manager [cedula=" + cedula +
                ", departamento=" + departamento + "]";
    }


}
