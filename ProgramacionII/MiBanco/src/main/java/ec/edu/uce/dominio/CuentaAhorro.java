package ec.edu.uce.dominio;

public class CuentaAhorro extends Cuenta {

    private static final double TASA_INTERES = 0.05; // 5% anual
    private double montoInteres;

    // Constructor por defecto usando super()
    public CuentaAhorro() {
        super();
        this.montoInteres = 0.0;
    }

    // Constructor con balance inicial usando super()
    public CuentaAhorro(double balance) {
        super(balance);
        this.montoInteres = 0.0;
    }

    // Constructor con balance y montoInteres usando super()
    public CuentaAhorro(double balance, double montoInteres) {
        super(balance);
        this.montoInteres = montoInteres;
    }

    // Getter para monto de intereses
    public double getMontoInteres() {
        return montoInteres;
    }

    // Implementación del método deposito
    @Override
    public boolean deposito(double monto) {
        if (monto >= 1) { // No puede depositar valores menores a 1
            setBalance(getBalance() + monto);
            System.out.println("Depósito exitoso en Cuenta de Ahorro. Monto: $" + String.format("%.2f", monto));
            return true;
        } else {
            System.out.println("Error: No puede depositar valores menores a 1 en Cuenta de Ahorro");
            return false;
        }
    }

    // Implementación del método retiro
    @Override
    public boolean retiro(double monto) {
        if (monto > 0) {
            if (getBalance() >= monto) { // No puede retirar fondos superiores al balance
                setBalance(getBalance() - monto);
                System.out.println("Retiro exitoso de Cuenta de Ahorro. Monto: $" + String.format("%.2f", monto));
                return true;
            } else {
                System.out.println("Error: No puede retirar fondos superiores al balance en Cuenta de Ahorro. Balance: $" + String.format("%.2f", getBalance()));
                return false;
            }
        } else {
            System.out.println("Error: El monto a retirar debe ser mayor a cero");
            return false;
        }
    }

    // Implementación del cálculo de intereses - acumula montoInteres
    public double calculoInteres() {
        double interesCalculado = getBalance() * TASA_INTERES;
        this.montoInteres += interesCalculado; // Acumula el montoInteres
        System.out.println("Interés calculado: $" + String.format("%.2f", interesCalculado) +
                ". Total acumulado: $" + String.format("%.2f", this.montoInteres));
        return interesCalculado;
    }

    // Método toString usando sobreescritura
    @Override
    public String toString() {
        return "Cuenta de Ahorro: [saldo actual: " + String.format("%.2f", getBalance()) +
                "] [interes: " + String.format("%.2f", montoInteres) + "]";
    }
}
