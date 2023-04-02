package desarrollozaidin;

import java.util.Comparator;

public class OrdenarMejoresComerciales implements Comparator<Comercial> {
    @Override
    public int compare(Comercial o1, Comercial o2) {
        return o2.getNumeroVentasRealizada() - o1.getNumeroVentasRealizada();
    }
}
