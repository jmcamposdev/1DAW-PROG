package modelo;

import Funciones.Utilities;
import java.io.Serializable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase que representa una Serie hereda de Media,
 * la serie posee métodos para añadir, modificar, eliminar
 * tanto temporadas como capítulos y se compone de:
 * <ul>
 *     <li>Todos los valores de Media</li>
 *     <li>Fecha de Estreno de la Serie</li>
 *     <li>Una lista de las Temporadas</li>
 * </ul>
 * @see Media
 * @see Temporada
 */
public class Serie extends Media implements Serializable {
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private LocalDate fechaEstreno;
    private final ArrayList<Temporada> temporadas;

    /**
     * Constructor de Serie con los valores de Media más la Fechas de Estreno e inicializa la lista de Temporadas.
     * @param nombre Nombre de la Película (No podrá estar vacío o contener solo espacios)
     * @param calificacionEdad Calificación de Edad (Debe de estar entre 0 - 18 ambos incluidos)
     * @param fechaIncorporacionAlCatalogo Fecha de Incorporación al Catálogo
     * @param estaDisponible La Disponibilidad de la Película
     * @param fechaEstreno La Fecha de Estreno de la Serie
     * @throws IllegalArgumentException Si el Nombre está vacío o contiene solo espacios.
     * @throws IllegalArgumentException Si la Calificación de Edad se encuentra fuera del rango (0 - 18) ambos incluidos.
     */
    public Serie(String nombre, int calificacionEdad, LocalDate fechaIncorporacionAlCatalogo, boolean estaDisponible, LocalDate fechaEstreno) {
        super(nombre, calificacionEdad, fechaIncorporacionAlCatalogo, estaDisponible);
        this.fechaEstreno = fechaEstreno;
        this.temporadas = new ArrayList<>();
    }

    /**
     * Constructor Copia de Serie realiza una Copia profunda de la Serie.
     * Si posee Temporadas se ejecuta una Copia profunda de cada una de ellas.
     * @param serie Objeto Serie a copiar
     */
    public Serie(Serie serie) {
        this(serie.getNombre(),serie.getCalificacionEdad(),serie.getFechaIncorporacionAlCatalogo(), serie.isEstaDisponible(),serie.fechaEstreno);
        for (Temporada temporada : serie.temporadas) {
            this.temporadas.add(new Temporada(temporada));
        }
    }

    /**
     * Método que devuelve una copia profunda de la temporada situada en "nTemporada"
     * El "nTemporada" se debe de encontrar entre (0 - temporadas.size()-1).
     * @param nTemporada La posición de la Temporada
     * @return Devuelve la Temporada si la posición es válida en caso contrario devuelve null
     */
    public Temporada getCopiaTemporada(int nTemporada) {
        Temporada temporadaARetornar = null;
        if (Utilities.validateRange(nTemporada,0,temporadas.size())) {
            temporadaARetornar = new Temporada(temporadas.get(nTemporada));
        }
        return temporadaARetornar;
    }

    /**
     * Devuelve la Fecha de Estreno de la Serie
     * @return Devuelve la Fecha de Estreno de la Serie
     */
    public LocalDate getFechaEstreno () {
        return this.fechaEstreno;
    }

    /**
     * Método que modifica la Fecha de Estreno de la Serie.
     * Se modificará si la Fecha de Estreno pasada por Parámetro
     * es anterior o igual a la fecha de la Primera Temporada.
     * @param fechaEstreno La nueva Fecha de Estreno
     * @return Devuelve True si se ha realizado la modificación y False en caso contrario.
     */
    public boolean setFechaEstreno(LocalDate fechaEstreno) {
        boolean cambioRealizado = false;
        LocalDate primeraFechaTemporada = temporadas.isEmpty() ? null : temporadas.get(0).getFechaEstreno();
        if (primeraFechaTemporada == null || fechaEstreno.isBefore(primeraFechaTemporada) || fechaEstreno.equals(primeraFechaTemporada)) {
            this.fechaEstreno = fechaEstreno;
            cambioRealizado = true;
        }
        return cambioRealizado;
    }

