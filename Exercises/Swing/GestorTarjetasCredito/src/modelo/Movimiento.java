package clases;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 * Clase que representa un movimiento en una tarjeta de crédito.
 * @author José María Campos Trujillo
 * @version 1.0
 *
 */
public class Movimiento implements Comparable<Movimiento>{

    /**
     * Formato de fecha y hora para el movimiento.
     */
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    /**
     * Cantidad del movimiento.
     */
    private final double cantidad;

    /**
     * Concepto del movimiento.
     */
    private String concepto;

    /**
     * Fecha del movimiento.
     */
    private LocalDateTime fecha;

    /**
     * Constructor para crear un movimiento con una cantidad y un concepto.
     * @param cantidad Cantidad del movimiento.
     * @param concepto Concepto del movimiento.
     * @throws IllegalArgumentException Si la cantidad es menor o igual a 0.
     * @throws IllegalArgumentException si el concepto es nulo o tiene más de 50
     */
    public Movimiento(double cantidad, String concepto){
        if (!validarCantidad(cantidad)){ // Validamos la cantidad
            throw new IllegalArgumentException("La cantidad debe ser un valor positivo");
        }
        if (!validarConcepto(concepto)){ // Validamos el concepto
            throw new IllegalArgumentException("El concepto debe tener una longitud máxima de 50 caracteres");
        }
        // Asignamos los parámetros a los atributos
        this.cantidad = cantidad;
        this.concepto = concepto;
        this.fecha = LocalDateTime.now();
    }

    /**
     * Constructor de copia para crear un nuevo movimiento a partir de otro existente.
     * @param m Movimiento existente a copiar.
     */
    public Movimiento(Movimiento m){
        // Todos los atributos son inmutables
        this(m.cantidad,m.concepto);
        this.fecha = m.fecha;
    }

    /**
     * Devuelve la cantidad del movimiento.
     * @return Cantidad del movimiento.
     */
    public double getCantidad() {
        return cantidad;
    }

    /**
     * Devuelve el concepto del movimiento.
     * @return Concepto del movimiento.
     */
    public String getConcepto() {
        return concepto;
    }

    /**
     * Devuelve la fecha del movimiento.
     * @return Fecha del movimiento.
     */
    public LocalDateTime getFecha() {
        return fecha; // El objeto LocalDate es inmutable
    }

    /**
     * Asigna un nuevo valor al atributo "concepto" de la clase Movimiento.
     * Antes de actualizar el valor, se valida que cumpla con las condiciones necesarias.
     * @param concepto El nuevo valor a asignar al atributo "concepto"
     */
    public void setConcepto(String concepto) {
        if (validarConcepto(concepto)) // Validamos el concepto antes de actualizarlo
            this.concepto = concepto;
    }



    /**
     * Devuelve una representación en formato de cadena del objeto Movimiento.
     * Incluye los valores de los atributos "concepto", "cantidad" y "fecha" con un formato específico.
     * @return Devuelve un String que representa el Movimiento.
    */
     @Override
    public String toString() {
        return "Movimiento: \n" +
                "Concepto: "+this.concepto+"\n"+
                "Cantidad: "+this.cantidad+"\n"+
                "Fecha realizado: "+DATE_TIME_FORMATTER.format(this.fecha)+"\n"; // Le damos un buen formato a la fecha
    }

    /**
     * Compara si dos objetos Movimiento son idénticos en cuanto a sus valores de atributos.
     * Se considera que dos objetos son iguales si su "concepto", "cantidad" y "fecha" son iguales.
     * @param m El objeto Movimiento con el cual se comparará el objeto actual.
     * @return true si los objetos son iguales, false en caso contrario.
     */
    public boolean equals(Movimiento m) {
        // Comparamos que todos los valores sean idénticos entre sí.
        return this.concepto.equalsIgnoreCase(m.concepto) && this.cantidad == m.cantidad && this.fecha == m.fecha;
    }

    /**
     * Valida que la cantidad sea un valor positivo.
     * @param cantidad La cantidad a validar.
     * @return true si la cantidad es positiva, false en caso contrario.
     */
    public static boolean validarCantidad(double cantidad){
        return cantidad > 0;
    }

    /**
     * Valida que el concepto tenga una longitud máxima de 50 caracteres y no sea una cadena vacía o solo espacios en blanco.
     * @param concepto El concepto a validar.
     * @return true si el concepto cumple con las condiciones de longitud y no estar vacío, false en caso contrario.
     */
    public static boolean validarConcepto(String concepto){
        return concepto.length() <= 50 && !concepto.isBlank();
    }

    @Override
    public int compareTo(Movimiento o) {
        return this.fecha.compareTo(o.fecha);
    }
}
