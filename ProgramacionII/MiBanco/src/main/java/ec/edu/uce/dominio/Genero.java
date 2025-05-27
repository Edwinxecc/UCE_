package ec.edu.uce.dominio;
/**
 * Enumeración que representa los géneros posibles.
 * Cada género tiene una abreviatura (char) y un nombre completo.
 *
 * FEMENINO: Representa el género femenino.
 * MASCULINO: Representa el género masculino.
 *
 * Se utiliza para representar el género de una persona de forma segura.
 *
 */
public enum Genero {
    /**
     * Género femenino.
     */
    FEMENINO('F', "Femenino"),

    /**
     * Género masculino.
     */
    MASCULINO('M', "Masculino");

    private char abrev;
    private String nombre;

    /**
     * Constructor privado del enum que inicializa los atributos.
     *
     * @param abrev Abreviatura del género (por ejemplo, 'F' o 'M')
     * @param nombre Nombre completo del género
     */
    private Genero(char abrev, String nombre) {
        this.abrev = abrev;
        this.nombre = nombre;
    }

    /**
     * Obtiene la abreviatura del género.
     *
     * @return Abreviatura del género
     */
    public char getAbrev() {
        return abrev;
    }

    /**
     * Obtiene el nombre completo del género.
     *
     * @return Nombre del género
     */
    public String getNombre() {
        return nombre;
    }
}
