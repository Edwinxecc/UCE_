/**
 * @author Edwin Caiza
 */
package ec.edu.uce.dominio;

public class ReporteCliente {

    public static String reporteClientes() {
        String texto = "Reporte Clientes\n";
        Banco banco = Banco.getInstance();

        for (Cliente cli : banco.getClientes()) {
            if (cli != null) {
                texto += cli + "\n";

                for (Cuenta c : cli.getCuentas()) {
                    if (c != null) {
                        texto += c + "\n";
                    }
                }
                texto += "\n";
            }
        }
        return texto;
    }
}