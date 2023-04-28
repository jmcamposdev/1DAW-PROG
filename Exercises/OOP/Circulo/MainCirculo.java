package FigurasGeometricas;

public class MainCirculo {
    public static void main(String[] args) {
        Circulo c1 = new Circulo(0,0,5);
        System.out.println("Area= "+c1.getArea());
        System.out.println("Circunferencia= "+c1.getCircunferencia());
        System.out.println(c1);
    }
}
