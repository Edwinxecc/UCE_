package ec.edu.uce.dominio;

/**
 * Representa a un **manager** dentro de la organización, heredando propiedades de `Empleado`
 * y añadiendo información sobre el departamento que dirige.
 */
public class Manager extends Empleado {

    private String deptNombre; // Nombre del departamento bajo la responsabilidad del manager.

    // Constructor predeterminado.
    public Manager() {
        super("Sin Nombre", "Sin Apellido", Genero.OTRO, 0.0); // Llama al constructor de la superclase con valores por defecto.
        this.deptNombre = "sin departamento";
    }

    // Constructor con los datos esenciales del manager.
    public Manager(String nombre, String apellido, Genero genero, double salario, String departamento) {
        super(nombre, apellido, genero, salario); // Llama al constructor de la superclase.
        setDeptNombre(departamento); // Asigna el nombre del departamento.
    }

    // Constructor completo que autogenera el ID del manager.
    public Manager(String nombre, String apellido, String correo, String direccion,
                   String[] telefonos, Fecha fechaNacimiento, Genero genero,
                   double salario, String puesto, Fecha fechaContratacion, String departamento) {
        super(nombre, apellido, correo, direccion, telefonos, fechaNacimiento, genero, salario, puesto, fechaContratacion); // Llama al constructor completo de la superclase.
        setDeptNombre(departamento);
    }

    /**
     * Constructor para Manager que permite asignar un ID explícito.
     * @param id El identificador único del manager.
     */
    public Manager(int id, String nombre, String apellido, String correo, String direccion,
                   String[] telefonos, Fecha fechaNacimiento, Genero genero,
                   double salario, String puesto, Fecha fechaContratacion, String departamento) {
        super(id, nombre, apellido, correo, direccion, telefonos, fechaNacimiento, genero,
                salario, puesto, fechaContratacion); // Llama al constructor de la superclase con ID.
        setDeptNombre(departamento);
    }

    public String getDeptNombre() {
        return deptNombre;
    }

    public void setDeptNombre(String deptNombre) {
        // Valida que el nombre del departamento no sea nulo o vacío.
        if (deptNombre != null && !deptNombre.trim().isEmpty()) {
            this.deptNombre = deptNombre;
        } else {
            this.deptNombre = "sin departamento"; // Valor por defecto si el nombre es inválido.
        }
    }

    /**
     * Calcula el **bono anual** específico para un Manager.
     * El bono equivale al 30% del salario del manager.
     * @return El monto del bono anual.
     */
    @Override
    public double calcularBonoAnual() {
        return getSalario() * 0.30; // Calcula el 30% del salario como bono.
    }

    // Devuelve el monto del bono anual calculado.
    public double getBono() {
        return calcularBonoAnual();
    }

    @Override
    public String toString() {
        // Extiende la representación de cadena de la clase Empleado para incluir el departamento y el bono anual.
        return super.toString().replace("Empleado [", "Manager [") +
                ", Departamento=" + deptNombre + ", Bono Anual=" + String.format("%.2f", calcularBonoAnual());
    }

    /**
     * Compara si dos objetos Manager son iguales, basándose en la igualdad de la superclase
     * y el nombre del departamento.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false; // Llama al equals de la superclase.

        Manager manager = (Manager) obj;

        // Compara el atributo específico de Manager.
        return java.util.Objects.equals(deptNombre, manager.deptNombre);
    }

    /**
     * Genera un valor hash para el Manager, consistente con el método `equals`.
     */
    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), deptNombre);
    }
}