package ec.edu.uce.dominio;

public class TarjetaCredito extends Cuenta {
    private double cupo;        // El crédito disponible actual en la tarjeta.
    private double cupoMaximo;  // El límite total de crédito que la tarjeta puede tener.

    // Constructor predeterminado.
    public TarjetaCredito() {
        super(); // Inicializa el balance de la cuenta a 0.0.
        this.cupoMaximo = 1000; // Define un límite máximo de crédito por defecto.
        this.cupo = cupoMaximo; // Inicialmente, el cupo disponible es igual al cupo máximo.
    }

    // Constructor que permite definir un saldo inicial y un límite de cupo máximo.
    public TarjetaCredito(double saldo, double cupoMaximo) {
        super(saldo); // Inicializa el balance (saldo) de la superclase.
        this.cupoMaximo = cupoMaximo;
        this.cupo = cupoMaximo; // Al inicio, el cupo disponible es el total del cupo máximo.
    }

    public double getCupo() {
        return cupo;
    }

    public void setCupo(double cupo) {
        // Asegura que el cupo disponible no sea negativo y no exceda el cupo máximo.
        if (cupo < 0) {
            this.cupo = 0; // El cupo no puede ser menor a cero.
        } else if (cupo > cupoMaximo) {
            this.cupo = cupoMaximo; // El cupo disponible no puede superar su límite máximo.
        } else {
            this.cupo = cupo;
        }
    }

    public double getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(double cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
        // Ajusta el cupo actual si el nuevo cupo máximo es menor que el cupo disponible.
        if (this.cupo > cupoMaximo) {
            this.cupo = cupoMaximo;
        }
    }

    @Override
    public boolean deposito(double monto) {
        if (monto > 0) {
            // Calcula el monto de la deuda pendiente sobre el cupo.
            double deuda = cupoMaximo - cupo;
            if (deuda < 0) { // Si el cupo actual es mayor al cupoMaximo, no hay deuda de cupo.
                deuda = 0;
            }

            // El monto depositado se usa primero para "restaurar" el cupo consumido.
            double pagoAlCupo = Math.min(monto, deuda);
            double nuevoCupo = cupo + pagoAlCupo;
            setCupo(nuevoCupo); // Actualiza el cupo disponible usando el setter para validación.

            // Si aún queda dinero después de restaurar el cupo, se añade al balance de la cuenta.
            double restante = monto - pagoAlCupo;
            if (restante > 0) {
                double nuevoBalance = getBalance() + restante;
                setBalance(nuevoBalance);
            }
            return true; // El depósito se considera exitoso si el monto es positivo.
        }
        return false;
    }

    @Override
    public boolean retiro(double monto) {
        if (monto > 0) {
            // El total disponible para gastar incluye el balance actual y el cupo disponible.
            double disponibleTotal = getBalance() + cupo;

            if (monto <= disponibleTotal) {
                if (monto <= getBalance()) {
                    // Si el monto del retiro es cubierto por el saldo, se descuenta directamente del saldo.
                    double nuevoBalance = getBalance() - monto;
                    setBalance(nuevoBalance);
                } else {
                    // Si el monto excede el saldo, se consume el saldo y el resto se descuenta del cupo.
                    double restante = monto - getBalance();
                    setBalance(0); // El balance se reduce a cero.

                    double nuevoCupo = cupo - restante; // El cupo disponible se reduce.
                    setCupo(nuevoCupo); // Actualiza el cupo disponible usando el setter para validación.
                }
                return true; // El retiro fue exitoso.
            } else {
                return false; // Fondos insuficientes (saldo + cupo).
            }
        }
        return false;
    }

    @Override
    public double calculoInteres() {
        // Calcula el monto de crédito que ha sido utilizado.
        double creditoUsado = cupoMaximo - cupo;
        if (creditoUsado <= 0) {
            return 0; // Si no hay crédito utilizado, no se genera interés.
        }

        double interes = creditoUsado * 0.05; // Calcula el interés (por ejemplo, 5% sobre el crédito usado).

        // El interés generado se suma a la "deuda", lo que reduce el cupo disponible.
        double nuevoCupo = cupo - interes;
        setCupo(nuevoCupo); // Actualiza el cupo disponible usando el setter.

        return interes; // Retorna el valor del interés calculado.
    }

    @Override
    public String toString() {
        // Formato para mostrar el saldo (balance de la cuenta), el cupo disponible y el cupo máximo.
        return String.format("TarjetaCredito: [saldo actual : %.2f] [cupo disponible: %.2f / %.2f]", getBalance(), cupo, cupoMaximo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        // Verifica si el objeto a comparar es nulo o no es una instancia de TarjetaCredito.
        if (!(obj instanceof TarjetaCredito)) return false;

        TarjetaCredito otra = (TarjetaCredito) obj;

        // Compara el balance de la superclase y los atributos específicos de TarjetaCredito.
        if (Double.compare(this.getBalance(), otra.getBalance()) != 0) return false;
        if (Double.compare(this.cupo, otra.cupo) != 0) return false;
        if (Double.compare(this.cupoMaximo, otra.cupoMaximo) != 0) return false;
        return true;
    }

    @Override
    public int hashCode() {
        // Genera un código hash basado en los atributos relevantes para la comparación de igualdad.
        return java.util.Objects.hash(getBalance(), cupo, cupoMaximo);
    }

    @Override
    public String descripcion() {
        // Proporciona una descripción del tipo de cuenta.
        return "Tarjeta de Crédito";
    }
}