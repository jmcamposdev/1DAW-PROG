package clases;

import java.util.Comparator;

public class OrdenarGastoMayorTarjeta implements Comparator<TarjetaCredito> {
    @Override
    public int compare(TarjetaCredito o1, TarjetaCredito o2) {
        return (int) (o1.gastado() - o2.gastado()) * -1;
    }
}
