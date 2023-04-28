package FigurasGeometricas;

public class MainPuntoColor {
    public static void main(String[] args) {
        PuntoColor p1 = new PuntoColor(4,5,"Negro");
        PuntoColor p2 = new PuntoColor(5,5);
        System.out.println(p1.equals(p2));
    }
}
