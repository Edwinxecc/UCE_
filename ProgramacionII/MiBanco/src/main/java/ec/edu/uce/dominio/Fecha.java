package ec.edu.uce.dominio;
/**
 * Clase que representa una fecha con día, mes y año.
 * Incluye validaciones para garantizar que la fecha sea correcta.
 *
 * @author Samanta Tuqueres
 */
public class Fecha {
    private int dia;
    private int mes;
    private int anio;

    /**
     * Constructor por defecto que inicializa la fecha con valores predeterminados.
     */
    public Fecha() {
        this.dia = 24;
        this.mes = 1;
        this.anio = 2006;
    }

    /**
     * Constructor con validación que verifica si la fecha es válida antes de asignarla.
     * Si la fecha no es válida, se asigna la fecha por defecto 01/01/2000.
     *
     * @param dia Día de la fecha
     * @param mes Mes de la fecha
     * @param anio Año de la fecha
     */
    public Fecha(int dia, int mes, int anio) {
        if (esFechaValida(dia, mes, anio)) {
            this.dia = dia;
            this.mes = mes;
            this.anio = anio;
        } else {
            System.out.println("Fecha inválida.");
            this.dia = 1;
            this.mes = 1;
            this.anio = 2000;
        }
    }

    /**
     * Verifica si una fecha es válida según el día, mes y año proporcionados.
     *
     * @param dia Día de la fecha
     * @param mes Mes de la fecha
     * @param anio Año de la fecha
     * @return true si la fecha es válida, false en caso contrario
     */
    private boolean esFechaValida(int dia, int mes, int anio) {
        if (anio < 1900 || anio > 2100) return false;
        if (mes < 1 || mes > 12) return false;

        int[] diasPorMes = { 31, esBisiesto(anio) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        return dia >= 1 && dia <= diasPorMes[mes - 1];
    }

    /**
     * Determina si un año es bisiesto.
     *
     * @param anio Año a verificar
     * @return true si el año es bisiesto, false en caso contrario
     */
    private boolean esBisiesto(int anio) {
        return (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0);
    }

    /**
     * Establece el día de la fecha con validación.
     *
     * @param dia Nuevo día
     */
    public void setDia(int dia) {
        if (esFechaValida(dia, this.mes, this.anio)) {
            this.dia = dia;
        } else {
            System.out.println("Día inválido para el mes/año actual.");
        }
    }

    /**
     * Establece el mes de la fecha con validación.
     *
     * @param mes Nuevo mes
     */
    public void setMes(int mes) {
        if (esFechaValida(this.dia, mes, this.anio)) {
            this.mes = mes;
        } else {
            System.out.println("Mes inválido.");
        }
    }

    /**
     * Establece el año de la fecha con validación.
     *
     * @param anio Nuevo año
     */
    public void setAnio(int anio) {
        if (esFechaValida(this.dia, this.mes, anio)) {
            this.anio = anio;
        } else {
            System.out.println("Año inválido.");
        }
    }

    /**
     * Obtiene el día de la fecha.
     *
     * @return Día de la fecha
     */
    public int getDia() {
        return dia;
    }

    /**
     * Obtiene el mes de la fecha.
     *
     * @return Mes de la fecha
     */
    public int getMes() {
        return mes;
    }

    /**
     * Obtiene el año de la fecha.
     *
     * @return Año de la fecha
     */
    public int getAnio() {
        return anio;
    }

    /**
     * Obtiene la fecha en formato corto (dd/mm/yyyy).
     *
     * @return Fecha en formato corto
     */
    public String obtenerFormatoCorto() {
        return String.format("%02d/%02d/%04d", dia, mes, anio);
    }

    /**
     * Obtiene la fecha en formato largo (Ejemplo: 1 de enero de 2025).
     *
     * @return Fecha en formato largo
     */
    public String obtenerFormatoLargo() {
        String[] nombresMeses = {
                "enero", "febrero", "marzo", "abril", "mayo", "junio",
                "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"
        };
        return dia + " de " + nombresMeses[mes - 1] + " de " + anio;
    }

    /**
     * Representación en cadena del objeto Fecha.
     *
     * @return Fecha en formato corto
     */
    @Override
    public String toString() {
        return obtenerFormatoCorto();
    }
}
