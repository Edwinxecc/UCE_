/**
 * @author Edwin Caiza
 */
package ec.edu.uce.dominio;

/**
 * Clase de utilidad encargada de generar un **informe detallado** de los clientes
 * y todas las cuentas bancarias asociadas a cada uno.
 */
public class ReporteCliente {

    /**
     * Genera un **reporte exhaustivo** de todos los clientes registrados en el sistema del banco.
     * Este informe abarca la información personal de cada cliente y un listado completo de sus cuentas bancarias.
     *
     * @return Una cadena de texto (`String`) que contiene el reporte final de clientes.
     */
    public static String reporteClientes() {
        StringBuilder textoReporte = new StringBuilder("Reporte de Clientes\n");
        Banco banco = Banco.getInstance(); // Accede a la única instancia del banco.

        // Recorre la colección de clientes obtenidos del banco.
        for (Cliente cliente : banco.getClientes()) {
            if (cliente != null) {
                textoReporte.append("----------------------------------------\n");
                textoReporte.append("CLIENTE: ").append(cliente).append("\n"); // Añade la información esencial del cliente.

                textoReporte.append("Cuentas del Cliente:\n");
                // Verifica y añade el detalle de las cuentas del cliente.
                if (cliente.getNumCuentas() == 0) {
                    textoReporte.append("   - No tiene cuentas bancarias asociadas.\n");
                } else {
                    textoReporte.append(cliente.consultarCuentasDetalle());
                }
                textoReporte.append("\n"); // Añade una línea en blanco para separar los clientes en el reporte.
            }
        }
        return textoReporte.toString();
    }
}