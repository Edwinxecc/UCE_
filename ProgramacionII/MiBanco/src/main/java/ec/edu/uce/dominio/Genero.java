package ec.edu.uce.dominio;

/**
 * Enumeración para representar los **géneros** disponibles: Femenino, Masculino y Otro.
 * Cada opción de género cuenta con una abreviatura y un nombre completo.
 */
public enum Genero {

    FEMENINO('F', "Femenino"),
    MASCULINO('M', "Masculino"),
    OTRO('O', "Otro");

    private char abrev;   // Almacena la abreviatura del género (ej. 'F', 'M', 'O').
    private String nombre; // Guarda el nombre completo del género.

    /**
     * Constructor privado para las constantes de la enumeración `Genero`.
     * @param abrev La abreviatura del género.
     * @param nombre El nombre completo del género.
     */
    private Genero(char abrev, String nombre) {
        this.abrev = abrev;
        this.nombre = nombre;
    }

    /**
     * Obtiene la abreviatura asociada a este género.
     * @return El carácter que representa la abreviatura del género.
     */
    public char getAbrev() {
        return abrev;
    }

    /**
     * Obtiene el nombre completo de este género.
     * @return Una cadena con el nombre completo del género.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Proporciona el nombre completo del género como su representación en cadena.
     * Esto es útil al imprimir directamente una instancia de `Genero`.
     * @return El nombre completo del género.
     */
    @Override
    public String toString() {
        return nombre;
    }
}