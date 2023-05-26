package JPA;

import modelo.Movimiento;
import modelo.OrdenarMovimientosMayorCantidad;
import modelo.TarjetaCredito;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Clase que representa una Entidad JPA de una Tarjeta de Crédito.
 * Contiene información sobre el titular, el número de identificación, el pin, el límite, la fecha de caducidad, el número de la tarjeta, el cvv y los movimientos realizados con la tarjeta.
 * Hereda de la clas TarjetaCredito la cual tiene sus atributos mapeados y añadimos la relación con MovimientoJPA
 * La relación es Uno a Muchos, Una tarjeta posee varios movimientos y un movimiento solo puede estar en una tarjeta.
 * La clase sobreescribe todos los métodos relacionados con los movimientos.
 * @author José María Campos Trujillo
 * @version 1.0
 */
@Entity
@Table(name = "tarjetacredito")
public class TarjetaCreditoJPA extends TarjetaCredito implements Serializable{
    /**
     * Lista de todos las Entidades - Movimientos de la tarjeta 
     * Con @OneToMany se relaciona la relación Uno a muchos
     * en la que se mapea el atributo "tarjetaCredito" que está
     * en la clase MovimientosJPA
     */
    @OneToMany(mappedBy = "tarjetaCredito")
    private final List<MovimientoJPA> movimientos;
   

    /**
     * Constructor por defecto llama al constructor por defecto de la 
     * superClase e inicializa los movimientos
     */
    public TarjetaCreditoJPA() {
        super();
        this.movimientos = new ArrayList<>();
    }

    /**
     * Constructor con todos los atributos de la Tarjeta de Credito
     * Valida que los campos sean correctos para ello:
     * - Nombre: Debe de componerse de letras exclusivamente y poseer una longitud entre 15 y 80 caracteres
     * - NIF: Debe ser un NIF, NIE, DNI válido se comprobará algorítmicamente y a través de su formato
     * - PIN: Debe poseer 4 dígitos 
     * - Límite: Debe de encontrarse entre 500 y 5000
     * - NumeroTarjeta: Debe de ser un número de 16 dígitos se validará a través del algoritmo de Luhn
     * - mesCaducidad: Debe de encontrarse entre 1 y 12 ambos incluidos
     * - añoCaducidad: No puede ser un valor inferior al 1900
     * - CVV: Debe contener 3 dígitos
     * @param titular El Titular de la Tarjeta
     * @param nif El NIF del Titular
     * @param pin El PIN de la Tarjeta
     * @param limite El Límite mensual de la tarjeta
     * @param mesCaducidad El mes de Caducidad de la Tarjeta
     * @param añoCaducidad El año de Caducidad de la Tarjeta
     * @param numeroTarjeta El número de la Tarjeta
     * @param cvv El CVV de la Tarjeta
     */
    public TarjetaCreditoJPA(String titular, String nif, String pin, int limite, int mesCaducidad,int añoCaducidad, String numeroTarjeta, String cvv) {
        super(titular, nif, pin, limite, mesCaducidad, añoCaducidad, numeroTarjeta, cvv);
        this.movimientos = new ArrayList<>();
    }
    
    /**
     * Constructor que convierte un Objeto TarjetaCredito a un Objeto TarjetaCreditoJPA
     * Copia todos sus movimientos si posee y los convierte a Movimientos JPA.
     * @param tarjeta Tarjeta de Crédito a convertir
     */
    public TarjetaCreditoJPA(TarjetaCredito tarjeta) {
        this(tarjeta.getTitular(),tarjeta.getNif(),tarjeta.getPin(),tarjeta.getLimite(),tarjeta.getMesCaducidad(),tarjeta.getAñoCaducidad(),tarjeta.getNumeroTarjeta(),tarjeta.getCvv());
        ArrayList<Movimiento> listaMovimientos = tarjeta.movimientos(tarjeta.numeroMovimientos());
        for (Movimiento movimiento : listaMovimientos) {
            this.movimientos.add(new MovimientoJPA(movimiento, this));
        }
    }

