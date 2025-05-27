package ec.edu.uce.dominio;

import static ec.edu.uce.dominio.Banco.esCorreoValido;

/**
 * Clase que representa un empleado del banco.
 * Contiene atributos y métodos para gestionar la información de un empleado.
 * Esta clase está diseñada para integrarse con la clase Banco.
 *
 * @author Samanta Tuqueres
 */
public class Empleado {
    private int id;
    private String nombre;
    private String apellido;
    private Genero genero;
    private String correo;
    private Fecha fechaIngreso;
    private double salario;
    private String puesto;
    public static final double SALARIO_BASICO = 500.0;

    /**
     * Constructor parametrizado para crear un empleado completo.
     *
     * @param id           Identificador del empleado (no negativo)
     * @param nombre       Nombre del empleado (no vacío)
     * @param apellido     Apellido del empleado (no vacío)
     * @param genero       Género del empleado (no nulo)
     * @param correo       Correo válido
     * @param fechaIngreso Fecha de ingreso (no futura)
     */
    public Empleado(int id, String nombre, String apellido, Genero genero, String correo, Fecha fechaIngreso) {
        setId(id);
        setNombre(nombre);
        setApellido(apellido);
        setGenero(genero);
        setCorreo(correo);
        setFechaIngreso(fechaIngreso);
        this.salario = 0.0;  // salario inicial 0.0
        this.puesto = "No definido"; // puesto inicial
    }

    /**
     * Constructor para editar empleado sin cambiar fecha ingreso y género,
     * pero actualizando nombre, apellido, salario y puesto.
     *
     * @param id       Identificador (para conservar el id original)
     * @param nombre   Nuevo nombre
     * @param apellido Nuevo apellido
     * @param salario  Nuevo salario
     * @param puesto   Nuevo puesto
     */
    public Empleado(int id, String nombre, String apellido, double salario, String puesto) {
        setId(id);
        setNombre(nombre);
        setApellido(apellido);
        this.salario = salario;
        this.puesto = puesto;
        this.genero = null;
        this.correo = null;
        this.fechaIngreso = null;
    }

    /**
     * Constructor por defecto.
     * Inicializa valores básicos para evitar errores al extender la clase.
     */
    public Empleado() {
        this.id = 0;
        this.nombre = "Sin nombre";
        this.apellido = "Sin apellido";
        this.genero = null;
        this.correo = null;
        this.fechaIngreso = null;
        this.salario = 0.0;
        this.puesto = "No definido";
    }

    // Getters y setters con validaciones

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0)
            throw new IllegalArgumentException("El ID no puede ser negativo.");
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty())
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        if (apellido == null || apellido.trim().isEmpty())
            throw new IllegalArgumentException("El apellido no puede estar vacío.");
        this.apellido = apellido;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        if (genero == null)
            throw new IllegalArgumentException("El género no puede ser nulo.");
        this.genero = genero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        if (!esCorreoValido(correo)) {
            System.out.println("Error: El correo no es válido.");
        } else {
            this.correo = correo;
        }
    }


    public Fecha getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Fecha fechaIngreso) {
        if (fechaIngreso == null)
            throw new IllegalArgumentException("La fecha de ingreso no puede ser nula.");
        if (Banco.esFechaFutura(fechaIngreso))
            throw new IllegalArgumentException("La fecha de ingreso no puede ser futura.");
        this.fechaIngreso = fechaIngreso;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario < 0)
            throw new IllegalArgumentException("El salario no puede ser negativo.");
        this.salario = salario;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        if (puesto == null || puesto.trim().isEmpty())
            throw new IllegalArgumentException("El puesto no puede estar vacío.");
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return "Empleado [id=" + id +
                ", nombre=" + nombre +
                ", apellido=" + apellido +
                ", genero=" + (genero != null ? genero : "No definido") +
                ", correo=" + (correo != null ? correo : "No definido") +
                ", fechaIngreso=" + (fechaIngreso != null ? fechaIngreso : "No definido") +
                ", salario=" + salario +
                ", puesto=" + puesto +
                "]";
    }


    // Clase 26/05/2025
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return nombre.equals(empleado.nombre) &&
                apellido.equals(empleado.apellido);
    }
}