/**
 * @author Edwin Caiza
 */
package ec.edu.uce.dominio;
/**
 * Representa una cuenta corriente bancaria que permite sobregiro,
 * pero dicho sobregiro es fijo y no puede modificarse después de la creación.
 */
public class CuentaCorriente extends Cuenta {
    private final double sobregiro;

    /**
     * Constructor por defecto: saldo 0, sobregiro 0.
     */
    public CuentaCorriente() {
        super();
        this.sobregiro = 0;
    }

    /**
     * Constructor con saldo inicial y sobregiro.
     * @param saldo Saldo inicial
     * @param sobregiro Límite de sobregiro permitido
     */
    public CuentaCorriente(double saldo, double sobregiro) {
        super(saldo);
        this.sobregiro = Math.max(0, sobregiro);
    }

    /**
     * Constructor con solo sobregiro. El saldo es 0.
     * @param sobregiro Límite de sobregiro
     */
    public CuentaCorriente(double sobregiro) {
        this(0, sobregiro);
    }

    public double getSobregiro() {
        return sobregiro;
    }

    /**
     * Realiza un depósito si el monto es mayor a 1.
     * @param monto Monto a depositar
     */
    @Override
    public void deposito(double monto) {
        if (monto > 1) {
            setSaldo(getSaldo() + monto);
        }
    }

    /**
     * Retira un monto si no supera el saldo + sobregiro.
     * No modifica el sobregiro, ya que es constante.
     * @param monto Monto a retirar
     */
    @Override
    public void retiro(double monto) {
        if (monto > 0 && monto <= (getSaldo() + sobregiro)) {
            setSaldo(getSaldo() - monto);
        }
    }

    /**
     * La cuenta corriente no genera intereses.
     * @return Siempre retorna 0.
     */
    @Override
    public double calculoInteres() {
        return 0;
    }

    /**
     * Devuelve la descripción del tipo de cuenta.
     * @return "corriente: "
     */
    public String descripcion() {
        return "corriente: ";
    }

    /**
     * Representación en cadena de la cuenta corriente.
     * Incluye el saldo base y el sobregiro permitido.
     * @return Cadena con detalles de la cuenta
     */
    @Override
    public String toString() {
        return super.toString() + " sobregiro: " + String.format("%.2f", sobregiro);
    }

    /**
     * Compara esta cuenta con otra por igualdad de saldo y sobregiro.
     * @param obj Objeto a comparar
     * @return true si saldo y sobregiro son iguales
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CuentaCorriente)) return false;
        CuentaCorriente otra = (CuentaCorriente) obj;
        return this.getSaldo() == otra.getSaldo() && this.sobregiro == otra.sobregiro;
    }
}