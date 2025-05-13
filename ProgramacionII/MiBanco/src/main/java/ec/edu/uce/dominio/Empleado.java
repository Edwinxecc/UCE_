package ec.edu.uce.dominio;



public class Empleado {
    private int idEmpleado;
    private String nombre;
    private String apellido;
    private int salarioMensual;

    public Empleado(int idEmpleado, String nombre, String apellido, int salarioMensual){
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.salarioMensual = salarioMensual;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
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

    public int getSalarioMensual() {
        return salarioMensual;
    }

    public void setSalarioMensual(int salarioMensual) {
        this.salarioMensual = salarioMensual;
    }

    public double calcularSalarioMensual(double horasTrabajadas){
        final double costoHoraTrabajo = 3.88;
        return horasTrabajadas * costoHoraTrabajo;
    }
}

