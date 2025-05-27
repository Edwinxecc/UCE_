package ec.edu.uce.dominio;

/**
 * Clase que representa a un cliente en el sistema bancario.
 * Contiene información personal, detalles de registro y hasta 5 cuentas bancarias.
 */
public class Cliente {
    private int clienteId;
    private String nombre;
    private String apellido;
    private String correo;
    private Fecha fechaRegistro;
    private Genero genero;

    // Asociación con hasta 5 cuentas sin usar arrays
    private Cuenta cuenta1;
    private Cuenta cuenta2;
    private Cuenta cuenta3;
    private Cuenta cuenta4;
    private Cuenta cuenta5;
    private int numeroCuentas; // Contador de cuentas activas

    /**
     * Constructor por defecto que inicializa los atributos con valores predeterminados.
     */
    public Cliente() {
        this.clienteId = 1;
        this.nombre = "Sin nombre";
        this.apellido = "Sin apellido";
        this.correo = "Sin correo";
        this.fechaRegistro = new Fecha();
        this.genero = Genero.FEMENINO;
        this.numeroCuentas = 0;
    }

    /**
     * Constructor con parámetros que permite definir los datos principales del cliente.
     */
    public Cliente(int id, String nombre, String apellido, Genero genero) {
        this.clienteId = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = "Sin correo";
        this.fechaRegistro = new Fecha();
        this.genero = genero;
        this.numeroCuentas = 0;
    }

    /**
     * Constructor con parámetros ampliado.
     */
    public Cliente(int id, String nombre, String apellido, Genero genero, String correo, Fecha fechaRegistro) {
        this.clienteId = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.correo = correo;
        this.fechaRegistro = fechaRegistro;
        this.numeroCuentas = 0;
    }

    /**
     * Constructor de copia.
     */
    public Cliente(Cliente nuevoCliente) {
        this.clienteId = nuevoCliente.clienteId;
        this.nombre = nuevoCliente.nombre;
        this.apellido = nuevoCliente.apellido;
        this.correo = nuevoCliente.correo;
        this.fechaRegistro = new Fecha(nuevoCliente.fechaRegistro.getDia(),
                nuevoCliente.fechaRegistro.getMes(),
                nuevoCliente.fechaRegistro.getAnio());
        this.genero = nuevoCliente.genero;
        this.numeroCuentas = nuevoCliente.numeroCuentas;
        // Copiar cuentas si existen
        this.cuenta1 = nuevoCliente.cuenta1;
        this.cuenta2 = nuevoCliente.cuenta2;
        this.cuenta3 = nuevoCliente.cuenta3;
        this.cuenta4 = nuevoCliente.cuenta4;
        this.cuenta5 = nuevoCliente.cuenta5;
    }

