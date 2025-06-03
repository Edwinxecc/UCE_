package ec.edu.uce.dominio;

public class Fecha {
    private int dia;
    private int mes;
    private int anio;

    public Fecha() {
        // Por defecto, inicializamos con una fecha base
        this.dia = 1;
        this.mes = 1;
        this.anio = 2000;
    }

    public Fecha(int dia, int mes, int anio) {
        setDia(dia);
        setMes(mes);
        setAnio(anio);
    }

    public Fecha(Fecha fecha) {
        if (fecha != null) {
            this.dia = fecha.dia;
            this.mes = fecha.mes;
            this.anio = fecha.anio;
        } else {
            this.dia = 1;
            this.mes = 1;
            this.anio = 2000;
        }
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        // Validación simple: el día debe estar entre 1 y 31
        if (dia >= 1 && dia <= 31) {
            // Validación adicional según el mes
            if (mes == 2) { // Febrero
                int maxDias = (esAnioBisiesto()) ? 29 : 28;
                if (dia <= maxDias) {
                    this.dia = dia;
                } else {
                    System.out.println("Error: dia invalido para febrero");
                    this.dia = 1;
                }
            } else if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30) {
                // Abril, junio, septiembre y noviembre tienen 30 días
                System.out.println("Error: dia invalido para el mes " + mes);
                this.dia = 1;
            } else {
                this.dia = dia;
            }
        } else {
            System.out.println("Error: dia fuera de rango (1-31): " + dia);
            this.dia = 1;
        }
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        if (mes >= 1 && mes <= 12) {
            this.mes = mes;
            // Re-validar el día actual después de cambiar el mes
            setDia(this.dia);
        } else {
            System.out.println("Error: mes fuera de rango (1-12): " + mes);
            this.mes = 1;
        }
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        if (anio >= 0) {
            this.anio = anio;
            // Re-validar el día después de cambiar el año (por si cambia febrero en año bisiesto)
            if (mes == 2) {
                setDia(this.dia);
            }
        } else {
            System.out.println("Error: año no puede ser negativo: " + anio);
            this.anio = 2000;
        }
    }

    public boolean esAnioBisiesto() {
        return (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0);
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", dia, mes, anio);
    }
}