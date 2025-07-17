/**
 * @author Jhon Avila
 */
package ec.edu.uce.dominio;

import java.util.Date;

/**
 * Representa a un Manager, que es un tipo especializado de Empleado
 * con asignación a un departamento específico dentro de la organización.
 */
public class Manager extends Empleado {

    private String departamento;

    public double getBono() {
        return bono;
    }

    public void setBono(double bono) {
        this.bono = bono;
    }

    private double bono;
    /**
     * Constructor por defecto.
     * Inicializa el departamento como "Sin asignar".
     */
    public Manager() {
        super();  // Llama al constructor por defecto de Empleado
        this.setSalario(2000);
        this.departamento = "Sin asignar";
    }

    /**
     * Constructor para crear un Manager con todos los atributos.
     *
     * @param id                Identificador único del empleado
     * @param nombre            Nombre del empleado
     * @param apellido          Apellido del empleado
     * @param correo            Correo electrónico del empleado
     * @param direccion         Dirección de residencia
     * @param telefono          Número de teléfono
     * @param salario           Salario mensual
     * @param puesto            Puesto o cargo del empleado
     * @param fechaContratacion Fecha de contratación
     * @param departamento      Departamento asignado
     */
    public Manager(int id, String nombre, String apellido, String correo,
                   String direccion, String telefono, double salario,
                   String puesto, Date fechaContratacion, String departamento) {
        super(id, nombre, apellido, correo, direccion, telefono, salario, puesto, fechaContratacion);
        this.departamento = departamento;
    }

    public Manager(String nombre, String apellido) {
        super();
        this.departamento = departamento;
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.bono=500.00;
    }

    /**
     * Obtiene el nombre del departamento asignado al Manager.
     *
     * @return nombre del departamento
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * Establece el nombre del departamento para el Manager.
     *
     * @param departamento nombre del departamento
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * Devuelve una representación en texto del Manager,
     * incluyendo la información heredada del empleado y su departamento.
     *
     * @return cadena con los datos del manager
     */
    @Override
    public String toString() {
        return "Manager: "+ super.toString() + ", \r\nDepartamento= " + departamento+ "\r\nBono= "+bono;
    }
}
