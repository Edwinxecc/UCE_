package ec.edu.uce.dominio;

/**
 * Clase **CuentaCorriente**: representa un tipo de cuenta bancaria que permite el sobregiro.
 * Hereda funcionalidades y comportamientos de la clase `Cuenta`.
 */
public class CuentaCorriente extends Cuenta {

    private double sobregiro; // Monto máximo permitido para sobregirar la cuenta.

    // Constructor predeterminado. Inicializa el balance en cero y el sobregiro permitido en cero.
    public CuentaCorriente() {
        super();
        this.sobregiro = 0.0;
    }

    // Constructor que inicializa la cuenta con un balance específico, sin sobregiro inicial.
    public CuentaCorriente(double balance) {
        super(balance);
        this.sobregiro = 0.0;
    }

    // Constructor que permite inicializar la cuenta con un balance y un límite de sobregiro.
    public CuentaCorriente(double balance, double sobregiro) {
        super(balance);
        setSobregiro(sobregiro); // Utiliza el setter para validar el valor del sobregiro.
    }

    public double getSobregiro() {
        return sobregiro;
    }

    public void setSobregiro(double sobregiro) {
        // Asegura que el sobregiro no sea un valor negativo.
        if (sobregiro >= 0) {
            this.sobregiro = sobregiro;
        } else {
            System.out.println("Advertencia: El límite de sobregiro no puede ser negativo. Se ha establecido en $0.00.");
            this.sobregiro = 0.0;
        }
    }

    // Implementación del método de depósito: el monto a depositar debe ser superior a $1.00.
    @Override
    public boolean deposito(double monto) {
        if (monto <= 1.00) {
            return false; // Depósito mínimo no alcanzado.
        }
        this.balance += monto;
        return true;
    }

    // Implementación del método de retiro: permite retirar fondos incluso si excede el balance, hasta el límite de sobregiro.
    @Override
    public boolean retiro(double monto) {
        if (monto <= 0) {
            return false; // El monto a retirar debe ser positivo.
        }
        // Verifica si hay fondos suficientes, incluyendo el límite de sobregiro.
        if (this.balance + this.sobregiro >= monto) {
            this.balance -= monto;
            return true;
        } else {
            System.out.println("Error: Fondos insuficientes (incluido el límite de sobregiro). Total disponible: $" + String.format("%.2f", this.balance + this.sobregiro));
            return false;
        }
    }

    // Calcula el interés por sobregiro; aplica un 10% si el balance es negativo.
    @Override
    public double calculoInteres() {
        if (balance < 0) {
            return Math.abs(balance) * 0.10; // 10% de interés sobre el valor sobregirado.
        }
        return 0; // No hay interés si el balance es positivo o cero.
    }

    // Proporciona una descripción del tipo de cuenta.
    @Override
    public String descripcion() {
        return "Cuenta Corriente";
    }

    // Retorna una representación en cadena de la Cuenta Corriente, incluyendo balance y sobregiro.
    @Override
    public String toString() {
        return "Cuenta Corriente [Saldo actual: $" + String.format("%.2f", balance) +
                ", Sobregiro permitido: $" + String.format("%.2f", sobregiro) + "]";
    }

    // Compara si dos objetos CuentaCorriente son iguales basándose en su balance y límite de sobregiro.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        CuentaCorriente otra = (CuentaCorriente) obj;

        // Compara los valores double con un pequeño margen de error si es necesario,
        // aunque `Double.compare` es preciso.
        if (Double.compare(balance, otra.balance) != 0) return false;
        if (Double.compare(sobregiro, otra.sobregiro) != 0) return false;
        return true;
    }
    // Falta la implementación del método hashCode() aquí.
}