package ec.edu.uce.dominio;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void testGetIdCliente() {
        Cliente cliente = new Cliente(123, "Edwin", "Caiza", "edcaizac1@uce.edu.ec");
        assertEquals(123, cliente.getIdCliente());
    }

    @Test
    void testSetIdCliente() {
        Cliente cliente = new Cliente(123, "Edwin", "Caiza", "edcaizac1@uce.edu.ec");
        cliente.setIdCliente(456);
        assertEquals(456, cliente.getIdCliente());
    }

    @Test
    void testGetNombre() {
        Cliente cliente = new Cliente(123, "Edwin", "Caiza", "edcaizac1@uce.edu.ec");
        assertEquals("Edwin", cliente.getNombre());
    }

    @Test
    void testSetNombre() {
        Cliente cliente = new Cliente(123, "Edwin", "Caiza", "edcaizac1@uce.edu.ec");
        cliente.setNombre("Carlos");
        assertEquals("Carlos", cliente.getNombre());
    }

    @Test
    void testGetApellido() {
        Cliente cliente = new Cliente(123, "Edwin", "Caiza", "edcaizac1@uce.edu.ec");
        assertEquals("Caiza", cliente.getApellido());
    }

    @Test
    void testSetApellido() {
        Cliente cliente = new Cliente(123, "Edwin", "Caiza", "edcaizac1@uce.edu.ec");
        cliente.setApellido("Paredes");
        assertEquals("Paredes", cliente.getApellido());
    }

    @Test
    void testGetCorreo() {
        Cliente cliente = new Cliente(123, "Edwin", "Caiza", "edcaizac1@uce.edu.ec");
        assertEquals("edcaizac1@uce.edu.ec", cliente.getCorreo());
    }

    @Test
    void testGetFechaRegistro() {
        Cliente cliente = new Cliente(123, "Edwin", "Caiza", "edcaizac1@uce.edu.ec");
        assertNotNull(cliente.getFechaRegistro());
    }

    @Test
    void testSetFechaRegistro() {
        Cliente cliente = new Cliente(123, "Edwin", "Caiza", "edcaizac1@uce.edu.ec");
        Date nuevaFecha = new Date();
        cliente.setFechaRegistro(nuevaFecha);
        assertEquals(nuevaFecha, cliente.getFechaRegistro());
    }

    @Test
    void testValidarCorreoValido() {
        Cliente cliente = new Cliente(123, "Edwin", "Caiza", "edcaizac1@uce.edu.ec");
        assertTrue(cliente.validarCorreo());
    }

    @Test
    void testValidarCorreoInvalido() {
        Cliente cliente = new Cliente(124, "Luis", "Gomez", "luis@gmail.com");
        assertFalse(cliente.validarCorreo());
    }

    @Test
    void testValidarNombreApellidoCorrecto() {
        Cliente cliente = new Cliente(125, "Maria", "Lopez", "maria@uce.edu.ec");
        boolean[] validaciones = cliente.validarNombreApellido();
        assertTrue(validaciones[0]);
        assertTrue(validaciones[1]);
    }

    @Test
    void testValidarNombreApellidoConNumeros() {
        Cliente cliente = new Cliente(126, "Ju4n", "Ca1za", "juan@uce.edu.ec");
        boolean[] validaciones = cliente.validarNombreApellido();
        assertFalse(validaciones[0]);
        assertFalse(validaciones[1]);
    }
}
