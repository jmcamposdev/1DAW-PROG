package vergeflix;

import Funciones.GetData;
import Funciones.Utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


/**
 *
 * @author josemaria
 */
public class Vergeflix {
    // CONSTANTES MEDIA
    public static final String OPCION_PELICULA = "OPCION_PELICULA";
    public static final String OPCION_SERIE = "OPCION_SERIE";
    public static final String OPCION_DIRECTOR = "OPCION_DIRECTOR";
    public static final String OPCION_ACTOR_PRINCIPAL = "OPCION_ACTOR_PRINCIPAL";

    // GESTIÓN DE VERGEFLIX
    public static final int OPCION_GESTIONAR_PELICULAS = 1;
    public static final int OPCION_GESTIONAR_SERIES = 2;
    public static final int OPCION_CONSULTAR_CATALOGO = 3;
    public static final int OPCION_SALIDA_PROGRAMA = 4;


    // OPCIONES CONSULTAR CATÁLOGO
    public static final int OPCION_MOSTRAR_SERIES_PELICULAS_SEGUN_EDAD = 1;
    public static final int OPCION_MOSTRAR_PELICULAS_POR_TEMATICA = 2;
    public static final int OPCION_MOSTRAR_MEJORES_PELICULAS_POR_ACTOR = 3;
    public static final int OPCION_MOSTRAR_MEJORES_PELICULAS_POR_DIRECTOR = 4;
    public static final int OPCION_MOSTRAR_MEJORES_SERIES = 5;
    public static final int OPCION_MOSTRAR_MEJORES_ELEMENTOS_DEL_CATALOGO = 6;
    public static final int OPCION_SALIR_CONSULTAR_CATALOGO = 7;

    // OPCIONES GESTIONAR PELÍCULA
    public static final int OPCION_AÑADIR_PELICULA = 1;
    public static final int OPCION_MODIFICAR_PELICULA = 2;
    public static final int OPCION_ELIMINAR_PELICULA = 3;
    public static final int OPCION_LISTAR_PELICULAS = 4;
    public static final int OPCION_VALORAR_PELICULA = 5;
    public static final int OPCION_SALIDA_GESTIONAR_PELICULA = 6;

    // OPCIONES GESTIONAR SERIE
    public static final int OPCION_AÑADIR_SERIE = 1;
    public static final int OPCION_MODIFICAR_SERIE = 2;
    public static final int OPCION_ELIMINAR_SERIE = 3;
    public static final int OPCION_LISTAR_SERIE = 4;
    public static final int OPCION_GESTIONAR_SERIE_CONCRETA = 5;
    public static final int OPCION_SALIR_GESTIONAR_SERIE = 6;

    // OPCIONES GESTIONAR SERIE CONCRETA
    public static final int OPCION_AÑADIR_TEMPORADA = 1;
    public static final int OPCION_MODIFICAR_TEMPORADA = 2;
    public static final int OPCION_ELIMINAR_TEMPORADA = 3;
    public static final int OPCION_AÑADIR_CAPITULOS = 4;
    public static final int OPCION_ELIMINAR_CAPITULOS = 5;
    public static final int OPCION_LISTAR_TEMPORADAS_Y_CAPITULOS = 6;
    public static final int OPCION_VALORAR_CAPITULO = 7;
    public static final int OPCION_SALIR_GESTIONAR_SERIE_CONCRETA = 8;

    // OPCIONES GESTIONAR TEMPORADA
    public static final int OPCION_MODIFICAR_FECHA_ESTRENO_TEMPORADA = 1;
    public static final int OPCION_MODIFICAR_TITULO_CAPITULO = 2;
    public static final int OPCION_MODIFICAR_FECHA_EMISION_CAPITULO= 3;
    public static final int OPCION_SALIR_MODIFICAR_TEMPORADA= 4;


    // OPCIONES MODIFICAR -- MEDIA
    public static final int OPCION_MODIFICAR_NOMBRE = 1;
    public static final int OPCION_MODIFICAR_CALIFIACION_EDAD = 2;
    public static final int OPCION_MODIFICAR_FECHA_DE_INCORPORACION = 3;
    public static final int OPCION_MODIFICAR_DISPONIBILIDAD = 4;

    // OPCIONES MODIFICAR -- PELICULA
    public static final int OPCION_MODIFICAR_DIRECTOR = 5;
    public static final int OPCION_MODIFICAR_ACTOR_PRINCIPAL = 6;
    public static final int OPCION_MODIFICAR_DURACION = 7;
    public static final int OPCION_MODIFICAR_CATEGORIA = 8;
    public static final int OPCION_SALIR_MODIFICAR_PELICULA = 9;

    // OPCIONES MODIFICAR -- SERIE
    public static final int OPCION_MODIFICAR_FECHA_ESTRENO = 5;
    public static final int OPCION_SALIR_MODIFICAR_SERIE = 6;

