package modelo;

/**
 * Clase que representa una Canción
 * La canción se compone de:
 * <ul>
 *      <li>Titulo: El título de la canción (No puede estar vacío o contener solo espacios)</li>
 *      <li>Ruta: El Path absoluto donde se encuentra la canción (No puede estar vacío o contener solo espacios)</li>
 *      <li>Duración: La duración de la Canción (Debe ser positivo o -1 si su duración es desconocida)</li>
 * </ul>
 * @author josemaria
 */
public class Cancion {
    private String titulo;
    private String ruta;
    private int duracion;
    
    /**
     * Crea una nueva Canción con su Título, Ruta y Duración
     * @param titulo El Título de la Canción (No puede estar vacío o contener solo espacios)
     * @param ruta El Path Absoluto de la Canción (No puede estar vacío o contener solo espacios)
     * @param duracion La duración de la Canción (Debe ser positivo o -1 si su duración es desconocida)
     */
    public Cancion (String titulo, String ruta, int duracion) {
        if (titulo.isBlank()) {
            throw new IllegalArgumentException("El título de la canción no puede estar vacío");
        }
        if (ruta.isBlank()) {
            throw new IllegalArgumentException("La ruta no puede estar vacía");
        }
        if (duracion < 0) { // 0 significa longitud desconocida
            throw new IllegalArgumentException("La duración no puede ser menor a -1");
        }
        
        this.titulo = titulo;
        this.ruta = ruta;
        this.duracion = duracion;
    }
    
    /**
     * Constructor copia, recibe un objeto Cancion
     * Crea una copia profunda de la Canción pasada por parámetro
     * @param cancion Objeto Canción a copiar
     */
    public Cancion (Cancion cancion) {
        this.titulo = cancion.titulo;
        this.ruta = cancion.ruta;
        this.duracion = cancion.duracion;
    }

    /**
     * Devuelve el Título de la Canción
     * @return El Título de la Canción
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Modifica el Título de la Canción
     * Se modificará si el título pasado no este vacío o si solo contiene espacios.
     * @param titulo El nuevo Título
     */
    public void setTitulo(String titulo) {
        if (!titulo.isBlank()) {
            this.titulo = titulo;
        }
    }

    /**
     * Devuelve la Ruta de la Canción
     * @return La Ruta de la Canción
     */
    public String getRuta() {
        return ruta;
    }

    /**
     * Modifica la Ruta de la Canción
     * Se modificará si la ruta no está vacía o si solo contiene espacios.
     * @param ruta La nueva Ruta
     */
    public void setRuta(String ruta) {
        if (!ruta.isBlank()) {
            this.ruta = ruta;
        }
    }

    /**
     * Devuelve la Duración de la Canción
     * @return La Duración de la Canción
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * Modifica la Duración de la Canción
     * Se modificará si la duración pasada es positiva o -1 (Indica duración desconocida)
     * @param duracion La nueva Duración
     */
    public void setDuracion(int duracion) {
        if (duracion >= -1) {
            this.duracion = duracion;
        }
    }
}
