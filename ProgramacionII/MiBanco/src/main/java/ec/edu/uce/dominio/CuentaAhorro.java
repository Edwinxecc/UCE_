package ec.edu.uce.dominio;

public class CuentaAhorro extends Cuenta{
    private double TASA_INTERES;
    private double montoInteres;

    public CuentaAhorro (double balance, double montoInteres){
        super(balance);
        this.montoInteres = montoInteres;
    }


    public boolean retiro(double monto){
        if (monto > 0 && getBalance() <= monto){
            setBalance();
        }
        return false;
    }
}
