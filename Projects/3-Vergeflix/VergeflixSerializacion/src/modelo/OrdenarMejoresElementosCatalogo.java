package modelo;

import java.util.Comparator;

/**
 * Comparador de Media para ordenar de mejores Media a menos valorados.
 * La valoración se determina con el método calcularPuntuacion() de las subClases de Media (Pelicula, Serie).
 * @see Pelicula
 * @see Serie
 */
public class OrdenarMejoresElementosCatalogo implements Comparator<Media> {
    @Override
    public int compare(Media o1, Media o2) {
        return o2.calcularPuntuacion() - o1.calcularPuntuacion();
    }
}
