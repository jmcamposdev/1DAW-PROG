package vergeflix;

import Funciones.Utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Modela una Temporada de una Serie.
 * Se compone de:
 * <ul>
 *     <li>Fecha de Estreno de la Temporada</li>
 *     <li>Una lista de los Capítulos</li>
 * </ul>
 * Implementa las interfaces Valorable y Comparable:
 * <ul>
 *     <li>Valorable: Calcula la puntuación de la Temporada en base a media de
 *     la valoración de todos sus Capítulos. Si no posee Capítulos devuelve 0.</li>
 *     <li>Comparable: Compara dos temporadas en base a la Fecha de Estreno en un orden
 *     de mas antiguos primero y los mas nuevos últimos.
 *     </li>
 * </ul>
 * @see Capitulo
 */
public class Temporada implements Valorable, Comparable<Temporada>{
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private LocalDate fechaEstreno;
    private final ArrayList<Capitulo> capitulos;

    /**
     * Constructor de Temporada crea una nueva Temporada.
     * Con los valores de Fecha de Estreno pasados por parámetro
     * e inicializa la lista de Capítulos
     * @param fechaEstreno La Fecha de Estreno de la Temporada
     */
    public Temporada(LocalDate fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
        this.capitulos = new ArrayList<>();
    }

    /**
     * Constructor Copia recibe una Temporada y realiza una copia profunda de ella.
     * Inicializa la lista de Capítulos y si posee Capítulos realiza una copia profunda de cada Capítulo
     * @param temporada Objeto Temporada a Copiar
     */
    public Temporada(Temporada temporada) {
        this(temporada.fechaEstreno);
        for (Capitulo capitulo : temporada.capitulos) {
            this.capitulos.add(new Capitulo(capitulo));
        }
    }

    /**
     * Devuelve la Fecha de Estreno de la Temporada
     * @return La Fecha de Estreno de la Temporada
     */
    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    /**
     * Modifica la Fecha de Estreno de la Temporada.
     * Se realizará la modificación si la Fecha de Estreno
     * es anterior o igual a la Fecha de Emisión del primer capítulo de la Temporada.
     * Si no posee Capítulos se le asignará directamente.
     * @param fechaEstreno La nueva Fecha de Estreno de la Temporada
     */
    public void setFechaEstreno(LocalDate fechaEstreno) {
        LocalDate primeraFechaCapitulo = capitulos.isEmpty() ? null : capitulos.get(0).getFechaEmision();
        if (primeraFechaCapitulo == null || Utilities.validateLocaDateIsAfterOrEquals(primeraFechaCapitulo, fechaEstreno)) {
            this.fechaEstreno = fechaEstreno;
        }
    }

    /**
     * Método que añade un nuevo Capítulo a la Temporada.
     * Lo añade si la fecha de Emisión es posterior o igual
     * a la Fecha de estreno de la Temporada. Y si no existe
     * otro Capítulo con el mismo Título
     * @param capitulo El nuevo Capítulo a añadir a la Temporada
     * @return Devuelve True si se ha añadido y False en caso contrario
     */
    public boolean añadirCapitulo(Capitulo capitulo) {
        return añadirCapitulo(capitulos.size(), capitulo.getFechaEmision(), capitulo.getTitulo());
    }

    /**
     * Método que crea y añade un nuevo Capítulo a la Temporada.
     * Lo añade si la fecha de Emisión es posterior o igual
     * a la Fecha de estreno de la Temporada. Y si no existe
     * otro Capítulo con el mismo Título
     * @param fechaEmision La fecha de Emisión del nuevo Capítulo. Debe de ser posterior o igual a la Fecha de Estreno de la Temporada
     * @param titulo El Título del nuevo Capítulo. No debe estar vacío o contener solo espacios
     * @return Devuelve True si se ha añadido y False en caso contrario.
     */
    public boolean añadirCapitulo(LocalDate fechaEmision, String titulo) {
        return añadirCapitulo(capitulos.size(), fechaEmision, titulo);
    }

    /**
     * Método que añade un nuevo Capítulo a la Temporada.
     * Lo añade en una posición indicada.
     * Se añadirá si la posición es válida (0 - capitulos.size()) ambos incluidos,
     * si la Fecha de Emisión es posterior o igual a la Fecha de Estreno de la Temporada
     * y si no existe otro Capítulo con el mismo Título
     * @param posicion La posición de inserción del Capítulo en la Lista. Debe de estar entre (0 - capitulos-size())
     * @param capitulo El nuevo Capítulo a Añadir.
     * @return Devuelve True si se ha añadido y False en caso contrario.
     */
    public boolean añadirCapitulo (int posicion, Capitulo capitulo) {
        return añadirCapitulo(posicion, capitulo.getFechaEmision(), capitulo.getTitulo());
    }

