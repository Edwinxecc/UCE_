package ec.edu.uce.dominio;

public class Empleado {
    private int idEmpleado;
    private String nombre;
    private String cedula;
    private double salarioMensual;

    public Empleado(){
        this(0, "SIn nombre", "Cedula", 0);
    }

    public Empleado(int idEmpleado, String nombre, String cedula, int horasTrabajadas) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.cedula = cedula;
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
        return cedula;
    }

    public void setApellido(String apellido) {
        this.cedula = apellido;
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

        for (char c : this.cedula.toCharArray()) {
            if (numeros.contains(String.valueOf(c))) {
                validaciones[1] = false;
                break;
            }
        }

        return validaciones;
    }

    @Override
    public String toString() {
        //aca el string con el objeto
        return "bueno";
    }

    public void incrementarSalario(double monto){
        this.salarioMensual += monto;
    }

}
