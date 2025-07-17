package ec.edu.uce.datos;

import ec.edu.uce.dominio.Cliente;
import ec.edu.uce.util.DAOException;

public interface ClienteDAO {
    void agregarCliente(Cliente cliente) throws DAOException;
    void editarCliente(Cliente cliente) throws DAOException;
    void eliminarCliente(int id) throws DAOException;
    Cliente buscarClientePorId(int id) throws DAOException;
    Cliente[] consultarClientes() throws DAOException;
}
