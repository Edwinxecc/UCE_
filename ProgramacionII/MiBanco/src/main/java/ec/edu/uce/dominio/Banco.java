package ec.edu.uce.dominio;
/**
 * Clase que representa un banco con clientes y empleados.
 * Permite la gestión de clientes y empleados asociados al banco.
 *
 * @author Edwin Caiza
 */
public class Banco {
    // Atributos del banco
    private String nombreBanco;
    private String direccion;
    private String telefono;
    private String codigoBanco;

    // ASOCIACIÓN CON EMPLEADOS

    private Empleado[] staff;

    private int numEmpleados;

    // ASOCIACIÓN CON CLIENTES

    private Cliente[] clientes;

    private int numClientes;

    // CONSTANTES

    private static final int CAPACIDAD_INICIAL_DEFAULT = 5;

    private static final int INCREMENTO_CAPACIDAD = 3;
    public static final double SALARIO_BASICO = 470.00;
    public static int contador;

    //bloque de inicializacion
    static {
        contador = 1;
    }

    // CONSTRUCTORES

    public Banco() {
        this(CAPACIDAD_INICIAL_DEFAULT);
    }


    public Banco(int capacidadInicial) {
        if (capacidadInicial <= 0) {
            capacidadInicial = CAPACIDAD_INICIAL_DEFAULT;
            System.out.println("Advertencia: Capacidad inicial inválida, usando valor por defecto (" + CAPACIDAD_INICIAL_DEFAULT + ")");
        }

        // Inicializar información básica del banco
        this.nombreBanco = "Banco Sin Nombre";
        this.direccion = "";
        this.telefono = "";
        this.codigoBanco = "000";

        // Inicializar arrays y contadores
        this.clientes = new Cliente[capacidadInicial];
        this.staff = new Empleado[capacidadInicial];
        this.numClientes = 0;
        this.numEmpleados = 0;
    }


    public Banco(String nombreBanco, String codigoBanco, int capacidadInicial) {
        this(capacidadInicial);
        setNombreBanco(nombreBanco);
        setCodigoBanco(codigoBanco);
    }

    public Banco(String nombreBanco, String direccion, String telefono, String codigoBanco, int capacidadInicial) {
        this(capacidadInicial);
        setNombreBanco(nombreBanco);
        setDireccion(direccion);
        setTelefono(telefono);
        setCodigoBanco(codigoBanco);
    }

