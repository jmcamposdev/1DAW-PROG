package vergeflix;

import Funciones.Utilities;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase que representa una Película,
 * hereda de Media y se compone de:
 * <ul>
 *     <li>Todos los valores de Media</li>
 *     <li>Director (No puede estar vacío o solo con espacios)</li>
 *     <li>Actor Principal (No puede estar vacío o solo con espacios)</li>
 *     <li>Duración (Debe de estar entre 60 y 240 ambos incluidos)</li>
 *     <li>Categoria (Enum - Tematica)</li>
 * </ul>
 * @see Media
 * @see Tematica
 */
public class Pelicula extends Media {
    /**
     * Nombre del Director
     */
    private String director;
    /**
     * Nombre del Actor Principal
     */
    private String actorPrincipal;
    /**
     * La duración de la Película
     */
    private int duracion;
    /**
     * Temática de la Película
     */
    private Tematica categoria;
    /**
     * Votos de la Película
     */
    private final ArrayList<Integer> votos;

    /**
     * Crea una nueva Película con los valores de Media, Director, Actor Principal, Duración y Categoría
     * @param nombre Nombre de la Película (No podrá estar vacío o contener solo espacios)
     * @param calificacionEdad Calificación de Edad (Debe de estar entre 0 - 18 ambos incluidos)
     * @param fechaIncorporacionAlCatalogo Fecha de Incorporación al Catálogo
     * @param estaDisponible La Disponibilidad de la Película (True = Disponibles, False = No Disponible)
     * @param director El Director (No podrá estar vacío o contener solo espacios)
     * @param actorPrincipal El Actor Principal (No podrá estar vacío o contener solo espacios)
     * @param duracion La Duración (Debe de estar entre 60 mint y 240 mint ambos incluidos)
     * @param categoria La Categoría de la Película (Enum de Temática)
     * @throws IllegalArgumentException Si el Nombre está vacío o contiene solo espacios.
     * @throws IllegalArgumentException Si la Calificación de Edad se encuentra fuera del rango (0 - 18) ambos incluidos.
     * @throws IllegalArgumentException Si el Director está vacío o contiene solo espacios.
     * @throws IllegalArgumentException Si el Actor Principal está vacío o contiene solo espacios.
     * @throws IllegalArgumentException Si la Duración se encuentra fuera del rango (60 - 240) ambos incluidos.
     * @see Tematica
     */
    public Pelicula(String nombre, int calificacionEdad, LocalDate fechaIncorporacionAlCatalogo, boolean estaDisponible, String director, String actorPrincipal, int duracion, Tematica categoria) {
        super(nombre, calificacionEdad, fechaIncorporacionAlCatalogo, estaDisponible);
        if (director.isBlank()) {
            throw new IllegalArgumentException("El campos del director no puede permanecer vacío");
        }
        if (actorPrincipal.isBlank()) {
            throw new IllegalArgumentException("El campos del actor principal no puede permanecer vacío");
        }
        if (!Utilities.validateRange(duracion,60,241)) {
            throw new IllegalArgumentException("La duracion debe contemplarse entre 60 - 240 minutos");
        }
        this.director = director;
        this.actorPrincipal = actorPrincipal;
        this.duracion = duracion;
        this.categoria = categoria;
        this.votos = new ArrayList<>();
    }

    /**
     * Constructor Copia, recibe un objeto Película,
     * crea una copia profunda de la Película pasada por parámetro.
     * @param pelicula Objeto Película a copiar
     */
    public Pelicula(Pelicula pelicula) {
        this(pelicula.getNombre(),pelicula.getCalificacionEdad(),pelicula.getFechaIncorporacionAlCatalogo(),pelicula.isEstaDisponible(),pelicula.director, pelicula.actorPrincipal,pelicula.duracion,pelicula.categoria);
        if (pelicula.votos.size() != 0) {
            this.votos.addAll(pelicula.votos);
        }
    }

    /**
     * Devuelve el Director de la Película
     * @return El Director de la Película
     */
    public String getDirector() {
        return director;
    }

    /**
     * Modifica el Director de la Película
     * Se modificará si el director pasado no este vacío o si solo contiene espacios.
     * @param director El nuevo Director
     */
    public void setDirector(String director) {
        if (!director.isBlank()) {
            this.director = director;
        }
    }

    /**
     * Devuelve el Actor Principal de la Película
     * @return El Actor Principal
     */
    public String getActorPrincipal() {
        return actorPrincipal;
    }

    /**
     * Modifica el Actor Principal de la Película
     * Se modificará si el actor principal pasado no este vacío o contiene solo espacios
     * @param actorPrincipal El nuevo Actor Principal
     */
    public void setActorPrincipal(String actorPrincipal) {
        if (!actorPrincipal.isBlank()) {
            this.actorPrincipal = actorPrincipal;
        }
    }

    /**
     * Devuelve la Duración de la Película
     * @return La Duración de la Película
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * Modifica la Duración de la Película
     * Se modificará si la duración pasa está entre 60 y 240 ambos incluidos
     * @param duracion La nueva Duración
     */
    public void setDuracion(int duracion) {
        if (Utilities.validateRange(duracion,60,241)) {
            this.duracion = duracion;
        }
    }

    /**
     * Devuelve la Categoria de la Película
     * @return La Categoria de la Película
     * @see Tematica
     */
    public Tematica getCategoria() {
        return categoria; // Es inmutable
    }

    /**
     * Modifica la Categoria de la Película
     * @param categoria La nueva Categoria
     * @see Tematica
     */
    public void setCategoria(Tematica categoria) {
        this.categoria = categoria; // Es inmutable
    }

    /**
     * Método para realizar un voto a la Película.
     * El voto debe estar entre 0 y 10 ambos incluidos,
     * si el voto no se encuentra en ese rango devuelve False
     * Si se encuentra en el rango añade el voto y devuelve True
     * @param voto La puntuación de la Película (0 - 10) ambos incluidos
     * @return Devuelve True si se ha realizado el voto y false en caso contrario
     */
    public boolean votar(int voto) {
        boolean votoRealizado = Utilities.validateRange(voto,0,11); // Validamos que sea un voto válido 0 - 10
        if (votoRealizado) votos.add(voto); // Si es válido lo añadimos
        return votoRealizado; // Devolvemos el boolean
    }

    /**
     * Devuelve una representación en forma de String del Objeto Película
     * Muestra el nombre, Calificación de Edad, Fecha de Incorporación al Catálogo, Disponibilidad, Director, Actor Principal, Duración, Categoria, Valoración Media
     * @return Devuelve una cadena de Texto con la información de la Película
     */
    @Override
    public String toString() {
        return "Película " + (super.isEstaDisponible() ? "- Disponible" : "- No Disponible") + "\n" +
                super.toString() + "\n" +
                "Director: " + this.director + "\n" +
                "Actor Principal: " + this.actorPrincipal + "\n" +
                "Duración: " + this.duracion + " minutos" + "\n" +
                "Categoria: " + this.categoria.getNombre() + "\n" +
                "Valoración Media: " + calcularPuntuacion();
    }

    /**
     * Método sobreescrito de la interfaz Valorable
     * Este método retorna la media de la lista de votos.
     * Si no existen votos retorna 0.
     * Si existen calcula y retorna la media de los votos.
     * @return La media del total de votos de la Película
     */
    @Override
    public int calcularPuntuacion() {
        int media = 0;
        int sumaVotos = 0;
        for (Integer voto : votos) {
            sumaVotos += voto;
        }

        if (sumaVotos != 0) {
            media = sumaVotos / votos.size();
        }
        return media;

    }
}
