/**
 * @author Jhon Avila
 */
package ec.edu.uce.dominio;

import java.util.Date;

/**
 * Representa a un Director que es un tipo especializado de Manager,
 * con autoridad para aprobar gastos según un presupuesto asignado.
 */
public class Director extends Manager {

    /**
     * Presupuesto asignado al director para autorizar gastos.
     */
    private double presupuesto;
    private double comision;
    /**
     * Constructor por defecto que inicializa el director con valores predeterminados.
     */
    public Director() {
        super();
        this.setSalario(3000);
        presupuesto=10000.00;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    /**
     * Constructor que inicializa todos los atributos del director,
     * incluyendo los heredados de Manager y su presupuesto.
     *
     * @param id                Identificador del director
     * @param nombre            Nombre del director
     * @param apellido          Apellido del director
     * @param correo            Correo electrónico del director
     * @param direccion         Dirección de residencia del director
     * @param telefono          Teléfono de contacto del director
     * @param salario           Salario mensual del director
     * @param puesto            Puesto del director
     * @param fechaContratacion Fecha de contratación
     * @param departamento      Departamento asignado
     * @param presupuesto       Presupuesto asignado para aprobar gastos
     */
    public Director(int id, String nombre, String apellido, String correo,
                    String direccion, String telefono, double salario,
                    String puesto, Date fechaContratacion,
                    String departamento, double presupuesto) {
        super(id, nombre, apellido, correo, direccion, telefono, salario, puesto, fechaContratacion, departamento);
        this.presupuesto = presupuesto;
    }

    public Director(String nombre, String apellido) {
        super();
        this.presupuesto = presupuesto;
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.comision=400.00;
    }

    /**
     * Obtiene el presupuesto asignado al director.
     *
     * @return presupuesto actual
     */
    public double getPresupuesto() {
        return presupuesto;
    }

    /**
     * Asigna un nuevo presupuesto al director.
     *
     * @param presupuesto nuevo presupuesto
     */
    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    /**
     * Verifica si un gasto puede ser aprobado de acuerdo al presupuesto disponible.
     *
     * @param gasto Monto del gasto a evaluar
     * @return true si el gasto es menor o igual al presupuesto, false en caso contrario
     */
    public boolean aprobarGasto(double gasto) {
        return gasto <= presupuesto;
    }

    /**
     * Devuelve una representación en cadena del director, incluyendo el presupuesto.
     *
     * @return cadena descriptiva del director
     */
    @Override
    public String toString() {
        return "Director: "+super.toString() + ", \r\nPresupuesto=" + presupuesto+" \r\nComisión= "+comision;
    }
}
