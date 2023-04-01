package poo.EjerciciosSencillos_1.Academia.Estudiante;

import poo.EjerciciosSencillos_1.Academia.Asignatura.Asignatura;

public class MainEstudiante {
    public static void main(String[] args) {
        Asignatura lengua = new Asignatura("Lengua",10);
        Asignatura historia = new Asignatura("Historia y Geografía", 10);
        Asignatura matematica = new Asignatura("Matemática", 10);
        Asignatura biologia = new Asignatura("Biología",10);

        Estudiante e1 = new Estudiante("José","Campos","Trujillo");
        System.out.println(e1);
        System.out.println(e1.añadeAsignatura(lengua) ? "Asignatura añadida" : "No se puede añadir sobre pasa las 30h");
        Estudiante e2 = new Estudiante(e1);
        System.out.println(e2);
        System.out.println(e1.añadeAsignatura(historia) ? "Asignatura añadida" : "No se puede añadir sobre pasa las 30h");
        System.out.println(e1.añadeAsignatura(biologia) ? "Asignatura añadida" : "No se puede añadir sobre pasa las 30h");
        System.out.println(e1);
        System.out.println(e1.getAsignatura(0));
        System.out.println("Numero de horas matriculadas: "+e1.getNumeroHorasMatriculadas());
        System.out.println(e1.añadeAsignatura(matematica) ? "Asignatura añadida" : "No se puede añadir sobre pasa las 30h");
        e2.setNombre("Paco");
        e2.setApellido1("Trujillo");
        System.out.println(e2);


    }
}
