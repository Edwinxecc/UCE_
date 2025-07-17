package ec.edu.uce.dominio;

/**
 * Representa una cuenta de ahorro con una tasa de interés fija del 5%.
 */
public class CuentaAhorro extends Cuenta {

    /**
     * Tasa de interés fija para todas las cuentas de ahorro (5%).
     */
    private static final double TASA_INTERES = 0.05;

    /**
     * Constructor por defecto. Crea una cuenta con saldo 0.
     */
    public CuentaAhorro() {
        super();
    }

    /**
     * Constructor con saldo inicial.
     * @param saldo Saldo inicial de la cuenta
     */
    public CuentaAhorro(double saldo) {
        super(saldo);
    }

    /**
     * Obtiene la tasa de interés.
     * @return Tasa de interés fija (5%)
     */
    public double getInteres() {
        return TASA_INTERES;
    }

    /**
     * Realiza un depósito si el monto es mayor o igual a 1.
     * @param monto Monto a depositar
     */
    @Override
    public void deposito(double monto) {
        if (monto >= 1) {
            setSaldo(getSaldo() + monto);
        }
    }

    /**
     * Realiza un retiro si hay saldo suficiente.
     * @param monto Monto a retirar
     */
    @Override
    public void retiro(double monto) {
        if (monto > 0 && monto <= getSaldo()) {
            setSaldo(getSaldo() - monto);
        }
    }

    /**
     * Calcula y aplica el interés al saldo actual.
     * @return Monto del interés generado
     */
    @Override
    public double calculoInteres() {
        double interesGenerado = getSaldo() * TASA_INTERES;
        setSaldo(getSaldo() + interesGenerado);
        return interesGenerado;
    }

    /**
     * Representación en cadena de la cuenta de ahorro, incluyendo el saldo base
     * y el interés calculado dinámicamente.
     * @return Cadena con información detallada
     */
    @Override
    public String toString() {
        return super.toString() + " interés generado: " + String.format("%.2f", calculoInteres());
    }

    /**
     * Compara si dos cuentas de ahorro tienen el mismo saldo.
     * @param obj Objeto a comparar
     * @return true si son del mismo tipo y saldo
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CuentaAhorro)) return false;
        CuentaAhorro otra = (CuentaAhorro) obj;
        return this.getSaldo() == otra.getSaldo();
    }

    @Override
    public String descripcion() {
        return "Cuenta Corriente";
    }
}
