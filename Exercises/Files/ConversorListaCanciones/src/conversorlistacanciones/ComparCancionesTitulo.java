package conversorlistacanciones;

import java.util.Comparator;

public class ComparCancionesTitulo implements Comparator<Cancion> {
    @Override
    public int compare(Cancion o1, Cancion o2) {
        return o1.getTitulo().compareTo(o2.getTitulo());
    }
}
