package ec.edu.uce.dominio;

import java.util.Date;

public class Cliente {
    private int clienteId;
    private String nombre;
    private String apellido;
    private String correo;
    private Date fechaRegistro;

    public Cliente(int clienteId, String nombre, String apellido, String correo) {
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.fechaRegistro = new Date(); // Fecha actual al momento de crear el cliente
    }

    public int getIdCliente() {
        return clienteId;
    }

    public void setIdCliente(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public boolean validarCorreo() {
        int atIndex = correo.indexOf('@');
        if (atIndex != -1) {
            String dominio = correo.substring(atIndex);
            return dominio.equalsIgnoreCase("@uce.edu.ec");
        }
        return false;
    }

    public boolean[] validarNombreApellido() {
        String numeros = "0123456789";
        boolean[] validaciones = {true, true};

        for (char c : this.nombre.toCharArray()) {
            if (numeros.contains(String.valueOf(c))) {
                validaciones[0] = false;
                break;
            }
        }

        for (char c : this.apellido.toCharArray()) {
            if (numeros.contains(String.valueOf(c))) {
                validaciones[1] = false;
                break;
            }
        }

        return validaciones;
    }
}
