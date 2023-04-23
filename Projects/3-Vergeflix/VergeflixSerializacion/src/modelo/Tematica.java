package modelo;

/**
 * Enumeración para listar las Diferentes Categorías de una Película
 * Los posibles categorías son: Comedia, Drama, Terror, Suspense, Ciencia Ficción y Fantasía.
 * Posee un método para obtener el nombre de la Temática.
 */
public enum Tematica {
    COMEDIA ("Comedia"),
    DRAMA ("Drama"),
    TERROR ("Terror"),
    SUSPENSE ("Suspense"),
    CIENCIA_FICCION ("Ciencia Ficción"),
    FANTASIA ("Fantasía");

    private final String nombre;

    Tematica(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    
    @Override
    public String toString() {
        return nombre;
    }
}