    // Getters y setters básicos
    public int getClienteId() { return clienteId; }
    public int getId() { return clienteId; }
    public void setClienteId(int clienteId) {
        if (clienteId >= 0) this.clienteId = clienteId;
        else System.out.println("ID inválido");
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public Fecha getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(Fecha fecha) { this.fechaRegistro = fecha; }

    public Genero getGenero() { return genero; }
    public void setGenero(Genero genero) { this.genero = genero; }

    public int getNumeroCuentas() { return numeroCuentas; }

    // Getters individuales para las cuentas
    public Cuenta getCuenta1() { return cuenta1; }
    public Cuenta getCuenta2() { return cuenta2; }
    public Cuenta getCuenta3() { return cuenta3; }
    public Cuenta getCuenta4() { return cuenta4; }
    public Cuenta getCuenta5() { return cuenta5; }

    // ===============================================
    // MÉTODOS DE GESTIÓN DE CUENTAS
    // ===============================================

    /**
     * Crea una nueva cuenta para el cliente.
     * @param saldo Saldo inicial de la cuenta
     */
    public void nuevaCuenta(double saldo) {
        if (numeroCuentas >= 5) {
            System.out.println("El cliente ya tiene el máximo de 5 cuentas");
            return;
        }

        Cuenta nuevaCuenta = new Cuenta(saldo);

        if (cuenta1 == null) {
            cuenta1 = nuevaCuenta;
        } else if (cuenta2 == null) {
            cuenta2 = nuevaCuenta;
        } else if (cuenta3 == null) {
            cuenta3 = nuevaCuenta;
        } else if (cuenta4 == null) {
            cuenta4 = nuevaCuenta;
        } else if (cuenta5 == null) {
            cuenta5 = nuevaCuenta;
        }

        numeroCuentas++;
        System.out.println("Nueva cuenta creada con número: " + nuevaCuenta.getNumeroCuenta());
    }

    /**
     * Consulta todas las cuentas del cliente.
     */
    public void consultarCuentas() {
        if (numeroCuentas == 0) {
            System.out.println("El cliente no tiene cuentas registradas");
            return;
        }

        System.out.println("Cuentas del cliente " + nombre + " " + apellido + ":");

        if (cuenta1 != null) {
            System.out.println("Posición 0: " + cuenta1);
        }
        if (cuenta2 != null) {
            System.out.println("Posición 1: " + cuenta2);
        }
        if (cuenta3 != null) {
            System.out.println("Posición 2: " + cuenta3);
        }
        if (cuenta4 != null) {
            System.out.println("Posición 3: " + cuenta4);
        }
        if (cuenta5 != null) {
            System.out.println("Posición 4: " + cuenta5);
        }
    }

    /**
     * Edita el saldo de una cuenta en la posición especificada.
     * @param pos Posición de la cuenta (0-4)
     * @param saldo Nuevo saldo para la cuenta
     */
    public void editarCuenta(int pos, double saldo) {
        if (saldo < 0) {
            System.out.println("El saldo no puede ser negativo");
            return;
        }

        switch (pos) {
            case 0:
                if (cuenta1 != null) {
                    cuenta1.setSaldo(saldo);
                    System.out.println("Cuenta editada exitosamente");
                } else {
                    System.out.println("No existe cuenta en la posición 0");
                }
                break;
            case 1:
                if (cuenta2 != null) {
                    cuenta2.setSaldo(saldo);
                    System.out.println("Cuenta editada exitosamente");
                } else {
                    System.out.println("No existe cuenta en la posición 1");
                }
                break;
            case 2:
                if (cuenta3 != null) {
                    cuenta3.setSaldo(saldo);
                    System.out.println("Cuenta editada exitosamente");
                } else {
                    System.out.println("No existe cuenta en la posición 2");
                }
                break;
            case 3:
                if (cuenta4 != null) {
                    cuenta4.setSaldo(saldo);
                    System.out.println("Cuenta editada exitosamente");
                } else {
                    System.out.println("No existe cuenta en la posición 3");
                }
                break;
            case 4:
                if (cuenta5 != null) {
                    cuenta5.setSaldo(saldo);
                    System.out.println("Cuenta editada exitosamente");
                } else {
                    System.out.println("No existe cuenta en la posición 4");
                }
                break;
            default:
                System.out.println("Posición inválida. Use posiciones 0-4");
        }
    }

    /**
     * Elimina una cuenta de la posición especificada.
     * @param pos Posición de la cuenta a eliminar (0-4)
     */
    public void eliminarCuenta(int pos) {
        Cuenta cuentaEliminada = null;

        switch (pos) {
            case 0:
                if (cuenta1 != null) {
                    cuentaEliminada = cuenta1;
                    cuenta1 = null;
                    numeroCuentas--;
                }
                break;
            case 1:
                if (cuenta2 != null) {
                    cuentaEliminada = cuenta2;
                    cuenta2 = null;
                    numeroCuentas--;
                }
                break;
            case 2:
                if (cuenta3 != null) {
                    cuentaEliminada = cuenta3;
                    cuenta3 = null;
                    numeroCuentas--;
                }
                break;
            case 3:
                if (cuenta4 != null) {
                    cuentaEliminada = cuenta4;
                    cuenta4 = null;
                    numeroCuentas--;
                }
                break;
            case 4:
                if (cuenta5 != null) {
                    cuentaEliminada = cuenta5;
                    cuenta5 = null;
                    numeroCuentas--;
                }
                break;
            default:
                System.out.println("Posición inválida. Use posiciones 0-4");
                return;
        }

        if (cuentaEliminada != null) {
            System.out.println("Cuenta eliminada: " + cuentaEliminada.getNumeroCuenta());
        } else {
            System.out.println("No existe cuenta en la posición " + pos);
        }
    }

    /**
     * Busca una cuenta en la posición especificada.
     * @param pos Posición de la cuenta a buscar (0-4)
     * @return La cuenta encontrada o null si no existe
     */
    public Cuenta buscarCuenta(int pos) {
        switch (pos) {
            case 0:
                return cuenta1;
            case 1:
                return cuenta2;
            case 2:
                return cuenta3;
            case 3:
                return cuenta4;
            case 4:
                return cuenta5;
            default:
                System.out.println("Posición inválida. Use posiciones 0-4");
                return null;
        }
    }

    @Override
    public String toString() {
        return "Id: " + clienteId +
                " Nombre: " + nombre +
                " Apellido: " + apellido +
                " Correo: " + correo +
                " Fecha de Registro: " + fechaRegistro +
                " Género: " + genero +
                " Número de cuentas: " + numeroCuentas + "\n";
    }
}

// ===============================================
