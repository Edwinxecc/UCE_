package ec.edu.uce.dominio;

public class ComparableCliente implements Comparable<ComparableCliente> {

    private int clienteId;
    private String nombre;
    private String apellido;


    public ComparableCliente() {

    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    @Override
    public int compareTo(ComparableCliente o) {
        int resultado = this.nombre.compareTo(o.getNombre());
        return resultado;
    }
}