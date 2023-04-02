package desarrollozaidin;


/**
 * Clase que representa un Comercial es una subClase de Empleado
 * La clase se compone de:
 * <ul>
 *     <li>Los valores de Empleado</li>
 *     <li>Zona de Ventas: Es un enum llamado ZonaVentas</li>
 *     <li>Numero de Ventas: Es el número de ventas realizadas</li>
 * </ul>
 * @see Empleado
 * @see ZonaVentas
 *
 */
public class Comercial extends Empleado{
    private ZonaVentas zonaVentas;
    private int numeroVentasRealizada;

    /**
     * Constructor de Comercial crea un nuevo Comcercial con: nombre, apellidos,
     * salario base, años,zona de ventas, numero de ventas realizadas
     * @param nombre El nombre del Empleado. No puede estar vacío o contener solo espacios en blanco
     * @param apellidos Los apellidos del Empleado. No puede estar vacío o contener solo espacios en blanco
     * @param salarioBase El Salario Base el empleado debe de ser un número positivo distinto de 0.
     * @param años Los años de Experiencia en la Empresa. Debe de ser un número positivo incluido el 0.
     * @param zonaVentas La Zona de Ventas se representa con un Enum ZonaVentas
     * @param numeroVentasRealizada El número de ventas Realizadas no puede ser un número negativo
     * @throws IllegalArgumentException Si el Nombre introducido está vacío o contiene solo espacios en blanco
     * @throws IllegalArgumentException Si los Apellidos introducidos está vacío o contiene solo espacios en blanco
     * @throws IllegalArgumentException Si el Salario Base introducido es un número negativo.
     * @throws IllegalArgumentException Si los Años introducidos son un número negativo.
     * @throws IllegalArgumentException Si el número de ventas es un valor negativo
     */
    public Comercial(String nombre, String apellidos, int salarioBase, int años, ZonaVentas zonaVentas, int numeroVentasRealizada) {
        super(nombre, apellidos, salarioBase, años);
        if (numeroVentasRealizada < 0) {
            throw new IllegalArgumentException("El numero de Ventas Realizada no puede ser negativo");
        }
        this.zonaVentas = zonaVentas;
        this.numeroVentasRealizada = numeroVentasRealizada;
    }

    /**
     * Constructor Copia recibe un Comercial y realiza una copia profunda de todos los datos
     * @param comercial El Objeto Comercial a Copiar
     */
    public Comercial (Comercial comercial) {
        super(comercial.getNombre(),comercial.getApellidos(),comercial.getSalarioBase(),comercial.getAños());
        this.zonaVentas = comercial.zonaVentas;
        this.numeroVentasRealizada = comercial.numeroVentasRealizada;
    }

    /**
     * Devuelve el Enum ZonaVentas a la que pertenece
     * @return el Enum ZonaVentas a la que pertenece
     */
    public ZonaVentas getZonaVentas() {
        return zonaVentas;
    }

    /**
     * Modifica la Zona de Vetas
     * @param zonaVentas La nueva zona de ventas
     */
    public void setZonaVentas(ZonaVentas zonaVentas) {
        this.zonaVentas = zonaVentas;
    }

    /**
     * Devuelve el número de ventas realizadas
     * @return el número de ventas realizadas
     */
    public int getNumeroVentasRealizada() {
        return numeroVentasRealizada;
    }

    /**
     * Modifica el número de ventas realizadas debe de ser un número positivo o 0 para modificarse
     * @param numeroVentasRealizada El nuevo número de ventas realizada
     */
    public void setNumeroVentasRealizada(int numeroVentasRealizada) {
        if (numeroVentasRealizada >= 0)
            this.numeroVentasRealizada = numeroVentasRealizada;
    }

    /**
     * Método que represetenta en forma de String el Objeto Comercial
     * @return Devuelve una cadena de texto con la información de Comercial
     */
    @Override
    public String toString() {
        return "Comercial: " + "\n" +
                super.toString() + "\n" +
                "Zona Ventas: " + this.zonaVentas + "\n" +
                "Numero de Ventas: " + this.numeroVentasRealizada;
    }

    /**
     * Método para calcular el Salario de Comercial y se calcula:
     * El  salario base + 100 euros por cada trienio en la empresa y
     * un 10% del salario base si realiza más de 5 ventas y un 15 si realiza 10 o más ventas
     * @return El salario calculado del Comercial
     */
    @Override
    public double calcularSalario() {
        int salarioMasPlusPorVentas = getSalarioBase();
        int plusTrienios = numeroTrienios() * 100;

        if (numeroVentasRealizada > 5 && numeroVentasRealizada < 10) {
            salarioMasPlusPorVentas += salarioMasPlusPorVentas * .1;
        } else if (numeroVentasRealizada >= 10) {
            salarioMasPlusPorVentas += salarioMasPlusPorVentas * .15;
        }
        return salarioMasPlusPorVentas + plusTrienios;

    }
}
