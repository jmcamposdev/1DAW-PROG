package poo.EjerciciosSencillos_2.Cafetera;

public class MainCafetera {
    public static void main(String[] args) {
        Cafetera cafetera = new Cafetera();
        System.out.println(cafetera);
        System.out.println("Servir: "+cafetera.servirTaza(100));
        cafetera.agregarCafe(200);
        System.out.println(cafetera);
        System.out.println("Servir: "+cafetera.servirTaza(100));
        System.out.println(cafetera);
        cafetera.llenarCafetera();
        System.out.println(cafetera);
        cafetera.vaciarCafetera();
        System.out.println(cafetera);
        cafetera.agregarCafe(3000);
        System.out.println(cafetera);
    }
}
