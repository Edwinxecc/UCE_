package ec.edu.uce.dominio;

public class Empleado {
    private int idEmpleado;
    private String nombre;
    private String apellido;
    private double salarioMensual;

    public Empleado(){

    }

    public Empleado(int idEmpleado, String nombre, String apellido, int horasTrabajadas) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.salarioMensual = calcularSalarioMensual(horasTrabajadas);
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

    public double getSalarioMensual() {
        return this.salarioMensual;
    }

    public double calcularSalarioMensual(double horasTrabajadas) {
        final double costoHoraTrabajo = 3.88;
        return horasTrabajadas * costoHoraTrabajo;
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

    @Override
    public String toString() {
        return "bueno";
    }
}
