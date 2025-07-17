package ec.edu.uce.dominio;

import ec.edu.uce.util.DAOException;

public class TestReporte {
    public static void main(String[] args) {
        try {
            System.out.println(ReporteCliente.reporteClientes());
        } catch (DAOException e) {
            System.err.println("Error al generar el reporte de clientes: " + e.getMessage());
        }
    }
}