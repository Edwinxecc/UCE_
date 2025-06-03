package ec.edu.uce.dominio;

import java.util.Objects;

public class Empleado implements Comparable<Empleado> {
    // ATRIBUTOS
    private int empleadoId;
    private String nombre;
    private String apellido;
    private String correo;
    private String direccion;
    private String telefono;
    private Fecha fechaNacimiento;
    private Genero genero;
    private double salario;
    private String puesto;
    private Fecha fechaContratacion;

    public Empleado() {
        this.empleadoId = 1;
        this.nombre = "sin nombre";
        this.apellido = "sin apellido";
        this.genero = Genero.FEMENINO; // Valor por defecto
        this.salario = 0.0;
        this.puesto = "Sin asignar";
        this.fechaContratacion = new Fecha();
    }

    public Empleado(Empleado otroEmpleado) {
        this.empleadoId = otroEmpleado.empleadoId;
        this.nombre = otroEmpleado.nombre;
        this.apellido = otroEmpleado.apellido;
        this.correo = otroEmpleado.correo;
        this.direccion = otroEmpleado.direccion;
        this.telefono = otroEmpleado.telefono;
        this.fechaNacimiento = otroEmpleado.fechaNacimiento != null ?
                new Fecha(otroEmpleado.fechaNacimiento) : null;
        this.genero = otroEmpleado.genero;
        this.salario = otroEmpleado.salario;
        this.puesto = otroEmpleado.puesto;
        this.fechaContratacion = otroEmpleado.fechaContratacion != null ?
                new Fecha(otroEmpleado.fechaContratacion) : null;
    }

    public Empleado(int id, String nombre, String apellido, Genero genero, double salario) {
        setEmpleadoId(id);
        setNombre(nombre);
        setApellido(apellido);
        setGenero(genero);
        setSalario(salario);
    }

    public Empleado(int empleadoId, String nombre, String apellido, String correo,
                    String direccion, String telefono, Fecha fechaNacimiento, Genero genero,
                    double salario, String puesto, Fecha fechaContratacion) {
        setEmpleadoId(empleadoId);
        setNombre(nombre);
        setApellido(apellido);
        setCorreo(correo);
        setDireccion(direccion);
        setTelefono(telefono);
        setFechaNacimiento(fechaNacimiento);
        setGenero(genero);
        setSalario(salario);
        setPuesto(puesto);
        setFechaContratacion(fechaContratacion);
    }

    // MÉTODOS GET Y SET

    public int getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(int empleadoId) {
        if (empleadoId >= 0) {
            this.empleadoId = empleadoId;
        } else {
            System.out.println("Error: codigo invalido " + empleadoId);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nuevoNombre) {
        if (nuevoNombre != null && !nuevoNombre.trim().isEmpty()) {
            this.nombre = nuevoNombre;
        } else {
            System.out.println("Error: nombre invalido");
            this.nombre = "sin nombre";
        }
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String nuevoCorreo) {
        if (nuevoCorreo != null && nuevoCorreo.contains("@") && nuevoCorreo.contains(".")) {
            this.correo = nuevoCorreo;
        } else {
            System.out.println("Error: formato de correo invalido");
        }
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String nuevoApellido) {
        if (nuevoApellido != null && !nuevoApellido.trim().isEmpty()) {
            this.apellido = nuevoApellido;
        } else {
            System.out.println("Error: apellido invalido");
            this.apellido = "sin apellido";
        }
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String nuevaDireccion) {
        this.direccion = nuevaDireccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String nuevoTelefono) {
        if (nuevoTelefono != null && nuevoTelefono.matches("\\d{10}")) {
            this.telefono = nuevoTelefono;
        } else {
            System.out.println("Error: formato de telefono invalido (debe tener 10 digitos)");
        }
    }

    public Fecha getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Fecha fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Genero getGenero() {
        return genero;
    }


    public void setGenero(Genero genero) {
        if (genero != null) {
            this.genero = genero;
        } else {
            System.out.println("Error: genero invalido");
        }
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario >= 0) {
            this.salario = salario;
        } else {
            System.out.println("Error: el salario no puede ser negativo");
            this.salario = 0.0;
        }
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        if (puesto != null && !puesto.trim().isEmpty()) {
            this.puesto = puesto;
        } else {
            System.out.println("Error: puesto invalido");
            this.puesto = "Sin asignar";
        }
    }

