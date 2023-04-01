package FigurasGeometricas;


/**
 * Esta clase representa un Punto en dos dimensiones
 * Es una versión inicial que hemos creado para aprender POO
 * @author Jose Maria
 * @version 1.1
 * @since 1.0
 */
public class Punto {
    private double x,y;

    /*-----------------------
       Constructores
    -----------------------*/
    /**
     * Constructor por defecto y los valores son 0,0.
     * Se construirá un objeto con los valores por defecto de X e Y los cuales son 0,0.
     */
    public Punto(){
        this(0,0);
    }


    /**
     * Construye un Punto a través de las coordenada X e Y.
     * Se construirá con los valores pasados por parámetro X e Y
     * @param x El valor de la coordenada x del punto.
     * @param y El valor de la coordenada y del punto.
     */
    public Punto(double x, double y){
        this.x = x;
        this.y = y;
    }
    /**
     * Construye un Punto a través de una única coordenada x e y.
     * Se construirá un objeto con ambos valores iguales al pasador por parámetro.
     * @param valor El valor de ambas coordenadas.
     */
    public Punto(double valor){
        this(valor,valor);
    }

    //Constructor Copia

    /**
     * Construye un Punto a través de otro Punto
     * Un constructor copia que crea un Punto idéntico al pasado por parámetro
     * @param p El objeto Punto
     */
    public Punto(Punto p){
        this(p.x,p.y);
    }

    /*-----------------------
       Getters and Setters
    -----------------------*/
    // Métodos Getters and Setters

    /**
     * Método que devuelve X
     * @return Devuelve X
     */
    public double getX() {
        return x;
    }

    /**
     * Método que actualiza X
     * @param x Valor por el cual se actualiza X
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Método que devuelve Y
     * @return Devuelve el valor de Y
     */
    public double getY() {
        return y;
    }

    /**
     * Método que actualiza Y
     * @param y Valor por el cual se actualiza Y
     */
    public void setY(double y) {
        this.y = y;
    }

    /*-----------------------
       Overrides
    -----------------------*/
    // ToString

    /**
     * Override de toString
     * @return Devuelve un String con un formato concreto
     */
    @Override
    public String toString() {
        return "Punto: X="+this.x+" Y="+this.y;
    }

    // Equals

    /**
     * Override de equals
     * Compara dos Punto y retorna true si son iguales tanto X como Y.
     * @param obj El objeto Punto
     * @return Devuelve un booleano
     */
    @Override
    public boolean equals(Object obj) {
        Punto p = (Punto) obj;
        return this.x == p.x && this.y == p.y;
    }
}