    /**
     * Método que modifica la Fecha de Estreno de una Temporada.
     * La posición se debe de encontrar entre (0 - temporadas.size()-1).
     * Y la Fecha de Estreno debe de ser posterior o igual a la Fecha de Estreno de la Serie y
     * que en el mes de la Fecha de Estreno pasada no exista ninguna otra Temporada y
     * además la Fecha de Estreno de la Temporada debe de ser anterior o igual a la Fecha de Emisión
     * del primer capítulo si la Temporada no posee capítulos se añade directamente
     * @param posicion La posición de la Temporada. Debe de encontrarse entre (0  temporadas.size()-1)
     * @param fechaEstreno La nueva Fecha de Estreno de la Temporada debe de ser posterior o igual a la
     *                      Fecha de Estreno de la Serie, no debe de existir otra temporada en el mismo
     *                     mes y la fecha debe de ser anterior o igual a la Fecha de Emision del Primer Capítulo
     *                     si la Temporada no posee capítulos saltamos esta validación.
     * @return Devuelve True si se ha realizado la modificación y false en caso contrario.
     */
    public boolean setFechaEstrenoTemporada (int posicion, LocalDate fechaEstreno) {
        boolean esValido = validarNuevaFechaEstrenoTemporada(posicion, fechaEstreno);
        if (esValido) {
            temporadas.get(posicion).setFechaEstreno(fechaEstreno);
            Collections.sort(temporadas);
        }
        return esValido;
    }


    /**
     * Método para añadir una nueva Temporada con la Fecha de Estreno.
     * Se comprobará que no exista otra temporada el mismo mes y
     * que la Fecha de la Temporada sea posterior o igual a la Fecha de estreno de la Serie.
     * @param fechaEstreno La Fecha de Estreno de la Temporada
     * @return Devolverá True si se ha añadido y False en caso contrario.
     */
    public boolean añadirTemporada (LocalDate fechaEstreno) {
        return añadirTemporada(new Temporada(fechaEstreno));
    }

    /**
     * Método que añade una temporada a la Lista de Temporadas
     * Se validara que no haya dos temporadas el mismo mes
     * Y que la fecha de la Temporada sea posterior o igual a la Fecha de Estreno de la Serie.
     * @param temporada Temporada para añadir
     * @return Devolverá True si se ha añadido la temporada y False en caso contrario
     */
    public boolean añadirTemporada (Temporada temporada) {
        boolean esValida = validarTemporada(temporada.getFechaEstreno());
        if (esValida) {
            temporadas.add(new Temporada(temporada));
            Collections.sort(temporadas);
        }
        return esValida;
    }

    /**
     * Método para eliminar una Temporada situada en la posición "n".
     * La posición se debe de encontrar entre (0 - temporadas.size()-1)
     * @param n La posición de la Temporada a eliminar
     * @return Devolverá True si se ha eliminado la Temporada y False en caso contrario
     */
    public boolean eliminarTemporada (int n) {
        boolean posicionValida = Utilities.validateRange(n,0,temporadas.size());
        if (posicionValida) {
            temporadas.remove(n);
        }
        return posicionValida;
    }

    /**
     * Método para añadir un Capítulo a una Temporada.
     * La "nTemporada" se debe de encontrar entre (0 - temporadas.size()-1).
     * Del Capítulo se validará que no exista otro Capítulo con el mismo nombre en la Temporada y
     * que la Fecha de Emisión del Capítulo sea posterior o Igual a la Fecha de Estreno de la Temporada
     * @param nTemporada La posición de la Temporada a la cual se le añadirá el Capítulo
     * @param capitulo El Capítulo que se añadirá
     * @return Devolverá True si se ha añadido el Capítulo a la Temporada y False en caso contrario.
     */
    public boolean añadirCapitulo(int nTemporada, Capitulo capitulo) {
        return Utilities.validateRange(nTemporada,0,temporadas.size()) && temporadas.get(nTemporada).añadirCapitulo(capitulo);
    }

    /**
     * Método que creará y añadirá un nuevo Capítulo a una Temporada.
     * La "nTemporada" se debe de encontrar entre (0 - temporadas.size()-1).
     * El Título no debe de existir en los Capítulos de la Temporada (Debe ser único).
     * La Fecha de Emisión debe de ser posterior o igual a la Fecha de Estreno de la Temporada.
     * @param nTemporada La posición de la Temporada a la cual se le añadirá el nuevo Capítulo
     * @param fechaEmision La Fecha de Emisión del Capítulo
     * @param titulo El Título del Capítulo.
     * @return Devolverá True si se ha añadido el Capítulo a la Temporada y False en caso contrario
     */
    public boolean añadirCapitulo(int nTemporada, LocalDate fechaEmision, String titulo) {
        return Utilities.validateRange(nTemporada,0,temporadas.size()) && temporadas.get(nTemporada).añadirCapitulo(fechaEmision, titulo);
    }

