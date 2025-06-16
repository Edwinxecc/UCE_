/**
 * @author Edwin Caiza
 */
package ec.edu.uce.dominio;

/**
 * Clase que representa un banco con clientes y empleados.
 */
public class Banco {

    private static final Banco instance=new Banco();

    public static Banco getInstance(){
        return instance;
    }

    /**
     * Arreglo de clientes registrados en el banco.
     */
    private static Cliente[] clientes;

    /**
     * Número actual de clientes en el banco.
     */
    private static int numClientes;

    /**
     * Arreglo de empleados (staff) del banco.
     */
    private static Empleado[] staff;

    /**
     * Número actual de empleados en el banco.
     */
    private static int numEmpleados;

    static {
        numEmpleados=0;
        staff = new Empleado[5];
        numClientes=0;
        clientes = new Cliente[5];
    }

    /**
     * Constructor que inicializa el banco con capacidad para 3 clientes y 3 empleados.
     */

    /**
     * Obtiene la cantidad actual de clientes registrados en el banco.
     *
     * @return número de clientes
     */
    public static int getNumClientes() {
        return numClientes;
    }

    /**
     * Obtiene el cliente en la posición especificada.
     *
     * @param indice índice del cliente en el arreglo
     * @return objeto Cliente en la posición dada
     */
    public static Cliente getCliente(int indice) {
        return clientes[indice];
    }

    public static Cliente[] getClientes() {
        return clientes;
    }

    public static Empleado[] getStaff() {
        return staff;
    }


    /**
     * Agrega un nuevo cliente al banco.
     * Si el arreglo está lleno, se expande dinámicamente para acomodar más clientes.
     *
     * @param id       identificador único del cliente
     * @param nombre   nombre del cliente
     * @param apellido apellido del cliente
     * @param genero   género del cliente (enum Genero)
     */
    public static void agregarCliente(int id, String nombre, String apellido, Genero genero) {
        Cliente cliente = new Cliente(id, nombre, apellido, genero);
        if (numClientes == clientes.length) {
            Cliente[] cliaux = clientes;
            clientes = new Cliente[numClientes + 1];
            System.arraycopy(cliaux, 0, clientes, 0, numClientes);
        }
        clientes[numClientes] = cliente;
        numClientes++;
    }

    /**
     * Agrega un nuevo empleado al banco.
     * Si el arreglo está lleno, se expande dinámicamente para acomodar más empleados.
     *
     * @param empleado objeto Empleado a agregar
     */
    public static boolean agregarEmpleado(Empleado empleado) {
        boolean respuesta=false;
        if (!validarEmpleado(empleado)){
            if (numEmpleados == staff.length) {
                Empleado[] empaux = staff;
                staff = new Empleado[numEmpleados + 1];
                System.arraycopy(empaux, 0, staff, 0, numEmpleados);
            }
            staff[numEmpleados] = empleado;
            numEmpleados=numEmpleados++;
            System.out.println(numEmpleados);
            respuesta=true;
        }
        return respuesta;
    }

    /**
     * Edita los datos de un cliente existente en el índice dado.
     *
     * @param indice   posición del cliente a editar
     * @param id       nuevo id del cliente
     * @param nombre   nuevo nombre
     * @param apellido nuevo apellido
     * @param genero   nuevo género
     */
    public static void editarCliente(int indice, int id, String nombre, String apellido, Genero genero) {
        clientes[indice] = new Cliente(id, nombre, apellido, genero);
    }

    /**
     * Elimina un cliente del banco en la posición dada, desplazando los demás clientes hacia la izquierda.
     *
     * @param indice índice del cliente a eliminar
     */
    public static void eliminarCliente(int indice) {
        if (indice >= 0 && indice < numClientes) {
            for (int i = indice; i < numClientes - 1; i++) {
                clientes[i] = clientes[i + 1];
            }
            clientes[numClientes - 1] = null;
            numClientes--;
        } else {
            System.out.println("Índice fuera de rango.");
        }
    }

    /**
     * Devuelve una cadena con la información de todos los clientes del banco.
     *
     * @return String con la lista de clientes
     */
    public static String consultarClientes() {
        String texto = "";
        for (Cliente cliente : clientes) {
            if (cliente != null) {
                texto += cliente + "\r\n";
            }
        }
        return texto;
    }

    /**
     * Devuelve una cadena con la información de todos los empleados del banco.
     *
     * @return String con la lista de empleados
     */
    public static String consultarEmpleados() {
        String texto = "";
        for (Empleado e : staff) {
            if (e != null) {
                texto += e + "\r\n";
            }
        }
        return texto;
    }

    /**
     * Representación en cadena del banco, mostrando clientes y empleados.
     */
    @Override
    public String toString() {
        return "Banco:\n" + consultarClientes() + "\nEmpleados:\n" + consultarEmpleados();
    }
    /**
     * Busca y devuelve el cliente en la posición especificada.
     *
     * @param indice posición del cliente a buscar
     * @return Cliente si existe en esa posición, o null si no existe
     */
    public static Cliente buscarCliente(int indice) {
        if (indice >= 0 && indice < numClientes) {
            return clientes[indice];
        } else {
            System.out.println("Índice fuera de rango.");
            return null;
        }
    }
    public static boolean validarEmpleado(Empleado empleado){
        boolean respuesta=false;
        for(Empleado e:staff){
            if (e!=null && e.equals(empleado)){
                respuesta=true;
            }
            break;
        }
        return respuesta;
    }


}