package FigurasGeometricas;

public class MainPunto {
    public static void main(String[] args) {
        Punto p1 = new Punto();
        Punto p2 = new Punto(4,6);
        p1.setX(3);
        Punto p3 = new Punto(p1);
        System.out.println("P1 "+p1);
        System.out.println("P2 "+p2);
        System.out.println("P3 "+p3);
        System.out.println("Son iguales P1 y P3 = "+p1.equals(p3));
        p3.setY(6.5);
        System.out.println("P1 "+p1);
        System.out.println("P2 "+p2);
        System.out.println("P3 "+p3);
        System.out.println("Son iguales P2 y P3 = "+p2.equals(p3));


    }
}
