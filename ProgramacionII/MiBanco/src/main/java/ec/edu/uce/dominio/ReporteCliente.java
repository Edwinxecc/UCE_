package ec.edu.uce.dominio;

import ec.edu.uce.util.DAOException;

public class ReporteCliente {

    public static String reporteClientes() throws DAOException {
        Banco banco = Banco.getInstance();
        int numClientes = banco.getNumClientes();
        StringBuilder texto = new StringBuilder("Reporte Clientes\n");

        for (int i = 0; i < numClientes; i++) {
            Cliente cli = banco.getCliente(i);
            if (cli != null) {
                texto.append(cli).append("\n");
                for (Cuenta c : cli.getCuentas()) {
                    texto.append(c).append("\n");
                }
                texto.append("\n");
            }
        }
        return texto.toString();
    }
}