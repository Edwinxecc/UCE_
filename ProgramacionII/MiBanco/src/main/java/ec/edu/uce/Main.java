package ec.edu.uce;

import ec.edu.uce.dominio.*;

public class Main {

    public static void main(String[] args) {
        // Creación del banco
        Banco banco = new Banco();
        System.out.println("Banco creado: " + banco);

        // Ejemplo de asignación de género basado en un valor de entrada
        String gen = "F";
        switch (gen) {
            case "F": {
                banco.nuevoCliente(new Cliente(1, "Maria", "Gomez", Genero.FEMENINO));
                break;
            }
            case "M": {
                banco.nuevoCliente(new Cliente(1, "Alexander", "Arnold", Genero.MASCULINO));
                break;
            }
            default: {
                System.out.println("Género no reconocido, usando valor por defecto");
                banco.nuevoCliente(new Cliente(1, "Alex", "Morgan", Genero.FEMENINO));
            }
        }
        banco.agregarEmpleado(new Empleado());
        banco.agregarEmpleado(new Manager());
        banco.agregarEmpleado(new Director());

        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.println("=== Reporte de Clientes Inicial ===");
        System.out.println(banco.consultarClientes());

        // Editar un cliente existente
        Cliente clienteEditado = new Cliente(200, "Erick", "Pedri", Genero.MASCULINO);
        banco.editarCliente(0, clienteEditado);
        System.out.println("----------------------------------------------------------------------------------------------------------------");

        System.out.println("=== Cliente Editado ===");
        System.out.println(banco.buscarCliente(0));
        System.out.println("----------------------------------------------------------------------------------------------------------------");

        // Mostrar un cliente específico (verificar que existe)
        if (banco.getNumClientes() > 1) {
            System.out.println("=== Cliente en posicion 1 ===");
            System.out.println(banco.buscarCliente(1));
        } else {
            System.out.println("=== No hay cliente en posicion 1 ===");
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------");

        // Consultar todos los clientes
        System.out.println("=== Listado de Todos los Clientes ===");
        System.out.println(banco.consultarClientes());

        // Consultar clientes por género
        System.out.println("=== Listado de Clientes por Género ===");
        System.out.println(banco.consultarClientesPorGenero(Genero.FEMENINO));
        System.out.println(banco.consultarClientesPorGenero(Genero.MASCULINO));

        // Crear un cliente con fecha de nacimiento
        Fecha fechaNacimiento = new Fecha(15, 4, 1990);
        Cliente clienteConFecha = new Cliente(6, "Ana", "Perez", "ana@example.com",
                "Calle 123", "0998877665", fechaNacimiento, Genero.FEMENINO);

        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.println("=== Cliente con Fecha de Nacimiento ===");
        System.out.println(clienteConFecha);

        // Crear un empleado con firma de constructor correcta
        Fecha fechaContratacion = new Fecha(1, 3, 2022);
        Fecha fechaNacimientoEmpleado = new Fecha(10, 5, 1985);
        Empleado empleado = new Empleado(101, "Carlos", "Rodriguez", "carlos@banco.com",
                "Av. Principal 456", "0912345678", fechaNacimientoEmpleado, Genero.MASCULINO,
                1500.0, "Cajero", fechaContratacion);
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.println("=== Informacion del Empleado ===");
        System.out.println(empleado);

        // Agregar más clientes para poder eliminar
        banco.nuevoCliente(new Cliente(2, "Daniel", "Carvajal", Genero.MASCULINO));
        banco.nuevoCliente(new Cliente(3, "Federico", "Valverde", Genero.MASCULINO));

        // Eliminar un cliente
        banco.eliminarCliente(2);

        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.println("=== Listado despues de eliminar un cliente ===");
        System.out.println(banco.consultarClientes());
        System.out.println("----------------------------------------------------------------------------------------------------------------");

        // Ejecutar pruebas adicionales
        System.out.println("=== Ejecutando pruebas adicionales ===");
        testFecha();
        testEmpleado();
        testGenero();
        testCuentasCliente();
    }

    public static void testFecha() {
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.println("=== Pruebas de la clase Fecha ===");

        // Crear una fecha por defecto
        Fecha fechaDefecto = new Fecha();
        System.out.println("Fecha por defecto: " + fechaDefecto);

        // Crear una fecha con valores específicos
        Fecha fechaEspecifica = new Fecha(15, 7, 2023);
        System.out.println("Fecha especifica: " + fechaEspecifica);

        // Probar validaciones de fecha
        System.out.println("Pruebas de validacion de fecha:");

        // Mes inválido
        Fecha fechaMesInvalido = new Fecha(10, 13, 2023);
        System.out.println("Intento mes 13: " + fechaMesInvalido);

        // Día inválido para febrero en año no bisiesto
        Fecha fechaFebrero = new Fecha(29, 2, 2023);
        System.out.println("29 de febrero 2023 (no bisiesto): " + fechaFebrero);

        // Día válido para febrero en año bisiesto
        Fecha fechaBisiesto = new Fecha(29, 2, 2024);
        System.out.println("29 de febrero 2024 (bisiesto): " + fechaBisiesto);

        // Día inválido para abril
        Fecha fechaAbril = new Fecha(31, 4, 2023);
        System.out.println("31 de abril: " + fechaAbril);

        // Constructor de copia
        Fecha fechaOriginal = new Fecha(25, 12, 2023);
        Fecha fechaCopia = new Fecha(fechaOriginal);
        System.out.println("Original: " + fechaOriginal + ", Copia: " + fechaCopia);
    }

    /**
     * Prueba la funcionalidad de la clase Empleado.
     * Este método puede ser invocado desde el main para demostrar las características de Empleado.
     */
    public static void testEmpleado() {
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.println("=== Pruebas de la clase Empleado ===");

        // Crear un empleado por defecto
        Empleado empleadoDefecto = new Empleado();
        System.out.println("Empleado por defecto: " + empleadoDefecto);

        // Crear un empleado con todos los datos
        Fecha fechaNacimientoEmpleado = new Fecha(15, 5, 1990);
        Fecha fechaContratacion = new Fecha(1, 6, 2022);

        // Usando el constructor correcto según la clase Empleado actualizada
        Empleado empleadoCompleto = new Empleado(
                501, "Luis", "Mendez", "luis@banco.com",
                "Av. Central 123", "0912345678", fechaNacimientoEmpleado, Genero.MASCULINO,
                1800.0, "Gerente", fechaContratacion
        );
        System.out.println("Empleado completo: " + empleadoCompleto);

        // Probar cálculo de bono anual
        System.out.println("Bono anual: $" + String.format("%.2f", empleadoCompleto.calcularBonoAnual()));

        // Probar setters con validaciones
        System.out.println("Pruebas de validacion de empleado: ");

        // Salario negativo
        empleadoCompleto.setSalario(-500);
        System.out.println("Despues de intentar salario negativo: $" + empleadoCompleto.getSalario());

        // Puesto vacío
        empleadoCompleto.setPuesto("");
        System.out.println("Despues de intentar puesto vacio: " + empleadoCompleto.getPuesto());

        // Puesto válido
        empleadoCompleto.setPuesto("Director");
        System.out.println("Despues de cambiar a puesto valido: " + empleadoCompleto.getPuesto());
    }

    public static void testGenero() {
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.println("=== Pruebas de la enumeración Genero ===");

        // Mostrar todos los valores del enum Genero
        System.out.println("Valores disponibles del enum Genero:");
        for (Genero g : Genero.values()) {
            System.out.println("- " + g + " (Abreviatura: " + g.getAbrev() +
                    ", Nombre: " + g.getNombre() + ")");
        }

        // Acceder a valores específicos
        Genero generoF = Genero.FEMENINO;
        Genero generoM = Genero.MASCULINO;

        System.out.println("\nPruebas con valores específicos:");
        System.out.println("FEMENINO - Abrev: " + generoF.getAbrev() + ", Nombre: " + generoF.getNombre());
        System.out.println("MASCULINO - Abrev: " + generoM.getAbrev() + ", Nombre: " + generoM.getNombre());

        // Demostrar uso del toString()
        System.out.println("\nPrueba de toString():");
        System.out.println("generoF.toString(): " + generoF.toString());
        System.out.println("generoM.toString(): " + generoM.toString());

        // Demostrar uso de enumeración en otras clases
        Cliente clienteF = new Cliente(999, "Ejemplo", "Femenino", Genero.FEMENINO);
        Cliente clienteM = new Cliente(998, "Ejemplo", "Masculino", Genero.MASCULINO);

        System.out.println("\nClientes con género:");
        System.out.println("Cliente femenino: " + clienteF.getNombre() + " " + clienteF.getApellido() +
                " - Género: " + clienteF.getGenero());
        System.out.println("Cliente masculino: " + clienteM.getNombre() + " " + clienteM.getApellido() +
                " - Género: " + clienteM.getGenero());

        // Demostrar uso en estructura switch
        System.out.println("\nPrueba de uso en switch con clientes:");
        Cliente[] clientes = {clienteF, clienteM};

        for (Cliente c : clientes) {
            System.out.print("Cliente " + c.getNombre() + " " + c.getApellido() + ": ");

            if (c.getGenero() != null) {
                switch (c.getGenero()) {
                    case FEMENINO:
                        System.out.println("Debe usar el baño de mujeres");
                        break;
                    case MASCULINO:
                        System.out.println("Debe usar el baño de hombres");
                        break;
                    default:
                        System.out.println("No tiene género asignado");
                }
            } else {
                System.out.println("No tiene género asignado");
            }
        }
    }

    public static void testCuentasCliente() {
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.println("=== Pruebas de Cuentas de Cliente ===");

        // Crear un cliente para probar las cuentas
        Cliente cliente = new Cliente(1001, "Juan", "Pérez", Genero.MASCULINO);
        System.out.println("Cliente creado: " + cliente);

        // Crear cuentas
        System.out.println("\n1. Creando cuentas:");
        cliente.nuevoCuenta(1000.0);
        cliente.nuevoCuenta(5000.0);
        cliente.nuevoCuenta(2500.0);

        // Consultar cuentas
        System.out.println("\n2. Consultando todas las cuentas:");
        System.out.println(cliente.consultarCuentas());

        // Buscar cuenta específica
        System.out.println("3. Buscando cuenta en posición 1:");
        Cuenta cuentaEncontrada = cliente.buscarCuenta(1);
        if (cuentaEncontrada != null) {
            System.out.println("Cuenta encontrada: " + cuentaEncontrada);
        }

        // Editar cuenta
        System.out.println("\n4. Editando saldo de la cuenta en posición 0:");
        System.out.println("Balance anterior: $" + cliente.buscarCuenta(0).getBalance());
        cliente.editarCuenta(0, 1500.0);
        System.out.println("Nuevo balance: $" + cliente.buscarCuenta(0).getBalance());

        // Realizar operaciones
        System.out.println("\n5. Realizando operaciones bancarias:");
        Cuenta cuenta = cliente.buscarCuenta(0);
        if (cuenta != null) {
            System.out.println("Balance inicial: $" + cuenta.getBalance());
            cuenta.deposit(500.0);
            System.out.println("Después del depósito: $" + cuenta.getBalance());
            cuenta.withdraw(300.0);
            System.out.println("Después del retiro: $" + cuenta.getBalance());
        }

        // Eliminar cuenta
        System.out.println("\n6. Eliminando cuenta en posición 1:");
        cliente.eliminarCuenta(1);
        System.out.println("Cuentas después de eliminar:");
        System.out.println(cliente.consultarCuentas());
    }
}