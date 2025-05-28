package ec.edu.uce.dominio;
/**
 * Clase que representa un banco con clientes y empleados.
 * Permite la gestión de clientes y empleados asociados al banco.
 *
 * @author Edwin Caiza
 */
public class Banco {
    /**
     * ATRIBUTOS
     */
    private String nombre;
    private int id;
    private static Cliente[] clientes;      // Variable estática
    private static Empleado[] empleados;    // Variable estática
    private static int numClientes;         // Variable estática
    private static int numEmpleados;        // Variable estática
    // Bloque estático para inicializar los arreglos de clientes y empleados
    static {
        clientes = new Cliente[3];          // Inicializa clientes con un arreglo de tamaño 3
        empleados = new Empleado[3];        // Inicializa empleados con un arreglo de tamaño 3
        numClientes = 0;
        numEmpleados = 0;
    }
    /**
     * CONSTRUCTO VACIO  que inicializa el banco con valores predeterminados.
     */
    public Banco() {
        this("sin nombre", 1, new Cliente[3], new Empleado[3], 0, 0);
    }
    /**
     * Constructor parametrizado para inicializar el banco.
     *
     * @param nombre Nombre del banco
     * @param id Identificador del banco
     * @param clientes Arreglo de clientes
     * @param empleados Arreglo de empleados
     * @param numClientes Número de clientes
     * @param numEmpleados Número de empleados
     */
    public Banco(String nombre, int id, Cliente[] clientes, Empleado[] empleados, int numClientes, int numEmpleados) {
        this.nombre = nombre;
        this.id = id;
        this.clientes = clientes;
        this.empleados = empleados;
        this.numClientes = numClientes;
        this.numEmpleados = numEmpleados;
    }

    /**
     * METODOS GETTERS Y SETTERS
     */
    /**

     * Obtiene el nombre del banco.
     *
     * @return Nombre del banco
     */

