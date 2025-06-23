/**
 * @author Edwin Caiza
 */
package ec.edu.uce.dominio;

/**
 * Esta clase de utilidad se encarga de calcular el impuesto sobre el salario de los empleados.
 * La tasa impositiva varía según la categoría del empleado (Director, Manager o Empleado regular).
 */
public class Impuesto {

    /**
     * Calcula el monto del impuesto aplicable a un empleado.
     * La metodología de cálculo del impuesto se ajusta si el empleado es un Director,
     * un Manager, o un Empleado general, considerando sus ingresos adicionales como comisiones o bonos.
     *
     * @param empleado El objeto Empleado para el cual se desea calcular el impuesto.
     * @return El monto total del impuesto que el empleado debe pagar.
     */
    public static double calcularImpuesto(Empleado empleado) {
        double impuesto = 0.00;

        if (empleado == null) {
            return 0.0; // Retorna 0 si el empleado es nulo.
        }

        if (empleado instanceof Director) {
            Director director = (Director) empleado;
            // Para un Director, el impuesto se calcula sobre el salario más la comisión.
            impuesto = (director.getSalario() + director.getComision()) * 0.15;
        } else if (empleado instanceof Manager) {
            Manager manager = (Manager) empleado;
            // Para un Manager, el impuesto se calcula sobre el salario más el bono.
            impuesto = (manager.getSalario() + manager.getBono()) * 0.10;
        } else {
            // Para un empleado regular, el impuesto es un porcentaje de su salario base.
            impuesto = empleado.getSalario() * 0.05;
        }
        return impuesto;
    }
}