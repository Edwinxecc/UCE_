package ec.edu.uce.dominio;

import java.util.Date;

public class Cliente {
    Date currentDate = new Date();
    private int clienteId;
    private String nombre;
    private String apellido;
    private String correo;
    private Date fechaRegistro;

    public Cliente (int clienteId, String nombre, String apellido, String correo){
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.fechaRegistro = currentDate;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
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

    //metodos
    public boolean validarCorreo(){
        String correoTemp = this.correo, dominio = "";
        for (int i = 0; i < correoTemp.length(); i++) {
            if ((correoTemp.charAt(i)+"").equalsIgnoreCase("@")){
                dominio = correoTemp.substring(i);
                break;
            }
        }
        return dominio.equalsIgnoreCase("@uce.edu.ec");
    }

    public boolean[] validarNombreApellido(){
        String numbers = "0123456789";
        boolean [] validation = new boolean[2];
        validation[0] = true; // nombre es validdo o no
        validation[1] = true; // apellido valido
        for (int i = 0; i < this.nombre.length(); i++) {

            for (int j = 0; j < numbers.length(); j++) {
                if ((this.nombre.charAt(i)+"").equalsIgnoreCase(numbers.charAt(j)+"")){
                    validation[0] = false;
                }
                if ((this.apellido.charAt(i)+"").equalsIgnoreCase(numbers.charAt(j)+"")){
                    validation[1] = false;
                }
            }

        }

        return validation;
    }

}
