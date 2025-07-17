package ec.edu.uce.dominio;

public class TarjetaCredito extends Cuenta {
    private double cupo;        // Crédito disponible
    private double cupoMaximo;  // Límite máximo de crédito

    public TarjetaCredito() {
        super();
        this.cupoMaximo = 1000; // ejemplo límite máximo de crédito
        this.cupo = cupoMaximo; // inicialmente todo el cupo está disponible
    }

    public TarjetaCredito(double saldo, double cupoMaximo) {
        super(saldo);
        this.cupoMaximo = cupoMaximo;
        this.cupo = cupoMaximo;
    }

    public double getCupo() {
        return cupo;
    }

    public void setCupo(double cupo) {

        if (cupo < 0) {
            this.cupo = 0;
        } else if (cupo > cupoMaximo) {
            this.cupo = cupoMaximo;
        } else {
            this.cupo = cupo;
        }
    }

    public double getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(double cupoMaximo) {
        this.cupoMaximo = cupoMaximo;

        if (this.cupo > cupoMaximo) {
            this.cupo = cupoMaximo;
        }
    }

    @Override
    public void deposito(double monto) {
        if (monto > 0) {

            double deuda;
            if ((cupoMaximo - cupo) > 0) {
                deuda = cupoMaximo - cupo;
            } else {
                deuda = 0;
            }

            double pago;
            if (monto < deuda) {
                pago = monto;
            } else {
                pago = deuda;
            }

            double nuevoCupo = cupo + pago;
            setCupo(nuevoCupo);

            double restante = monto - pago;
            if (restante > 0) {
                double nuevoSaldo = getSaldo() + restante;
                setSaldo(nuevoSaldo);
            }
        }
    }

    @Override
    public void retiro(double monto) {
        if (monto > 0) {

            double disponible = getSaldo() + cupo;

            if (monto <= disponible) {
                if (monto <= getSaldo()) {

                    double nuevoSaldo = getSaldo() - monto;
                    setSaldo(nuevoSaldo);
                } else {

                    double restante = monto - getSaldo();
                    setSaldo(0);

                    double nuevoCupo = cupo - restante;
                    setCupo(nuevoCupo);
                }
            } else {
                System.out.println("Límite de crédito superado");
            }
        }
    }

    @Override
    public double calculoInteres() {

        double creditoUsado = cupoMaximo - cupo;
        if (creditoUsado <= 0) {
            return 0;
        }

        double interes = creditoUsado * 0.05;

        double nuevoCupo = cupo - interes;
        setCupo(nuevoCupo);

        return interes;
    }

    @Override
    public String toString() {
        return String.format("TarjetaCredito: [saldo actual : %.2f] [cupo: %.2f]", getSaldo(), cupo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof TarjetaCredito)) return false;

        TarjetaCredito otra = (TarjetaCredito) obj;

        if (getSaldo() != otra.getSaldo()) return false;
        if (cupo != otra.cupo) return false;
        if (cupoMaximo != otra.cupoMaximo) return false;
        return true;
    }

    @Override
    public String descripcion() {
        return "Cuenta de Ahorro";
    }
}

