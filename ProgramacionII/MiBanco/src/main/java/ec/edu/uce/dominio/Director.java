package ec.edu.uce.dominio;

import java.util.Arrays; // Mantenido por herencia o uso futuro, aunque no directamente en Director.

import ec.edu.uce.dominio.Fecha;
import ec.edu.uce.dominio.Genero;

/**
 * Clase **Director**, extiende de la clase `Manager` e incorpora atributos específicos
 * como el presupuesto que gestiona y su porcentaje de comisión.
 */
public class Director extends Manager {

    private double presupuesto; // Cantidad de dinero que el director puede gestionar.
    private double comision;    // Porcentaje de comisión asignado al director.

    // Constructor predeterminado.
    public Director() {
        super();
        this.presupuesto = 0.0;
        this.comision = 0.0;
    }

    // Constructor con los datos esenciales para un director.
    public Director(String nombre, String apellido, Genero genero, double salario, String departamento, double presupuesto, double comision) {
        super(nombre, apellido, genero, salario, departamento);
        setPresupuesto(presupuesto); // Asigna y valida el presupuesto.
        setComision(comision);     // Asigna y valida la comisión.
    }

    // Constructor completo (sin ID explícito al inicio).
    public Director(String nombre, String apellido, String correo, String direccion,
                    String[] telefonos, Fecha fechaNacimiento, Genero genero,
                    double salario, String puesto, Fecha fechaContratacion, String departamento, double presupuesto, double comision) {
        super(nombre, apellido, correo, direccion, telefonos, fechaNacimiento, genero, salario, puesto, fechaContratacion, departamento);
        setPresupuesto(presupuesto);
        setComision(comision);
    }

    /**
     * Constructor completo para un Director, incluyendo un ID explícito.
     */
    public Director(int id, String nombre, String apellido, String correo, String direccion,
                    String[] telefonos, Fecha fechaNacimiento, Genero genero,
                    double salario, String puesto, Fecha fechaContratacion, String departamento, double presupuesto, double comision) {
        super(id, nombre, apellido, correo, direccion, telefonos, fechaNacimiento, genero,
                salario, puesto, fechaContratacion, departamento);
        setPresupuesto(presupuesto);
        setComision(comision);
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        // Asegura que el presupuesto no sea negativo.
        if (presupuesto >= 0) {
            this.presupuesto = presupuesto;
        } else {
            System.out.println("Advertencia (Director Presupuesto): El presupuesto no puede ser negativo. Se ha establecido en 0.0.");
            this.presupuesto = 0.0;
        }
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        // Asegura que el valor de la comisión no sea negativo.
        if (comision >= 0) {
            this.comision = comision;
        } else {
            System.out.println("Advertencia (Director Comisión): La comisión no puede ser negativa. Se ha establecido en 0.0.");
            this.comision = 0.0;
        }
    }

    /**
     * Permite al director aprobar un gasto si el presupuesto disponible es suficiente.
     * @param gasto Monto del gasto a aprobar.
     * @return `true` si el gasto fue aprobado y descontado del presupuesto, `false` en caso contrario.
     */
    public boolean aprobarGasto(double gasto) {
        if (gasto <= 0) {
            return false; // El gasto debe ser un valor positivo.
        }
        if (gasto <= presupuesto) {
            presupuesto -= gasto; // Descuenta el gasto del presupuesto.
            return true;
        } else {
            System.out.println("Gasto rechazado: $" + String.format("%.2f", gasto) +
                    ". Presupuesto disponible: $" + String.format("%.2f", presupuesto));
            return false;
        }
    }

    /**
     * Calcula el bono anual para el Director, sumando el bono de Manager y un porcentaje adicional por comisión.
     * @return El monto total del bono anual del director.
     */
    @Override
    public double calcularBonoAnual() {
        return super.calcularBonoAnual() + (this.comision * 0.15); // Suma el bono de Manager más el 15% de su comisión.
    }

    /**
     * Devuelve una cadena de texto con la información detallada del Director.
     */
    @Override
    public String toString() {
        return super.toString() +
                "\n  Presupuesto Asignado: $" + String.format("%.2f", presupuesto) +
                "\n  Comisión: " + String.format("%.2f", (comision * 100)) + "%";
    }

    /**
     * Compara si dos objetos Director son iguales, basándose en la igualdad de la superclase
     * y los atributos específicos de Director (presupuesto y comisión).
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false; // Llama al equals de la superclase.

        Director director = (Director) obj;

        // Compara los atributos específicos de Director.
        if (Double.compare(director.presupuesto, presupuesto) != 0) return false;
        return Double.compare(director.comision, comision) == 0;
    }

    /**
     * Genera un valor hash para el Director, consistente con el método `equals`.
     */
    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), presupuesto, comision);
    }
}