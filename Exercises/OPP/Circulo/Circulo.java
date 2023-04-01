package FigurasGeometricas;
import FigurasGeometricas.Punto;

/**
 * Clase que representa un círculo en 2 dimensiones
 * Clase que contiene un objeto Punto y un double radio
 * @author Jose Maria
 */
public class Circulo {
    private Punto centro;
    private double radio;

    /*-----------------------
        Constructores
    -----------------------*/

    /**
     * Construye un Circulo con valores por defecto X = 0, Y = 0, Radio = 0.
     */
    public Circulo(){
        this(0,0,0);
    }

    /**
     * Construye un Círculo en base a los parámetros pasados. Objeto Punto y un Radio
     * Restricciones el Radio debe ser positivo y distinto de 0.
     * @param p Objeto Punto
     * @param radio Valor del radio
     */
    public Circulo(Punto p, double radio){
        this(p.getX(),p.getY(),radio);
    }

    /**
     * Constructor que crea un objeto Círculo, que contiene las coordenadas del centro del círculo y el valor del radio
     * Este constructor crea un objeto con un calor del centro en las coordenadas (x, y) recibidas por parámetro
     * Restricciones el Radio debe ser positivo y distinto de 0.
     * @param origen_x el valor de la coordenada x del centro del círculo
     * @param origen_y El valor de la coordenada y del centro del círculo
     * @param radio El valor del radio del círculo
     * @throws IllegalArgumentException cuando el radio es negativo
     */
    public Circulo(double origen_x, double origen_y, double radio){
        if (!validarRadio(radio)){
            throw new IllegalArgumentException("El radio debe de ser positivo");
        }
        this.centro = new Punto(origen_x,origen_y);
        this.radio = radio;
    }
    //Constructor Copia

    /**
     * Constructor que crea un objeto Circulo copiado de otro.
     * Crea un Circulo copiando los valores del Circulo pasado por parametro
     * @param c El objeto Ciruclo
     */
    public Circulo(Circulo c){
        this(c.centro.getX(),c.centro.getY(),c.radio);

    }

    /*----------------------
        Getters and Setter
    ------------------------*/

    /**
     * Método que devuelve una copia del Objeto Punto del Círculo
     * @return Devuelve un Objeto Punto
     */
    public Punto getCentro() {
        return new Punto(centro);
    }

    /**
     * Actualiza el centro del Círculo
     * @param centro Objeto Punto.
     */
    public void setCentro(Punto centro) {
        this.centro = new Punto(centro);
    }

    /**
     * Devuelve el radio
     * @return Devuelve el radio
     */
    public double getRadio() {
        return radio;
    }

    /**
     * Actualiza el valor del radio
     * @param radio Valor por el que se actualiza el radio
     * @throws IllegalArgumentException el radio debe de ser positivo y distinto de 0
     */
    public void setRadio(double radio) {
        if (validarRadio(radio)){
            this.radio = radio;
        }

    }

    /*-----------------------
        Métodos
    -----------------------*/

    /**
     * Calcula el área del Circulo.
     * @return Devuelve el cálculo del área del Circulo
     */
    public double getArea(){
        return Math.PI*Math.pow(this.radio,2);
    }

    /**
     * Calcula la Circunferencia del Circulo
     * @return Devuelve el cálculo de la Circunferencia
     */
    public double getCircunferencia(){
        return Math.PI*(2*this.radio);
    }

    /*-----------------------
        Validación
    -----------------------*/
    private boolean validarRadio(double radio){
        return radio >= 0;
    }

    /*-----------------------
        Override
    -----------------------*/

    @Override
    public String toString() {
        return "Circulo"+" - "+this.centro+" - "+"Radio "+this.radio;
    }

    @Override
    public boolean equals(Object obj) {
       Circulo c = (Circulo) obj;
       return this.radio == c.radio && this.centro.equals(c.centro);
    }
}
