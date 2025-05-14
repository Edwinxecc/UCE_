package ec.edu.uce.dominio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoTest {

    @Test
    void getIdEmpleado() {
        Empleado empleado = new Empleado(213, "Rafael", "Luciano", 87);
        assertEquals(213, empleado.getIdEmpleado());
    }

    @Test
    void setIdEmpleado() {
        Empleado empleado = new Empleado(1, "Ana", "Perez", 40);
        empleado.setIdEmpleado(999);
        assertEquals(999, empleado.getIdEmpleado());
    }

    @Test
    void getNombre() {
        Empleado empleado = new Empleado(2, "Lucia", "Torres", 35);
        assertEquals("Lucia", empleado.getNombre());
    }

    @Test
    void setNombre() {
        Empleado empleado = new Empleado(3, "Pedro", "Rojas", 50);
        empleado.setNombre("Mario");
        assertEquals("Mario", empleado.getNombre());
    }

    @Test
    void getApellido() {
        Empleado empleado = new Empleado(4, "Luis", "Mora", 60);
        assertEquals("Mora", empleado.getApellido());
    }

    @Test
    void setApellido() {
        Empleado empleado = new Empleado(5, "Sara", "Garcia", 25);
        empleado.setApellido("López");
        assertEquals("López", empleado.getApellido());
    }

    @Test
    void getSalarioMensual() {
        Empleado empleado = new Empleado(6, "Andres", "Vega", 100);
        double esperado = 100 * 3.88;
        assertEquals(esperado, empleado.getSalarioMensual(), 0.01);
    }

    @Test
    void calcularSalarioMensual() {
        Empleado empleado = new Empleado(7, "Erika", "Ramirez", 0);
        double resultado = empleado.calcularSalarioMensual(120);
        assertEquals(120 * 3.88, resultado, 0.01);
    }

    @Test
    void validarNombreApellidoValidos() {
        Empleado empleado = new Empleado(8, "Carlos", "Suarez", 40);
        boolean[] validaciones = empleado.validarNombreApellido();
        assertTrue(validaciones[0]);
        assertTrue(validaciones[1]);
    }

    @Test
    void validarNombreApellidoConNumeros() {
        Empleado empleado = new Empleado(9, "J0se", "Perez1", 40);
        boolean[] validaciones = empleado.validarNombreApellido();
        assertFalse(validaciones[0]); // Nombre inválido
        assertFalse(validaciones[1]); // Apellido inválido
    }
}
