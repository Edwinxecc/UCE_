/**
 * @author Edwin Caiza
 */
package ec.edu.uce.dominio;

import java.awt.font.TextHitInfo;
import java.util.Date;

/**
 * Representa un cliente del banco con información personal, contacto y género.
 * Contiene atributos como nombre, apellido, correo electrónico, dirección, teléfono y un ID único.
 */
public class Cliente {
    /**
     * Contador estático para asignar IDs únicos autoincrementales.
     */
    private static int contadorId = 1;

    /**
     * Identificador único del cliente.
     */
    private int clienteId;

    /**
     * Nombre del cliente.
     */
    private String nombre;

    /**
     * Apellido del cliente.
     */
    private String apellido;

    /**
     * Correo electrónico del cliente.
     */
    private String correo;

    /**
     * Fecha relacionada con el cliente (puede ser fecha de nacimiento u otra).
     */
    private Date fecha;

    /**
     * Dirección del cliente.
     */
    private String direccion;

    /**
     * Teléfono de contacto del cliente.
     */
    private String telefono;

    /**
     * Género del cliente.
     */
    private Genero genero;

    /**
     * Constructor por defecto que inicializa el cliente con valores vacíos y asigna un ID automático.
     */
    public Cliente() {
        this(1,"Sin nombre","Sin apellido","x@mail","sin direccion","00000000", Genero.FEMENINO);
    }

    /**
     * Constructor que inicializa el cliente con nombre, apellido, correo y fecha.
     * Asigna un ID automático.
     *
     * @param nombre  nombre del cliente
     * @param apellido apellido del cliente
     * @param correo  correo electrónico
     * @param fecha   fecha asociada
     */
    public Cliente(String nombre, String apellido, String correo, Date fecha) {
        this(contadorId++,nombre, apellido, correo, "", "", Genero.FEMENINO);
    }

    /**
     * Constructor que inicializa todos los atributos, incluyendo ID y género.
     *
     * @param clienteId ID del cliente
     * @param nombre    nombre del cliente
     * @param apellido  apellido del cliente
     * @param correo    correo electrónico
     * @param direccion dirección del cliente
     * @param telefono  teléfono del cliente
     * @param genero    género del cliente
     */
    public Cliente(int clienteId, String nombre, String apellido, String correo, String direccion, String telefono, Genero genero) {
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.genero = genero;
        this.numCuentas=0;
        this.cuentas=new Cuenta[3];
    }

    /**
     * Constructor que inicializa el cliente con ID, nombre, apellido y género.
     *
     * @param id       ID del cliente
     * @param nombre   nombre del cliente
     * @param apellido apellido del cliente
     * @param genero   género del cliente
     */
    public Cliente(int id, String nombre, String apellido, Genero genero) {
        this(contadorId++,nombre,apellido,"","","",genero);
    }

    /**
     * Constructor de copia que clona los datos de otro cliente.
     *
     * @param nuevoCliente cliente a copiar
     */
    public Cliente(Cliente nuevoCliente) {
        this.nombre = nuevoCliente.nombre;
        this.apellido = nuevoCliente.apellido;
        this.correo = nuevoCliente.correo;
        this.fecha = nuevoCliente.fecha;
        this.direccion = nuevoCliente.direccion;
        this.telefono = nuevoCliente.telefono;
        this.genero = nuevoCliente.genero;
    }

    // Getters

