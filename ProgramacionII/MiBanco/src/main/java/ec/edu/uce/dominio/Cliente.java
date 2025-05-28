
package ec.edu.uce.dominio;

/**
 * Clase que representa a un cliente en el sistema bancario.
 * Contiene información personal, detalles de registro y hasta 5 cuentas bancarias.
 */
public class Cliente {
    private int clienteId;
    private String nombre;
    private String apellido;
    private String correo;
    private Fecha fechaRegistro;
    private Genero genero;

    // Asociación con hasta 5 cuentas sin usar arrays
    private Cuenta cuenta1;
    private Cuenta cuenta2;
    private Cuenta cuenta3;
    private Cuenta cuenta4;
    private Cuenta cuenta5;
    private int numeroCuentas; // Contador de cuentas activas

    /**
     * Constructor por defecto que inicializa los atributos con valores predeterminados.
     */
    public Cliente() {
        this.clienteId = 1;
        this.nombre = "Sin nombre";
        this.apellido = "Sin apellido";
        this.correo = "Sin correo";
        this.fechaRegistro = new Fecha();
        this.genero = Genero.FEMENINO;
        this.numeroCuentas = 0;
    }

    /**
     * Constructor con parámetros que permite definir los datos principales del cliente.
     */
    public Cliente(int id, String nombre, String apellido, Genero genero) {
        this.clienteId = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = "Sin correo";
        this.fechaRegistro = new Fecha();
        this.genero = genero;
        this.numeroCuentas = 0;
    }

    /**
     * Constructor con parámetros ampliado.
     */
    public Cliente(int id, String nombre, String apellido, Genero genero, String correo, Fecha fechaRegistro) {
        this.clienteId = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.correo = correo;
        this.fechaRegistro = fechaRegistro;
        this.numeroCuentas = 0;
    }

    /**
     * Constructor de copia.
     */
    public Cliente(Cliente nuevoCliente) {
        this.clienteId = nuevoCliente.clienteId;
        this.nombre = nuevoCliente.nombre;
        this.apellido = nuevoCliente.apellido;
        this.correo = nuevoCliente.correo;
        this.fechaRegistro = new Fecha(nuevoCliente.fechaRegistro.getDia(),
                nuevoCliente.fechaRegistro.getMes(),
                nuevoCliente.fechaRegistro.getAnio());
        this.genero = nuevoCliente.genero;
        this.numeroCuentas = nuevoCliente.numeroCuentas;
        // Copiar cuentas si existen
        this.cuenta1 = nuevoCliente.cuenta1;
        this.cuenta2 = nuevoCliente.cuenta2;
        this.cuenta3 = nuevoCliente.cuenta3;
        this.cuenta4 = nuevoCliente.cuenta4;
        this.cuenta5 = nuevoCliente.cuenta5;
    }

    // Getters y setters básicos
    public int getClienteId() { return clienteId; }
    public int getId() { return clienteId; }
    public void setClienteId(int clienteId) {
        if (clienteId >= 0) this.clienteId = clienteId;
        else System.out.println("ID inválido");
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public Fecha getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(Fecha fecha) { this.fechaRegistro = fecha; }

    public Genero getGenero() { return genero; }
    public void setGenero(Genero genero) { this.genero = genero; }

    public int getNumeroCuentas() { return numeroCuentas; }


    @Override
    public String toString() {
        return "Id: " + clienteId +
                " Nombre: " + nombre +
                " Apellido: " + apellido +
                " Correo: " + correo +
                " Fecha de Registro: " + fechaRegistro +
                " Género: " + genero +
                " Número de cuentas: " + numeroCuentas + "\n";
    }
}