    /**
     * Método que creará y añadirá un nuevo Capítulo a una Temporada.
     * La "nTemporada" se debe de encontrar entre (0 - temporadas.size()-1).
     * La "posicion" se debe de encontrar entre (0 - capitulos.size()-1) la lista de Capítulos de Temporada
     * Del Capítulo se validará que no exista otro Capítulo con el mismo nombre en la Temporada y
     * que la Fecha de Emisión del Capítulo sea posterior o Igual a la Fecha de Estreno de la Temporada
     * @param nTemporada La posición de la Temporada a la cual se le añadirá el nuevo Capítulo
     * @param posicion La posición de inserción del nuevo Capítulo a la Temporada
     * @param capitulo El capítulo que se añadirá a la Temporada
     * @return Devolverá True si se ha añadido el Capítulo a la Temporada y False en caso contrario
     */
    public boolean añadirCapitulo(int nTemporada, int posicion, Capitulo capitulo) {
        return Utilities.validateRange(nTemporada,0,temporadas.size()) && temporadas.get(nTemporada).añadirCapitulo(posicion,capitulo);
    }

    /**
     * Método que creará y añadirá un nuevo Capítulo a una Temporada.
     * La "nTemporada" se debe de encontrar entre (0 - temporadas.size()-1).
     * La "posicion" se debe de encontrar entre (0 - capitulos.size()-1) la lista de Capítulos de Temporada
     * El Título no debe de existir en los Capítulos de la Temporada (Debe ser único).
     * La Fecha de Emisión debe de ser posterior o igual a la Fecha de Estreno de la Temporada.
     * @param nTemporada La posición de la Temporada a la cual se le añadirá el nuevo Capitulo
     * @param posicion La posición de inserción del nuevo Capítulo
     * @param fechaEmision La Fecha de Emisión del Capítulo
     * @param titulo El Título del Capítulo
     * @return Devolverá True si se ha añadido el Capítulo a la Temporada y False en caso contrario
     */
    public boolean añadirCapitulo(int nTemporada, int posicion, LocalDate fechaEmision, String titulo) {
        return Utilities.validateRange(nTemporada,0,temporadas.size()) && temporadas.get(nTemporada).añadirCapitulo(posicion, fechaEmision, titulo);
    }

    /**
     * Método que elimina un Capítulo de una Temporada basándose en el Título.
     * El "nTemporada" debera estar entre (0 - temporadas.size()-1).
     * @param nTemporada La posición de la Temporada.
     * @param titulo El Título del Capítulo que se desea eliminar. No debe estar vacío o contener solo espacios
     * @return Devuelve True si ha eliminado el Capítulo y false en caso contrario
     */
    public boolean eliminarCapitulo(int nTemporada, String titulo) {
        // Validamos que esté en el rango que no este vacío y por último probamos a eliminar el capítulo
        return Utilities.validateRange(nTemporada,0,temporadas.size()) && Utilities.validateNotEmptyString(titulo) && temporadas.get(nTemporada).eliminarCapitulo(titulo);
    }

    /**
     * Método que eliminará todos los Capítulos de todas las temporadas,
     * que concuerden con la Expresión Regular
     * @param expresionRegular La Expresión Regular
     * @return Devuelve el número de Capítulos eliminados, si no elimina ninguno devuelve 0.
     * @throws NullPointerException Lanzará la Excepción si el String pasado en null.
     * @throws java.util.regex.PatternSyntaxException Lanzará la Excepción si la expresión regular pasada es errónea
     */
    public int eliminarCapitulos(String expresionRegular) {
        int capitulosEliminados = 0;
        for (Temporada temporada : temporadas) {
            capitulosEliminados += temporada.eliminarCapitulos(expresionRegular);
        }
        return capitulosEliminados;
    }

    /**
     * Método que devuelve una copia profunda de un Capítulo en una Temporada.
     * Se devolverá el Capítulo si el "nTemporada" se sitúa en el rango de (0 - temporadas.size()-1) y
     * si el capítulo se sitúa entre (0 - capitulos.size()-1) de la Temporada.
     * @param nTemporada La posición de la Temporada
     * @param posicion La posición del Capítulo en la Temporada
     * @return Devolverá una copia profunda siempre que exista el capítulo y la temporada sino no existen
     * alguno de ellos devolverá null.
     */
    public Capitulo getCapitulo(int nTemporada, int posicion) {
        Capitulo capituloADevolver = null;
        if (Utilities.validateRange(nTemporada,0,temporadas.size())) {
            capituloADevolver = temporadas.get(nTemporada).getCapitulo(posicion);
        }
        return capituloADevolver;
    }

