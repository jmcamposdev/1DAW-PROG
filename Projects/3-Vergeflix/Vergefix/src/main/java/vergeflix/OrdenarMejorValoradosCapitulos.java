package vergeflix;

import java.util.Comparator;

/**
 * Comparador de Capítulos ordena los capítulos de mejor valorados a menos valorados.
 * La valoración es el resultado del Método calcularPuntuacion() que poseen los Capítulos
 * @see Capitulo
 */
public class OrdenarMejorValoradosCapitulos implements Comparator<Capitulo> {

    @Override
    public int compare(Capitulo o1, Capitulo o2) {
        return (o2.calcularPuntuacion() - o1.calcularPuntuacion());
    }
}
