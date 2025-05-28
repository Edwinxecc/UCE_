
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
    private int numCuentas;
    private Cuenta cuentas[];

    /**
     * Constructor por defecto que inicializa los atributos con valores predeterminados.
     */
    public Cliente() {
        this.clienteId = 1;
        this.nombre = "Sin nombre";
        this.apellido = "Sin apellido";
        this.correo = "Sin correo";
        this.fechaRegistro = new Fecha();
        this.genero = Genero.MASCULINO;
        this.numCuentas = 0;
        this.cuentas = new Cuenta[3];
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

    public void agregarCuenta(double saldo){
        if (numCuentas == cuentas.length){
            Cuenta [] aux = cuentas;
            cuentas = new Cuenta[numCuentas+1];
            System.arraycopy(aux, 0, cuentas, 0, numCuentas);
        }
        cuentas[numCuentas] = new Cuenta(saldo);
        numCuentas++;
    }

    //metodo con sobre carga
    public void agregarCuenta(Cuenta nuevaCuenta){
        if (numCuentas == cuentas.length){
            Cuenta [] aux = cuentas;
            cuentas = new Cuenta[numCuentas+1];
            System.arraycopy(aux, 0, cuentas, 0, numCuentas);
        }
        cuentas[numCuentas] = nuevaCuenta;
        numCuentas++;
    }

    //redimencionar arreglos con system array copy

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