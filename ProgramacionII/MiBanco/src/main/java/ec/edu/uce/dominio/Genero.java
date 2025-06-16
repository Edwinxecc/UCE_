/**
 * @author Edwin Caiza
 */
package ec.edu.uce.dominio;

/**
 * Enumeración que representa el género de una persona.
 * Cada género tiene una abreviatura (carácter) y un nombre completo.
 */
public enum Genero {

    FEMENINO('F', "Femenino"),
    MASCULINO('M', "Masculino");

    private char abrev;
    private String nombre;

    /**
     * Constructor privado para inicializar cada valor del enum.
     *
     * @param abrev  Abreviatura del género (por ejemplo, 'F' para Femenino)
     * @param nombre Nombre completo del género
     */
    private Genero(char abrev, String nombre) {
        this.abrev = abrev;
        this.nombre = nombre;
    }

    /**
     * Obtiene la abreviatura del género.
     *
     * @return abreviatura como carácter
     */
    public char getAbrev() {
        return abrev;
    }

    /**
     * Obtiene el nombre completo del género.
     *
     * @return nombre del género
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el nombre completo del género como representación de texto.
     *
     * @return nombre del género
     */
    @Override
    public String toString() {
        return nombre;
    }
}