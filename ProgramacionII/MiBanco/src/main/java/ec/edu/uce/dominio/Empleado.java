package ec.edu.uce.dominio;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Esta clase representa a un **empleado** dentro de la estructura bancaria.
 * Almacena datos personales y laborales como nombre, salario, género, y otros.
 * @author Edwin Caiza
 */
public class Empleado implements Comparable<Empleado> {

    /**
     * El **salario básico** referencial para todos los empleados del banco.
     * Es un valor constante accesible directamente desde la clase.
     */
    public static final double SALARIO_BASICO = 470.00;

    /**
     * Un **contador estático** para generar identificadores únicos para cada empleado.
     * Se incrementa automáticamente al crear un nuevo empleado sin un ID predefinido.
     * Se ajusta si se proporciona un ID explícito para evitar duplicados.
     */
    public static int contador;

    // Bloque estático que se ejecuta una única vez al cargar la clase, inicializando el contador.
    static {
        contador = 0;
    }

    // Atributos que definen las características del empleado.
    private final int id; // ID único e inmutable.
    private String nombre;
    private String apellido;
    private String correo;
    private String direccion;
    private String[] telefonos;
    private Fecha fechaNacimiento;
    private Genero genero;
    private double salario;
    private String puesto;
    private Fecha fechaContratacion;

    /**
     * Constructor completo para crear un empleado con todos sus datos.
     * El ID del empleado se asigna automáticamente al instanciarlo.
     */

    public Empleado(int id, String nombre, String apellido, double salario, Genero gen){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.salario = salario;
        this.genero = gen;
    }

    public Empleado(String nombre, String apellido, String correo, String direccion,
                    String[] telefonos, Fecha fechaNacimiento, Genero genero,
                    double salario, String puesto, Fecha fechaContratacion) {
        this.id = ++contador; // Asigna un ID único y autoincrementado.

        // Se utilizan los setters para aplicar validaciones básicas al asignar los valores.
        setNombre(nombre);
        setApellido(apellido);
        setCorreo(correo);
        setDireccion(direccion);
        setTelefonos(telefonos);
        setFechaNacimiento(fechaNacimiento);
        setGenero(genero);
        setSalario(salario);
        setPuesto(puesto);
        setFechaContratacion(fechaContratacion);
    }

    /**
     * Constructor simplificado que acepta solo los datos esenciales.
     * Los campos no proporcionados se inicializan con valores por defecto.
     * El ID se genera automáticamente.
     */
    public Empleado(String nombre, String apellido, Genero genero, double salario) {
        // Llama al constructor completo, rellenando los campos faltantes con valores predeterminados.
        this(nombre, apellido, "", "", new String[0], null, genero, salario, "", null);
    }

    /**
     * Constructor para crear un empleado con un ID predefinido.
     * Útil para cuando el ID ya es conocido o proviene de una fuente externa.
     */
    public Empleado(int id, String nombre, String apellido, String correo, String direccion,
                    String[] telefonos, Fecha fechaNacimiento, Genero genero,
                    double salario, String puesto, Fecha fechaContratacion) {
        this.id = id; // Asigna el ID recibido como parámetro.

        // Ajusta el contador estático para mantener la unicidad en futuros IDs autogenerados.
        if (id >= contador) {
            contador = id + 1;
        }

        // Se utilizan los setters para asignar los valores con sus respectivas validaciones.
        setNombre(nombre);
        setApellido(apellido);
        setCorreo(correo);
        setDireccion(direccion);
        setTelefonos(telefonos);
        setFechaNacimiento(fechaNacimiento);
        setGenero(genero);
        setSalario(salario);
        setPuesto(puesto);
        setFechaContratacion(fechaContratacion);
    }

    // --- Métodos Getters y Setters ---

    public int getId() { return id; }
    // No existe un setter para 'id' porque es un atributo final (inmutable).

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        this.nombre = (nombre != null && !nombre.trim().isEmpty()) ? nombre : "Desconocido";
    }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) {
        this.apellido = (apellido != null && !apellido.trim().isEmpty()) ? apellido : "Desconocido";
    }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) {
        this.correo = (correo != null) ? correo : "";
    }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) {
        this.direccion = (direccion != null) ? direccion : "";
    }

    public String[] getTelefonos() { return telefonos; }
    public void setTelefonos(String[] telefonos) {
        // Realiza una copia defensiva del arreglo para evitar modificaciones externas directas.
        this.telefonos = (telefonos != null) ? Arrays.copyOf(telefonos, telefonos.length) : new String[0];
    }

    public Fecha getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(Fecha fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Genero getGenero() { return genero; }
    public void setGenero(Genero genero) {
        // Asigna el género proporcionado, o `Genero.OTRO` si es nulo.
        this.genero = (genero != null) ? genero : Genero.OTRO;
    }

    public double getSalario() { return salario; }
    public void setSalario(double salario) {
        // Valida que el salario no sea negativo.
        if (salario >= 0) {
            this.salario = salario;
        } else {
            System.out.println("Advertencia (Empleado Salario): El salario no puede ser negativo. Se ha establecido en 0.0.");
            this.salario = 0.0;
        }
    }

    public String getPuesto() { return puesto; }
    public void setPuesto(String puesto) {
        this.puesto = (puesto != null && !puesto.trim().isEmpty()) ? puesto : "Sin Puesto";
    }

    public Fecha getFechaContratacion() { return fechaContratacion; }
    public void setFechaContratacion(Fecha fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    /**
     * Calcula el **bono anual** del empleado.
     * Por defecto, este bono es el 20% de su salario.
     * @return El monto del bono anual.
     */
    public double calcularBonoAnual() {
        return salario * 0.20;
    }

    /**
     * Proporciona una representación en cadena con la **información principal del empleado**.
     * Incluye su ID, nombre, salario, puesto, género y números de teléfono.
     * @return Una cadena formateada con los datos clave del empleado.
     */
    @Override
    public String toString() {
        String telString = (telefonos != null && telefonos.length > 0)
                ? String.join(", ", telefonos)
                : "No tiene";

        return "Empleado [ID=" + id + ", Nombre=" + nombre + ", Apellido=" + apellido +
                ", Género=" + genero + ", Salario=" + String.format("%.2f", salario) +
                ", Puesto=" + puesto + ", Teléfonos=" + telString + "]";
    }

    /**
     * Compara este empleado con otro objeto para determinar si son iguales.
     * La comparación se basa en el **ID único** del empleado.
     * @param o El objeto con el que se va a comparar.
     * @return `true` si los empleados tienen el mismo ID, `false` en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return id == empleado.id; // La igualdad se define por el ID.
    }

    /**
     * Genera un **valor hash** para el empleado, que es consistente con el método `equals()`.
     * El hash se calcula a partir del ID del empleado.
     * @return El código hash del empleado.
     */
    @Override
    public int hashCode() {
        return Integer.hashCode(id); // El hash se basa en el ID único.
    }

    /**
     *
     * @param o the object to be compared.
     * @return numero negativo o positivo y 0 si son iguales
     */

    public int compareTo(Empleado o) {
        int resultado = this.apellido.compareTo(o.getNombre()); // comparacion entre objetos
        if (resultado > 0){
            return 1;
        }else if (resultado < 0){
            return -1;
        }
        return 0;
    }
}