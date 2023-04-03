package clases;

import java.util.Comparator;

public class OrdenarMovientosMayorCantidad implements Comparator<Movimiento> {
    @Override
    public int compare(Movimiento o1, Movimiento o2) {
        return (int) (o1.getCantidad() - o2.getCantidad()) * -1;
    }
}