    /**
     * Método que crea y añade un nuevo Capítulo a la Temporada.
     * Lo añade en la posición indicada.
     * Se añadirá si la posición es válida (0 - capitulos.size()) ambos incluidos,
     * si la Fecha de Emisión es posterior o igual a la Fecha de Estreno de la Temporada
     * y si no existe otro Capítulo con el mismo Título
     * @param posicion La posición de inserción del Capítulo a la Lista. Debe de estar entre (0 - capitulos-size())
     * @param fechaEmision La Fecha de Emisión del Capítulo.  Debe de ser posterior o igual a la Fecha de Estreno de la Temporada
     * @param titulo El Título del Capítulo. No debe estar vacío o contener solo espacios
     * @return Devuelve True si se ha añadido y False en caso contrario
     */
    public boolean añadirCapitulo(int posicion, LocalDate fechaEmision, String titulo) {
        boolean esValido = Utilities.validateRange(posicion,0,capitulos.size()+1) && validarCapitulo(titulo,fechaEmision);
        if (esValido) {
            capitulos.add(posicion,new Capitulo(titulo, fechaEmision));
            Collections.sort(capitulos); // Ordenamos por Fecha de Emisión (Antiguos antes y nuevos los últimos)
        }
        return esValido;
    }

    /**
     * Método que elimina un Capítulo.
     * Eliminará un Capítulo si encuentra un Capítulo con el mismo Título (Ignorando Mayúsculas y Minúsculas).
     * @param titulo El Título del Capítulo a Eliminar.
     * @return Devuelve True si lo ha eliminado y False en caso contrario (No encontrarlo).
     */
    public boolean eliminarCapitulo(String titulo) {
        return capitulos.removeIf(n -> n.getTitulo().equalsIgnoreCase(titulo));
    }

    /**
     * Método para eliminar Capítulos por Expresiones Regulares.
     * Eliminará tantos Capítulos que concuerden con la Expresión.
     * @param expresionRegular Expresión Regular para eliminar los Capítulos.
     * @return Devuelve el número de Capítulos eliminados, si no ha eliminado ninguno devuelve 0.
     * @throws NullPointerException Lanzará la Excepción si el String pasado en null.
     */
    public int eliminarCapitulos(String expresionRegular) {
        boolean expresiónValida = true;
        int capitulosEliminados = 0; // Almacenamos el número de capitulos eliminados
        Pattern pattern = null;
        try {
            pattern = Pattern.compile(expresionRegular); // Creamos el Pattern de la regex
        } catch (PatternSyntaxException e) {
            expresiónValida = false;
        }

        if (expresiónValida) {
            Iterator <Capitulo> it = capitulos.iterator(); // Creamos un iterator para iterar el arrayList

            while (it.hasNext()) { // Iteramos mientras exista elementos en el Iterator
                Capitulo capitulo = it.next(); // Creamos el objeto Capítulo
                // Se puede usar sin el objeto, pero es más legible creándolo
                if (pattern.matcher(capitulo.getTitulo()).find()) { // Comprobamos que concuerde con la expresión regular
                    it.remove(); // Removemos el objeto
                    capitulosEliminados++; // Sumamos los objetos eliminados
                }
            }
        }

        return capitulosEliminados;
    }

    /**
     * Método que devuelve una copia profunda del Capítulo
     * que se encuentre en la posición indicada.
     * Si no encuentra el Capítulo devolverá null
     * @param posicion La posición del Capítulo deseado. Debe de estar entre (0 - capitulos-size()-1)
     * @return Devolverá el Capítulo si la posición es válida (0 - capitulos.size-1) en caso de no encontrarlo devolverá null
     */
    public Capitulo getCapitulo(int posicion) {
        Capitulo capituloADevolver = null;
        if (Utilities.validateRange(posicion,0,capitulos.size())) {
            capituloADevolver = new Capitulo(capitulos.get(posicion));
        }
        return capituloADevolver;
    }

