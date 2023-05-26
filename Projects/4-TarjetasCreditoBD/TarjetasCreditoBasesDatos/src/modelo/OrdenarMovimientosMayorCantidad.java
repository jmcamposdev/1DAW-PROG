package modelo;

import java.util.Comparator;

/**
 * Comparador para la clase Movimiento ordena los movimientos
 * con base en su cantidad de mayor a menor
 * @author josemaria
 */
public class OrdenarMovimientosMayorCantidad implements Comparator<Movimiento> {
    
    /**
     * Método compare que compara dos movimientos con base en su cantidad
     * @param o1 Movimiento 1 a comparar
     * @param o2 Movimiento 2 a comparar
     * @return Devolve 0 si poseen la misma cantidad, un valor positivo si
     * el movimiento del primer parámetro posee mayor cantidad y negativo en
     * caso contrario
     */
    @Override
    public int compare(Movimiento o1, Movimiento o2) {
        return (int) (o1.getCantidad() - o2.getCantidad()) * -1;
    }
}