    /**
     * Obtiene el ID del cliente.
     *
     * @return ID del cliente
     */
    public int getClienteId() {
        return clienteId;
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el apellido del cliente.
     *
     * @return apellido del cliente
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Obtiene el correo electrónico del cliente.
     *
     * @return correo electrónico
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Obtiene la fecha asociada al cliente.
     *
     * @return fecha asociada
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Obtiene la dirección del cliente.
     *
     * @return dirección del cliente
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Obtiene el teléfono del cliente.
     *
     * @return teléfono del cliente
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Obtiene el género del cliente.
     *
     * @return género del cliente
     */
    public Genero getGenero() {
        return genero;
    }

    // Setters

    /**
     * Asigna un nuevo nombre al cliente.
     *
     * @param nombre nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Asigna un nuevo apellido al cliente.
     *
     * @param apellido nuevo apellido
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Asigna un nuevo correo electrónico al cliente.
     *
     * @param correo nuevo correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Asigna una nueva fecha asociada al cliente.
     *
     * @param fecha nueva fecha
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Asigna una nueva dirección al cliente.
     *
     * @param direccion nueva dirección
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Asigna un nuevo teléfono al cliente.
     *
     * @param telefono nuevo teléfono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Asigna un nuevo género al cliente.
     *
     * @param genero nuevo género
     */
    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    /**
     * Devuelve una representación en cadena con los datos relevantes del cliente.
     */
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + clienteId +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                (genero != null ? ", genero=" + genero : "") +
                '}';
    }
    /**
     * Arreglo que almacena las cuentas.
     */
    private Cuenta[] cuentas = new Cuenta[0];
    private int numCuentas;
    /**
     * Crea una nueva cuenta con el saldo especificado y la añade al arreglo de cuentas.
     *
     * @param saldo Saldo inicial de la nueva cuenta.
     */
    public void nuevoCuenta(double saldo) {
        if (numCuentas == cuentas.length) {
            Cuenta[] nuevoarr = cuentas;
            cuentas = new Cuenta[numCuentas + 1];
            System.arraycopy(nuevoarr, 0, cuentas, 0, numCuentas);
        }
        cuentas[numCuentas] = new CuentaAhorro(saldo);  // <-- Aquí la clase concreta
        numCuentas++;
    }

    public void nuevoCuenta(Cuenta nuevaCuenta) {
        if (numCuentas == cuentas.length) {
            Cuenta[]nuevoarr = cuentas;
            cuentas=new Cuenta[numCuentas+1];

            System.arraycopy(nuevoarr,0,cuentas,0, numCuentas);
        }
        cuentas[numCuentas]=nuevaCuenta;
        numCuentas++;
    }


    /**
     * Devuelve un arreglo con todas las cuentas actuales.
     *
     * @return arreglo de objetos Cuenta.
     */
    public Cuenta[] consultarCuentas() {
        String texto="";
        for (Cuenta c:cuentas){
            if (c!=null)
                texto+=c+"\r\n";
        }
        return cuentas;
    }

    /**
     * Modifica el saldo de la cuenta en la posición indicada.
     *
     * @param pos  Índice de la cuenta a modificar (de 0 a cuentas.length - 1).
     * @param saldo Nuevo saldo que se asignará a la cuenta.
     */
    public void editarCuenta(int pos, double saldo) {
        if (pos >= 0 && pos < cuentas.length) {
            cuentas[pos].setSaldo(saldo);
        }
    }

    /**
     * Elimina la cuenta en la posición indicada.
     *
     * @param pos Índice de la cuenta a eliminar (de 0 a cuentas.length - 1).
     */
    public void eliminarCuenta(int pos) {
        if (pos >= 0 && pos < cuentas.length) {
            Cuenta[] nuevo = new Cuenta[cuentas.length - 1];
            for (int i = 0, j = 0; i < cuentas.length; i++) {
                if (i != pos) {
                    nuevo[j++] = cuentas[i];
                }
            }
            cuentas = nuevo;
        }
    }

    /**
     * Devuelve la cuenta en la posición indicada, o null si la posición no es válida.
     *
     * @param pos Índice de la cuenta a buscar (de 0 a cuentas.length - 1).
     * @return La cuenta encontrada o null si no existe.
     */
    public Cuenta buscarCuenta(int pos) {
        if (pos >= 0 && pos < cuentas.length) {
            return cuentas[pos];
        }
        return null;
    }

    public Cuenta[]getCuentas(){
        return cuentas;
    }
}