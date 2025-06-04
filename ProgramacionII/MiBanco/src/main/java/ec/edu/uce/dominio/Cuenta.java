package ec.edu.uce.dominio;

public abstract class Cuenta {

    protected double balance;

    private static int contadorCuentas = 1000;

    private int numeroCuenta;

    // Constructor por defecto
    public Cuenta() {
        this.numeroCuenta = ++contadorCuentas;
        this.balance = 0.0;
    }

    // Constructor con balance inicial
    public Cuenta(double inicioBalance) {
        this.numeroCuenta = ++contadorCuentas;
        setBalance(inicioBalance);
    }

    public double getBalance() {
        return balance;
    }

    void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Error: El balance no puede ser negativo");
            this.balance = 0.0;
        }
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void deposit(double amt) {
        if (amt > 0) {
            this.balance += amt;
            System.out.println("Depósito exitoso. Monto: $" + amt);
        } else {
            System.out.println("Error: El monto a depositar debe ser mayor a cero");
        }
    }

    public void withdraw(double amt) {
        if (amt > 0) {
            if (this.balance >= amt) {
                this.balance -= amt;
                System.out.println("Retiro exitoso. Monto: $" + amt);
            } else {
                System.out.println("Error: Saldo insuficiente. Saldo actual: $" + this.balance);
            }
        } else {
            System.out.println("Error: El monto a retirar debe ser mayor a cero");
        }
    }

    // Métodos abstractos según el diagrama
    public abstract boolean deposito(double monto);
    public abstract boolean retiro(double monto);
    public abstract double calculoInteres();

    @Override
    public String toString() {
        return "Cuenta [Número: " + numeroCuenta +
                ", Balance: $" + String.format("%.2f", balance) + "]";
    }
}