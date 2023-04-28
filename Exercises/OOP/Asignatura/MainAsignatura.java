package poo.EjerciciosSencillos_1.Academia.Asignatura;

public class MainAsignatura {
    public static void main(String[] args) {
        Asignatura a1 = new Asignatura("Historia",3);
        Asignatura a2 = new Asignatura("Lengua",8);
        Asignatura a3 = new Asignatura(a1);
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println("Es igual a1 que a2 ="+a1.equals(a2));
        a1.setNombre("Historia y Geografía");
        a3.setNombre("Educación Física");
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        //a3.setNombre("   ");
        //a3.setNombre("");
    }
}