    /**
     * Método para modificar el Título y la Fecha de Emisión de un Capítulo.
     * La "nTemporada" debera estar entre (0 - temporadas.size()-1).
     * La "posicion" debera estar entre (0 - capitulos.size()-1).
     * El Título no debera estar vacío o con solo espacios y no debera existir otro
     * capítulo con el mismo Título.
     * La fecha de Emisión debera de ser posterior o igual a la Fecha de Estreno de la Temporada.
     * @param nTemporada La posición de la Temporada
     * @param posicion La posición del Capítulo en la Temporada
     * @param fechaEmision La nueva Fecha de Emisión
     * @param titulo El nuevo Título del Capítulo
     * @return Devolverá True si se ha realizado la modificación y False en caso contrario.
     */
    public boolean setCapitulo(int nTemporada, int posicion, LocalDate fechaEmision, String titulo) {
        return Utilities.validateRange(nTemporada,0,temporadas.size()) && temporadas.get(nTemporada).setCapitulo(posicion,fechaEmision,titulo);
    }

    /**
     * Método para modificar la Fecha de Emisión de un Capítulo.
     * La "nTemporada" debera estar entre (0 - temporadas.size()-1).
     * La "posicion" debera estar entre (0 - capitulos.size()-1).
     * capítulo con el mismo Título.
     * La fecha de Emisión debera de ser posterior o igual a la Fecha de Estreno de la Temporada.
     * @param nTemporada La posición de la Temporada
     * @param posicion La posición del Capítulo en la Temporada
     * @param fechaEmision La nueva Fecha de Emisión
     * @return Devolverá True si se ha realizado la modificación y False en caso contrario.
     */
    public boolean setCapitulo(int nTemporada, int posicion, LocalDate fechaEmision) {
        return Utilities.validateRange(nTemporada,0,temporadas.size()) && temporadas.get(nTemporada).setCapitulo(posicion,fechaEmision) ;
    }

    /**
     * Método para modificar el Título de un Capítulo.
     * La "nTemporada" debera estar entre (0 - temporadas.size()-1).
     * La "posicion" debera estar entre (0 - capitulos.size()-1).
     * El Título no debera estar vacío o con solo espacios y no debera existir otro
     * capítulo con el mismo Título.
     * @param nTemporada La posición de la Temporada
     * @param posicion La posición del Capítulo en la Temporada
     * @param titulo El nuevo Título del Capítulo
     * @return Devolverá True si se ha realizado la modificación y False en caso contrario.
     */
    public boolean setCapitulo(int nTemporada, int posicion, String titulo) {
        return Utilities.validateRange(nTemporada,0,temporadas.size()) && temporadas.get(nTemporada).setCapitulo(posicion,titulo);
    }

    /**
     * Método que añade un voto positivo o negativo (dependiendo del booleano like)
     * al capítulo de la Temporada y situado en esa posición.
     * El "nTemporada" debera de estar entre (0 - temporadas.size()-1)
     * La "posicionCapitulo" debera de estar entre (0 - capitulos.size()-1) de la temporada
     * @param nTemporada La posición de la Temporada
     * @param posicionCapitulo La posición del Capítulo en la Temporada
     * @param like El voto (Positivo = true) y (Negativo = false)
     * @return Devuelve si se ha realizado el voto correctamente o False en caso contrario
     */
    public boolean meGusta(int nTemporada, int posicionCapitulo, boolean like) {
        return Utilities.validateRange(nTemporada,0,temporadas.size()) && temporadas.get(nTemporada).meGusta(posicionCapitulo, like);
    }
    /**
     * Método que añade un voto positivo o negativo (dependiendo del booleano like)
     * al capítulo de la Temporada que contenga el mismo Título que el pasado por parámetro.
     * El "nTemporada" debera de estar entre (0 - temporadas.size()-1)
     * El "titulo" debera ser igual a algún Título de un Capítulo existente.
     * @param nTemporada La posición de la Temporada
     * @param titulo El Título del Capítulo que se desea dar un voto
     * @param like El voto (Positivo = true) y (Negativo = false)
     * @return Devuelve si se ha realizado el voto correctamente o False en caso contrario
     */
    public boolean meGusta(int nTemporada, String titulo, boolean like) {
        return Utilities.validateRange(nTemporada,0,temporadas.size()) && temporadas.get(nTemporada).meGusta(titulo, like);
    }




