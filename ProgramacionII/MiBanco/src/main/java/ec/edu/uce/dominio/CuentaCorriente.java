package ec.edu.uce.dominio;

public class CuentaCorriente extends Cuenta {
    private double sobregiro;

    // Constructor por defecto usando super()
    public CuentaCorriente() {
        super();
        this.sobregiro = 0.0;
    }

    // Constructor con balance inicial usando super()
    public CuentaCorriente(double balance) {
        super(balance);
        this.sobregiro = 0.0;
    }

    // Constructor con balance y sobregiro usando super()
    public CuentaCorriente(double balance, double sobregiro) {
        super(balance);
        this.sobregiro = sobregiro;
    }

    // Getter para sobregiro
    public double getSobregiro() {
        return sobregiro;
    }

    // Setter para sobregiro
    public void setSobregiro(double sobregiro) {
        this.sobregiro = sobregiro;
    }

    // Implementación del método deposito
    @Override
    public boolean deposito(double monto) {
        if (monto > 1) { // Puede depositar valores mayores a 1
            setBalance(getBalance() + monto);
            System.out.println("Depósito exitoso en Cuenta Corriente. Monto: $" + monto);
            return true;
        } else {
            System.out.println("Error: No puede depositar valores menores o iguales a 1 en Cuenta Corriente");
            return false;
        }
    }

    // Implementación del método retiro
    @Override
    public boolean retiro(double monto) {
        if (monto > 0) {
            double disponible = getBalance() + sobregiro;
            if (disponible >= monto) {
                setBalance(getBalance() - monto);
                System.out.println("Retiro exitoso de Cuenta Corriente. Monto: $" + monto);
                return true;
            } else {
                System.out.println("Error: Fondos insuficientes en Cuenta Corriente. Disponible: $" + disponible);
                return false;
            }
        } else {
            System.out.println("Error: El monto a retirar debe ser mayor a cero");
            return false;
        }
    }

    // Implementación del cálculo de intereses (no aplica para cuenta corriente)
    @Override
    public double calculoInteres() {
        return 0.0; // Las cuentas corrientes no generan intereses
    }

    // Método toString usando sobreescritura
    @Override
    public String toString() {
        return "Cuenta Corriente: [saldo actual: " + String.format("%.2f", getBalance()) +
                "] [sobregiro: " + String.format("%.2f", sobregiro) + "]";
    }
}