    /**
     * Método sobreescrito el cual devuelve el número de movimientos que ha realizado la tarjeta
     * @return El número de movimientos que ha realizado la tarjeta
     */
    @Override
    public int numeroMovimientos() {
        return this.movimientos.size();
    }
    
    /**
     * Método sobreescrito el cual devuelve los n últimos movimientos realizados en la tarjeta
     * Si el número es inválido lanzará una excepción
     * @param numero El número de movimientos deseados
     * @return Devolverá un listado con los n movimentos
     * @throws IllegalArgumentException Si el número es negativo o mayor que el número de movimientos
     */
    @Override
    public ArrayList<Movimiento> movimientos(int numero){
        // Validamos que el número no sea negativo y que poseemos tantos movimientos como el número insertado
        if (numero < 0 || numero > this.movimientos.size()){
            throw new IllegalArgumentException("Valor fuera del rango");
        }
        int posicionInicio = this.movimientos.size() - numero;
        // Si existen los añadimos al StringBuilder
        // Calculamos la posición para recorrer el array
        ArrayList<Movimiento> movimientosPedidos = new ArrayList<>();
        for (int i = posicionInicio; i < this.movimientos.size(); i++) {
            movimientosPedidos.add(new Movimiento(this.movimientos.get(i)));
        }
        return movimientosPedidos;
    }

    /**
     * Método sobreescrito el cual devuelve un String con los n movimientos con mayor cantidad
     * @param numero Este parámetro especifica cuántos movimientos se deben mostrar. Debe ser un valor entero mayor o igual a cero.
     * @return Devolverá un listado con los n movimientos
     * @throws IllegalArgumentException Si el número es negativo o mayor que el número de movimientos
     */
    @Override
    public String movimientosMayorCantidad(int numero) {
        if (numero <= 0 || numero > this.movimientos.size()) {
            throw new IllegalArgumentException("Valor fuera del rango");
        }
        ArrayList<Movimiento> movimientosOrdenados = new ArrayList<>();
        for (Movimiento movimiento : this.movimientos) {
            movimientosOrdenados.add(new MovimientoJPA(movimiento, this));
        }
        Collections.sort(movimientosOrdenados, new OrdenarMovimientosMayorCantidad());
        StringBuilder movimientosString = new StringBuilder();
        for (int i = 0; i < numero; i++) {
            movimientosString.append(movimientosOrdenados.get(i)).append("-------------------").append("\n");
        }
        return movimientosString.toString();
    }
    
    /**
     * Método sobreescrito que permite realizar un pago con la tarjeta de crédito.
     * @param cantidad La cantidad a pagar.
     * @param concepto Concepto del pago.
     * @throws IllegalArgumentException Si la cantidad es negativa
     * @throws IllegalArgumentException Si el concepto está vacío o posee más de 50 caracteres
     * @return true si el pago fue realizado exitosamente, false en caso contrario.
     */
    @Override
    public boolean pagar(double cantidad, String concepto){
        if (!Movimiento.validarCantidad(cantidad)){ // Validamos la cantidad
            throw new IllegalArgumentException("La cantidad debe de ser positiva");
        }
        if (!Movimiento.validarConcepto(concepto)){ // Validamos el concepto
            throw new IllegalArgumentException("El concepto no debe permanecer vacío y debe poseer un máximo de 50 caracteres.");
        }
        boolean movimientoRealizado = false;
        // Comprobamos que no exceda el límite sumando el gasto actual + los gastos anteriores
        if (gastado()+cantidad <= super.getLimite()){
            this.movimientos.add(new MovimientoJPA(cantidad,concepto,this)); // Añadimos el movimiento e incrementamos el contador
            super.totalGastado += cantidad; // Sumamos el pago
            movimientoRealizado = true;
        }
       return movimientoRealizado;
    }

    /**
     * Método el cual actualiza el total gastado de la tarjeta
     */
    public void actualizarGastado() {
        for (MovimientoJPA movimiento : this.movimientos) {
            super.totalGastado += movimiento.getCantidad();
        }
    }
}
