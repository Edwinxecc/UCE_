package ec.edu.uce.dominio;

public class TarjetaCredito extends Cuenta {

    private double cupo; // Cupo o límite de crédito disponible

    public TarjetaCredito() {
        super();
        this.cupo = 1000.0; // Cupo por defecto
    }

    public TarjetaCredito(double balance) {
        super(balance);
        this.cupo = 1000.0; // Cupo por defecto
    }

    public TarjetaCredito(double balance, double cupo) {
        super(balance);
        this.cupo = cupo > 0 ? cupo : 1000.0;
    }

    // Getter y Setter para cupo
    public double getCupo() {
        return cupo;
    }

    public void setCupo(double cupo) {
        if (cupo > 0) {
            this.cupo = cupo;
        } else {
            System.out.println("Error: El cupo debe ser mayor a cero");
        }
    }

    @Override
    public boolean deposito(double monto) {
        if (monto > 1) { // Siguiendo el patrón de las otras clases
            setBalance(getBalance() + monto);
            System.out.println("Depósito exitoso en Tarjeta de Crédito. Monto: $" + monto);
            return true;
        } else {
            System.out.println("Error: No puede depositar valores menores o iguales a 1 en Tarjeta de Crédito");
            return false;
        }
    }

    @Override
    public boolean retiro(double monto) {
        if (monto > 0) {
            double disponible = getBalance() + cupo;
            if (disponible >= monto) {
                setBalance(getBalance() - monto);
                System.out.println("Retiro exitoso de Tarjeta de Crédito. Monto: $" + monto);
                return true;
            } else {
                System.out.println("Error: Fondos insuficientes en Tarjeta de Crédito. Disponible: $" + disponible);
                return false;
            }
        } else {
            System.out.println("Error: El monto a retirar debe ser mayor a cero");
            return false;
        }
    }

    public double calculoInteres() {
        // Las tarjetas de crédito no generan intereses en este caso
        return 0.0;
    }

    // Método toString usando sobreescritura
    @Override
    public String toString() {
        return "TarjetaCredito: [saldo actual: " + String.format("%.2f", getBalance()) +
                "] [cupo: " + String.format("%.2f", cupo) + "]";
    }
}