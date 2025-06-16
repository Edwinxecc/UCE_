/**
 * @author Edwin Caiza
 */
package ec.edu.uce.dominio;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * Representa a un empleado dentro de la organización.
 * Contiene información personal, de contacto, salario, puesto y fecha de contratación.
 */
public class Empleado {

    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private String direccion;
    private String telefono;
    private double salario;
    private String puesto;
    private Date fechaContratacion;

    public static final double SALARIO_BASICO = 470.00;
    public static int contador;

    static {
        contador = 0;
    }

    /**
     * Constructor por defecto que inicializa con valores predeterminados.
     */
    public Empleado() {
        this(1, "sin nombre", "sin apellido", "@mail", "", "", SALARIO_BASICO, "", new Date());
    }

    /**
     * Constructor que inicializa todos los atributos del empleado.
     *
     * @param id                Identificador del empleado
     * @param nombre            Nombre del empleado
     * @param apellido          Apellido del empleado
     * @param correo            Correo electrónico
     * @param direccion         Dirección de residencia
     * @param telefono          Teléfono de contacto
     * @param salario           Salario mensual
     * @param puesto            Puesto asignado
     * @param fechaContratacion Fecha de contratación (si es null se asigna la fecha actual)
     */
    public Empleado(int id, String nombre, String apellido, String correo,
                    String direccion, String telefono, double salario,
                    String puesto, Date fechaContratacion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.salario = salario;
        this.puesto = puesto;
        this.fechaContratacion = (fechaContratacion != null) ? fechaContratacion : new Date();
    }

    // Getters

    /**
     * @return ID del empleado
     */
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    /**
     * Establece la fecha de contratación. Si se pasa null, se asigna la fecha actual.
     *
     * @param fechaContratacion Fecha de contratación o null
     */
    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = (fechaContratacion != null) ? fechaContratacion : new Date();
    }

    /**
     * Incrementa el salario del empleado en el monto especificado.
     *
     * @param monto cantidad a incrementar
     */
    public void incrementarSalario(double monto) {
        this.salario += monto;
    }

    /**
     * Devuelve una representación en texto del empleado, incluyendo salario formateado y fecha legible.
     *
     * @return cadena representativa del objeto
     */
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechaStr = (fechaContratacion != null) ? sdf.format(fechaContratacion) : "N/A";

        return "ID=" + id +
                ", Nombre=" + nombre +
                ", Apellido=" + apellido +
                ", Correo=" + correo +
                ", Dirección=" + direccion +
                ", Teléfono=" + telefono +
                ", Puesto=" + puesto +
                ", Salario=$" + String.format("%.2f", salario) +
                ", Fecha Contratación=" + fechaStr;
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (o != null && o instanceof Empleado) {
            Empleado empleado = (Empleado) o;
            if (this.nombre.equals(empleado.nombre) && this.apellido.equals(empleado.apellido)) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = 7 * hash + Objects.hashCode(this.getNombre());
        hash = 7 * hash + Objects.hashCode(this.getApellido());
        return hash;
    }
}