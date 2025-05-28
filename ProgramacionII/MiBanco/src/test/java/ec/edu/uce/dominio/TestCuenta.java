package ec.edu.uce.dominio;
 import  ec.edu.uce.dominio.Cuenta;
public class TestCuenta {
    public static void main(String[] args) {
        Cliente nuevo = new Cliente();
        Cuenta nueva = new Cuenta(100);
        System.out.println(nueva.getSaldo());
        nueva.deposito(150);
        System.out.println(nueva.getSaldo());
        nueva.retiro(100);
        System.out.println(nueva.getSaldo());

    }
}