    /*------------------------
       MÉTODOS PROPIOS
    -----------------------*/
    private boolean validarTemporada(LocalDate fechaEstreno) {
        boolean temporadaValida = Utilities.validateLocaDateIsAfterOrEquals(fechaEstreno,this.fechaEstreno);
        for (int i = 0; i < temporadas.size() && temporadaValida; i++) {
            if (temporadas.get(i).getFechaEstreno().getMonthValue() == fechaEstreno.getMonthValue() && temporadas.get(i).getFechaEstreno().getYear() == fechaEstreno.getYear()) {
                temporadaValida = false;
            }
        }
        return temporadaValida;
    }
    //
    private boolean validarNuevaFechaEstrenoTemporada (int posicion, LocalDate fechaEstreno) {
        boolean cambioRealizado = false;
        // Validamos que la posición de la Temporada sea Correcta y que La nueva Fecha de Estreno sea Posterior o igual a la Serie
        boolean esValido = Utilities.validateRange(posicion,0,temporadas.size()) && Utilities.validateLocaDateIsAfterOrEquals(fechaEstreno,this.fechaEstreno);
        if (esValido) {
            // Verificamos si la nueva Fecha de Estreno está en el mismo mes
            boolean esMismoMesYAño =  temporadas.get(posicion).getFechaEstreno().getMonthValue() == fechaEstreno.getMonthValue() && temporadas.get(posicion).getFechaEstreno().getYear() == fechaEstreno.getYear();
            // Obtenemos el Primer Capítulo sino posee capítulos devuelve null
            Capitulo primerCapitulo = temporadas.get(posicion).getCapitulo(0);
            // Obtenemos la Fecha de Emisión del Capítulo sino existen capítulos devuelve null
            LocalDate primeraFechaCapituloDeTemporada = primerCapitulo == null ? null : primerCapitulo.getFechaEmision();
            /*  Validamos si la nueva Fecha es válida para la Temporada
                Debe de ser nula (significa que no existen Capítulos) o
                si no debe ser anterior o igual a la Fecha de Emisión del Primer Capítulo */
            boolean nuevaFechaEsValida = primeraFechaCapituloDeTemporada == null || fechaEstreno.isBefore(primeraFechaCapituloDeTemporada) || fechaEstreno.equals(primeraFechaCapituloDeTemporada);
            // Si está en el mismo mes y es valida la Fecha para la Temporada la actualizamos
            if (esMismoMesYAño && nuevaFechaEsValida) {
                temporadas.get(posicion).setFechaEstreno(fechaEstreno);
                cambioRealizado = true;
            } else if (nuevaFechaEsValida){ // Si no está en el mismo mes
                esValido = validarTemporada(fechaEstreno); // Validamos que la nueva Fecha sea válida (No exista otra en el mismo mes)
                if (esValido) { // Si no existe otra en el mismo mes la actualizamos
                    temporadas.get(posicion).setFechaEstreno(fechaEstreno);
                    cambioRealizado = true;
                }
            }
        }

        return cambioRealizado;
    }

     /**
     * Devuelve una representación en forma de String del Objeto Serie
     * Muestra la nombre, Calificación de Edad, Disponibilidad, Fecha de Incorporación al Catálogo,
      * Fecha de Estreno, listado de las temporadas.
     * @return Devuelve una cadena de texto con la información de la Serie
     */
    @Override
    public String toString() {
        StringBuilder serieString = new StringBuilder();
        serieString.append("Serie ");
        serieString.append("\n");
        serieString.append(super.toString()).append("\n");
        serieString.append("Fecha de Estreno: ").append(formatter.format(this.fechaEstreno)).append("\n");
        if (this.temporadas.isEmpty()) {
            serieString.append("Esta Serie no posee Temporadas todavía");
        } else {
            int counter = 1;
            for (Temporada temporada:  this.temporadas) {
                serieString.append(counter++).append(". Temporada: ").append("Fecha de Estreno: ").append(formatter.format(temporada.getFechaEstreno())).append("\n");
            }
        }
        return serieString.toString();
    }

    /**
     * Método implementado por la interfaz Valorable
     * Calcula la puntuación con base en la media de la
     * valoración de todas sus temporadas.
     * @return La puntuación de la Serie si no posee temporadas retorna 0.
     * @see Valorable
     */
    @Override
    public int calcularPuntuacion() {
        int media = 0;
        int valoracionTemporadas = 0;
        for (Temporada temporada : temporadas) {
            valoracionTemporadas += temporada.calcularPuntuacion();
        }
        if (valoracionTemporadas != 0) {
            media = valoracionTemporadas / temporadas.size();
        }
        return media;
    }
}
