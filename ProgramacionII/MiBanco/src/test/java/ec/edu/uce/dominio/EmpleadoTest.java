package ec.edu.uce.dominio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmpleadoTest {
    Empleado empleadoObj = new Empleado(123, "Marco", "Alvares2", 96);
    //@org.junit.jupiter.api.Test
    @Test
    void getIdEmpleado() {
        assert empleadoObj.getIdEmpleado() == 123: "Valido";
    }

    //@org.junit.jupiter.api.Test
    void setIdEmpleado() {
    }

    //@org.junit.jupiter.api.Test
    void getNombre() {
    }

    //@org.junit.jupiter.api.Test
    void setNombre() {
    }

    //@org.junit.jupiter.api.Test
    void getApellido() {
    }

    //@org.junit.jupiter.api.Test
    void setApellido() {
    }

    //@org.junit.jupiter.api.Test
    void getSalarioMensual() {
    }

   // @org.junit.jupiter.api.Test
    void calcularSalarioMensual() {
    }

    //@org.junit.jupiter.api.Test
    void validarNombreApellido() {
    }
}