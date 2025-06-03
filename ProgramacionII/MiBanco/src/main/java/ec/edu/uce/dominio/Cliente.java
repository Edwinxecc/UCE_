package ec.edu.uce.dominio;

public class Cliente {

    private int clienteId;
    private String nombre;
    private String apellido;
    private String correo;
    private String direccion;
    private String telefono;
    private Fecha fechaNacimiento;
    private Genero genero;
    private Cuenta[] cuentas;

    private int numCuentas;

    private static final int CAPACIDAD_INICIAL_CUENTAS = 10;

    public Cliente() {
        this.clienteId = 1;
        this.nombre = "sin nombre";
        this.apellido = "sin apellido";
        this.genero = Genero.FEMENINO;
        this.cuentas = new Cuenta[CAPACIDAD_INICIAL_CUENTAS];
        this.numCuentas = 0;
    }

    public Cliente(Cliente nuevoCliente) {
        this.clienteId = nuevoCliente.clienteId;
        this.nombre = nuevoCliente.nombre;
        this.apellido = nuevoCliente.apellido;
        this.correo = nuevoCliente.correo;
        this.direccion = nuevoCliente.direccion;
        this.telefono = nuevoCliente.telefono;
        this.fechaNacimiento = nuevoCliente.fechaNacimiento != null ?
                new Fecha(nuevoCliente.fechaNacimiento) : null;
        this.genero = nuevoCliente.genero;

        // Copiar cuentas
        this.cuentas = new Cuenta[nuevoCliente.cuentas.length];
        this.numCuentas = nuevoCliente.numCuentas;
        for (int i = 0; i < numCuentas; i++) {
            this.cuentas[i] = new Cuenta(nuevoCliente.cuentas[i].getBalance()) {
                @Override
                public boolean deposito(double monto) {
                    return false;
                }

                @Override
                public boolean retiro(double monto) {
                    return false;
                }

                @Override
                public double calculoInteres() {
                    return 0;
                }
            };
        }
    }

    public Cliente(int id, String nombre, String apellido, Genero genero) {
        setClienteId(id);
        setNombre(nombre);
        setApellido(apellido);
        setGenero(genero);
        this.cuentas = new Cuenta[CAPACIDAD_INICIAL_CUENTAS];
        this.numCuentas = 0;
    }

    public Cliente(int clienteId, String nombre, String apellido, String correo,
                   String direccion, String telefono, Genero genero) {
        setClienteId(clienteId);
        setNombre(nombre);
        setApellido(apellido);
        setCorreo(correo);
        setDireccion(direccion);
        setTelefono(telefono);
        setGenero(genero);
        this.cuentas = new Cuenta[CAPACIDAD_INICIAL_CUENTAS];
        this.numCuentas = 0;
    }

    public Cliente(int clienteId, String nombre, String apellido, String correo,
                   String direccion, String telefono, Fecha fechaNacimiento, Genero genero) {
        setClienteId(clienteId);
        setNombre(nombre);
        setApellido(apellido);
        setCorreo(correo);
        setDireccion(direccion);
        setTelefono(telefono);
        setFechaNacimiento(fechaNacimiento);
        setGenero(genero);
        this.cuentas = new Cuenta[CAPACIDAD_INICIAL_CUENTAS];
        this.numCuentas = 0;
    }

    public Cliente(int clienteId, String correoElectronico, String numeroTelefono, boolean esContacto) {
        setClienteId(clienteId);
        setCorreo(correoElectronico);
        setTelefono(numeroTelefono);
        this.cuentas = new Cuenta[CAPACIDAD_INICIAL_CUENTAS];
        this.numCuentas = 0;
    }

