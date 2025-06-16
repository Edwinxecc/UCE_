/**
 * @author Edwin Caiza
 */

package ec.edu.uce.dominio;

/**
 * Clase abstracta que representa una cuenta bancaria básica con saldo.
 * Define métodos abstractos para depósito, retiro, cálculo de intereses,
 * y descripción, que deben ser implementados por las subclases específicas.
 */
public abstract class Cuenta {

    protected double saldo;

    /**
     * Constructor por defecto que inicializa el saldo en cero.
     */
    public Cuenta() {
        this.saldo = 0;
    }

    /**
     * Constructor que inicializa la cuenta con un saldo específico.
     *
     * @param saldo saldo inicial de la cuenta
     */
    public Cuenta(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Obtiene el saldo actual de la cuenta.
     *
     * @return saldo actual
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Establece un nuevo saldo en la cuenta.
     *
     * @param saldo nuevo saldo a establecer
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Realiza un depósito en la cuenta.
     *
     * @param monto cantidad a depositar
     */
    public abstract void deposito(double monto);

    /**
     * Realiza un retiro de la cuenta.
     *
     * @param monto cantidad a retirar
     */
    public abstract void retiro(double monto);

    /**
     * Calcula y acumula el interés en la cuenta.
     *
     * @return monto de interés calculado
     */
    public abstract double calculoInteres();

    /**
     * Devuelve una pequeña descripción del tipo de cuenta.
     *
     * @return descripción breve de la cuenta
     */
    public abstract String descripcion();

    /**
     * Representación en cadena del estado de la cuenta.
     *
     * @return cadena con información de la cuenta
     */
    @Override
    public String toString() {
        return descripcion() + " ,saldo: " + this.saldo;
    }

    /**
     * Compara esta cuenta con otro objeto para igualdad.
     *
     * @param obj objeto a comparar
     * @return true si son iguales, false en caso contrario
     */
    @Override
    public abstract boolean equals(Object obj);
}