package ec.edu.uce.dominio;
/**
 * Representa a un Director que extiende la clase Empleado,
 * con información adicional sobre departamento y presupuesto.
 */
public class Director extends Empleado {
    private String departamento;
    private double presupuesto;

    /**
     * Constructor por defecto.
     */
    public Director() {
        super();
        this.departamento = "Sin departamento";
        this.presupuesto = 0.0;
    }

    /**
     * Constructor con parámetros.
     *
     * @param nombre      Nombre del director.
     * @param apellido    Apellido del director.
     * @param genero      Genero del director.
     * @param correo      correo del manager.
     * @param fechaIngreso fecha de ingreso del manager.
     * @param salario     Salario del manager.
     * @param departamento Departamento al que pertenece.
     */
    public Director(int id, String nombre, String apellido, Genero genero, String correo, Fecha fechaIngreso,
                    double salario, String departamento, double presupuesto) {
        super(id, nombre, apellido, genero, correo, fechaIngreso);
        this.setSalario(salario);
        this.setPuesto("Director");
        this.departamento = departamento;
        this.presupuesto = presupuesto;
    }

    /**
     * Obtiene el departamento del director.
     *
     * @return Nombre del departamento.
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * Establece el departamento del director.
     *
     * @param departamento Nombre del nuevo departamento.
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * Obtiene el presupuesto asignado.
     *
     * @return Presupuesto actual.
     */
    public double getPresupuesto() {
        return presupuesto;
    }

    /**
     * Establece el presupuesto disponible.
     *
     * @param presupuesto Nuevo valor del presupuesto.
     */
    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    /**
     * Verifica si el gasto puede ser aprobado según el presupuesto disponible.
     *
     * @param gasto Monto del gasto a evaluar.
     * @return true si el gasto es aprobado, false si es rechazado.
     */
    public boolean aprobarPresupuesto(double gasto) {
        if (gasto <= presupuesto) {
            System.out.println("Presupuesto aprobado: $" + gasto);
            return true;
        } else {
            System.out.println("Presupuesto rechazado. Gasto excede el límite: $" + gasto);
            return false;
        }
    }

    /**
     * Devuelve una representación en texto del director.
     *
     * @return Información completa del director.
     */
    @Override
    public String toString() {
        return super.toString() +
                ", Director [departamento=" + departamento +
                ", presupuesto=" + presupuesto + "]";
    }

}
