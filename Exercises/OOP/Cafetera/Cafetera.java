package poo.EjerciciosSencillos_2.Cafetera;

public class Cafetera {
    private int capacidadMaxima;
    private int capacidadActual;

    /*-----------------------
        Constructores
    -----------------------*/
    public Cafetera(){
        this(0,1000);
    }
    public Cafetera(int capacidadMaxima){
        this(capacidadMaxima,capacidadMaxima);
    }
    public Cafetera(int capacidadActual, int capacidadMaxima){
        if (!validarCantidad(capacidadActual) || !validarCantidad(capacidadMaxima))
            throw new IllegalArgumentException("El valor debe de ser positivo");

        this.capacidadMaxima = capacidadMaxima;
        this.capacidadActual = Math.min(capacidadActual, capacidadMaxima);
    }

    /*-----------------------
        Getters and Setters
    -----------------------*/
    public double getCapacidadMaxima() {
        return capacidadMaxima;
    }
    public void setCapacidadMaxima(int capacidadMaxima) {
        if (validarCantidad(capacidadMaxima)){
            this.capacidadActual = Math.min(this.capacidadActual,capacidadMaxima);
            this.capacidadMaxima = capacidadMaxima;
        }
    }

    public double getCapacidadActual() {
        return capacidadActual;
    }
    public void setCapacidadActual(int capacidadActual) {
        if (validarCantidad(capacidadActual))
            this.capacidadActual = Math.min(capacidadActual, this.capacidadMaxima);
    }

    /*-----------------------
        Métodos
    -----------------------*/
    public void llenarCafetera(){
        this.capacidadActual = this.capacidadMaxima;
    }

    public double servirTaza(int cantidad){
        double cantidadServida = 0;
        if (cantidad > this.capacidadActual){
            cantidadServida = this.capacidadActual;
            this.capacidadActual = 0;
        } else {
            cantidadServida = cantidad;
            this.capacidadActual -= cantidad;
        }
        return cantidadServida;
    }

    public void vaciarCafetera(){
        this.capacidadActual = 0;
    }

    public void agregarCafe(int cantidad){
        this.capacidadActual = Math.min(this.capacidadActual + cantidad, this.capacidadMaxima);
    }

    /*-----------------------
        Overrides
    -----------------------*/

    @Override
    public String toString() {
        return "Cafetera posee: "+this.capacidadActual+" -  Maxima: "+this.capacidadMaxima;
    }

    /*-----------------------
        Validaciones
    -----------------------*/
    private boolean validarCantidad(int cantidad){
        return cantidad >= 0;
    }
}
