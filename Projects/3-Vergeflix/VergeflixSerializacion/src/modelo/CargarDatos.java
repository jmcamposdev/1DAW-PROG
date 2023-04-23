package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class CargarDatos {
    public static void cargarTemporada (Temporada temporada) {
        Capitulo capitulo1 = new Capitulo("La desaparición de Will Byers", LocalDate.of(2016, 7, 16));
        temporada.añadirCapitulo(capitulo1);
        temporada.añadirCapitulo(new Capitulo("La loca de la calle Maple", LocalDate.of(2017, 7, 16)));
        temporada.añadirCapitulo(new Capitulo("Holly, Jolly", LocalDate.of(2016, 7, 30)));
        temporada.añadirCapitulo(new Capitulo("El cuerpo", LocalDate.of(2016, 7, 16)));
        temporada.añadirCapitulo(new Capitulo("La pulga y el acróbata", LocalDate.of(2016, 7, 16)));
    }

    public static void cargarPeliculas (ArrayList<Media> catalogo) {
        catalogo.add(new Pelicula("El Padrino", 18, LocalDate.of(1972, 3, 15), true, "Francis Ford Coppola", "Marlon Brando", 175, Tematica.DRAMA));
        catalogo.add(new Pelicula("El Señor de los Anillos: La Comunidad del Anillo", 12, LocalDate.of(2001, 12, 19), false, "William Friedkin", "Elijah Wood", 178, Tematica.CIENCIA_FICCION));
        catalogo.add( new Pelicula("Forrest Gump", 12, LocalDate.of(1994, 7, 6), true, "Robert Zemeckis", "Tom Hanks", 142, Tematica.DRAMA));
        catalogo.add(new Pelicula("El club de la pelea", 18, LocalDate.of(1999, 10, 15), true, "Francis Ford Coppola", "Marlon Brando", 139, Tematica.SUSPENSE));
        catalogo.add(new Pelicula("El silencio de los inocentes", 18, LocalDate.of(1991, 2, 14), true, "William Friedkin", "Tom Hanks", 118, Tematica.TERROR));
        catalogo.add(new Pelicula("Pulp Fiction", 18, LocalDate.of(1994, 9, 23), false, "Robert Zemeckis", "Elijah Wood", 154, Tematica.DRAMA));
        catalogo.add(new Pelicula("La La Land", 7, LocalDate.of(2016, 12, 25), false, "Francis Ford Coppola", "Marlon Brando", 128, Tematica.COMEDIA));
        catalogo.add(new Pelicula("Jurassic Park", 12, LocalDate.of(1993, 6, 11), true, "William Friedkin", "Tom Hanks", 127, Tematica.CIENCIA_FICCION));
        catalogo.add(new Pelicula("El exorcista", 18, LocalDate.of(1973, 12, 26), true, "Robert Zemeckis", "Elijah Wood", 122, Tematica.TERROR));
        catalogo.add( new Pelicula("El laberinto del fauno", 16, LocalDate.of(2006, 5, 27), true, "Francis Ford Coppola", "Marlon Brando", 118, Tematica.CIENCIA_FICCION));
    }
    public static void cargarSeries(ArrayList<Media> catalogo) {
        catalogo.add(new Serie("La Casa de Papel", 16, LocalDate.of(2017, 5, 2), true, LocalDate.of(2017, 5, 2)));
        catalogo.add(new Serie("Friends", 12, LocalDate.of(1994, 9, 22), false, LocalDate.of(1994, 9, 22)));
        catalogo.add(new Serie("Breaking Bad", 18, LocalDate.of(2008, 1, 20), false, LocalDate.of(2008, 1, 20)));
        catalogo.add(new Serie("Game of Thrones", 18, LocalDate.of(2011, 4, 17), true, LocalDate.of(2011, 4, 17)));
        catalogo.add(new Serie("Stranger Things", 16, LocalDate.of(2016, 7, 15), true, LocalDate.of(2016, 7, 15)));
        catalogo.add(new Serie("Black Mirror", 16, LocalDate.of(2011, 12, 4), true, LocalDate.of(2011, 12, 4)));
        catalogo.add(new Serie("The Crown", 16, LocalDate.of(2016, 11, 4), true, LocalDate.of(2016, 11, 4)));
        catalogo.add(new Serie("Narcos", 18, LocalDate.of(2015, 8, 28), true, LocalDate.of(2015, 8, 28)));
        catalogo.add(new Serie("The Mandalorian", 7, LocalDate.of(2019, 11, 12), true, LocalDate.of(2019, 11, 12)));
        catalogo.add(new Serie("The Big Bang Theory", 12, LocalDate.of(2007, 9, 24), true, LocalDate.of(2007, 9, 24)));
    }

    public static void cargarTemporadasCasaDePapel(Serie serie) {
        serie.añadirTemporada(LocalDate.of(2017, 5, 2));

        // Añadir los Capítulos de la Temporada 1
        serie.añadirCapitulo(0, 0, LocalDate.of(2017, 5, 2), "Efectuar lo acordado");
        serie.añadirCapitulo(0, 1, LocalDate.of(2017, 5, 2), "Imprudencias letales");
        serie.añadirCapitulo(0, 2, LocalDate.of(2017, 5, 2), "Errores de cálculo");
        serie.añadirCapitulo(0, 3, LocalDate.of(2017, 5, 2), "Caballo de Troya");
        serie.añadirCapitulo(0, 4, LocalDate.of(2017, 5, 2), "Que se jodan los pringados");
        serie.añadirCapitulo(0, 5, LocalDate.of(2017, 5, 2), "El día de la marmota");
        serie.añadirCapitulo(0, 6, LocalDate.of(2017, 5, 2), "La cálida Guerra Fría");

        // Añadir la Temporada 2
        serie.añadirTemporada(LocalDate.of(2019, 4, 6));

        // Añadir los Capítulos de la Temporada 2
        serie.añadirCapitulo(1, 0, LocalDate.of(2019, 4, 6), "Se acabaron las máscaras");
        serie.añadirCapitulo(1, 1, LocalDate.of(2019, 4, 6), "La cabeza del plan");
        serie.añadirCapitulo(1, 2, LocalDate.of(2019, 4, 6), "Cuestión de eficacia");
        serie.añadirCapitulo(1, 3, LocalDate.of(2019, 4, 6), "¿Qué hemos hecho?");
        serie.añadirCapitulo(1, 4, LocalDate.of(2019, 4, 6), "A contrarreloj");
        serie.añadirCapitulo(1, 5, LocalDate.of(2019, 4, 6), "Bum, bum, ciao");

        // Añadir la Temporada 3
        serie.añadirTemporada(LocalDate.of(2019, 7, 19));

        // Añadir los capítulos de la Temporada 3
        serie.añadirCapitulo(2, LocalDate.of(2019, 7, 19), "Hemos vuelto");
        serie.añadirCapitulo(2, LocalDate.of(2019, 7, 19), "Aikido");
        serie.añadirCapitulo(2, LocalDate.of(2019, 7, 19), "48 metros bajo el suelo");
        serie.añadirCapitulo(2, LocalDate.of(2019, 7, 19), "La hora del delfín");
        serie.añadirCapitulo(2, LocalDate.of(2019, 7, 19), "Bum, bum, ciao");
        serie.añadirCapitulo(2, LocalDate.of(2019, 7, 19), "Todo pareció insignificante");
        serie.añadirCapitulo(2, LocalDate.of(2019, 7, 19), "Pequeñas vacaciones");
        serie.añadirCapitulo(2, LocalDate.of(2019, 7, 19), "La deriva");
        serie.añadirCapitulo(2, LocalDate.of(2019, 7, 19), "Resistencia");
        serie.añadirCapitulo(2, LocalDate.of(2019, 7, 19), "Plan París");
        serie.añadirCapitulo(2, LocalDate.of(2019, 7, 19), "¿Qué hemos hecho?");
        serie.añadirCapitulo(2, LocalDate.of(2019, 7, 19), "5 minutos antes");
        serie.añadirCapitulo(2, LocalDate.of(2019, 7, 19), "A contrarreloj");
    }

    public static void cargarPelicula (Pelicula pelicula) {
        pelicula.votar(1);
        pelicula.votar(2);
        pelicula.votar(3);
        pelicula.votar(4);
        pelicula.votar(5);
        pelicula.votar(6);
        pelicula.votar(7);
        pelicula.votar(8);
    }
}