    public final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        ArrayList<Media> catalogo = new ArrayList<>(); // Almacenará todas las Peliculas y Series
        /*
        Si deseas Cargar de Películas y Series el Programa descomentar las siguientes líneas.
        Se cargarán 10 Películas.
        Se cargarán 10 Series de las Cuales la "La Casa de Papel" posee Temporadas y Capítulos.


         */
        CargarDatos.cargarSeries(catalogo);
        CargarDatos.cargarTemporadasCasaDePapel((Serie) catalogo.get(0));
        CargarDatos.cargarPeliculas(catalogo);
        boolean exit = false; // Control de salida de la Aplicación
        int userInput; // Entrada del Usuario
        while (!exit) { // Mientras no seleccione salir
            // Mostramos el Menu Principal
            System.out.println("""
                1. Gestionar Películas
                2. Gestionar Series
                3. Consultar Catálogo
                4. Salir""");
            userInput = GetData.getInt("Ingrese opción (1 - 4): ",1,4); // Pedimos al usuario
            switch (userInput) { // Realizamos una acción dependiendo del input
                case OPCION_GESTIONAR_PELICULAS -> gestionarPeliculas(catalogo);
                case OPCION_GESTIONAR_SERIES -> gestionarSeries(catalogo);
                case OPCION_CONSULTAR_CATALOGO ->  consultarCatalogo(catalogo);
                case OPCION_SALIDA_PROGRAMA -> exit = true;
            }
        }
        System.out.println("Gracias por su Visita.");
    }
    /*------------------------
       Gestionar Películas
    -----------------------*/
    public static void gestionarPeliculas(ArrayList<Media> catalogo) {
        boolean exit = false; // Control de Salida
        int userInput; // Entrada del Usuario
        ArrayList<Pelicula> peliculas; // Declaración del ArrayList de peliculas
        ArrayList<Pelicula> peliculasDisponibles; // Declaración del ArrayList de Películas Disponibles
        while (!exit) { // Mientras no seleccione salir
            peliculas = peliculasDelCatalogo(catalogo, false); // Cargamos todas las peliculas actuales de Catálogo
            peliculasDisponibles = peliculasDelCatalogo(catalogo, true);
            // Mostramos el Menu de Películas
            System.out.println("""
                1. Añadir Película
                2. Modificar Película
                3. Eliminar Película
                4. Listar Películas
                5. Valorar Película
                6. Volver""");
            userInput = GetData.getInt("Ingrese una opción (1 - 6): ",1,6); // Pedimos al usuario
            switch (userInput) { // Realizamos una acción dependiendo del input
                case OPCION_AÑADIR_PELICULA -> {
                    if (añadirMedia(catalogo, OPCION_PELICULA)) { // Si la pelicula nueva No Existe
                        System.out.println("Película añadida al catalogo");
                    } else { // Si la película nueva Existe
                        System.out.println("No se ha podido añadir la película porque ya existe");
                    }
                }
                case OPCION_MODIFICAR_PELICULA -> { // Modificamos las Peliculas Actuales
                    if (peliculas.isEmpty()) { // Si no disponemos de Peliculas se lo comentamos
                        System.out.println("No disponemos de Películas todavía");
                    } else { // Si existen peliculas accedemos a Modificarlas
                        modificarPelicula(peliculas);
                    }
                }
                case OPCION_ELIMINAR_PELICULA -> { // Eliminar Pelicula
                    if (peliculas.isEmpty()) { // Si no disponemos de Peliculas se lo comentamos
                        System.out.println("No disponemos de Películas todavía");
                    } else { // Si disponemos de peliculas procedemos a pedir los datos
                        int indexPelicula = getIndexMedia(peliculas);
                        if (catalogo.remove(peliculas.get(indexPelicula))) {
                            System.out.println("Se ha Eliminado la película correctamente");
                        } else {
                            System.out.println("No se ha eliminado la Película");
                        }
                    }
                }
                case OPCION_LISTAR_PELICULAS -> { // Listamos las peliculas actuales
                    if (peliculas.isEmpty()) { // Si no disponemos de Peliculas se lo comentamos
                        System.out.println("No disponemos de Películas todavía");
                    } else { // Si tenemos peliculas se las listamos
                        listarMediaMenu(peliculas);
                    }
                }
                case OPCION_VALORAR_PELICULA -> { // Valorar Películas Disponibles
                    if (peliculasDisponibles.isEmpty()) { // Si no disponemos de Peliculas se lo comentamos
                        System.out.println("No disponemos de Películas todavía");
                    } else { // Si tenemos peliculas le pedimos que las valore
                        int indexPeliculaAValorar = getIndexMedia(peliculasDisponibles);
                        int voto = GetData.getInt("Ingrese su voto (0 - 10): ", 0 , 10);
                        boolean votoRealizado = peliculasDisponibles.get(indexPeliculaAValorar).votar(voto);
                        if (votoRealizado) {
                            System.out.println("Se ha votado correctamente");
                        } else {
                            System.out.println("No se ha podido votar");
                        }
                    }
                }
                case OPCION_SALIDA_GESTIONAR_PELICULA -> exit = true; // Salimos del SubMenu de Peliculas
            }
        }
    }


    public static boolean añadirMedia (ArrayList<Media> catalogo, String opcion_media) {
        boolean estaMediaAñadida; // Verifica si la pelicula se ha añadido
        Media nuevaMedia = null; // Declaramos la Nueva Media a añadir
        String nombre = GetData.getString("Ingrese el Nombre: "); // Pedimos el nombre
        int calificacionEdad = GetData.getInt("Ingrese la Calificación de Edad (0 - 18): ",0,18); // Pedimos la calificación de Edad (0 - 18)
        LocalDate fechaIncorporacionCatalogo = GetData.getFecha("Ingrese la fecha de incorporación al catalogo (dd/MM/yyyy): "); // Pedimos fecha de Incorporacion al Catalogo
        boolean estaDisponible = GetData.getBoolean("Esta disponible (Si | No): "); // Pedimos  si esta Disponible

        switch (opcion_media) {
            case OPCION_PELICULA -> {
                String director = GetData.getString("Nombre del Director: "); // Pedimos el Director
                String actorPrincipal = GetData.getString("Nombre del Actor Principal: "); // Pedimos el Actor Principal
                int duracion = GetData.getInt("Ingrese la duración en minutos (60 - 240): ",60,240); // Pedimos la Duración
                Tematica categoria = getTematicaPelicula(); // Pedimos la Categoria
                nuevaMedia = new Pelicula(nombre,calificacionEdad,fechaIncorporacionCatalogo,estaDisponible,director,actorPrincipal,duracion,categoria);
            }
            case OPCION_SERIE -> {
                LocalDate fechaEstrenoSerie = GetData.getFecha("Ingrese la fecha de Estreno (dd/MM/yyyy): "); // Pedimos la Fecha de Estreno de la Serie
                nuevaMedia = new Serie(nombre,calificacionEdad,fechaIncorporacionCatalogo,estaDisponible,fechaEstrenoSerie);
            }
        }
        estaMediaAñadida = !catalogo.contains(nuevaMedia); // Comprobamos si no existe la Media en el Catálogo
        if (estaMediaAñadida) { // Si no Existe lo añadimos
            catalogo.add(nuevaMedia);
        }
        return estaMediaAñadida;
    }


    public static void modificarPelicula(ArrayList<Pelicula> peliculas) {
        boolean exit = false; // Control de Salida
        boolean accionRealizadaConExito; // Verifica si se ha realizado la modificación
        int userInput; // Entrada del Usuario
        Pelicula peliculaAModificar = null; // Pelicula que el usuario desea Modificar
        while (!exit) {
            accionRealizadaConExito = false;
            System.out.println("""
                Que desea modificar:
                1. Nombre
                2. Calificación Edad
                3. Fecha Incorporación al Catalogo
                4. Disponibilidad
                5. Director
                6. Actor Principal
                7. Duracion
                8. Tematica
                9. Volver""");
            userInput = GetData.getInt("Ingrese una opción (1 - 9): ",1, 9); // Le pedimos que elija una opción
            if (userInput != 9) { // Si no elige la opción de Salida le pedimos la película que desea Modificar
                peliculaAModificar = peliculas.get(getIndexMedia(peliculas)); // Guardamos la Película
            }
            switch (userInput) {
                case OPCION_MODIFICAR_NOMBRE -> { // Modificar Nombre
                    String nuevoNombre = GetData.getString("Ingrese el nuevo nombre: "); // Pedimos un nuevo Nombre
                    if (modificarNombre(peliculaAModificar,nuevoNombre,peliculas)) accionRealizadaConExito = true;
                }
                case OPCION_MODIFICAR_CALIFIACION_EDAD -> { // Modificar Calificación de Edad
                    int nuevaCalificacionEdad = GetData.getInt("Ingrese la nueva Calificación de Edad (0 - 18): ",0, 18); // Pedimos la Edad
                    if (modificarCalificacionEdad(peliculaAModificar, nuevaCalificacionEdad, peliculas)) accionRealizadaConExito = true; // Si se ha modificado verificamos la acción
                }
                case OPCION_MODIFICAR_FECHA_DE_INCORPORACION -> { // Modificar Fecha de Incorporación al Catalogo
                    LocalDate nuevaFechaIncorporacion = GetData.getFecha("Ingrese la nueva fecha de Incorporación (dd/MM/yyyy): "); // Pedimos la Fecha de Incorporación
                    // Modificamos el Fecha de Incorporación
                    peliculaAModificar.setFechaIncorporacionAlCatalogo(nuevaFechaIncorporacion);
                    accionRealizadaConExito = true;
                }
                case OPCION_MODIFICAR_DISPONIBILIDAD -> { // Modificar Disponibilidad
                    boolean nuevaDisponibilidad = GetData.getBoolean("Ingrese la Disponibilidad (Si | No): "); // Pedimos la Disponibilidad
                    // Modificamos la Disponibilidad
                    peliculaAModificar.setEstaDisponible(nuevaDisponibilidad);
                    accionRealizadaConExito = true;
                }
                case OPCION_MODIFICAR_DIRECTOR -> { // Modificar Director
                    String nuevoDirector = GetData.getString("Ingrese el nuevo Director: "); // Pedimos el nuevo Director
                    // Comprobamos que no este vacío el String o que contenga solo espacios en blanco
                    accionRealizadaConExito = Utilities.validateNotEmptyString(nuevoDirector);
                    if (accionRealizadaConExito) { // Si es válido el Director lo actualizamos
                        peliculaAModificar.setDirector(nuevoDirector);
                    }
                }
                case OPCION_MODIFICAR_ACTOR_PRINCIPAL -> { // Modificar Actor Principal
                    String nuevoActorPrincipal = GetData.getString("Ingrese el nuevo Actor Principal: "); // Pedimos el nuevo Actor Principal
                    // Comprobamos que no este vacío el String o contenga colo espacios en blanco
                    accionRealizadaConExito = Utilities.validateNotEmptyString(nuevoActorPrincipal);
                    if (accionRealizadaConExito) { // Si es válido el Director lo actualizamos
                        peliculaAModificar.setActorPrincipal(nuevoActorPrincipal);
                    }
                }
                case OPCION_MODIFICAR_DURACION -> { // Modificar Duración
                    int nuevaDuracion = GetData.getInt("Ingrese la nueva Duracion de la Pelicula (60 - 240): ", 60,240); // Pedimos la duración
                    // Actualizamos ya que hemos en el input.
                    peliculaAModificar.setDuracion(nuevaDuracion);
                    accionRealizadaConExito = true;
                }
                case OPCION_MODIFICAR_CATEGORIA -> { // Modificar Categoría
                    Tematica nuevaCategoria = getTematicaPelicula(); // Pedimos la nueva Categoria
                    peliculaAModificar.setCategoria(nuevaCategoria); // Modificamos la Nueva Categoría
                    accionRealizadaConExito = true; // Si se ha modificado verificamos la acción
                }
                case OPCION_SALIR_MODIFICAR_PELICULA -> exit = true; // Salida del SubMenu
                default -> System.out.println("Acción no válida."); // Cualquier opción no válida
            }

            if (accionRealizadaConExito) { // Si se ha realizado se lo mostramos
                System.out.println("Se ha realizado la Modificación");
            } else if (userInput != OPCION_SALIR_MODIFICAR_PELICULA){ // Si no se ha realizado la Acción validamos que no sea la opción de Salida
                System.out.println("No se ha realizado la Modificación");
            }
        }
    }

    public static int getIndexMedia (ArrayList<? extends Media> catalogo) {
        // Listamos las películas con solo el Título y la Disponibilidad
        System.out.println(listarMedia(catalogo, catalogo.size(), false,true,false, false));
        // Devolvemos el índice de la película deseada -- Le restamos 1 a la entrada del usuario.
        return GetData.getInt("Seleccione una Película (1 - "+catalogo.size()+"): ",1,catalogo.size())-1;
    }

    public static Tematica getTematicaPelicula () {
        // Imprimemos las Temáticas Dinámicamente
        for (Tematica tematica: Tematica.values()) {
            System.out.println(tematica.ordinal()+1+". "+tematica.getNombre());
        }
        // Devolvemos la Temática elegida gracias al método values con el índice de la Temática
        // Limito el valor máximo dependiendo del número de Temáticas que tenga el Enum
        return Tematica.values()[GetData.getInt("Que Categoria es (1 - 6): ",1,6)-1];
    }

    /*------------------------
        Gestionar Series
    -----------------------*/
    public static void gestionarSeries(ArrayList<Media> catalogo) {
        boolean exit = false; // Control de Salida
        int userInput; // Entrada del Usuario
        ArrayList<Serie> series; // Declaración del ArrayList de Series Todas
        ArrayList<Serie> seriesDisponibles; // Declaración del ArrayList de Series Disponibles
        while (!exit) { // Mientras no seleccione salir
            series = seriesDelCatalogo(catalogo, false); // Cargamos todas las Series actuales de Catálogo
            seriesDisponibles = seriesDelCatalogo(catalogo, true); // Cargamos todas las Series Disponibles
            // Mostramos el Menu de Series
            System.out.println("""
                1. Añadir Serie
                2. Modificar Serie
                3. Eliminar Serie
                4. Listar Series
                5. Gestionar Serie Concreta
                6. Volver""");
            userInput = GetData.getInt("Ingrese una opción (1 - 6): ",1,6); // Pedimos al usuario
            switch (userInput) { // Realizamos una acción dependiendo del input
                case OPCION_AÑADIR_SERIE -> { // Añadimos una nueva Serie
                    if (añadirMedia(catalogo, OPCION_SERIE)) { // Si la Serie nueva No Existe la añadimos y se lo comentamos
                        System.out.println("Serie añadida al catalogo");
                    } else { // Si la Serie nueva Existe
                        System.out.println("No se ha podido añadir la serie porque ya existe o la fecha insertada es futura");
                    }
                }
                case OPCION_MODIFICAR_SERIE -> { // Modificamos las Series Actuales
                    if (series.isEmpty()) { // Si no disponemos de Series se lo comentamos
                        System.out.println("No disponemos de Series todavía");
                    } else { // Si existen Series accedemos a Modificarlas
                        modificarSerie(series);
                    }
                }
                case OPCION_ELIMINAR_SERIE -> { // Eliminar Serie
                    if (series.isEmpty()) { // Si no disponemos de Series se lo comentamos
                        System.out.println("No disponemos de Series todavía");
                    } else { // Si disponemos de Series procedemos a pedir los datos
                        int indexSerie = getIndexMedia(series); // Obtennos el índice de la serie
                        if (catalogo.remove(series.get(indexSerie))) { // Si se ha eliminado se lo comentamos
                            System.out.println("Se ha Eliminado la serie correctamente");
                        } else { // Si no se ha encontrado se lo comentamos
                            System.out.println("No se ha eliminado la Serie");
                        }
                    }
                }
                case OPCION_LISTAR_SERIE -> { // Listamos las Series actuales
                    if (series.isEmpty()) { // Si no disponemos de Series se lo comentamos
                        System.out.println("No disponemos de Series todavía");
                    } else { // Si tenemos peliculas se las listamos
                        listarMediaMenu(series);
                    }
                }
                case OPCION_GESTIONAR_SERIE_CONCRETA -> { // Gestionar Serie Concreta
                    if (seriesDisponibles.isEmpty()) { // Si no disponemos de Series Disponibles se lo comentamos
                        System.out.println("No disponemos de series todavía");
                    } else { // Si tenemos peliculas le pedimos que las valore
                        int serieIndex = getIndexMedia(seriesDisponibles);
                        gestionarSerieConcreta(seriesDisponibles.get(serieIndex));
                    }
                }
                case OPCION_SALIR_GESTIONAR_SERIE -> exit = true; // Salimos del SubMenu de Series
            }
        }
    }


    public static void modificarSerie(ArrayList<Serie> series) {
        boolean exit = false; // Comprobación de Salida de Modificar Serie
        boolean accionRealizadaConExito; // Comprobación de la acción realizada
        int userInput; // Entrada del Usuario
        Serie serieAModificar = null; // Inicializamos la serie a modificar a null.
        while (!exit) {
            accionRealizadaConExito = false;
            // Mostramos el menu de modificaciones
            System.out.println("""
                1. Nombre
                2. Calificación Edad
                3. Fecha Incorporación al Catalogo
                4. Disponibilidad
                5. Fecha Estreno
                6. Volver""");
            // Pedimos al usuario una opción
            userInput = GetData.getInt("Ingrese una opción (1 - 6): ",1, 6);
            if (userInput != 6) { // Si la opción introducida es distinta a la de salida pedimos la serie a modificar
                serieAModificar = series.get(getIndexMedia(series));
            }
            switch (userInput) {
                case OPCION_MODIFICAR_NOMBRE -> { // Modificar Nombre
                    String nuevoNombre = GetData.getString("Ingrese el nuevo nombre: "); // Pedimos el nuevo nombre
                    // Comprobamos si se ha cambiado el nombre
                    if (modificarNombre(serieAModificar,nuevoNombre,series)) accionRealizadaConExito = true;
                }
                case OPCION_MODIFICAR_CALIFIACION_EDAD -> { // Modificar Calificación Edad
                    // Pedimos la nueva Calificación de Edad
                    int nuevaCalificacionEdad = GetData.getInt("Ingrese la nueva Calificación de Edad (0 - 18): ",0, 18);
                    // Comprobamos si se ha cambiado la Calificación de Edad
                    if (modificarCalificacionEdad(serieAModificar, nuevaCalificacionEdad, series)) accionRealizadaConExito = true;
                }
                case OPCION_MODIFICAR_FECHA_DE_INCORPORACION -> { // Modificar Fecha de Incorporación al Catalogo
                    LocalDate nuevaFechaIncorporacion = GetData.getFecha("Ingrese la nueva fecha de Incorporacion: ");
                    // Modificamos la Fecha de Incorporación
                    serieAModificar.setFechaIncorporacionAlCatalogo(nuevaFechaIncorporacion);
                    accionRealizadaConExito = true;
                }
                case OPCION_MODIFICAR_DISPONIBILIDAD -> { // Modificar la Disponibilidad
                    boolean nuevaDisponibilidad = GetData.getBoolean("Ingrese la Disponibilidad (Si | No): ");
                    // Modificamos la Disponibilidad
                    serieAModificar.setEstaDisponible(nuevaDisponibilidad);
                    accionRealizadaConExito = true;
                }
                case OPCION_MODIFICAR_FECHA_ESTRENO -> { // Modificar la Fecha de Estreno
                    // Pedimos la nueva Fecha de Estreno
                    LocalDate nuevaFechaEstreno = GetData.getFecha("Ingrese la nueva Fecha de Estreno: ");
                    // Comprobamos si se ha modificado
                    accionRealizadaConExito = serieAModificar.setFechaEstreno(nuevaFechaEstreno);
                }
                case OPCION_SALIR_MODIFICAR_SERIE -> exit = true;
            }
            // Si la acción se ha realizado se lo mostramos
            if (accionRealizadaConExito) {
                System.out.println("Se ha realizado la Modificación");
            } else if (!exit){ // Si no se ha realizado y no se ha salido le mostramos el error
                System.out.println("No se ha realizado la Modificación");
            }
        }
    }

    public static boolean modificarNombre (Media mediaAModificar, String nuevoNombre, ArrayList<? extends Media> catalogo) {
        boolean cambioRealizado = false; // Validación si se ha realizado el cambio
        if (mediaAModificar instanceof Pelicula) { // Comprobamos si es una Película
            Media nuevaPelicula = new Pelicula((Pelicula) mediaAModificar); // Copiamos la película
            nuevaPelicula.setNombre(nuevoNombre); // Modificamos el nombre de la Copia
            if (!catalogo.contains(nuevaPelicula)) { // Comprobamos que no exista otra película como la Copia
                mediaAModificar.setNombre(nuevoNombre); // Si no existe modificamos la película original
                cambioRealizado = true; // Confirmamos la modificación
            }
        } else if (mediaAModificar instanceof Serie) { // Comprobamos si es una Serie
            Media nuevaSerie = new Serie((Serie) mediaAModificar); // Copiamos la Serie
            nuevaSerie.setNombre(nuevoNombre); // Modificamos el nombre de la Copia
            if (!catalogo.contains(nuevaSerie)) { // Comprobamos que no exista otra Serie igual
                mediaAModificar.setNombre(nuevoNombre); // Si no existe modificamos la serie original
                cambioRealizado = true; // Confirmamos la modificación
            }
        }
        return cambioRealizado;
    }

    public static boolean modificarCalificacionEdad (Media mediaAModificar, int nuevaCalificacionEdad, ArrayList<? extends Media> catalogo) {
        boolean cambioRealizado = false; // Validación si se ha realizado el cambio
        if (mediaAModificar instanceof Pelicula) { // Comprobamos si es una Película
            Media nuevaPelicula = new Pelicula((Pelicula) mediaAModificar); // Copiamos la Película
            nuevaPelicula.setCalificacionEdad(nuevaCalificacionEdad); // Modificamos la Copia
            if (!catalogo.contains(nuevaPelicula)) { // Comprobamos que no existe otra película igual
                mediaAModificar.setCalificacionEdad(nuevaCalificacionEdad); // Si no existe modificamos la original
                cambioRealizado = true; // Confirmamos la modificación
            }
        } else if (mediaAModificar instanceof Serie) { // Comprobamos si es una Serie
            Media nuevaSerie = new Serie((Serie) mediaAModificar); // Copiamos la Serie
            nuevaSerie.setCalificacionEdad(nuevaCalificacionEdad); // Modificamos la Copia
            if (!catalogo.contains(nuevaSerie)) { // Comprobamos que no exista otra serie igual
                mediaAModificar.setCalificacionEdad(nuevaCalificacionEdad); // Si no existe modificamos la original
                cambioRealizado = true; // Confirmamos la modificación
            }
        }
        return cambioRealizado;
    }


    /*------------------------
       Listados
   -----------------------*/
    public static void listarMediaMenu (ArrayList<? extends Media> catalogo) {
        System.out.println("""
                Tipo de Listado:
                1. Listado Simple
                2. Listado Detallado""");
        int userOption = GetData.getInt("Ingrese una opción (1 - 2): ",1 ,2);
        System.out.println(listarMedia(catalogo,catalogo.size(), userOption == 2,true, false,false));
    }
    public static String listarMedia (ArrayList<? extends Media> catalogo,int numeroDeElementosAMostrar,  boolean listarDetallado,boolean mostrarDisponibilidad, boolean mostrarTipo, boolean mostrarValoracion) {
        StringBuilder seriesString = new StringBuilder();
        // Validamos que el número de Elementos sea Válido
        if (numeroDeElementosAMostrar > 0 && numeroDeElementosAMostrar <= catalogo.size()) {
            for (int i = 0; i < numeroDeElementosAMostrar; i++) {
                if (listarDetallado) { // Realizamos un Listado Detallado
                    seriesString.append(i+1).append(". ").append(catalogo.get(i)).append("\n\n");
                } else { // Realizamos un Listado Simple
                    // Guardamos el nombre y su número
                    seriesString.append(i+1).append(". ").append(catalogo.get(i).getNombre())
                            // Si desea mostrar la Disponibilidad la mostramos
                            .append(mostrarDisponibilidad ? catalogo.get(i).isEstaDisponible() ? " - Disponible" : " - No Disponible" : "")
                            // Si desea mostrar el Tipo lo mostramos
                            .append(mostrarTipo ? catalogo.get(i) instanceof Pelicula ? " - Pelicula" : " - Serie" : "")
                            // Si desea mostrar la Valoración la mostramos
                            .append(mostrarValoracion ? " - Valoración: "+catalogo.get(i).calcularPuntuacion() : "")
                            .append("\n");
                }
            }
        }
        return seriesString.toString();
    }


    /*-----------------------
    Gestionar Serie Concreta
    -----------------------*/
    public static void gestionarSerieConcreta(Serie serie) {
        boolean exit = false; // Control de Salida
        int userInput; // Entrada del Usuario
        ArrayList<Temporada> temporadas;
        while (!exit) {
            temporadas = getTemporadasSerie(serie);
            System.out.println("Estas Editando: "+serie.getNombre()+" - Fecha de Estreno: "+ FORMATTER.format(serie.getFechaEstreno())); // Mostrar la Serie que está Editando
            // Mostramos el menu
            System.out.println("""
                1. Añadir Temporada
                2. Modificar Temporada
                3. Eliminar Temporada
                4. Añadir Capítulos
                5. Eliminar Capítulos
                6. Listar Temporadas y Capítulos
                7. Valorar Capitulo
                8. Volver""");
            userInput = GetData.getInt("Ingrese una opción (1 - 8): ", 1, 8); // Pedimos una opción
            switch (userInput) {
                case OPCION_AÑADIR_TEMPORADA -> { // Añadir una Nueva Temporada
                    // Solicitamos la fecha de Estreno de la Temporada
                    LocalDate fechaEstreno = GetData.getFecha("Ingrese la Fecha de Estreno (dd/MM/yyyy): ");
                    // Si la Fecha es anterior a la Fecha de Estreno de la Serie se lo comentamos
                    if (fechaEstreno.isBefore(serie.getFechaEstreno())) {
                        System.out.println("La fecha insertada es Anterior al Estreno de la Serie");
                    } else if (serie.añadirTemporada(fechaEstreno)) { // Si se ha añadido la temporada correctamente se lo comentamos
                        System.out.println("Se ha añadido con exito");
                    } else { // Si no lo ha podido añadir es porque existe una temporada en el mismo mes
                        System.out.println("Ya existe un Temporada en el mismo Mes");
                    }
                }
                case OPCION_MODIFICAR_TEMPORADA -> { // Modificar Temporada
                    if (temporadas.isEmpty()) { // Validamos si no existen temporadas y se lo comentamos
                        System.out.println("La serie no dispone de Temporadas");
                    } else { // Si existen le pedimos que temporada desea modificar
                        int indexTemporada = getIndexTemporada(temporadas);
                        modificarTemporadaConcreta(serie, indexTemporada);
                    }
                }
                case OPCION_ELIMINAR_TEMPORADA -> { // Eliminar una temporada
                    if (temporadas.isEmpty()) {
                        System.out.println("La serie no dispone de Temporadas");
                    } else {
                        int indexTemporada = getIndexTemporada(temporadas);
                        if (serie.eliminarTemporada(indexTemporada)) {
                            System.out.println("Se ha eliminado la Temporada Correctamente");
                        } else {
                            System.out.println("No se ha podido encontrar la temporada");
                        }
                    }
                }
                case OPCION_AÑADIR_CAPITULOS -> { // Añadir Capítulos
                    if (temporadas.isEmpty()) {
                        System.out.println("La serie no dispone de Temporadas");
                    } else {
                        System.out.println("Seleccione una Temporada para añadir el Capitulo:");
                        int indexTemporada = getIndexTemporada(temporadas);
                        String nombreCapitulo = GetData.getString("Ingrese el titulo del Capitulo: ");
                        LocalDate fechaCapitulo = GetData.getFecha("Ingrese la fecha de Emision Capitulo: ");
                        if (fechaCapitulo.isBefore(temporadas.get(indexTemporada).getFechaEstreno())) {
                            System.out.println("La fecha insertada es anterior a la Fecha de Estreno de la Temporada");
                        } else if (serie.añadirCapitulo(indexTemporada,fechaCapitulo,nombreCapitulo)) {
                            System.out.println("Se ha añadido el Capítulo correctamente");
                        } else {
                            System.out.println("No se ha podido añadir el Capítulo porque ya existe");
                        }
                    }

                }
                case OPCION_ELIMINAR_CAPITULOS -> { // Eliminar Capítulos
                    if (temporadas.isEmpty()) {
                        System.out.println("La serie no dispone de Temporadas");
                    } else {
                        System.out.println("""
                                1. Eliminar un Capítulo de una Temporada
                                2. Eliminar todos los Capítulos que concuerden con la Expresion Regular
                                3. Volver""");
                        int userOption = GetData.getInt("Ingrese una opción (1 - 3): ", 1, 3);
                        switch (userOption) {
                            case 1 -> {
                                System.out.println("Seleccione una Temporada: ");
                                int indexTemporada = getIndexTemporada(temporadas);
                                ArrayList<Capitulo> capitulosTemporada = getCapitulosTemporada(temporadas.get(indexTemporada));
                                if (capitulosTemporada.isEmpty()) {
                                    System.out.println("La Temporada no posee Capítulos");
                                } else {
                                    int indexCapitulo = getIndexCapitulo(capitulosTemporada);
                                    if (serie.eliminarCapitulo(indexTemporada, capitulosTemporada.get(indexCapitulo).getTitulo())) {
                                        System.out.println("Se ha eliminado el Capítulo con Exito");
                                    } else {
                                        System.out.println("No se ha podido encontrar el Capítulo");
                                    }
                                }
                            }
                            case 2 -> {
                                String expresionRegular = GetData.getString("Ingrese su Expresion Regular: ");
                                int capitulosEliminados = serie.eliminarCapitulos(expresionRegular);
                                System.out.println("Se ha eliminado " + capitulosEliminados + " capítulos.");
                            }
                            default -> {}
                        }
                    }
                }
                case OPCION_LISTAR_TEMPORADAS_Y_CAPITULOS -> {
                    if (temporadas.isEmpty()) {
                        System.out.println("La serie no dispone de Temporadas");
                    } else {
                        listarTemporadasYCapitulos(temporadas);
                    }
                }
                case OPCION_VALORAR_CAPITULO -> {
                    if (temporadas.isEmpty()) {
                        System.out.println("La serie no dispone de Temporadas");
                    } else {
                        int indexTemporada = getIndexTemporada(temporadas);
                        ArrayList<Capitulo> capitulosDeTemporada = getCapitulosTemporada(temporadas.get(indexTemporada));
                        if (capitulosDeTemporada.isEmpty()) {
                            System.out.println("La Temporada no dispone de Capítulos");
                        } else {
                            int indexCapitulo = getIndexCapitulo(capitulosDeTemporada);
                            boolean voto = GetData.getBoolean("Te ha gustado el Capítulo (Si | No): ");
                            if (serie.meGusta(indexTemporada, indexCapitulo, voto)) {
                                System.out.println("Voto realizado Correctamente");
                            } else {
                                System.out.println("No se ha podido realizar el voto");
                            }
                        }
                    }
                }
                case OPCION_SALIR_GESTIONAR_SERIE_CONCRETA -> exit = true;
            }
        }
    }

    public static void modificarTemporadaConcreta (Serie serie, int indiceTemporadaAModificar) {
        boolean exit = false; // Opción de Salida
        int userOption; // Entrada del Usuario
        // Generamos la Lista de Capítulo de la Temporada
        ArrayList<Capitulo> capitulos;
        while (!exit) {
            //  Obtenemos todos los Capítulos de la Temporada
            capitulos = getCapitulosTemporada(serie.getCopiaTemporada(indiceTemporadaAModificar));
            // Mostramos el menu
            System.out.println("""
                1. Modificar la Fecha de Estreno de la Temporada
                2. Modificar Título de un Capítulo
                3. Modificar la Fecha de Emisión de un Capítulo
                4. Volver""");
            userOption = GetData.getInt("Ingrese una opción (1 - 4): ",1, 4); // Pedimos una opción
            switch (userOption) {
                case  OPCION_MODIFICAR_FECHA_ESTRENO_TEMPORADA -> { // Modificar Fecha Estreno Temporada
                    // Pedimos la nueva Fecha de Estreno para la Temporada
                    LocalDate nuevaFechaEstreno = GetData.getFecha("Ingrese la nueva Fecha de Estreno (dd/MM/yyyy): ");
                    // Obtenemos si tiene la fecha del Primer Capítulo
                    Capitulo primerCapitulo = serie.getCapitulo(indiceTemporadaAModificar,0);
                    LocalDate fechaCapitulo = primerCapitulo == null ? null : primerCapitulo.getFechaEmision();

                    if (nuevaFechaEstreno.isBefore(serie.getFechaEstreno())) { // Comprobamos si la nueva Fecha es anterior a la fecha de la Serie
                        System.out.println("No se ha modificado ya que la Fecha introducida es anterior a la Fecha de Estreno de la Serie");
                    } else if (fechaCapitulo != null && nuevaFechaEstreno.isAfter(fechaCapitulo)) { // Comprobamos si tiene Fecha del Capítulo si es posterior a la Fecha
                        System.out.println("No se ha modificado ya que la Fecha introducida es posterior a la Fecha de Emisión del Primer Capítulo");
                    } else if (serie.setFechaEstrenoTemporada(indiceTemporadaAModificar, nuevaFechaEstreno)) { // Comprobamos si se ha podido modificar
                        System.out.println("Se ha modificado Correctamente");
                    } else { // Si no se ha podido modificar le mostramos el porque
                        System.out.println("No se ha podido Modificar ya que existe otra Temporada en el mismo mes de la fecha introducida");
                    }
                }
                case OPCION_MODIFICAR_TITULO_CAPITULO -> { // Modificar Título de un Capítulo
                    if (capitulos.isEmpty()) { // Comprobamos que existan capitulos sino se lo comentamos
                        System.out.println("La Temporada no posee Capítulo todavía");
                    } else { // Si existen Capítulos
                        // Pedimos el índice el Capítulo
                        int indexCapitulo = getIndexCapitulo(capitulos);
                        // Pedimos el nuevo Título
                        String nuevoTitulo = GetData.getString("Ingrese el nuevo Título: ");
                        // Intentamos modificar el Título
                        if (serie.setCapitulo(indiceTemporadaAModificar,indexCapitulo, nuevoTitulo)) {
                            System.out.println("Se ha modificado Correctamente"); // Mostramos si se ha modificado
                        } else {
                            System.out.println("Ya existe un Capítulo con el mismo nombre"); // Mostramos si no se ha modificado
                        }
                     }
                }
                case OPCION_MODIFICAR_FECHA_EMISION_CAPITULO -> { // Modificar Fecha Emisión de un Capítulo
                    if (capitulos.isEmpty()) { // Comprobamos si no existen capítulos
                        System.out.println("La Temporada no posee Capítulo todavía"); // Imprimimos que no existen Capítulos
                    } else { // Si existen procedemos a modificar la Fecha de Emisión
                        // Pedimos el índice del Capítulo
                        int indexCapitulo = getIndexCapitulo(capitulos);
                        // Pedimos la nueva Fecha de Emisión del Capítulo
                        LocalDate nuevaFechaEmision = GetData.getFecha("Ingrese la nueva Fecha de Emisión: ");
                        // Intentamos modificar la Fecha y le comentamos si se ha podido o no y el porqué
                        if (serie.setCapitulo(indiceTemporadaAModificar, indexCapitulo, nuevaFechaEmision)) {
                            System.out.println("Se ha modificado Correctamente");
                        } else {
                            System.out.println("La fecha insertada es anterior a la Fecha de Estreno de la Temporada");
                        }
                    }
                }
                case OPCION_SALIR_MODIFICAR_TEMPORADA -> exit = true; // Salimos del Menu
                default -> System.out.println("Opción no válida");
            }
        }
    }

    public static void listarTemporadasYCapitulos (ArrayList<Temporada> temporadas) {
        boolean exit = false; // Validación de Salida
        int userInput; // Almacenar la opción del Usuario
        while (!exit) {
            // Pedimos que seleccione una Temporada o salir.
            System.out.println("Seleccione que de que Temporada desea ver los Capítulos: ");
            System.out.println(listadoTemporadas(temporadas));
            System.out.println(temporadas.size()+1+". Volver");
            userInput = GetData.getInt("Ingrese una Opción (1 - "+(temporadas.size()+1)+") : ",1,temporadas.size()+1);
            // Comprobamos si ha elegido Salir
            if (userInput == temporadas.size()+1) {
                exit = true; // Confirmamos la Salida
            } else {
                // Obtenemos todos los Capítulos de la Temporada
                ArrayList<Capitulo> capitulos = getCapitulosTemporada(temporadas.get(userInput-1));
                if (capitulos.isEmpty()) { // Comprobamos si no existen capítulos para comentárselo
                    System.out.println("La Temporada seleccionada no posee Capítulos.\n");
                } else {
                    // Imprimemos el menu de ordenación
                    System.out.println("""
                                        Tipo de Listado:
                                        1. Listado por Fechas
                                        2. Listado Ordenado por Mejores""");
                    // Pedimos la ordenación deseada
                    int userOption = GetData.getInt("Ingrese una opción (1 - 2): ",1,2);
                    // Si selecciona listado ordenado lo ordenamos
                    if (userOption == 2) capitulos.sort(new OrdenarMejorValoradosCapitulos());
                    // Imprimimos los capítulos
                    System.out.println(listadoCapitulos(capitulos));
                }
            }
        }
    }
    public static ArrayList<Temporada> getTemporadasSerie (Serie serie) {
        // Lista para almacenar las Copias Profundas de las Temporadas
        ArrayList<Temporada> temporadas = new ArrayList<>();
        int counter = 0;
        // Copiamos las Temporadas hasta que nos retorne null
        while (serie.getCopiaTemporada(counter) != null) {
            temporadas.add(serie.getCopiaTemporada(counter++));
        }
        return temporadas;
    }
    public static ArrayList<Capitulo> getCapitulosTemporada (Temporada temporada) {
        // Lista para almacenar las Copias Profundas de los Capítulos
        ArrayList<Capitulo> capitulos = new ArrayList<>();
        int counter = 0;
        // Copiamos los Capítulos hasta que nos retorne null
        while (temporada.getCapitulo(counter) != null) {
            capitulos.add(temporada.getCapitulo(counter++));
        }
        return capitulos;
    }
    public static String listadoTemporadas (ArrayList<Temporada> temporadas) {
        // Lista las Temporadas con su Fecha de Estreno y lo devuelve como String
        StringBuilder temporadasString = new StringBuilder();
        for (int i = 0; i < temporadas.size(); i++) {
            temporadasString.append(i + 1).append(". ")
                    .append("Temporada - ")
                    .append(FORMATTER.format(temporadas.get(i).getFechaEstreno()))
                    .append("- Valoración: ").append(temporadas.get(i).calcularPuntuacion())
                    .append(i == temporadas.size()-1 ? "" : "\n");
        }
        return temporadasString.toString();
    }

    public static String listadoCapitulos (ArrayList<Capitulo> capitulos) {
        // Lista los Capítulos con su Nombre y Fecha de Emisión
        StringBuilder capitulosString = new StringBuilder();
        for (int i = 0; i < capitulos.size(); i++) {
            capitulosString.append(i+1).append(". ").append(capitulos.get(i).getTitulo()).append(" - ").append(FORMATTER.format(capitulos.get(i).getFechaEmision())).append("\n");
        }
        return capitulosString.toString();
    }
    public static int getIndexTemporada (ArrayList<Temporada> temporadas) {
        // Obtenemos el Índice de una de las Temporadas pasada por parámetro
        System.out.println(listadoTemporadas(temporadas));
        return GetData.getInt("Seleccione una Temporada (1 - "+temporadas.size()+"): ",1,temporadas.size())-1;
    }
    public static int getIndexCapitulo (ArrayList<Capitulo> capitulos) {
        // Obtenemos el Índice de un Capítulo
        System.out.println(listadoCapitulos(capitulos));
        return GetData.getInt("Seleccione un Capítulo (1 - "+capitulos.size()+"): ",1,capitulos.size())-1;
    }




    public static void consultarCatalogo (ArrayList<Media> catalogo) {
        boolean exit = false; // Validación de Salida
        int userInput; // Opción del Usuario
        while (!exit) {
            System.out.println("""
                1. Mostrar Series o películas según su calificación de edad
                2. Listar las n mejores películas por temática
                3. Listar las n mejores películas por Actor Principal
                4. Listar las n mejores películas por Director
                5. Listar las n mejores series
                6. Listar los n mejores elementos disponibles del catálogo (serie o película)
                7. Volver
                """); // Mostramos el Menu de Consultar Catalogo
            userInput = GetData.getInt("Ingrese una opción (1 - 7): ",1,7); // Pedimos que elija una opción
            switch (userInput) {
                case OPCION_MOSTRAR_SERIES_PELICULAS_SEGUN_EDAD -> { // Mostrar Series o películas según su calificación de edad
                    // Pedimos si desea mostrar todas incluidas las "No Disponibles"
                    boolean mostrarSoloDisponibles = GetData.getBoolean("Deseas mostrar solo las películas o series Disponibles (Si | No): ");
                    // Pedimos por qué edad desea filtrar
                    int filtradoEdad = GetData.getInt("Ingrese que la edad (0 - 18): ",0,18);
                    // Creamos la Lista Filtrada por Edad
                    ArrayList<Media> catalogoFiltrado = filtradoPorEdad(catalogo, filtradoEdad, mostrarSoloDisponibles);
                    if (catalogoFiltrado.isEmpty()) { // Comprobamos si esta vacía
                        System.out.println("No disponemos de Series ni Películas de esa Edad."); // Imprimimos que no disponemos de Elementos
                    } else { // Mostramos la lista con su nombre y si es Serio o Película
                        System.out.println(listarMedia(catalogoFiltrado,catalogoFiltrado.size(),false,true, true, false));
                    }

                }
                case OPCION_MOSTRAR_PELICULAS_POR_TEMATICA -> { // Mostrar n Mejores Películas por Temática
                    // Pedimos si desea mostrar todas las Películas incluidas las "No Disponibles"
                    boolean mostrarSoloDisponibles = GetData.getBoolean("Deseas mostrar solo las películas Disponibles (Si | No): ");
                    // Pedimos la Temática por la que desea Filtrar
                    Tematica tematicaElegida = getTematicaPelicula();
                    // Obtenemos las películas dependiendo de la opción del usuario (Todas o Solo Disponibles)
                    ArrayList<Pelicula> peliculas = peliculasDelCatalogo(catalogo, mostrarSoloDisponibles);
                    // Obtenemos las Películas con la Temática Elegida
                    ArrayList<Pelicula> peliculasFiltradasTematica = filtradoCategoriaPelicula(peliculas, tematicaElegida);
                    if (peliculasFiltradasTematica.isEmpty()) { // Comprobamos si no existen películas
                        System.out.println("No disponemos de Películas con esa Temática");
                    } else { // Si existen
                        // Las ordenamos por las Mejores
                        peliculasFiltradasTematica.sort(new OrdenarMejoresElementosCatalogo());
                        // Pedimos la cantidad que desea mostrar
                        int cantidadDeseada = GetData.getInt("Cuantas deseas mostrar (1 - "+peliculasFiltradasTematica.size()+")"+": ",1,peliculasFiltradasTematica.size());
                        // Imprimimos las Películas
                        System.out.println(listarMedia(peliculasFiltradasTematica,cantidadDeseada,false,true, false, true));
                    }
                }
                case OPCION_MOSTRAR_MEJORES_PELICULAS_POR_ACTOR -> { // Mostrar Mejores Películas por Actor Principal
                    // Pedimos si desea mostrar todas las Películas incluidas las "No Disponibles"
                    boolean mostrarSoloDisponibles = GetData.getBoolean("Deseas mostrar solo las películas Disponibles (Si | No): ");
                    // Obtenemos las películas dependiendo de la opción del usuario (Todas o Solo Disponibles)
                    ArrayList<Pelicula> peliculas = peliculasDelCatalogo(catalogo, mostrarSoloDisponibles);
                    if (peliculas.isEmpty()) { // Comprobamos si no existen películas
                        System.out.println("No disponemos de Películas Actualmente");
                    } else { // Si existen
                        // Obtenemos las Películas que contengan el Actor
                        ArrayList<Pelicula> peliculasDelActor = getPersonaPeliculas(peliculas,OPCION_ACTOR_PRINCIPAL);
                        // Ordenamos la Lista de Peliculas
                        peliculasDelActor.sort(new OrdenarMejoresElementosCatalogo());
                        // Pedimos la cantidad que desea mostrar
                        int cantidadDeseada = GetData.getInt("Cuantas deseas mostrar (1 - "+peliculasDelActor.size()+")"+": ",1,peliculasDelActor.size());
                        // Imprimimos las Películas
                        System.out.println(listarMedia(peliculasDelActor,cantidadDeseada,false,true, false, true));

                    }
                }
                case OPCION_MOSTRAR_MEJORES_PELICULAS_POR_DIRECTOR -> { // Mostrar las n Mejores Películas por Director
                    // Pedimos si desea mostrar todas las Películas incluidas las "No Disponibles"
                    boolean mostrarSoloDisponibles = GetData.getBoolean("Deseas mostrar solo las películas Disponibles (Si | No): ");
                    // Obtenemos las películas dependiendo de la opción del usuario (Todas o Solo Disponibles)
                    ArrayList<Pelicula> peliculas = peliculasDelCatalogo(catalogo, mostrarSoloDisponibles);
                    if (peliculas.isEmpty()) { // Comprobamos si no existen películas
                        System.out.println("No disponemos de Películas Actualmente");
                    } else { // Si existen
                        // Obtenemos las Películas que contengan el Director elegido
                        ArrayList<Pelicula> peliculasDelDirector = getPersonaPeliculas(peliculas,OPCION_DIRECTOR);
                        // Ordenamos por las Mejores Películas
                        peliculasDelDirector.sort(new OrdenarMejoresElementosCatalogo());
                        // Pedimos la cantidad que desea mostrar
                        int cantidadDeseada = GetData.getInt("Cuantas deseas mostrar (1 - "+peliculasDelDirector.size()+")"+": ",1,peliculasDelDirector.size());
                        // Imprimimos las Películas
                        System.out.println(listarMedia(peliculasDelDirector,cantidadDeseada,false,true, false, true));

                    }

                }
                case OPCION_MOSTRAR_MEJORES_SERIES -> { // Mostrar las n Mejores Series
                    // Pedimos si desea mostrar todas las Series incluidas las "No Disponibles"
                    boolean mostrarSoloDisponibles = GetData.getBoolean("Deseas mostrar solo las Series Disponibles (Si | No): ");
                    // Obtenemos las series dependiendo de la opción del usuario (Todas o Solo Disponibles)
                    ArrayList<Serie> series = seriesDelCatalogo(catalogo, mostrarSoloDisponibles);
                    if (series.isEmpty()) { // Comprobamos si no existen Series
                        System.out.println("No disponemos de Series actualmente.");
                    } else { // Si existen
                        // Las Ordenamos
                        series.sort(new OrdenarMejoresElementosCatalogo());
                        // Pedimos la cantidad que desea mostrar
                        int cantidadDeseada = GetData.getInt("Cuantas deseas mostrar (1 - "+series.size()+")"+": ",1,series.size());
                        // Imprimimos las Series
                        System.out.println(listarMedia(series,cantidadDeseada,false,true,false, true));
                    }
                }
                case OPCION_MOSTRAR_MEJORES_ELEMENTOS_DEL_CATALOGO -> { // Mostrar los n Mejores Elementos del Catálogo Disponibles
                    // Creamos el catálogo de solo disponibles
                    ArrayList<Media> catalogoOrdenadoDisponibles = new ArrayList<>();
                    // Añadimos las Películas Disponibles
                    catalogoOrdenadoDisponibles.addAll(peliculasDelCatalogo(catalogo, true));
                    // Añadimos las Series Disponibles
                    catalogoOrdenadoDisponibles.addAll(seriesDelCatalogo(catalogo, true));
                    if (catalogoOrdenadoDisponibles.isEmpty()) { // Comprobamos si el catálogo está vacío
                            System.out.println("No disponemos de Series ni Películas Disponibles. Disculpe las molestias");
                    } else { // Si no esta vacío
                        // Ordenamos el Catálogo
                        catalogoOrdenadoDisponibles.sort(new OrdenarMejoresElementosCatalogo());
                        // Pedimos la cantidad que desea mostrar
                        int cantidadDeseada = GetData.getInt("Cuantas deseas mostrar (1 - "+catalogoOrdenadoDisponibles.size()+")"+": ",1,catalogoOrdenadoDisponibles.size());
                        // Imprimimos las n mejores
                        System.out.println(listarMedia(catalogoOrdenadoDisponibles,cantidadDeseada, false,true, true, true));
                    }
                }
                case OPCION_SALIR_CONSULTAR_CATALOGO -> exit = true;
                default -> System.out.print("Opción no válida");
            }
        }
    }

    public static ArrayList<Media> filtradoPorEdad (ArrayList<Media> catalogo, int edadFiltro, boolean incluirSoloDisponibles) {
        // Creamos el Listado Filtrado por Edad
        ArrayList<Media> catalogoFiltrado = new ArrayList<>();
        for (Media media : catalogo) { // Iteramos por completo el Catálogo
            // Añadimos solos las Disponibles.
            if (incluirSoloDisponibles && media.getCalificacionEdad() == edadFiltro && media.isEstaDisponible()) {
                catalogoFiltrado.add(media);
                // Añadimos solo las Disponibles
            } else if (!incluirSoloDisponibles && media.getCalificacionEdad() == edadFiltro) {
                catalogoFiltrado.add(media);
            }
        }
        return catalogoFiltrado;
    }
    public static ArrayList<Pelicula> filtradoCategoriaPelicula (ArrayList<Pelicula> peliculas, Tematica categoria){
        // Creamos el Listado Filtrado por Temática
        ArrayList<Pelicula> peliculasFiltrada = new ArrayList<>();
        for (Pelicula pelicula : peliculas) { // Iteramos todas las Películas
            if (pelicula.getCategoria() == categoria) { // Si coinciden en la Temática las añadimos
                peliculasFiltrada.add(pelicula);
            }
        }
        return peliculasFiltrada;
    }

    public static ArrayList<Pelicula> getPersonaPeliculas(ArrayList<Pelicula> peliculas, String opcion_persona) {
        ArrayList<Pelicula> peliculasDeLaPersona = new ArrayList<>(); // Listado de las Películas de la Persona Elegida
        ArrayList<String> personas = new ArrayList<>(); // Listado de las Personas (Actores, Directores)
        String personaElegida = ""; // Persona Elegida por el Usuario
        for (Pelicula pelicula : peliculas) { // Guardamos todos los distintos (Actores o Directores)
            if (opcion_persona.equals(OPCION_DIRECTOR) && !personas.contains(pelicula.getDirector())) {
                personas.add(pelicula.getDirector());
            } else if (opcion_persona.equals(OPCION_ACTOR_PRINCIPAL) && !personas.contains(pelicula.getActorPrincipal())){
                personas.add(pelicula.getActorPrincipal());
            }
        }
        if (!personas.isEmpty()) { // Si existen Actores o Directores
            for (int i = 0; i < personas.size(); i++) { // Imprimimos los nombres
                System.out.println((i+1)+". "+personas.get(i));
            }
            // Guardamos el Nombre del Actor o Director Elegido
            personaElegida = personas.get(GetData.getInt("Que "+(opcion_persona.equals(OPCION_DIRECTOR) ? "director" : "actor")+" desea (1 - "+personas.size()+"): ",1,personas.size())-1);
        }

        if (!personaElegida.isBlank()) { // Si la persona Elegida no está vacío
            for (Pelicula pelicula : peliculas) { // Obtenemos todas las Películas con ese Actor o Director
                if (opcion_persona.equals(OPCION_DIRECTOR) && pelicula.getDirector().equals(personaElegida)) {
                    peliculasDeLaPersona.add(pelicula);
                } else if (opcion_persona.equals(OPCION_ACTOR_PRINCIPAL) &&pelicula.getActorPrincipal().equals(personaElegida)) {
                    peliculasDeLaPersona.add(pelicula);
                }
            }
        }
        return peliculasDeLaPersona;
    }

    /*------------------------
        Obtener ArrayLists
    -----------------------*/
        public static ArrayList<Pelicula> peliculasDelCatalogo(ArrayList<Media> catalogo, boolean almacenarSoloDisponibles) {
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        for (Media media : catalogo) {
            if (media instanceof Pelicula && !almacenarSoloDisponibles) {
                peliculas.add((Pelicula) media);
            } else if (media instanceof Pelicula && media.isEstaDisponible()) {
                peliculas.add((Pelicula) media);
            }
        }
        return peliculas;
    }
    public static ArrayList<Serie> seriesDelCatalogo(ArrayList<Media> catalogo, boolean almacenarSoloDisponibles) {
        ArrayList<Serie> series = new ArrayList<>();
        for (Media media : catalogo) {
            if (media instanceof Serie && !almacenarSoloDisponibles) {
                series.add((Serie) media);
            } else if (media instanceof Serie && media.isEstaDisponible()) {
                series.add((Serie) media);
            }
        }
        return series;
    }
}