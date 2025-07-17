/**
 * @author Jhon Avila
 */
package ec.edu.uce.dominio;

import ec.edu.uce.util.DAOException;

import javax.swing.table.DefaultTableModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un banco con clientes y empleados.
 */
public class Banco implements Serializable {

    private static final Banco instance=new Banco();

    public static Banco getInstance(){
        return instance;
    }

    /**
     * Arreglo de clientes registrados en el banco.
     */
    private static List<Cliente> clientes;

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
        clientes = new ArrayList<>(3);
        inicializar();
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
        return clientes.size();
    }

    /**
     * Obtiene el cliente en la posición especificada.
     *
     * @param indice índice del cliente en el arreglo
     * @return objeto Cliente en la posición dada
     */
    public static Cliente getCliente(int indice) throws DAOException{
        Cliente cli=null;
        try{
        cli= clientes.get(indice);
        }catch (IndexOutOfBoundsException ex){
            System.out.println("Índice no permitido: "+indice);
            throw new DAOException("Índice no permitido: "+ indice, ex);
        }finally {
            return cli;
        }

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
        Cliente cliente = new Cliente(nombre, apellido, genero);
        clientes.add(cliente);
    }

    public static void agregarCliente(Cliente cli) {
       clientes.add(cli);
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
            numEmpleados++;
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
        Cliente cli = new Cliente(nombre, apellido, genero);
        clientes.set(indice, cli);
    }

    /**
     * Elimina un cliente del banco en la posición dada, desplazando los demás clientes hacia la izquierda.
     *
     * @param indice índice del cliente a eliminar
     */
    public static void eliminarCliente(int indice) {
        if (indice >= 0 && indice < clientes.size()) {
            clientes.remove(indice);
        }
    }

    /**
     * Devuelve una cadena con la información de todos los clientes del banco.
     *
     * @return String con la lista de clientes
     */
    public static StringBuilder consultarClientes() {
        StringBuilder texto = new StringBuilder();
        for (Cliente c : clientes) {
            texto.append(c).append("\n");
        }
        return texto;
    }

    public static List<Cliente> getClientes() {
        return clientes;
    }

    /**
     * Devuelve una cadena con la información de todos los empleados del banco.
     *
     * @return String con la lista de empleados
     */
    public static String consultarEmpleados() {
        StringBuilder texto = new StringBuilder();
        for (Empleado e : staff) {
            if (e != null) {
                texto.append(e).append("\n");
            }
        }
        return texto.toString();
    }

    public static void inicializar() {
        //agregarCliente(new Cliente(1, "Edwin", "Caiza", Genero.MASCULINO));
        agregarCliente(1,"Juan","Urquizo",Genero.FEMENINO);
        agregarCliente(4,"Ana","Perez",Genero.FEMENINO);
        agregarCliente(6,"Jose","Masacho",Genero.MASCULINO);
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
        if (indice >= 0 && indice < clientes.size()) {
            return clientes.get(indice);
        } else {
            System.out.println("Índice fuera de rango.");
            return null;
        }
    }

    public Cliente getCliente(String nombre){
        for (Cliente cli:clientes){
            if (cli.getNombre().equals(nombre)){
                return cli;
            }
        }
        return null;
    }

    public static String reporteClientes() {
        String texto = "";
        for (Cliente c : clientes) {
            texto += c + "\r\n";
        }
        return texto;
    }


    public static boolean validarEmpleado(Empleado empleado){
        for (Empleado e : staff) {
            if (e != null && e.equals(empleado)) {
                return true;
            }
        }
        return false;
    }


}
