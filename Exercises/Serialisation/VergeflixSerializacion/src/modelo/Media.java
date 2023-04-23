package modelo;

import Funciones.Utilities;
import java.io.Serializable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase que represente un Medio Audiovisual.
 * Heredan de ella: Pelicula, Serie.
 * Posee valores generales como:
 * <ul>
 *     <li>Nombre: El nombre del Medio Audiovisual (No puede estar vacío o solo con espacios)</li>
 *     <li>Fecha de Incorporación al Catálogo</li>
 *     <li>La disponibilidad del Medio Audiovisual</li>
 * </ul>
 * Implementa la interfaz Valorable y la interfaz Comparable con el tipo de datos Media.
 * <ul>
 *     <li>Valorable: Interfaz que sera implementada en las clases que herede. Calculara la puntuación del Medio Audiovisual</li>
 *     <li>CompareTo: Compara dos objetos Media por orden alfabético y si son idénticos el menor será el que disponga de la Calificación de Edad mas baja </li>
 * </ul>
 * @see Valorable
 * @see Comparable
 * @see Pelicula
 * @see Serie
 */
public abstract class Media implements Comparable<Media>, Valorable, Serializable {
    /**
     * Formato de fecha utilizado para la impresión por pantalla
     */
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    /**
     * Nombre del objeto Multimedia
     */
    private String nombre;
    /**
     * Calificación de Edad del Objeto Multimedia
     */
    private int calificacionEdad;
    /**
     * Fecha de Incorporación al Catálogo del Objeto Multimedia
     */
    private LocalDate fechaIncorporacionAlCatalogo;
    /**
     * La disponibilidad del Medio Audiovisual
     */
    private boolean estaDisponible;

    /**
     * Constructor de la Clase Media, revive Nombre, Calificación Edad, Fecha de Incorporación
     * al catálogo y si está Disponible. Valida que los parámetros sean válidos para crearlo.
     * @param nombre El Nombre del Objeto Multimedia, no debe estar vacío o contener solo espacios en blanco.
     * @param calificacionEdad La Calificación de Edad del Objeto Multimedia, debe de estar entre 0 - 18 ambos incluidos
     * @param fechaIncorporacionAlCatalogo la Fecha de Incorporación al Catálogo del Objeto Multimedia
     * @param estaDisponible Es estado de disponibilidad del Objeto Multimedia
     * @throws IllegalArgumentException Si el nombre está vacío o solo contiene espacios.
     * @throws IllegalArgumentException Si la Calificación de Edad está fuera del rango de 0 - 18 ambos incluidos
     */
    public Media(String nombre, int calificacionEdad, LocalDate fechaIncorporacionAlCatalogo, boolean estaDisponible) {
        if (nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre de la película no puede esta vacío");
        }
        if (calificacionEdad < 0 || calificacionEdad > 18) {
            throw new IllegalArgumentException("El rango de edad debe ser entre 0 - 18, valor insertado: "+calificacionEdad);
        }
        this.nombre = nombre;
        this.calificacionEdad = calificacionEdad;
        this.fechaIncorporacionAlCatalogo = fechaIncorporacionAlCatalogo;
        this.estaDisponible = estaDisponible;
    }

    /**
     * Método que retorna el Nombre del Medio Audiovisual
     * @return El nombre de Medio Audiovisual
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que modifica el Nombre al pasado por parámetro.
     * Se realizará la modificación si el nombre pasado por parámetro no está vacío o contiene solo espacios.
     * @param nombre El nuevo Nombre
     */
    public void setNombre(String nombre) {
        if (!nombre.isBlank()) {
            this.nombre = nombre;
        }
    }

    /**
     * Método que devuelve la Calificación de Edad
     * @return La Calificación de Edad
     */
    public int getCalificacionEdad() {
        return calificacionEdad;
    }

    /**
     * Método que modifica la Calificación de Edad.
     * Se modificará si la nueva Calificación de Edad se encuentra entre 0 - 18 ambos incluidos
     * @param calificacionEdad La nueva Calificación de Edad
     */
    public void setCalificacionEdad(int calificacionEdad) {
        if (Utilities.validateRange(calificacionEdad,0,19)) {
            this.calificacionEdad = calificacionEdad;
        }
    }

    /**
     * Método que devuelve la Fecha de Incorporación al Catálogo
     * @return La Fecha de Incorporación al Catálogo
     */
    public LocalDate getFechaIncorporacionAlCatalogo() {
        return fechaIncorporacionAlCatalogo;
    }

    /**
     * Método que modifica la Fecha de Incorporación al Catálogo
     * @param fechaIncorporacionAlCatalogo La nueva Fecha de Incorporación al Catálogo
     */
    public void setFechaIncorporacionAlCatalogo(LocalDate fechaIncorporacionAlCatalogo) {
        this.fechaIncorporacionAlCatalogo = fechaIncorporacionAlCatalogo;
    }

    /**
     * Método que devuelve la disponibilidad.
     * True si está disponible y False en caso contrario
     * @return La Disponibilidad
     */
    public boolean isEstaDisponible() {
        return estaDisponible;
    }

    /**
     * Método para modificar la Disponibilidad de la Media
     * @param estaDisponible La nueva Disponibilidad, True (Disponible), False (No Disponible)
     */
    public void setEstaDisponible(boolean estaDisponible) {
        this.estaDisponible = estaDisponible;
    }

    /**
     * Método que devuelve una representación en forma de String del Objeto Media
     * @return Una cadena de Texto que contiene: nombre, Calificación de Edad, Fecha de Incorporación al Catálogo  y la disponibilidad
     */
    @Override
    public String toString() {
        return  "Nombre: "+this.nombre + "\n" +
                "Calificación Edad: "+this.calificacionEdad + "\n" +
                "Fecha Incorporación: "+formatter.format(fechaIncorporacionAlCatalogo) + "\n" +
                "Se encuentra disponible: " + (estaDisponible ? "Si" : "No");
    }

    /**
     * Compara si el Objeto dado es igual a esta Media.
     * Se considera que dos objetos son Iguales si es el mismo objeto, o
     * si tienen el mismo Nombre (Ignorando las mayúsculas y minúsculas) y
     * la misma Calificación de Edad.
     * @param obj El objeto que se va a comparar con esta Media
     * @return True si el objeto es igual a esta Media y False en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Media mediaAComparar = (Media) obj;
        return this.nombre.equalsIgnoreCase(mediaAComparar.nombre) && this.calificacionEdad == mediaAComparar.calificacionEdad;
    }


    /**
     * Compara dos Capítulos según su nombre y Calificación de Edad
     * Se ordena alfabéticamente el nombre y si poseen ambos el mismo nombre
     * se ordenaría por la Calificación de edad siendo el menor el que posea la
     * Calificación de Edad más baja
     * @param o El objeto para ser comparado.
     * @return Un valor negativo, cero o positivo si este es anterior, igual o posterior al Capítulo
     * @throws NullPointerException Lanzará la Excepción si el Objeto Media pasado por parámetro es nulo (null).
     */
    @Override
    public int compareTo(Media o) {
        int compare = this.nombre.compareTo(o.nombre);
        if (compare == 0) {
            compare = o.calificacionEdad - this.calificacionEdad;
        }
        return compare;
    }

}
