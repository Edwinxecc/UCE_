package ec.edu.uce.dominio;
/**
 * Clase que representa una cuenta bancaria.
 * Contiene información del saldo y operaciones básicas.
 */
public class Cuenta {
    private double balance;

    /**
     * Constructor sin argumentos que inicializa con valores por defecto.
     */
    public Cuenta() {
        this.balance = 0;
    }

    /**
     * Constructor con argumentos para inicializar la cuenta.
     */
    public Cuenta(double initBalance) {
        this.balance = initBalance;
    }

    public void setBalance(double monto) {
        if (monto > 0) {
            this.balance = monto;
        }
    }

    public double getBalance() {
        return balance;
    }

    public void deposito(double monto){
        if (monto > 0){
            this.balance += monto;
        }
    }

    public void retiro(double monto){
        double temp = 0;
        if (monto <= this.balance && monto > 0){
            temp = this.balance - monto;
            setBalance(temp);
        }
    }

    @Override
    public String toString() {
        return "Balance: " + getBalance();
    }
}