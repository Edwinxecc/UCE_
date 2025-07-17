package ec.edu.uce.dominio;

import ec.edu.uce.util.DAOException;

public class TestException {

    public static void main(String[] args) {
        try {
            Banco banco = Banco.getInstance();
            Cliente cli = banco.getCliente(50);
            // Puedes imprimirlo o hacer algo más
            System.out.println(cli);
        } catch (DAOException e) {
            System.err.println("Indice excedido: " + e.getMessage());
        }
    }
}