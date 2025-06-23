package ec.edu.uce.dominio;

import java.util.Arrays;

/**
 * Clase Cliente, que representa a un usuario del banco y gestiona sus datos.
 *
 */
public class Cliente implements Comparable<Cliente> {

    // Contador estático para asignar IDs únicos automáticamente
    public static int contador;

    static {
        contador = 0;
    }

    private final int id; // Identificador único e inmutable del cliente
    private String nombre;
    private String apellido;
    private String correo;
    private String direccion;
    private String[] telefonos;
    private Fecha fechaNacimiento;
    private Genero genero;
    private Cuenta[] cuentas; // Arreglo para almacenar las cuentas del cliente
    private int numCuentas; // Contador de cuentas asociadas

    /**
     * Constructor principal para crear una nueva instancia de Cliente con todos sus datos.
     * El ID del cliente se genera automáticamente y es único.
     */
    public Cliente(String nombre, String apellido, String correo, String direccion,
                   String[] telefonos, Fecha fechaNacimiento, Genero genero) {
        this.id = ++contador; // Asigna un ID único autoincrementado

        setNombre(nombre);
        setApellido(apellido);
        setCorreo(correo);
        setDireccion(direccion);
        setTelefonos(telefonos);
        setFechaNacimiento(fechaNacimiento);
        setGenero(genero);

        this.cuentas = new Cuenta[5]; // Capacidad inicial para las cuentas
        this.numCuentas = 0;
    }

    /**
     * Constructor simplificado para crear un cliente con datos esenciales.
     * Otros campos se inicializan con valores por defecto.
     */
    public Cliente(String nombre, String apellido, Genero genero) {
        this(nombre, apellido, "", "", new String[0], null, genero);
    }

    /**
     * Constructor para crear un cliente con un ID predefinido.
     * Útil cuando el ID ya es conocido o viene de una fuente externa.
     */
    public Cliente(int id, String nombre, String apellido, Genero genero) {
        this.id = id;
        // Asegura que el contador estático no sea menor que el ID proporcionado
        if (id >= contador) {
            contador = id + 1;
        }

        setNombre(nombre);
        setApellido(apellido);
        setCorreo("");
        setDireccion("");
        setTelefonos(new String[0]);
        setFechaNacimiento(null);
        setGenero(genero);

        this.cuentas = new Cuenta[5];
        this.numCuentas = 0;
    }

    // --- Métodos Getters y Setters ---

    public int getId() { return id; }

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
        this.telefonos = (telefonos != null) ? Arrays.copyOf(telefonos, telefonos.length) : new String[0];
    }

    public Fecha getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(Fecha fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Genero getGenero() { return genero; }
    public void setGenero(Genero genero) {
        this.genero = (genero != null) ? genero : Genero.OTRO;
    }

    public Cuenta[] getCuentas() {
        return Arrays.copyOf(cuentas, numCuentas); // Devuelve una copia para seguridad
    }

    public int getNumCuentas() { return numCuentas; }

    /**
     * Añade una cuenta a la colección de cuentas del cliente.
     * Si el arreglo de cuentas está lleno, se redimensiona automáticamente.
     */
    public void agregarCuenta(Cuenta cuenta) {
        if (cuenta == null) {
            return;
        }
        // Redimensiona el arreglo si no hay espacio para una nueva cuenta.
        if (numCuentas == cuentas.length) {
            Cuenta[] nuevoArreglo = new Cuenta[cuentas.length * 2];
            System.arraycopy(cuentas, 0, nuevoArreglo, 0, cuentas.length);
            this.cuentas = nuevoArreglo;
        }
        cuentas[numCuentas++] = cuenta;
    }

    /**
     * Elimina una cuenta del cliente basándose en su índice en el arreglo.
     * Desplaza los elementos subsiguientes para mantener la continuidad.
     */
    public boolean eliminarCuenta(int indice) {
        if (indice < 0 || indice >= numCuentas) {
            return false; // Índice fuera de rango.
        }
        // Mueve los elementos a la izquierda para rellenar el espacio vacío.
        System.arraycopy(cuentas, indice + 1, cuentas, indice, numCuentas - 1 - indice);
        cuentas[--numCuentas] = null; // Anula la referencia del último elemento y disminuye el contador.
        return true;
    }

    /**
     * Busca y retorna una cuenta del cliente por su índice.
     */
    public Cuenta buscarCuenta(int indice) {
        if (indice >= 0 && indice < numCuentas) {
            return cuentas[indice];
        }
        return null; // Cuenta no encontrada en el índice especificado.
    }

    /**
     * Genera una cadena con los detalles de todas las cuentas asociadas a este cliente.
     */
    public String consultarCuentasDetalle() {
        StringBuilder detalleCuentas = new StringBuilder();
        if (numCuentas == 0) {
            detalleCuentas.append("   - No hay cuentas asociadas a este cliente.\n");
        } else {
            for (int i = 0; i < numCuentas; i++) {
                detalleCuentas.append("   Cuenta ").append(i + 1).append(": ").append(cuentas[i].toString()).append("\n");
            }
        }
        return detalleCuentas.toString();
    }

    /**
     * Compara este cliente con otro objeto basándose en su ID único.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cliente cliente = (Cliente) obj;
        return id == cliente.id; // Dos clientes son iguales si tienen el mismo ID.
    }

    /**
     * Genera un código hash para el cliente, consistente con el método `equals`.
     */
    @Override
    public int hashCode() {
        return Integer.hashCode(id); // El hash se basa en el ID único.
    }

    /**
     * Devuelve una representación en cadena con la información principal del cliente.
     */
    @Override
    public String toString() {
        return "Cliente [ID=" + id + ", Nombre=" + nombre + ", Apellido=" + apellido +
                ", Género=" + genero.getNombre() + ", Num. Cuentas=" + numCuentas + "]";
    }


    @Override
    public int compareTo(Cliente o) { //REVISAR
        int resultado= this.nombre.compareTo(o.getNombre());
        if(resultado>0){
            return 1;
        }else if (resultado<0) {
            return -1;
        }else
            return 0;
    }

}