    /**
     * Método que modificará la Fecha de Emisión y el Título del capítulo en la posición indicada.
     * Se realizará la modificación si la posición se encuentra entre (0 - capitulos.size-1),
     * si la Fecha de Emisión es posterior o igual a la Fecha de Estreno de la Temporada y si
     * el Título no está en los Capítulos.
     * @param posicion Posición del Capítulo a modificar. Debe de estar entre (0 - capitulos-size()-1)
     * @param fechaEmision La nueva Fecha de Emisión del Capítulo. Debe de ser posterior o igual a la Fecha de Estreno de la Temporada
     * @param titulo El nuevo Título del Capítulo. No debe estar vacío o contener solo espacios en blanco
     * @return Devolverá True si se ha realizado la modificación y False en caso contrario.
     */
    public boolean setCapitulo(int posicion, LocalDate fechaEmision, String titulo) {
        boolean esValido = validarCapitulo(titulo, fechaEmision) && Utilities.validateRange(posicion,0,capitulos.size());
        if (esValido) {
            capitulos.get(posicion).setTitulo(titulo);
            capitulos.get(posicion).setFechaEmision(fechaEmision);
            Collections.sort(capitulos);
        }
        return esValido;
    }

    /**
     * Método que modificará la Fecha de Emisión del capítulo situado en "posicion".
     * Se realizará la modificación si la posicion se encuentra entre (0 - capitulos.size-1) y
     * si la Fecha de Emisión es posterior o igual a la
     * Fecha de Estreno de la Temporada.
     * @param posicion Posición del Capítulo a modificar. Debe de estar entre (0 - capitulos-size()-1)
     * @param fechaEmision La nueva Fecha de Emisión del Capítulo. Debe de ser posterior o igual a la Fecha de Estreno de la Temporada
     * @return Devolverá True si se ha realizado la modificación y False en caso contrario.
     */
    public boolean setCapitulo(int posicion, LocalDate fechaEmision) {
        boolean esValido = Utilities.validateLocaDateIsAfterOrEquals(fechaEmision, this.fechaEstreno) && Utilities.validateRange(posicion,0,capitulos.size());
        if (esValido) {
            capitulos.get(posicion).setFechaEmision(fechaEmision);
            Collections.sort(capitulos);
        }

        return esValido;
    }

    /**
     * Método que modificará el Título del Capítulo situado en "posicion".
     * Se realizará la modificación si no existe otro Capítulo con el mismo Título y
     * la posicion se encuentra entre (0 - capitulos.size()).
     * @param posicion La posición del Capítulo a Modificar. Debe de estar entre (0 - capitulos-size()-1)
     * @param titulo El nuevo Título del Capítulo. No debe de estar vacío o contener solo espacios
     * @return Devolverá True si se ha realizado la modificación y False en caso contrario.
     */
    public boolean setCapitulo(int posicion, String titulo) {
        boolean esValido = Utilities.validateRange(posicion,0,capitulos.size()) && validarCapitulo(titulo,capitulos.get(posicion).getFechaEmision());
        if (esValido) {
            capitulos.get(posicion).setTitulo(titulo);
        }
        return esValido;
    }

    /**
     * Método que añade si es posible, un voto positivo o negativo (dependiendo del booleano like) al
     * Capítulo situado en "posicionCapitulo".
     * La posición debe de estar entre (0 - capitulos.size).
     * @param posicionCapitulo La posicion del Capítulo a modificar. Debe de estar entre (0 - capitulos-size()-1)
     * @param like El voto positivo o negativo (Positivo = true), (Negativo = false).
     * @return Devuelve True si ha realizado el voto y False en caso contrario.
     */
    public boolean meGusta(int posicionCapitulo, boolean like) {
        boolean meGustaRealizado = Utilities.validateRange(posicionCapitulo,0,capitulos.size());
        if (meGustaRealizado) {
            capitulos.get(posicionCapitulo).meGusta(like);
        }
        return meGustaRealizado;
    }

    /**
     * Método que añade si es posible, un voto positivo o negativo (dependiendo del booleano like)
     * al Capítulo, que posea el mismo Título.
     * @param titulo El Título del Capítulo que desea modificar
     * @param like El voto positivo o negativo (Positivo = true), (Negativo = false).
     * @return Devuelve True si ha realizado el voto y False en caso contrario
     */
    public boolean meGusta(String titulo, boolean like) {
        boolean capituloEncontrado = Utilities.validateNotEmptyString(titulo);
        if (capituloEncontrado) {
            // Buscamos la posición del Capítulo. Creando uno nuevo con el Título a buscar y
            // la fecha de Estreno de la Temporada, ya que es indiferente en el Equals de Capítulos
            int index = capitulos.indexOf(new Capitulo(titulo, fechaEstreno));
            capituloEncontrado = index != -1; // Comprobamos si existe el Capítulo
            if (capituloEncontrado) { // Si existe le añadimos el meGusta
                capitulos.get(index).meGusta(like);
            }
        }
        return capituloEncontrado;
    }

