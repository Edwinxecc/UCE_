package ec.edu.uce.dominio;

/**
 * @author Edwin Caiza
 */

public class MiFecha {
    private int dia;
    private int mes;
    private int anio;

    public MiFecha(){
        this.dia = 1;
        this.mes = 1;
        this.anio = 1990;
    }

    public MiFecha (int dia, int mes, int anio){
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public int getDia() {
        return dia;
    }

    public boolean setDia(int dia) {
        if (dia > 0) {
            boolean bisiesto = (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0);
            switch (mes) {
                case 1, 3, 5, 7, 8, 10, 12 -> {
                    // Meses con 31 días
                    if (dia <= 31){
                        this.dia = dia;
                        return true;
                    }
                }
                case 4, 6, 9, 11 -> {
                    // Meses con 30 días
                    if (dia <= 30){
                        this.dia = dia;
                        return true;
                    }
                }
                case 2 -> {
                    if (bisiesto && dia <=29){
                        this.dia = dia;
                    }else if (dia <= 28){
                        this.dia = dia;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int getMes() {
        return mes;
    }

    public boolean setMes(int mes) {
        if (mes > 0 && mes <= 12) {
            this.mes = mes;
            return true;
        }
        return false;
    }

    public int getAnio() {
        return anio;
    }

    public boolean setAnio(int anio) {
        if (anio > 0 && anio < 9999){
            this.anio = anio;
            return true;
        }
        return false;
    }

    public boolean fechaValida(){
        boolean bisiesto = (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0);

        if (dia > 0 && (mes > 0 && mes <= 12) && (anio > 0 && anio <= 9999) ){
            switch (mes) {
                case 1, 3, 5, 7, 8, 10, 12 -> {
                    // Meses con 31 días
                    if (dia <= 31)
                        return true;
                }
                case 4, 6, 9, 11 -> {
                    // Meses con 30 días
                    if (dia <= 30)
                        return true;
                }
                case 2 -> {
                    if (bisiesto && dia <= 29)
                        return true;
                }
            }
        }
        return false;
    }
}
