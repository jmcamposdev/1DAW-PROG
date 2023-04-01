package vergeflix;

import Funciones.Utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase que representa un Capítulo de una Temporada.
 * Se compone de:
 * <ul>
 *     <li>Título del Capítulo (No puede estar vacío o solo con espacios)</li>
 *     <li>Fecha de Emisión del Capítulo</li>
 *     <li>Votos Positivos: Cantidad de votos positivos obtenidos por el capítulo.</li>
 *     <li>Votos Negativos: Cantidad de votos negativos obtenidos por el capítulo.</li>
 * </ul>
 * Implementa la interfaz Valorable y Comparable
 * <ul>
 *     <li>Valorable: Usada para calcular la puntuación del Capítulo.</li>
 *     <li>Comparable: Usada para comprara dos objetos según su Fecha de Emisión.</li>
 * </ul>
 */
public class Capitulo implements Valorable, Comparable<Capitulo> {
    /**
     * Formato para la fecha de Emisión
     */
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    /**
     * Cantidad de votos Positivos
     */
    private int votosPositivos;
    /**
     * Cantidad de votos Negativos
     */
    private int votosNegativos;
    /**
     * Título del Capítulo
     */
    private String titulo;
    /**
     * Fecha de Emisión del Capítulo
     */
    private LocalDate fechaEmision;

    /**
     * Crea un nuevo objeto Capitulo con el título y la fecha de emisión especificados.
     * @param titulo El Título del Capítulo. No puede estar vacío o contener solo espacios.
     * @param fechaEmision La Fecha de Emisión del Capítulo.
     * @throws IllegalArgumentException Si el Título está vacío o solo contiene espacios en blanco
     */
    public Capitulo(String titulo, LocalDate fechaEmision) {
        if (!Utilities.validateNotEmptyString(titulo)) {
            throw new IllegalArgumentException("El titulo del Capitulo no puede estar vacío o contener solo espacios en blanco");
        }
        this.titulo = titulo;
        this.fechaEmision = fechaEmision;
    }

    /**
     * Constructor Copia de la clase Capítulo. Recibe un objeto Capítulo
     * y crea una copia profunda del Capítulo pasado por parámetro.
     * @param capitulo Objeto Capítulo a Copiar.
     */
    public Capitulo(Capitulo capitulo) {
        this(capitulo.titulo,capitulo.fechaEmision);
        this.votosPositivos = capitulo.votosPositivos;
        this.votosNegativos = capitulo.votosNegativos;
    }

    /**
     * Retorna la cantidad de votos Positivos
     * @return La cantidad de votos Positivos
     */
    public int getVotosPositivos() {
        return votosPositivos;
    }

    /**
     * Retorna la cantidad de votos Negativos
     * @return La cantidad de Votos Negativos
     */
    public int getVotosNegativos() {
        return votosNegativos;
    }

    /**
     * Retorna el Título del Capítulo
     * @return El Título del Capítulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el Título del Capítulo.
     * Solo cambia el Título cuando no este vacío o contenga solo espacios en blanco.
     * @param titulo El nuevo Título del Capítulo
     */
    public void setTitulo(String titulo) {
        if (Utilities.validateNotEmptyString(titulo)) {
            this.titulo = titulo;
        }
    }

    /**
     * Retorna la Fecha de Emisión del Capítulo
     * @return La Fecha de Emisión del Capítulo
     */
    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    /**
     * Establece la Fecha de Emisión del Capítulo
     * @param fechaEmision La Fecha de Emisión del Capítulo
     */
    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    /**
     * Incrementa el contador de votos Positivos (true) o Negativos (false) del Capítulo,
     * dependiendo el valor del parámetro.
     * @param like Indica si el usuario le ha dado "Me Gusta" (true) o "No Me Gusta" (false) al Capítulo
     */
    public void meGusta (boolean like) {
        if (like) votosPositivos++; else votosNegativos++;
    }

    /**
     * Devuelve una representación en forma de String del Objeto Capítulo
     * @return Una cadena de Texto que contiene el Título, Fecha de Emisión, Votos Positivos y Negativos del Capítulo
     */
    @Override
    public String toString() {
        return "Capitulo: "+this.titulo + "\n" +
                "Fecha de Emisión: " + formatter.format(this.fechaEmision) + "\n" +
                "Votos Positivos: " + this.votosPositivos + "\n" +
                "Votos Negativos: " + this.votosNegativos;
    }

    /**
     * Compara si el Objeto dado es igual a este Capítulo.
     * Se considera que dos objetos son Iguales si es el mismo objeto
     * o si tiene el mismo Título (Ignorando las mayúsculas y minúsculas)
     * @param obj El objeto que se va a comparar con este Capítulo
     * @return True si el objeto es igual a este Capítulo y False en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Capitulo capituloAComparar = (Capitulo) obj;
        return this.titulo.equalsIgnoreCase(capituloAComparar.titulo);
    }

    /**
     * Método sobreescrito de la interfaz Valorable
     * Calcula la puntuación del Capítulo basada en los Votos Positivos y Negativos.
     * Se calcula como el porcentaje de Votos Positivos sobre el total de votos.
     * @return La puntuación del Capítulo como un entero entre 0 y 10, inclusive
     * @see Valorable
     */
    @Override
    public int calcularPuntuacion() {
        double votosTotales = this.votosPositivos + this.votosNegativos;
        double puntuacion = 0;
        if (votosTotales != 0) {
            puntuacion = this.votosPositivos / votosTotales;
        }
        return (int) (puntuacion * 10);
    }

    /**
     * Compara dos Capítulos según su Fecha de Emisión
     * Sirve para ordenar según la Fecha de Emisión de más Antiguo a más Actual
     * @param o El objeto para ser comparado.
     * @return Un valor negativo, cero o positivo si este es anterior, igual o posterior al Capítulo
     */
    @Override
    public int compareTo(Capitulo o) {
        return this.getFechaEmision().compareTo(o.fechaEmision);
    }
}