    public Fecha getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Fecha fechaContratacion) {
        if (fechaContratacion != null) {
            this.fechaContratacion = new Fecha(fechaContratacion);
        } else {
            this.fechaContratacion = new Fecha();
        }
    }

    // MÉTODOS ADICIONALES
    public double calcularBonoAnual() {
        return salario * 0.30;
    }

    public void incrementarSalario(double monto) {
        if (monto > 0) {
            this.salario += monto;
        } else {
            System.out.println("Error: el monto a incrementar debe ser positivo");
        }
    }

    public int calcularEdad() {
        if (fechaNacimiento == null) {
            return 0;
        }

        Fecha fechaActual = new Fecha(); // Asume fecha actual
        int edad = fechaActual.getAnio() - fechaNacimiento.getAnio();

        // Ajustar si aún no ha cumplido años este año
        if (fechaActual.getMes() < fechaNacimiento.getMes() ||
                (fechaActual.getMes() == fechaNacimiento.getMes() &&
                        fechaActual.getDia() < fechaNacimiento.getDia())) {
            edad--;
        }

        return edad;
    }

    public int calcularAniosExperiencia() {
        if (fechaContratacion == null) {
            return 0;
        }

        Fecha fechaActual = new Fecha(); // Asume fecha actual
        int anios = fechaActual.getAnio() - fechaContratacion.getAnio();

        // Ajustar si aún no ha cumplido el aniversario este año
        if (fechaActual.getMes() < fechaContratacion.getMes() ||
                (fechaActual.getMes() == fechaContratacion.getMes() &&
                        fechaActual.getDia() < fechaContratacion.getDia())) {
            anios--;
        }

        return anios;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public boolean esElegibleBonoAntiguedad() {
        return calcularAniosExperiencia() >= 5;
    }

    public double calcularSalarioMensual() {
        return salario / 12.0;
    }

    // MÉTODOS OVERRIDE

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Empleado empleado = (Empleado) obj;
        return empleadoId == empleado.empleadoId &&
                Double.compare(empleado.salario, salario) == 0 &&
                Objects.equals(nombre, empleado.nombre) &&
                Objects.equals(apellido, empleado.apellido) &&
                Objects.equals(correo, empleado.correo) &&
                Objects.equals(direccion, empleado.direccion) &&
                Objects.equals(telefono, empleado.telefono) &&
                Objects.equals(fechaNacimiento, empleado.fechaNacimiento) &&
                genero == empleado.genero &&
                Objects.equals(puesto, empleado.puesto) &&
                Objects.equals(fechaContratacion, empleado.fechaContratacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empleadoId, nombre, apellido, correo, direccion,
                telefono, fechaNacimiento, genero, salario, puesto,
                fechaContratacion);
    }

    @Override
    public int compareTo(Empleado otroEmpleado) {
        // Comparar por salario primero
        int comparacionSalario = Double.compare(this.salario, otroEmpleado.salario);
        if (comparacionSalario != 0) {
            return comparacionSalario;
        }

        // Si tienen el mismo salario, comparar por apellido
        int comparacionApellido = this.apellido.compareTo(otroEmpleado.apellido);
        if (comparacionApellido != 0) {
            return comparacionApellido;
        }

        // Si tienen el mismo apellido, comparar por nombre
        return this.nombre.compareTo(otroEmpleado.nombre);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empleado [ID = ").append(empleadoId)
                .append(", Nombre = ").append(nombre)
                .append(", Apellido = ").append(apellido);

        if (genero != null) {
            sb.append(", Género = ").append(genero);
        }

        if (correo != null && !correo.isEmpty()) {
            sb.append(", Correo = ").append(correo);
        }

        if (direccion != null && !direccion.isEmpty()) {
            sb.append(", Dirección = ").append(direccion);
        }

        if (telefono != null && !telefono.isEmpty()) {
            sb.append(", Teléfono = ").append(telefono);
        }

        if (fechaNacimiento != null) {
            sb.append(", Fecha Nacimiento = ").append(fechaNacimiento);
            sb.append(", Edad = ").append(calcularEdad()).append(" años");
        }

        sb.append(", Puesto = ").append(puesto)
                .append(", Salario = $").append(String.format("%.2f", salario))
                .append(", Salario Mensual = $").append(String.format("%.2f", calcularSalarioMensual()));

        if (fechaContratacion != null) {
            sb.append(", Fecha Contratación = ").append(fechaContratacion);
            sb.append(", Años de Experiencia = ").append(calcularAniosExperiencia());
        }

        sb.append(", Bono Anual = $").append(String.format("%.2f", calcularBonoAnual()));
        sb.append(", Elegible Bono Antigüedad = ").append(esElegibleBonoAntiguedad() ? "Sí" : "No");
        sb.append("]");

        return sb.toString();
    }

    @Override
    public Empleado clone() {
        try {
            return new Empleado(this);
        } catch (Exception e) {
            throw new RuntimeException("Error al clonar empleado", e);
        }
    }


}