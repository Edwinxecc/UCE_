package ec.edu.uce.dominio;
/**
 * Clase que representa una cuenta bancaria.
 * Contiene información del saldo y operaciones básicas.
 */
public class Cuenta {
    private int numeroCuenta;
    private double saldo;
    private String tipoCuenta;
    private boolean activa;

    /**
     * Constructor sin argumentos que inicializa con valores por defecto.
     */
    public Cuenta() {
        this.numeroCuenta = 0;
        this.saldo = 0.0;
        this.tipoCuenta = "Ahorros";
        this.activa = true;
    }

    /**
     * Constructor con argumentos para inicializar la cuenta.
     */
    public Cuenta(int numeroCuenta, double saldo, String tipoCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo >= 0 ? saldo : 0.0;
        this.tipoCuenta = tipoCuenta;
        this.activa = true;
    }

    /**
     * Constructor con saldo únicamente.
     */
    public Cuenta(double saldo) {
        this.numeroCuenta = (int)(Math.random() * 100000);
        this.saldo = saldo >= 0 ? saldo : 0.0;
        this.tipoCuenta = "Ahorros";
        this.activa = true;
    }

    // Getters y setters
    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if (saldo >= 0) {
            this.saldo = saldo;
        } else {
            System.out.println("El saldo no puede ser negativo");
        }
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    /**
     * Método para realizar un depósito en la cuenta.
     * @param monto Cantidad a depositar
     */
    public void deposito(double monto) {
        if (monto > 0 && activa) {
            this.saldo += monto;
            System.out.println("Depósito exitoso. Nuevo saldo: $" + this.saldo);
        } else if (!activa) {
            System.out.println("No se puede depositar en una cuenta inactiva");
        } else {
            System.out.println("El monto del depósito debe ser positivo");
        }
    }

    /**
     * Método para realizar un retiro de la cuenta.
     * @param monto Cantidad a retirar
     */
    public void retiro(double monto) {
        if (monto > 0 && activa) {
            if (this.saldo >= monto) {
                this.saldo -= monto;
                System.out.println("Retiro exitoso. Nuevo saldo: $" + this.saldo);
            } else {
                System.out.println("Saldo insuficiente para realizar el retiro");
            }
        } else if (!activa) {
            System.out.println("No se puede retirar de una cuenta inactiva");
        } else {
            System.out.println("El monto del retiro debe ser positivo");
        }
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "numeroCuenta=" + numeroCuenta +
                ", saldo=$" + saldo +
                ", tipoCuenta='" + tipoCuenta + '\'' +
                ", activa=" + (activa ? "Sí" : "No") +
                '}';
    }
}