    // MÉTODOS GET Y SET ORIGINALES

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        if (clienteId >= 0) {
            this.clienteId = clienteId;
        } else {
            System.out.println("Error: codigo invalido " + clienteId);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nuevoNombre) {
        if (nuevoNombre != null && !nuevoNombre.trim().isEmpty()) {
            this.nombre = nuevoNombre;
        } else {
            System.out.println("Error: nombre invalido");
            this.nombre = "sin nombre";
        }
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String nuevoCorreo) {
        if (nuevoCorreo != null && nuevoCorreo.contains("@") && nuevoCorreo.contains(".")) {
            this.correo = nuevoCorreo;
        } else {
            System.out.println("Error: formato de correo invalido");
        }
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String nuevoApellido) {
        if (nuevoApellido != null && !nuevoApellido.trim().isEmpty()) {
            this.apellido = nuevoApellido;
        } else {
            System.out.println(" Error: apellido invalido");
            this.apellido = " sin apellido ";
        }
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String nuevaDireccion) {
        this.direccion = nuevaDireccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String nuevoTelefono) {
        if (nuevoTelefono != null && nuevoTelefono.matches("\\d{10}")) {
            this.telefono = nuevoTelefono;
        } else {
            System.out.println("Error: formato de telefono invalido (debe tener 10 digitos)");
        }
    }

    public Fecha getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Fecha fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        if (genero != null) {
            this.genero = genero;
        } else {
            System.out.println("Error: genero invalido");
        }
    }

    // MÉTODOS PARA MANEJO DE CUENTAS

    public int getNumCuentas() {
        return numCuentas;
    }

    public void nuevoCuenta(double saldo) {
        if (numCuentas == cuentas.length) {
            Cuenta[] cuentasAux = cuentas;
            cuentas = new Cuenta[numCuentas + 10];
            System.arraycopy(cuentasAux, 0, cuentas, 0, numCuentas);
        }

        // Crear nueva cuenta
        Cuenta nuevaCuenta = new Cuenta(saldo) {
            @Override
            public boolean deposito(double monto) {
                return false;
            }

            @Override
            public boolean retiro(double monto) {
                return false;
            }

            @Override
            public double calculoInteres() {
                return 0;
            }
        };
        cuentas[numCuentas] = nuevaCuenta;
        numCuentas++;
        System.out.println("Cuenta creada exitosamente: " + nuevaCuenta);
    }

    public String consultarCuentas() {
        if (numCuentas == 0) {
            return "El cliente no tiene cuentas registradas";
        }

        StringBuilder sb = new StringBuilder("Cuentas del cliente " + nombre + " " + apellido + ":\n");
        for (int i = 0; i < numCuentas; i++) {
            sb.append("[").append(i).append("] ").append(cuentas[i]).append("\n");
        }
        return sb.toString();
    }

    public void editarCuenta(int pos, double saldo) {
        if (pos >= 0 && pos < numCuentas) {
            // Como setBalance es private en Cuenta, usamos deposit/withdraw para ajustar
            double balanceActual = cuentas[pos].getBalance();
            if (saldo >= balanceActual) {
                cuentas[pos].deposit(saldo - balanceActual);
            } else {
                cuentas[pos].withdraw(balanceActual - saldo);
            }
            System.out.println("Cuenta editada exitosamente");
        } else {
            System.out.println("Error: Posición de cuenta inválida");
        }
    }
    public void eliminarCuenta(int pos) {
        if (pos >= 0 && pos < numCuentas) {
            // Desplazar elementos para eliminar la cuenta
            for (int i = pos; i < numCuentas - 1; i++) {
                cuentas[i] = cuentas[i + 1];
            }
            cuentas[numCuentas - 1] = null;
            numCuentas--;
            System.out.println("Cuenta eliminada exitosamente");
        } else {
            System.out.println("Error: Posición de cuenta inválida");
        }
    }
    public Cuenta buscarCuenta(int pos) {
        if (pos >= 0 && pos < numCuentas) {
            return cuentas[pos];
        } else {
            System.out.println("Error: Posición de cuenta inválida");
            return null;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente [ID = ").append(clienteId)
                .append(", Nombre = ").append(nombre)
                .append(", Apellido = ").append(apellido);

        if (genero != null) {
            sb.append(", Género = ").append(genero);
        }

        if (correo != null && !correo.isEmpty()) {
            sb.append(", Correo = ").append(correo);
        }

        if (direccion != null && !direccion.isEmpty()) {
            sb.append(", Dirección = ").append(direccion);
        }

        if (telefono != null && !telefono.isEmpty()) {
            sb.append(", Telefono = ").append(telefono);
        }

        if (fechaNacimiento != null) {
            sb.append(", Fecha Nacimiento = ").append(fechaNacimiento);
        }

        sb.append(", Cuentas = ").append(numCuentas);
        sb.append("]");
        return sb.toString();
    }
}