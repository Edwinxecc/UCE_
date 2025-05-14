package ec.edu.uce.dominio;



public class Empleado {
    private int idEmpleado;
    private String nombre;
    private String apellido;
    private double salarioMensual;

    public Empleado(int idEmpleado, String nombre, String apellido, int horasTrabajadas){
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


    public double calcularSalarioMensual(double horasTrabajadas){
        final double costoHoraTrabajo = 3.88;
        return horasTrabajadas * costoHoraTrabajo;
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

