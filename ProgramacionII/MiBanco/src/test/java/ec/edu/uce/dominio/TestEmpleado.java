package ec.edu.uce.dominio;

import java.util.Arrays;

/**
 * Clase de prueba integral para verificar el comportamiento y la interacción de
 * las clases `Empleado`, `Manager` y `Director`.
 */
public class TestEmpleado {

    /**
     * Método principal que ejecuta una serie de pruebas básicas para
     * los diferentes tipos de empleados.
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        System.out.println("=============== Iniciando pruebas de Empleados, Managers y Directores ===============");

        // Reinicia el contador de IDs de `Empleado` para asegurar la consistencia en las pruebas.
        Empleado.contador = 0;
        System.out.println("\nContador de IDs de Empleado reseteado para la prueba.");

        // 1. Creación y verificación de un empleado básico.
        Empleado miEmpleado = new Empleado("Carlos", "Mendoza", "carlos.m@mail.com", "Av. Los Andes",
                new String[]{"17001", "0998765432"}, null, Genero.MASCULINO, 1600.0, "Asistente", new Fecha(12, 2, 2022));

        System.out.println("\nInformación del empleado básico: " + miEmpleado);
        System.out.println("Teléfonos del empleado: " + Arrays.toString(miEmpleado.getTelefonos()));

        assert miEmpleado.getNombre().equals("Carlos") : "¡Fallo: El nombre del empleado básico no coincide con lo esperado!";
        assert miEmpleado.getTelefonos() != null && miEmpleado.getTelefonos().length > 0 && miEmpleado.getTelefonos()[0].equals("17001") : "¡Fallo: El primer teléfono del empleado básico no es el esperado!";

        // 2. Creación y verificación de un `Manager`.
        Manager miManager = new Manager("Elena", "Vargas", "elena.v@mail.com", "Calle 10",
                new String[]{"0981234567"}, null, Genero.FEMENINO, 2100.0, "Jefa de Ventas", new Fecha(5, 5, 2021), "Ventas");
        System.out.println("\nInformación del Manager (antes de la prueba de incremento): " + miManager);
        assert miManager.getSalario() == 2100.0 : "¡Fallo: El salario base del manager no es el esperado!";
        assert miManager.getDeptNombre().equals("Ventas") : "¡Fallo: El departamento del manager no coincide con lo esperado!";

        // 3. Demostración del incremento de salario en el Manager.
        System.out.println("\n=============== Probando incremento salarial del Manager ===============");
        double incremento = 1200.00;
        miManager.setSalario(miManager.getSalario() + incremento);
        System.out.println("  Se ha simulado un incremento salarial.");
        System.out.println("  Manager (después del incremento): " + miManager);
        assert miManager.getSalario() == (2100.0 + incremento) : "¡Fallo: El salario del manager no se incrementó como se esperaba!";

        // 4. Demostración de Polimorfismo y Downcasting.
        System.out.println("\n=============== Demostrando Polimorfismo y Downcasting ===============");
        Manager managerPoly1 = new Manager("Luis", "Fernandez", "luis.f@mail.com", "Dir 1",
                new String[]{}, null, Genero.MASCULINO, 2300.0, "Jefe de Produccion", new Fecha(1, 2, 2023), "Produccion");
        // Asignación polimórfica: un Manager es también un Empleado.
        Empleado empleadoComoManager1 = managerPoly1;

        Manager managerPoly2 = new Manager("Ana", "Lopez", "ana.l@mail.com", "Dir 2",
                new String[]{}, null, Genero.FEMENINO, 2400.0, "RRHH Lead", new Fecha(1, 3, 2023), "Recursos Humanos");
        // Otra asignación polimórfica.
        Empleado empleadoComoManager2 = managerPoly2;

        // Downcasting seguro con `instanceof`.
        if (empleadoComoManager1 instanceof Manager) {
            Manager managerCasteado = (Manager) empleadoComoManager1;
            System.out.println("Departamento del manager casteado (empleadoComoManager1): " + managerCasteado.getDeptNombre());
            assert managerCasteado.getDeptNombre().equals("Produccion") : "¡Fallo: El departamento del manager casteado no es el esperado!";
        }

        // Downcasting directo (asumiendo conocimiento del tipo).
        System.out.println("Acceso directo al departamento (mediante downcasting para empleadoComoManager2): " +
                ((Manager) empleadoComoManager2).getDeptNombre());
        assert ((Manager) empleadoComoManager2).getDeptNombre().equals("Recursos Humanos") : "¡Fallo: El departamento del segundo manager casteado no es el esperado!";

        // Prueba de polimorfismo y downcasting con la clase `Director`.
        System.out.println("\n=============== Probando con un Director ===============");
        Director directorTest = new Director("Jorge", "Ramirez", "jorge.r@mail.com", "Dir 3",
                new String[]{}, null, Genero.MASCULINO, 4200.0, "CEO", new Fecha(1, 1, 2020), "General", 120000.0, 60000.0);
        // Asignación polimórfica: un Director es también un Empleado.
        Empleado empleadoComoDirector = directorTest;

        if (empleadoComoDirector instanceof Director) {
            Director directorCasteado = (Director) empleadoComoDirector;
            System.out.println("Director: " + directorCasteado.getNombre() + ", Departamento: " + directorCasteado.getDeptNombre() + ", Comisión: " + String.format("%.2f", directorCasteado.getComision()) + ", Presupuesto: " + String.format("%.2f", directorCasteado.getPresupuesto()));
            assert directorCasteado.getComision() == 60000.0 : "¡Fallo: La comisión del director no es la esperada!";
            assert directorCasteado.getPresupuesto() == 120000.0 : "¡Fallo: El presupuesto del director no es el esperado!";
        }

        // 5. Pruebas del método `equals()` de `Empleado`.
        System.out.println("\n=============== Pruebas del Método equals() de Empleado ===============");

        Empleado empleadoParaComparar1 = new Empleado("Lionel", "Messi", "l.m@mail.com", "Dir 4",
                new String[]{}, null, Genero.MASCULINO, 1500.0, "Futbolista", new Fecha(1, 1, 2000));
        Empleado empleadoParaComparar2 = new Empleado("Lionel", "Messi", "l.m@mail.com", "Dir 4",
                new String[]{}, null, Genero.MASCULINO, 1500.0, "Futbolista", new Fecha(1, 1, 2000));

        System.out.println("Empleado 1: " + empleadoParaComparar1);
        System.out.println("Empleado 2: " + empleadoParaComparar2);

        // En la implementación actual de `equals()` en `Empleado`, la comparación es por ID.
        // Dado que se crean con un constructor que autogenera ID, tendrán IDs diferentes.
        if (empleadoParaComparar1.equals(empleadoParaComparar2)){
            System.out.println("Empleados son iguales (esto indica que equals NO usa el ID autogenerado, lo cual es inesperado).");
            assert false : "¡Fallo: Empleados con IDs diferentes no deberían ser iguales si equals compara por ID!";
        } else {
            System.out.println("Empleados son distintos (este es el comportamiento esperado si equals compara por ID).");
            assert true : "¡Éxito: Empleados con IDs diferentes son correctamente identificados como distintos!";
        }

        // 6. Caso donde los empleados son claramente distintos.
        Empleado empleadoParaComparar3 = new Empleado("Andreina", "Galu", "a.g@mail.com", "Dir 5",
                new String[]{}, null, Genero.FEMENINO, 1800.0, "Cantante", new Fecha(1, 1, 1990));

        System.out.println("\nEmpleado 1: " + empleadoParaComparar1);
        System.out.println("Empleado 3: " + empleadoParaComparar3);

        if (!empleadoParaComparar1.equals(empleadoParaComparar3)){
            System.out.println("\nEmpleados (Lionel y Andreina) son distintos (comportamiento esperado).");
            assert true : "¡Éxito: Los empleados son correctamente identificados como distintos!";
        } else {
            System.out.println("\n¡Error en equals()! Los empleados (Lionel y Andreina) deberían ser distintos, pero se consideran iguales.");
            assert false : "¡Fallo: Los empleados (Lionel y Andreina) deberían ser distintos!";
        }

        System.out.println("\n=============== Todas las pruebas de Empleado han finalizado ===============");
    }
}