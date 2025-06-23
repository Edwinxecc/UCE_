package ec.edu.uce.dominio;

/**
 * Clase abstracta **Cuenta**, establece la estructura fundamental para todos los tipos de cuentas bancarias.
 * Define las operaciones básicas como depositar y retirar, que serán implementadas por sus subclases
 * (por ejemplo, CuentaAhorro, CuentaCorriente), adaptándose a sus lógicas específicas.
 *
 */
public abstract class Cuenta {

    /**
     * Almacena el **balance actual** de la cuenta.
     */
    protected double balance; // Accesible directamente por las clases que hereden.

    /**
     * Constructor predeterminado.
     * Inicializa el balance de la cuenta en **cero**.
     */
    public Cuenta() {
        this.balance = 0.0;
    }

    /**
     * Constructor que permite especificar un **balance inicial** al crear la cuenta.
     * @param balance Saldo inicial para la cuenta.
     */
    public Cuenta(double balance) {
        this.balance = balance;
    }

    /**
     * Recupera el **balance actual** de la cuenta.
     * @return El balance numérico de la cuenta.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Actualiza el **balance** de la cuenta con un nuevo valor.
     * @param balance El nuevo valor del balance.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * **Método abstracto** para realizar un depósito.
     * Cada tipo de cuenta definirá su propia lógica para esta operación.
     * @param monto Cantidad de dinero a depositar.
     * @return `true` si la operación de depósito fue exitosa, `false` si no.
     */
    public abstract boolean deposito(double monto);

    /**
     * **Método abstracto** para procesar un retiro.
     * Las subclases deberán implementar el comportamiento específico para retirar fondos.
     * @param monto Cantidad de dinero a retirar.
     * @return `true` si el retiro se completó con éxito, `false` en caso contrario.
     */
    public abstract boolean retiro(double monto);

    /**
     * **Método abstracto** para calcular intereses u otras métricas financieras asociadas a la cuenta.
     * @return El resultado del cálculo financiero (ej. monto de interés generado).
     */
    public abstract double calculoInteres();

    /**
     * **Método abstracto** que proporciona una descripción textual del tipo de cuenta.
     * @return Un `String` que describe el tipo de cuenta (ej. "Cuenta de Ahorros", "Cuenta Corriente").
     */
    public abstract String descripcion();

    /**
     * Genera una representación en cadena del objeto `Cuenta`.
     * Este método se espera que sea sobrescrito por las subclases para incluir detalles específicos.
     * @return Una cadena formateada con la información básica de la cuenta.
     */
    @Override
    public String toString() {
        return "Cuenta [Balance actual: $" + String.format("%.2f", balance) + "]";
    }

    /**
     * **Método abstracto** para determinar si dos objetos `Cuenta` son equivalentes.
     * La lógica de comparación debe ser definida por las clases que heredan.
     * @param obj El objeto con el que se va a comparar.
     * @return `true` si los objetos son considerados iguales, `false` si no lo son.
     */
    @Override
    public abstract boolean equals(Object obj);
}