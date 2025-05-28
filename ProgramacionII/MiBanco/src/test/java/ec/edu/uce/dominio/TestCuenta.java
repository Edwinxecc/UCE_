package ec.edu.uce.dominio;

public class TestCuenta {
    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta(100);
        System.out.println("Saldo inicial: "+ cuenta.getBalance());
        System.out.println("Deposito de: 150");
        cuenta.deposito(150);
        System.out.println("Saldo: " + cuenta.getBalance());
        cuenta.retiro(100);
        System.out.println("Retiro de: 100");
        System.out.println("Saldo: " + cuenta.getBalance());
    }
}
