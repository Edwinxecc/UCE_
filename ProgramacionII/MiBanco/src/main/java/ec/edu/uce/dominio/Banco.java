package ec.edu.uce.dominio;

import java.util.Arrays;

/**
 * Clase principal para la gestión de las operaciones bancarias.
 * Implementa el patrón Singleton para asegurar una única instancia.
 * @author Edwin Caiza
 */
public class Banco {

    // Instancia única del Banco (Singleton)
    private static final Banco instance = new Banco();


    // Arreglo y contador para la gestión de clientes
    private static Cliente[] clientes;
    private static int numClientes;

    // Arreglo y contador para la gestión de empleados
    private static Empleado[] staff;
    private static int numEmpleados;

    // Bloque de inicialización estático para los arreglos y contadores
    static {
        numEmpleados = 0;
        staff = new Empleado[5]; // Capacidad inicial para empleados
        numClientes = 0;
        clientes = new Cliente[5]; // Capacidad inicial para clientes
    }

    // Constructor privado, clave para el patrón Singleton
    private Banco() {
        // La inicialización de arreglos se realiza en el bloque estático.
    }

    /**
     * Proporciona el punto de acceso global a la única instancia del Banco.
     */
    public static Banco getInstance() {
        return instance;
    }

    // --- Métodos de Consulta General ---

    public static int getNumClientes() {
        return numClientes;
    }

    public static Cliente getCliente(int indice) {
        if (indice >= 0 && indice < numClientes) {
            return clientes[indice];
        }
        return null; // El índice está fuera de los límites válidos.
    }

    public static Cliente[] getClientes() {
        return Arrays.copyOf(clientes, numClientes); // Devuelve una copia para proteger los datos originales.
    }

    public static int getNumEmpleados() {
        return numEmpleados;
    }

    public static Empleado[] getStaff() {
        return Arrays.copyOf(staff, numEmpleados); // Devuelve una copia para proteger los datos originales.
    }

    public static void agregarCliente(int idCliente, String nombre, String apellido, Genero genero) {
        if (buscarCliente(idCliente) != null) {
            return; // Ya existe un cliente con este ID.
        }
        // Si el arreglo está lleno, duplica su tamaño.
        if (numClientes == clientes.length) {
            clientes = Arrays.copyOf(clientes, clientes.length * 2);
        }
        clientes[numClientes++] = new Cliente(idCliente, nombre, apellido, genero);
    }

    public static void agregarCliente(Cliente cliente) {
        if (cliente == null || buscarCliente(cliente.getId()) != null) {
            return; // Cliente inválido o con ID duplicado.
        }
        // Si el arreglo de clientes está lleno, lo redimensiona.
        if (numClientes == clientes.length) {
            clientes = Arrays.copyOf(clientes, clientes.length * 2);
        }
        clientes[numClientes++] = cliente;
    }

    public static void editarCliente(int idCliente, int nuevoId, String nuevoNombre, String nuevoApellido, Genero nuevoGenero) {
        int indiceClienteAEditar = -1;
        for (int i = 0; i < numClientes; i++) {
            if (clientes[i] != null && clientes[i].getId() == idCliente) {
                indiceClienteAEditar = i;
                break;
            }
        }

        if (indiceClienteAEditar != -1) {
            // Comprueba si el nuevo ID ya es utilizado por otro cliente (evitando el mismo cliente).
            if (nuevoId != idCliente && buscarCliente(nuevoId) != null) {
                return;
            }
            clientes[indiceClienteAEditar] = new Cliente(nuevoId, nuevoNombre, nuevoApellido, nuevoGenero);
        }
    }

    public static void eliminarCliente(int idCliente) {
        int indiceAEliminar = -1;
        for (int i = 0; i < numClientes; i++) {
            if (clientes[i] != null && clientes[i].getId() == idCliente) {
                indiceAEliminar = i;
                break;
            }
        }

        if (indiceAEliminar != -1) {
            // Desplaza los elementos subsiguientes para ocupar el espacio.
            System.arraycopy(clientes, indiceAEliminar + 1, clientes, indiceAEliminar, numClientes - 1 - indiceAEliminar);
            clientes[--numClientes] = null; // Anula la referencia y decrementa el contador.
        }
    }

