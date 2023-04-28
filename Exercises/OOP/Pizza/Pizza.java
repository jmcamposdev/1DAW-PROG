package poo.EjerciciosLibro.Pizza;


public class Pizza {
    private enum Estado {PEDIDA,SERVIDA};
    private Tamaño tamaño;
    private Tipos tipo;
    private Estado estado;
    private static int totalPedidas;
    private static int totalServidas;

    static {
        totalPedidas = 0;
        totalServidas = 0;
    }


    public Pizza(Tipos tipo,Tamaño tamaño){
        this.tamaño = tamaño;
        this.tipo = tipo;
        this.estado = Estado.PEDIDA;
        Pizza.totalPedidas++;
    }
    public void sirve(){
        if(!this.estado.equals(Estado.SERVIDA)){
            this.estado = Estado.SERVIDA;
            Pizza.totalServidas++;
        } else {
            System.out.println("La pizza ya esta servida");
        }

    }

    @Override
    public String toString() {
        return "Pizza{" +
                "tamaño='" + tamaño.toString().toLowerCase() + '\'' +
                ", tipo='" + tipo.toString().toLowerCase() + '\'' +
                ", estado='" + estado.toString().toLowerCase() + '\'' +
                '}';
    }
    public static int getTotalPedidas(){
        return Pizza.totalPedidas;
    }

    public static int getTotalServidas() {
        return totalServidas;
    }

}

