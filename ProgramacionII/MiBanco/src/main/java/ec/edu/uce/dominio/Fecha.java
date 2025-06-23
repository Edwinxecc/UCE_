package ec.edu.uce.dominio;

/**
 * Clase para la gestión de fechas básicas (día, mes, año).
 * Incorpora validaciones sencillas para los componentes de la fecha.
 */
public class Fecha {

    private int dia;
    private int mes;
    private int anio;

    /**
     * Constructor que crea una fecha, validando los valores proporcionados.
     * @param dia El día de la fecha.
     * @param mes El mes de la fecha.
     * @param anio El año de la fecha.
     */
    public Fecha(int dia, int mes, int anio) {
        setAnio(anio);
        setMes(mes);
        setDia(dia);
    }

    public int getDia() { return dia; }
    public void setDia(int dia) {
        // Valida que el día esté en el rango de 1 a 31. Si no, se establece en 1.
        this.dia = (dia >= 1 && dia <= 31) ? dia : 1;
    }

    public int getMes() { return mes; }
    public void setMes(int mes) {
        // Valida que el mes esté en el rango de 1 a 12. Si no, se establece en 1.
        this.mes = (mes >= 1 && mes <= 12) ? mes : 1;
    }

    public int getAnio() { return anio; }
    public void setAnio(int anio) {
        // Valida que el año esté en el rango de 1900 a 2100. Si no, se establece en 2000.
        this.anio = (anio >= 1900 && anio <= 2100) ? anio : 2000;
    }

    /**
     * Convierte la fecha a una representación de texto fácil de leer en formato día/mes/año.
     * @return Una cadena de texto con la fecha.
     */
    @Override
    public String toString() {
        return dia + "/" + mes + "/" + anio;
    }
}