    // MÉTODOS GET Y SET PARA INFORMACIÓN BÁSICA DEL BANCO

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        if (nombreBanco != null && !nombreBanco.trim().isEmpty()) {
            this.nombreBanco = nombreBanco;
        } else {
            System.out.println("Error: Nombre de banco inválido");
            this.nombreBanco = "Banco Sin Nombre";
        }
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion != null ? direccion : "";
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono != null && telefono.matches("\\d{10}")) {
            this.telefono = telefono;
        } else if (telefono != null && !telefono.isEmpty()) {
            System.out.println("Advertencia: Formato de teléfono del banco no válido");
            this.telefono = telefono; // Se acepta pero con advertencia
        } else {
            this.telefono = "";
        }
    }

    public String getCodigoBanco() {
        return codigoBanco;
    }

    public void setCodigoBanco(String codigoBanco) {
        if (codigoBanco != null && !codigoBanco.trim().isEmpty()) {
            this.codigoBanco = codigoBanco;
        } else {
            System.out.println("Error: Código de banco inválido");
            this.codigoBanco = "000";
        }
    }

    // MÉTODOS GET PARA CONTADORES


    public int getNumClientes() {
        return numClientes;
    }


    public int getNumEmpleados() {
        return numEmpleados;
    }
    public int getCapacidadClientes() {
        return clientes.length;
    }


    public int getCapacidadEmpleados() {
        return staff.length;
    }

    // MÉTODOS PRIVADOS DE VALIDACIÓN Y UTILIDAD


    private boolean existeClienteId(int id) {
        for (int i = 0; i < numClientes; i++) {
            if (clientes[i] != null && clientes[i].getClienteId() == id) {
                return true;
            }
        }
        return false;
    }

    private boolean existeEmpleadoId(int id) {
        for (int i = 0; i < numEmpleados; i++) {
            if (staff[i] != null && staff[i].getEmpleadoId() == id) {
                return true;
            }
        }
        return false;
    }

    private void ampliarCapacidadClientes() {
        Cliente[] nuevoArray = new Cliente[clientes.length + INCREMENTO_CAPACIDAD];
        System.arraycopy(clientes, 0, nuevoArray, 0, numClientes);
        clientes = nuevoArray;
        System.out.println("Capacidad de clientes ampliada a: " + clientes.length);
    }

    private void ampliarCapacidadEmpleados() {
        Empleado[] nuevoArray = new Empleado[staff.length + INCREMENTO_CAPACIDAD];
        System.arraycopy(staff, 0, nuevoArray, 0, numEmpleados);
        staff = nuevoArray;
        System.out.println("Capacidad de empleados ampliada a: " + staff.length);
    }

    private boolean esPosicionValidaCliente(int pos) {
        return pos >= 0 && pos < numClientes;
    }

    // ============================================================================
    // MÉTODOS PRINCIPALES DE ASOCIACIÓN CON CLIENTES (CRUD)
    // ============================================================================

    public boolean nuevoCliente(Cliente c) {
        // Validar que el cliente no sea nulo
        if (c == null) {
            System.out.println("Error: No se puede agregar un cliente nulo");
            return false;
        }

        // Validar que el ID no exista ya
        if (existeClienteId(c.getClienteId())) {
            System.out.println("Error: Ya existe un cliente con ID " + c.getClienteId());
            return false;
        }

        // Ampliar el array si es necesario
        if (numClientes >= clientes.length) {
            ampliarCapacidadClientes();
        }

        // Agregar el cliente al array
        clientes[numClientes] = c;
        numClientes++;
        System.out.println("Cliente agregado exitosamente: " + c.getNombre() + " " + c.getApellido());
        return true;
    }

    public String consultarClientes() {
        if (numClientes == 0) {
            return "No hay clientes registrados en " + nombreBanco;
        }

        StringBuilder texto = new StringBuilder();
        texto.append("=== LISTADO DE CLIENTES - ").append(nombreBanco.toUpperCase()).append(" ===\n");
        texto.append("Total de clientes: ").append(numClientes).append("\n");
        texto.append("-".repeat(60)).append("\n");

        for (int i = 0; i < numClientes; i++) {
            if (clientes[i] != null) {
                texto.append("[").append(String.format("%2d", i)).append("] ").append(clientes[i]).append("\n");
            }
        }

        return texto.toString();
    }

    public boolean editarCliente(int p, Cliente c) {
        // Validar posición
        if (!esPosicionValidaCliente(p)) {
            System.out.println("Error: Posición inválida para editar cliente (" + p + ")");
            return false;
        }

        // Validar que el nuevo cliente no sea nulo
        if (c == null) {
            System.out.println("Error: No se puede editar con un cliente nulo");
            return false;
        }

        // Verificar que el nuevo ID no exista ya (excepto si es el mismo cliente)
        if (clientes[p].getClienteId() != c.getClienteId() && existeClienteId(c.getClienteId())) {
            System.out.println("Error: No se puede editar, el ID " + c.getClienteId() + " ya existe en otro cliente");
            return false;
        }

        // Reemplazar el cliente
        Cliente clienteAnterior = clientes[p];
        clientes[p] = c;
        System.out.println("Cliente actualizado exitosamente:");
        System.out.println("  Anterior: " + clienteAnterior.getNombre() + " " + clienteAnterior.getApellido());
        System.out.println("  Nuevo: " + c.getNombre() + " " + c.getApellido());
        return true;
    }

    public boolean eliminarCliente(int p) {
        // Validar posición
        if (!esPosicionValidaCliente(p)) {
            System.out.println("Error: Posición inválida para eliminar cliente (" + p + ")");
            return false;
        }

        // Guardar información del cliente eliminado para el mensaje
        Cliente clienteEliminado = clientes[p];

        // Desplazar elementos hacia la izquierda para eliminar el cliente
        for (int i = p; i < numClientes - 1; i++) {
            clientes[i] = clientes[i + 1];
        }

        // Limpiar la última posición y decrementar contador
        clientes[numClientes - 1] = null;
        numClientes--;

        System.out.println("Cliente eliminado exitosamente: " +
                clienteEliminado.getNombre() + " " + clienteEliminado.getApellido() +
                " (ID: " + clienteEliminado.getClienteId() + ")");
        return true;
    }

    public Cliente buscarCliente(int p) {
        if (esPosicionValidaCliente(p)) {
            return clientes[p];
        } else {
            System.out.println("Error: Posición inválida (" + p + ") para buscar cliente");
            return null;
        }
    }

    // ============================================================================
    // MÉTODOS ADICIONALES DE BÚSQUEDA Y CONSULTA DE CLIENTES
    // ============================================================================

    /**
     * Busca un cliente por su ID único
     *
     * @param id ID del cliente a buscar
     * @return Cliente encontrado o null si no existe
     */
    public Cliente buscarClientePorId(int id) {
        for (int i = 0; i < numClientes; i++) {
            if (clientes[i] != null && clientes[i].getClienteId() == id) {
                return clientes[i];
            }
        }
        System.out.println("No se encontró cliente con ID: " + id);
        return null;
    }

    /**
     * Obtiene la posición de un cliente por su ID
     *
     * @param id ID del cliente a buscar
     * @return Posición del cliente o -1 si no se encuentra
     */
    public int obtenerPosicionClientePorId(int id) {
        for (int i = 0; i < numClientes; i++) {
            if (clientes[i] != null && clientes[i].getClienteId() == id) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Filtra clientes por género
     *
     * @param genero Género por el cual filtrar
     * @return Cadena con el listado de clientes del género especificado
     */
    public String consultarClientesPorGenero(Genero genero) {
        if (numClientes == 0) {
            return "No hay clientes registrados en " + nombreBanco;
        }

        StringBuilder texto = new StringBuilder();
        texto.append("=== CLIENTES DE GÉNERO ").append(genero.getNombre().toUpperCase()).append(" - ").append(nombreBanco.toUpperCase()).append(" ===\n");

        int contador = 0;
        for (int i = 0; i < numClientes; i++) {
            if (clientes[i] != null && clientes[i].getGenero() == genero) {
                if (contador == 0) {
                    texto.append("-".repeat(60)).append("\n");
                }
                texto.append("[").append(String.format("%2d", i)).append("] ").append(clientes[i]).append("\n");
                contador++;
            }
        }

        if (contador == 0) {
            return "No hay clientes registrados del género " + genero.getNombre() + " en " + nombreBanco;
        } else {
            texto.insert(texto.indexOf("===") + texto.substring(texto.indexOf("===")).indexOf("\n") + 1,
                    "Total encontrados: " + contador + "\n");
        }

        return texto.toString();
    }

    public String buscarClientesPorNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return "Error: Debe proporcionar un nombre para buscar";
        }

        if (numClientes == 0) {
            return "No hay clientes registrados en " + nombreBanco;
        }

        StringBuilder texto = new StringBuilder();
        texto.append("=== BÚSQUEDA DE CLIENTES POR NOMBRE: '").append(nombre.toUpperCase()).append("' ===\n");

        int contador = 0;
        String nombreBusqueda = nombre.toLowerCase();

        for (int i = 0; i < numClientes; i++) {
            if (clientes[i] != null) {
                String nombreCompleto = (clientes[i].getNombre() + " " + clientes[i].getApellido()).toLowerCase();
                if (nombreCompleto.contains(nombreBusqueda)) {
                    if (contador == 0) {
                        texto.append("-".repeat(60)).append("\n");
                    }
                    texto.append("[").append(String.format("%2d", i)).append("] ").append(clientes[i]).append("\n");
                    contador++;
                }
            }
        }

        if (contador == 0) {
            return "No se encontraron clientes con el nombre '" + nombre + "' en " + nombreBanco;
        } else {
            texto.insert(texto.indexOf("===") + texto.substring(texto.indexOf("===")).indexOf("\n") + 1,
                    "Total encontrados: " + contador + "\n");
        }

        return texto.toString();
    }

    // ============================================================================
    // MÉTODOS CRUD BÁSICOS PARA EMPLEADOS
    // ============================================================================

    public boolean agregarEmpleado(Empleado empleado) {
        if (empleado == null) {
            System.out.println("Error: No se puede agregar un empleado nulo");
            return false;
        }

        if (existeEmpleadoId(empleado.getEmpleadoId())) {
            System.out.println("Error: Ya existe un empleado con ID " + empleado.getEmpleadoId());
            return false;
        }

        if (numEmpleados >= staff.length) {
            ampliarCapacidadEmpleados();
        }

        staff[numEmpleados] = empleado;
        numEmpleados++;
        System.out.println("Empleado agregado exitosamente: " + empleado);
        return true;
    }

    public boolean eliminarEmpleado(int indice) {
        if (indice < 0 || indice >= numEmpleados) {
            System.out.println("Error: Índice inválido para eliminar empleado (" + indice + ")");
            return false;
        }

        // Desplazar elementos para eliminar el empleado
        for (int i = indice; i < numEmpleados - 1; i++) {
            staff[i] = staff[i + 1];
        }
        staff[numEmpleados - 1] = null;
        numEmpleados--;
        System.out.println("Empleado eliminado exitosamente");
        return true;
    }

    public String consultarEmpleados() {
        if (numEmpleados == 0) {
            return "No hay empleados registrados en " + nombreBanco;
        }

        StringBuilder texto = new StringBuilder();
        texto.append("=== LISTADO DE EMPLEADOS - ").append(nombreBanco.toUpperCase()).append(" ===\n");
        texto.append("Total de empleados: ").append(numEmpleados).append("\n");
        texto.append("-".repeat(60)).append("\n");

        for (int i = 0; i < numEmpleados; i++) {
            if (staff[i] != null) {
                texto.append("[").append(String.format("%2d", i)).append("] ").append(staff[i]).append("\n");
            }
        }

        return texto.toString();
    }

    // ============================================================================
    // MÉTODOS ESTADÍSTICOS Y DE RESUMEN
    // ============================================================================

    public String obtenerEstadisticas() {
        StringBuilder stats = new StringBuilder();
        stats.append("=== ESTADÍSTICAS DEL BANCO ===\n");
        stats.append("Nombre: ").append(nombreBanco).append("\n");
        stats.append("Código: ").append(codigoBanco).append("\n");

        if (!direccion.isEmpty()) {
            stats.append("Dirección: ").append(direccion).append("\n");
        }
        if (!telefono.isEmpty()) {
            stats.append("Teléfono: ").append(telefono).append("\n");
        }

        stats.append("-".repeat(30)).append("\n");
        stats.append("Total de clientes: ").append(numClientes).append("/").append(clientes.length).append("\n");
        stats.append("Total de empleados: ").append(numEmpleados).append("/").append(staff.length).append("\n");

        // Estadísticas por género de clientes
        int clientesMasculinos = 0, clientesFemeninos = 0;
        for (int i = 0; i < numClientes; i++) {
            if (clientes[i] != null) {
                if (clientes[i].getGenero() == Genero.MASCULINO) {
                    clientesMasculinos++;
                } else if (clientes[i].getGenero() == Genero.FEMENINO) {
                    clientesFemeninos++;
                }
            }
        }

        stats.append("Clientes masculinos: ").append(clientesMasculinos).append("\n");
        stats.append("Clientes femeninos: ").append(clientesFemeninos).append("\n");

        // Estadísticas de cuentas
        int totalCuentas = 0;
        for (int i = 0; i < numClientes; i++) {
            if (clientes[i] != null) {
                totalCuentas += clientes[i].getNumCuentas();
            }
        }
        stats.append("Total de cuentas: ").append(totalCuentas).append("\n");

        return stats.toString();
    }

    public boolean estaVacio() {
        return numClientes == 0 && numEmpleados == 0;
    }

    public void limpiarClientes() {
        for (int i = 0; i < numClientes; i++) {
            clientes[i] = null;
        }
        numClientes = 0;
        System.out.println("Todos los clientes han sido eliminados del banco");
    }

    public void limpiarEmpleados() {
        for (int i = 0; i < numEmpleados; i++) {
            staff[i] = null;
        }
        numEmpleados = 0;
        System.out.println("Todos los empleados han sido eliminados del banco");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Banco [");
        sb.append("Nombre = ").append(nombreBanco);
        sb.append(", Código = ").append(codigoBanco);

        if (!direccion.isEmpty()) {
            sb.append(", Dirección = ").append(direccion);
        }
        if (!telefono.isEmpty()) {
            sb.append(", Teléfono = ").append(telefono);
        }

        sb.append(", Clientes = ").append(numClientes);
        sb.append(", Empleados = ").append(numEmpleados);
        sb.append("]");

        return sb.toString();
    }
}