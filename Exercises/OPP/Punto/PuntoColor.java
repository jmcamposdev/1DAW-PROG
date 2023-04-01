package FigurasGeometricas;

public class PuntoColor extends Punto{
    private String color;

    // Constructor por defecto
    public PuntoColor() {
        super();
        this.color = "Blanco";
    }

    // Constructor
    public PuntoColor(double v,String color) {
        super(v);
        this.color = color;
    }

    public PuntoColor(double x, double y) {
        super(x,y);
        this.color = "Blanco";
    }

    public PuntoColor(double x, double y, String color) {
        super(x,y);
        this.color = color;
    }

    // Constructor Copia
    public PuntoColor(PuntoColor p) {
        super(p);
        this.color = p.color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public boolean equals (PuntoColor p) {
        return super.equals(p) && this.color.equals(p.color);
    }


    @Override
    public String toString() {
        return "PuntoColor: \n"+
                super.toString()+"\n"+
                "Color: "+this.color;
    }
}
