package JPA;

import javax.persistence.*;
import modelo.Movimiento;

/**
 * Entidad JPA que representa un Movimiento de Tarjeta
 * hereda de Movimiento y todos sus atributos se encuentra
 * mapeados con la base de datos.
 * Posee un ID que se genera automáticamente, Una relación ManyToOne con TarjetaCreditoJPA
 * @author josemaria
 */
@Entity
@Table(name = "movimientos")
public class MovimientoJPA extends modelo.Movimiento{
    /**
     * Atributo de la clase MovimientoJPA el cual es el ID
     * del movimiento es único y se genera automáticamente
     * es la clave primaria del movimiento
     */
    @Id // Indica que es la clave primaria
    @GeneratedValue // Genera el ID automáticamente
    @Column(name = "id")
    private long id;

    
    /**
     * Atributo que realiza la función de relación
     * con la tarjeta de credito posee @ManyToOne, ya que
     * una tarjeta posee varios movimientos y @JoinColumn
     * su función es indicar cuál es la columna de la clave foránea
     * en la base de datos en este caso es el número de la tarjeta
     * que es el ID de la clase TarjetaCreditoJPA
     */
    @ManyToOne // Indica que es una relación Muchos a Uno
    @JoinColumn(name = "id_numero_tarjeta") // Indica la columna de la clave foránea de la tabla movimientos
    private final TarjetaCreditoJPA tarjetaCredito;

    /**
     * Constructor sin argumentos de la clase MovimientoJPA.
     * Llama al constructor sin argumentos de la clase padre (Movimiento).
     */
    public MovimientoJPA() {
        super();
        this.tarjetaCredito = null;
    }

    /**
     * Constructor que asigna la cantidad y concepto llamando al constructor de la clase padre
     * y asigna la tarjeta de Credito al movimiento para realizar la relación
     * @param cantidad La cantidad del movimiento
     * @param concepto El concepto del movimiento
     * @param tarjetaCredito  La tarjeta de Credito a la que pertenece el movimiento
     */
    public MovimientoJPA(double cantidad, String concepto, TarjetaCreditoJPA tarjetaCredito) {
        super(cantidad, concepto);
        this.tarjetaCredito = new TarjetaCreditoJPA(tarjetaCredito);
    }
    
    /**
     * Constructor que recibe un Movimiento y lo convierte a una Entidad MovimientoJPA
     * @param movimiento Objeto Movimiento a convertir
     * @param tarjetaCredito Objeto TarjetaCredito en la que se ha efectuado el movimiento
     */
    public MovimientoJPA(Movimiento movimiento, TarjetaCreditoJPA tarjetaCredito) {
        this(movimiento.getCantidad(),movimiento.getConcepto(),tarjetaCredito);
    }


    /**
     * Constructor que recibe un MovimientoJPA y lo convierte a una Entidad MovimientoJPA
     * realizando una copia profunda de todos sus atributos
     * @param movimientoJPA Objeto MovimientoJPA a convertir
     */
    public MovimientoJPA(MovimientoJPA movimientoJPA) {
        this(movimientoJPA.getCantidad(),movimientoJPA.getConcepto(),movimientoJPA.getTarjetaCredito());
        super.setFecha(movimientoJPA.getFecha());
        this.id = movimientoJPA.getId();
    }

    /**
     * Método que devuelve la tarjeta de Credito a la que pertenece este movimiento
     * @return Devuelve la tarjeta de Credito a la que pertenece este movimiento
     */
    public TarjetaCreditoJPA getTarjetaCredito() {
        return tarjetaCredito;
    }

    /**
     * Método para obtener el ID del movimiento
     * @return Devuelve el ID del movimiento
     */
    public long getId() {
        return this.id;
    }



}
