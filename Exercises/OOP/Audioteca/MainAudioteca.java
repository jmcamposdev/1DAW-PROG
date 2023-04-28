package poo.EjerciciosSencillos_2.Audioteca;

public class MainAudioteca {
    public static void main(String[] args) {
        Cancion cancion1 = new Cancion("Cancion1","Paco");
        Cancion cancion2 = new Cancion("Cancion2","Paco");
        Cancion cancion3 = new Cancion("Cancion3","Paco");
        Cancion cancion4 = new Cancion("Cancion4","Paco");
        Album album1 = new Album();
        album1.agregarCancion(cancion1);
        album1.agregarCancion(cancion2);
        System.out.println(album1.dameCancion(0));
        album1.elimina(0);
        System.out.println(album1.dameCancion(0));
        System.out.println(album1.numeroCanciones());
        album1.grabaCancion(0,cancion3);
        System.out.println(album1.dameCancion(0));
    }
}
