package ec.edu.uce.dominio;

public class Director extends Manager {

    private double presupuesto;

    public Director() {
        super();
        this.presupuesto = 0.0;
        // this.deptNombre

    }

    public Director(int id, String nombre, String apellido, Genero genero, double salario, String departamento,double presupuesto) {
        super(id, nombre, apellido, genero, salario, departamento);
        setPresupuesto(presupuesto);


    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        if (presupuesto >= 0) {
            this.presupuesto = presupuesto;
        } else {
            System.out.println("Error: el presupuesto no puede ser negativo");
            this.presupuesto = 0.0;
        }
    }

    public boolean aprobarGasto(double gasto) {
        if (gasto <= 0) {
            System.out.println("Error: el gasto debe ser mayor a cero");
            return false;
        }

        if (gasto <= presupuesto) {
            presupuesto -= gasto;
            System.out.println("Gasto aprobado: $" + String.format("%.2f", gasto) +
                    ". Presupuesto restante: $" + String.format("%.2f", presupuesto));
            return true;
        } else {
            System.out.println("Gasto rechazado: $" + String.format("%.2f", gasto) +
                    ". Presupuesto disponible: $" + String.format("%.2f", presupuesto));
            return false;
        }
    }

    @Override
    public String toString() {

        return "Director [Presupuesto = $" + String.format("%.2f", presupuesto) + "]";
    }
}