    public static String consultarClientes() {
        if (numClientes == 0) {
            return "Actualmente no hay clientes registrados en el banco.";
        }
        String clientesString = "";
        for (int i = 0; i < numClientes; i++) {
            if (clientes[i] != null) {
                clientesString = clientesString + clientes[i].toString() + "\n";
            }
        }
        return clientesString;
    }

    public static Cliente buscarCliente(int idCliente) {
        for (int i = 0; i < numClientes; i++) {
            if (clientes[i] != null && clientes[i].getId() == idCliente) {
                return clientes[i];
            }
        }
        return null; // Cliente no encontrado.
    }

    public static boolean agregarEmpleado(Empleado empleado) {
        if (empleado == null || validarEmpleado(empleado)) {
            return false; // El empleado es nulo o ya existe.
        }
        // Redimensiona el arreglo si no hay espacio.
        if (numEmpleados == staff.length) {
            staff = Arrays.copyOf(staff, staff.length * 2);
        }
        staff[numEmpleados++] = empleado;
        return true;
    }

    public static boolean editarEmpleado(int idEmpleado, Empleado nuevosDatosEmpleado) {
        if (nuevosDatosEmpleado == null) {
            return false;
        }

        for (int i = 0; i < numEmpleados; i++) {
            if (staff[i] != null && staff[i].getId() == idEmpleado) {
                // Actualiza los atributos comunes del empleado.
                staff[i].setNombre(nuevosDatosEmpleado.getNombre());
                staff[i].setApellido(nuevosDatosEmpleado.getApellido());
                staff[i].setCorreo(nuevosDatosEmpleado.getCorreo());
                staff[i].setDireccion(nuevosDatosEmpleado.getDireccion());
                staff[i].setTelefonos(nuevosDatosEmpleado.getTelefonos());
                staff[i].setFechaNacimiento(nuevosDatosEmpleado.getFechaNacimiento());
                staff[i].setGenero(nuevosDatosEmpleado.getGenero());
                staff[i].setSalario(nuevosDatosEmpleado.getSalario());
                staff[i].setPuesto(nuevosDatosEmpleado.getPuesto());
                staff[i].setFechaContratacion(nuevosDatosEmpleado.getFechaContratacion());

                // Actualiza atributos específicos si es una subclase (Manager o Director).
                if (staff[i] instanceof Manager && nuevosDatosEmpleado instanceof Manager) {
                    ((Manager) staff[i]).setDeptNombre(((Manager) nuevosDatosEmpleado).getDeptNombre());
                }
                if (staff[i] instanceof Director && nuevosDatosEmpleado instanceof Director) {
                    ((Director) staff[i]).setPresupuesto(((Director) nuevosDatosEmpleado).getPresupuesto());
                    ((Director) staff[i]).setComision(((Director) nuevosDatosEmpleado).getComision());
                }
                return true;
            }
        }
        return false; // Empleado no encontrado.
    }

    public static boolean eliminarEmpleado(int idEmpleado) {
        for (int i = 0; i < numEmpleados; i++) {
            if (staff[i] != null && staff[i].getId() == idEmpleado) {
                // Desplaza los elementos para llenar el hueco del empleado eliminado.
                System.arraycopy(staff, i + 1, staff, i, numEmpleados - 1 - i);
                staff[--numEmpleados] = null;
                return true;
            }
        }
        return false; // Empleado no encontrado.
    }

    public static String consultarEmpleados() {
        if (numEmpleados == 0) {
            return "Actualmente no hay empleados registrados en el banco.";
        }
        String empleadosString = "";
        for (int i = 0; i < numEmpleados; i++) {
            if (staff[i] != null) {
                empleadosString = empleadosString + staff[i].toString() + "\n";
            }
        }
        return empleadosString;
    }

    public static boolean validarEmpleado(Empleado empleado) {
        if (empleado == null) {
            return false;
        }
        for (int i = 0; i < numEmpleados; i++) {
            if (staff[i] != null && staff[i].equals(empleado)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "=============== Resumen General del Banco ===============\n\n" +
                "--- Clientes Registrados ---\n" + consultarClientes() + "\n" +
                "--- Empleados del Staff ---\n" + consultarEmpleados();
    }
}