    /**
     * Método que devuelve un ArrayList con los n mejores Capítulos.
     * El orden se realiza a través de la valoración de la interfaz Valorable en Capítulo.
     * Se ordenan de mejor puntuación a peor y se devuelve los n mejores.
     * n se debe de encontrar entre (0 - capitulos.size()-1).
     * Si n no es válida se devolverá una Excepción
     * @param n El número de Capítulos del arrayList.
     * @return Devolverá el ArrayList con los n mejores Capítulos.
     * @see Valorable
     * @see Capitulo
     * @throws IllegalArgumentException Lanzará la Excepción si número de Capítulos esta fuera del rango (0 - capitulos.size())
     */
    public ArrayList<Capitulo> capitulosMejorValorados(int n) {
        if (!Utilities.validateRange(n,1,capitulos.size()+1)) {
            throw new IllegalArgumentException("Numero de Capítulos Erróneo fuera del rango");
        }
        ArrayList<Capitulo> capitulosOrdenados = new ArrayList<>();
        // Copiamos sin Copiar Referencias
        for (Capitulo capitulo : this.capitulos) {
            capitulosOrdenados.add( new Capitulo(capitulo));
        }
        // Ordenamos los Capitulos de Mejor a Peor
        capitulosOrdenados.sort(new OrdenarMejorValoradosCapitulos());
        // Crea una SubLista de los n mejores Capitulos
        List<Capitulo> mejoresCapitulos = capitulosOrdenados.subList(0,n);
        return new ArrayList<>(mejoresCapitulos);
    }




    /*------------------------
        Métodos PROPIOS
     -----------------------*/
    private boolean validarCapitulo (String titulo, LocalDate fecha) {
        return  Utilities.validateNotEmptyString(titulo)
                && Utilities.validateLocaDateIsAfterOrEquals(fecha, this.fechaEstreno)
                && !capitulos.contains(new Capitulo(titulo, fecha));
    }

    /**
     * Devuelve una representación en forma de String del Objeto Temporada
     * Muestra la Fecha de Estreno, y los Capítulos con su Título
     * @return Devuelve una cadena de texto con la información de la Temporada
     */
    @Override
    public String toString() {
        StringBuilder temporadaString = new StringBuilder();
        temporadaString.append("Temporada: \n");
        temporadaString.append("Fecha Estreno: ").append(formatter.format(this.fechaEstreno)).append("\n");
        if (capitulos.isEmpty()) {
            temporadaString.append("Esta temporada no posee capítulos todavía");
        } else {
            for (int i = 0; i < capitulos.size(); i++) {
                temporadaString.append(i+1).append(". Capítulo: ").append(capitulos.get(i).getTitulo()).append("\n");
            }
        }
        return temporadaString.toString();
    }

    /**
     * Método implementado de la interfaz Valorable.
     * Calcula la puntuación de la Temporada, realiza
     * la media de las valoraciones de todos los Capítulos.
     * Si no tiene Capítulos devuelve 0.
     * @return Devuelve la valoración de la Temporada.
     * @see Valorable
     */
    @Override
    public int calcularPuntuacion() {
        int media = 0;
        int valoracionTodosCapitulos = 0;
        for (Capitulo capitulo : capitulos) {
            valoracionTodosCapitulos += capitulo.calcularPuntuacion();
        }
        if (valoracionTodosCapitulos != 0) {
            media = valoracionTodosCapitulos / capitulos.size();
        }
        return media;
    }

    /**
     * Método implementado por la interfaz Comparable.
     * Compara dos objetos Temporada y se compara a través de
     * la fecha de Estreno de más antiguo a más Actual
     * @param temporada El objeto para ser Comparado
     * @return Un valor negativo, cero o positivo si este es anterior, igual o posterior al Capítulo
     */
    @Override
    public int compareTo(Temporada temporada) {
        return this.fechaEstreno.compareTo(temporada.fechaEstreno);
    }
}
