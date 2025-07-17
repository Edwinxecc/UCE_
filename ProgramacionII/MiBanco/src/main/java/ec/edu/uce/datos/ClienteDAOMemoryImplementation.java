package ec.edu.uce.datos;

import ec.edu.uce.dominio.Cliente;
import ec.edu.uce.util.DAOException;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAOMemoryImplementation implements ClienteDAO {

    private static List<Cliente> clientes = new ArrayList<>();

    @Override
    public void agregarCliente(Cliente cliente) throws DAOException {
        if (validarCliente(cliente)) {
            throw new DAOException("El cliente ya existe.");
        }
        clientes.add(cliente);
    }

    @Override
    public void editarCliente(Cliente cliente) throws DAOException {
        int id = cliente.getClienteId();
        if (id < 0 || id >= clientes.size() || clientes.get(id) == null) {
            throw new DAOException("No se puede editar: ID inválido o cliente no existe.");
        }
        clientes.set(id, cliente);
    }

    @Override
    public void eliminarCliente(int id) throws DAOException {
        if (id < 0 || id >= clientes.size() || clientes.get(id) == null) {
            throw new DAOException("No se puede eliminar: ID inválido o cliente no existe.");
        }
        clientes.set(id, null);
    }

    @Override
    public Cliente buscarClientePorId(int id) throws DAOException {
        if (id < 0 || id >= clientes.size()) {
            throw new DAOException("Cliente no encontrado: ID fuera de rango.");
        }
        return clientes.get(id);
    }

    @Override
    public Cliente[] consultarClientes() throws DAOException {
        return clientes.toArray(new Cliente[0]);
    }

    private static boolean validarCliente(Cliente cliente) {
        for (Cliente c : clientes) {
            if (c != null && c.equals(cliente)) {
                return true;
            }
        }
        return false;
    }
}
