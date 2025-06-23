package ec.edu.uce.dominio;

/**
 * Clase **CuentaAhorro**, extiende la clase abstracta `Cuenta`.
 * Proporciona implementaciones específicas para operaciones de depósito, retiro y cálculo de intereses.
 */
public class CuentaAhorro extends Cuenta {

    // Tasa de interés constante aplicada a todas las cuentas de ahorro.
    private static final double TASA_INTERES = 0.05;

    // Constructor predeterminado que llama al constructor de la superclase.
    public CuentaAhorro() {
        super();
    }

    // Constructor que inicializa la cuenta de ahorro con un balance dado.
    public CuentaAhorro(double balanceInicial) {
        super(balanceInicial);
    }

    // Constructor adicional para cumplir con un requisito de tener tres constructores.
    public CuentaAhorro(double balanceInicial, int dummyTasa) {
        super(balanceInicial);
    }

    // Devuelve la tasa de interés fija de la cuenta de ahorro.
    public double getTasaInteres() {
        return TASA_INTERES;
    }

    // Implementa el método de depósito para la cuenta de ahorro.
    @Override
    public boolean deposito(double monto) {
        if (monto > 0) {
            this.balance += monto;
            return true;
        } else {
            System.out.println("Error: El monto a depositar debe ser un valor positivo.");
            return false;
        }
    }

    // Implementa el método de retiro para la cuenta de ahorro.
    @Override
    public boolean retiro(double monto) {
        if (monto > 0 && this.balance >= monto) {
            this.balance -= monto;
            return true;
        } else {
            System.out.println("Error: El monto de retiro es inválido o no hay fondos suficientes.");
            return false;
        }
    }

    // Calcula y añade los intereses al balance actual de la cuenta.
    @Override
    public double calculoInteres() {
        double interesCalculado = this.balance * TASA_INTERES;
        this.balance += interesCalculado;
        return interesCalculado;
    }

    // Ofrece una breve descripción del tipo de cuenta.
    @Override
    public String descripcion() {
        return "Cuenta de Ahorro";
    }

    @Override
    public String toString() {
        return descripcion() + " [Balance=" + String.format("%.2f", this.balance) +
                ", Tasa Interés Fija=" + String.format("%.2f", (TASA_INTERES * 100)) + "%]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        CuentaAhorro that = (CuentaAhorro) obj;

        if (Double.compare(this.balance, that.balance) != 0) return false;
        if (Double.compare(TASA_INTERES, CuentaAhorro.TASA_INTERES) != 0) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(balance, TASA_INTERES);
    }
}