    public String getNombre() {
        return nombre;
    }
    /**
     * Establece el nombre del banco.
     *
     * @param nombre Nuevo nombre del banco
     */

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    /**
     * Obtiene el ID del banco.
     *
     * @return ID del banco
     */
    public int getId() {
        return id;
    }
    /**
     * Establece el ID del banco.
     *
     * @param id Nuevo ID del banco
     */
    public void setId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("El ID no puede ser negativo.");
        }
        this.id = id;
    }

    /**
     * Obtiene un cliente en un índice específico.
     *
     * @param indice Índice del cliente
     * @return Cliente encontrado, o null si el índice es inválido
     */
    public Cliente getCliente(int indice) {
        if (indice >= 0 && indice < numClientes) {
            return clientes[indice];
        }
        return null;
    }
    /**
     * Obtiene el número de empleados del banco.
     *
     * @return Número de empleados
     */
    public int getNumEmpleados() {
        return numEmpleados;
    }
    /**
     * Obtiene el número de clientes del banco.
     *
     * @return Número de clientes
     */
    public int getNumClientes() {
        return numClientes;
    }
    /**
     * Obtiene el arreglo de empleados.
     *
     * @return Arreglo de empleados
     */
    public Empleado[] getEmpleados() {
        return empleados;
    }
    /**
     * Establece el número de clientes del banco.
     *
     * @param numClientes Nuevo número de clientes
     */
    public void setNumClientes(int numClientes) {
        this.numClientes = numClientes;
    }

    /**
     * Establece el número de empleados del banco.
     *
     * @param numEmpleados Nuevo número de empleados
     */
    public void setNumEmpleados(int numEmpleados) {
        this.numEmpleados = numEmpleados;
    }

    /**
     * Relación entre Banco y Cliente/Empleado
     */
    public void setClientes(Cliente[] clientes) {
        if (clientes == null || clientes.length == 0) {
            System.out.println("Error: El arreglo de clientes no puede estar vacío.");
        } else {
            this.clientes = clientes;
        }
    }

    public void setEmpleados(Empleado[] empleados) {
        if (empleados == null || empleados.length == 0) {
            System.out.println("Error: El arreglo de empleados no puede estar vacío.");
        } else {
            this.empleados = empleados;
        }
    }

    /**
     * METODO TO STRING
     */

    /**
     * Representación en cadena del objeto Banco.
     *
     * @return String con los detalles del banco
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Banco {");
        sb.append("nombre='").append(nombre != null ? nombre : "No definido").append('\'');
        sb.append(", id=").append(id);
        sb.append(", numClientes=").append(numClientes);
        sb.append(", numEmpleados=").append(numEmpleados);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Métodos CRUD para Cliente
     */

    /**
     *
     * CRUD: Agregar cliente
     */

    /**
     * Agrega un nuevo cliente al banco.
     *
     * @param id ID del cliente (no negativo)
     * @param nombre Nombre del cliente (no vacío)
     * @param apellido Apellido del cliente (no vacío)
     * @param genero Género del cliente (no nulo)
     * @param correo Correo válido
     * @param fechaNacimiento Fecha de nacimiento válida y no futura
     */
    public void agregarCliente(int id, String nombre, String apellido, Genero genero, String correo, Fecha fechaNacimiento) {
        if (id < 0) {
            System.out.println("Error: El ID no puede ser negativo.");
            return;
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println("Error: El nombre no puede estar vacío.");
            return;
        }
        if (apellido == null || apellido.trim().isEmpty()) {
            System.out.println("Error: El apellido no puede estar vacío.");
            return;
        }
        if (genero == null) {
            System.out.println("Error: El género no puede ser nulo.");
            return;
        }
        if (correo == null || !esCorreoValido(correo)) {
            System.out.println("Error: El correo no es válido.");
            return;
        }
        if (fechaNacimiento == null) {
            System.out.println("Error: La fecha de nacimiento no puede ser nula.");
            return;
        }
        if (esFechaFutura(fechaNacimiento)) {
            System.out.println("Error: La fecha de nacimiento no puede ser futura.");
            return;
        }
        Cliente cliente = new Cliente(id, nombre, apellido, genero, correo, fechaNacimiento);
        if (verificarCliente(cliente)) {
            System.out.println("Error: Cliente ya existe.");
            return;
        }
        if (numClientes == clientes.length) {
            Cliente[] aux = new Cliente[numClientes + 1];
            System.arraycopy(clientes, 0, aux, 0, numClientes);
            clientes = aux;
        }
        clientes[numClientes] = cliente;
        numClientes++;
        System.out.println("Cliente agregado exitosamente.");
    }

    /**
     * CRUD: editar cliente
     */

    /**
     * Editar los datos de un cliente existente.
     * @param indice Índice del cliente a modificar
     * @param id Nuevo ID del cliente
     * @param nombre Nuevo nombre del cliente
     * @param apellido Nuevo apellido del cliente
     */

    public void editarCliente(int indice, int id, String nombre, String apellido) {
        if (indice >= 0 && indice < numClientes) {
            Cliente cliente = clientes[indice];
            cliente.setClienteId(id);
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
        }
    }
    /**
     * CRUD: eliminar cliente
     */

    /**
     * Elimina un cliente del banco.
     *
     * @param indice Índice del cliente a eliminar
     */
    public void eliminarCliente(int indice) {
        if (indice >= 0 && indice < numClientes) {
            // Mover todos los clientes una posición a la izquierda a partir del índice
            for (int i = indice; i < numClientes - 1; i++) {
                clientes[i] = clientes[i + 1];
            }
            clientes[numClientes - 1] = null;
            numClientes--;
        }
    }

    /**
     * CRUD: consultar cliente
     */

    /**
     * Consulta los clientes actuales del banco.
     *
     * @return Información de los clientes en formato de texto
     */

    public String consultarClientes() {
        StringBuilder texto = new StringBuilder();
        for (Cliente cliente : clientes) {
            if (cliente != null) {
                texto.append(cliente.toString()).append("\n");
            }
        }
        return texto.toString();
    }
    /**
     * Verifica si un cliente ya existe en el banco.
     *
     * @param cliente Cliente a verificar
     * @return true si el cliente ya está registrado, false en caso contrario
     */
    private boolean verificarCliente(Cliente cliente) {
        for (int i = 0; i < numClientes; i++) {
            if (clientes[i].getId() == cliente.getId()) {
                return true;
            }
        }
        return false;
    }
    /**
     * Busca y retorna un cliente por índice.
     *
     * @param indice Índice del cliente
     * @return Cliente encontrado o null si el índice no es válido
     */
    public Cliente buscarCliente(int indice) {
        if (indice >= 0 && indice < numClientes) {
            return clientes[indice];
        }
        System.out.println("Error: Índice de cliente no válido.");
        return null;
    }


    /**
     * Métodos CRUD para Empleados
     */

    /**
     *
     * CRUD: Agregar empleado
     */

    /**
     * Agrega un nuevo empleado al banco, validando duplicados.
     *
     * @param id ID del empleado (no negativo)
     * @param nombre Nombre del empleado (no vacío)
     * @param apellido Apellido del empleado (no vacío)
     * @param genero Género del empleado (no nulo)
     * @param correo Correo válido
     * @param fechaIngreso Fecha de ingreso válida y no futura
     */
    public void agregarEmpleado(int id, String nombre, String apellido, Genero genero, String correo, Fecha fechaIngreso) {
        if (id < 0) {
            System.out.println("Error: El ID no puede ser negativo.");
            return;
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println("Error: El nombre no puede estar vacío.");
            return;
        }
        if (apellido == null || apellido.trim().isEmpty()) {
            System.out.println("Error: El apellido no puede estar vacío.");
            return;
        }
        if (genero == null) {
            System.out.println("Error: El género no puede ser nulo.");
            return;
        }
        if (correo == null || !esCorreoValido(correo)) {
            System.out.println("Error: El correo no es válido.");
            return;
        }
        if (fechaIngreso == null) {
            System.out.println("Error: La fecha de ingreso no puede ser nula.");
            return;
        }
        if (esFechaFutura(fechaIngreso)) {
            System.out.println("Error: La fecha de ingreso no puede ser futura.");
            return;
        }
        Empleado empleado = new Empleado(id, nombre, apellido, genero, correo, fechaIngreso);
        if (verificarEmpleado(empleado)) {
            System.out.println("Error: Empleado ya existe.");
            return;
        }
        if (numEmpleados == empleados.length) {
            Empleado[] aux = new Empleado[numEmpleados + 1];
            System.arraycopy(empleados, 0, aux, 0, numEmpleados);
            empleados = aux;
        }
        empleados[numEmpleados] = empleado;
        numEmpleados++;
        System.out.println("Empleado agregado exitosamente.");
    }

    /**
     * Agrega un empleado existente al banco.
     *
     * Este método permite añadir directamente un objeto Empleado (o una subclase de Empleado)
     * al arreglo de empleados del banco, realizando las validaciones necesarias:
     * - No permite agregar empleados nulos.
     * - Verifica que no exista un empleado con el mismo ID previamente agregado.
     * - Si el arreglo está lleno, se redimensiona para acomodar un nuevo empleado.
     *
     * @param empleado El objeto Empleado a agregar.
     */

    public void agregarEmpleado(Empleado empleado) {
        if (empleado == null) {
            System.out.println("Error: empleado nulo");
            return;
        }
        if (verificarEmpleado(empleado)) {
            System.out.println("Error: Empleado ya existe.");
            return;
        }
        if (numEmpleados == empleados.length) {
            Empleado[] aux = new Empleado[numEmpleados + 1];
            System.arraycopy(empleados, 0, aux, 0, numEmpleados);
            empleados = aux;
        }
        empleados[numEmpleados] = empleado;
        numEmpleados++;
        System.out.println("El empleado se ha agregado exitosamente.");

    }

    /**
     *
     * CRUD: Editar empleado
     */

    /**
     * Edita los datos de un empleado existente.
     *
     */
    public boolean editarEmpleado(int indice, Empleado nuevoEmpleado) {
        if (indice >= 0 && indice < numEmpleados) {
            empleados[indice] = nuevoEmpleado;
            return true;
        }
        return false;
    }

    /**
     *
     * CRUD: Eliminar empleado
     */

    /**
     * Elimina un empleado del banco.
     *
     * @param indice Índice del empleado a eliminar
     */
    public void eliminarEmpleado(int indice) {
        if (indice >= 0 && indice < numEmpleados) {
            for (int i = indice; i < numEmpleados - 1; i++) {
                empleados[i] = empleados[i + 1];
            }
            empleados[numEmpleados - 1] = null;
            numEmpleados--;
        } else {
            System.out.println("Error: Índice inválido para eliminar empleado.");
        }
    }


    /**
     * CRUD: consultar cliente
     */

    /**
     * Consulta todos los empleados del banco.
     *
     * @return Cadena con información de los empleados
     */
    public void consultarEmpleados() {
        for (int i = 0; i < numEmpleados; i++) {
            System.out.println(empleados[i].toString());
        }
    }
    /**
     * Verifica si un empleado ya existe en el banco.
     *
     * @param empleado Empleado a verificar
     * @return true si ya existe, false si no
     */
    public boolean verificarEmpleado(Empleado empleado) {
        if (empleado.getId() == 0) {
            // No consideramos que ya exista porque el ID es el valor por defecto (sin asignar)
            return false;
        }
        for (int i = 0; i < numEmpleados; i++) {
            if (empleados[i].getId() == empleado.getId()) {
                return true;
            }
        }
        return false;
    }
    /**
     * Busca y retorna un empleado por índice.
     *
     * @param indice Índice del empleado
     * @return Empleado encontrado o null si el índice no es válido
     */
    public Empleado buscarEmpleado(int indice) {
        if (indice >= 0 && indice < numEmpleados) {
            return empleados[indice];
        }
        System.out.println("Error: Índice de empleado no válido.");
        return null;
    }
    /**
     * Valida si el correo tiene formato válido.
     *
     * @param correo Correo electrónico
     * @return true si es válido, false si no
     */
    public static boolean esCorreoValido(String correo) {
        if (correo == null) return false;
        return correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }

    public boolean validarEmpleado(Empleado empleados){
        boolean respuesta = false;
        for (Empleado em: empleados){
            if (em.equals(empleados)){
                respuesta = true;
                break;
            }
        }
        return respuesta;
    }

    /**
     * Verifica si la fecha es futura comparada con la fecha actual.
     *
     * @param fecha Fecha a validar
     * @return true si es futura, false si no
     */
    public static boolean esFechaFutura(Fecha fecha) {
        java.util.Calendar calFecha = java.util.Calendar.getInstance();
        calFecha.set(fecha.getAnio(), fecha.getMes() - 1, fecha.getDia(), 0, 0, 0);
        calFecha.set(java.util.Calendar.MILLISECOND, 0);

        java.util.Calendar hoy = java.util.Calendar.getInstance();
        hoy.set(java.util.Calendar.HOUR_OF_DAY, 0);
        hoy.set(java.util.Calendar.MINUTE, 0);
        hoy.set(java.util.Calendar.SECOND, 0);
        hoy.set(java.util.Calendar.MILLISECOND, 0);

        return calFecha.after(hoy);
    }

}







