package poo.EjerciciosSencillos_1.Academia.Estudiante;
import poo.EjerciciosSencillos_1.Academia.Asignatura.Asignatura;

import java.util.Arrays;

public class Estudiante {
    private String nombre, apellido1, apellido2;
    private Asignatura[] listaAsignaturas;

    /*-----------------------
        Constructores
    -----------------------*/
    public Estudiante (String nombre, String apellido1, String apellido2){
        if (!validarString(nombre))
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        if (!validarString(apellido1))
            throw new IllegalArgumentException("El apellido 1 no puede estar vacío");
        if (!validarString(apellido2))
            throw new IllegalArgumentException("El apellido 2 no puede estar vacío");

        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.listaAsignaturas = new Asignatura[0];
    }
    //Constructor Copia
    public Estudiante(Estudiante e){
        this(e.nombre,e.apellido1,e.apellido2);
        // Copiamos el array, ya que si se lo asignamos copiamos la referencia de memoria en vez de los datos.
        Asignatura[] copiaLista = new Asignatura[e.listaAsignaturas.length];
        System.arraycopy(e.listaAsignaturas, 0, copiaLista, 0, e.listaAsignaturas.length);
        this.listaAsignaturas = copiaLista;
    }

    /*-----------------------
        Getters and Setters
    -----------------------*/

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        if (validarString(nombre))
            this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }
    public void setApellido1(String apellido1) {
        if (validarString(apellido1))
            this.apellido1 = apellido1;

    }

    public String getApellido2() {
        return apellido2;
    }
    public void setApellido2(String apellido2) {
        if (validarString(apellido2))
            this.apellido2 = apellido2;

    }

    public Asignatura[] getListaAsignaturas() {
        Asignatura[] copiaLista = new Asignatura[this.listaAsignaturas.length];
        System.arraycopy(this.listaAsignaturas, 0, copiaLista, 0, this.listaAsignaturas.length);
        return copiaLista;
    }
    public void setListaAsignaturas(Asignatura[] listaAsignaturas) {
        Asignatura[] copiaLista = new Asignatura[listaAsignaturas.length];
        System.arraycopy(listaAsignaturas, 0, copiaLista, 0, listaAsignaturas.length);
        this.listaAsignaturas = copiaLista;
    }

    /*-----------------------
            Métodos
    -----------------------*/
    // Añadir una Asignatura
    public boolean añadeAsignatura(Asignatura a){
        int horasMatriculadas = getNumeroHorasMatriculadas();
        boolean asignaturaAñadida = false;
        horasMatriculadas += a.getHoras();

        if (horasMatriculadas <= 30){
            listaAsignaturas = Arrays.copyOf(listaAsignaturas,listaAsignaturas.length+1);
            listaAsignaturas[listaAsignaturas.length-1] = a;
            asignaturaAñadida = true;
        }
        return asignaturaAñadida;
    }

    // Devuelve el número de asignaturas matriculado
    public int getNumeroAsignaturasMatriculadas(){
        return listaAsignaturas.length;
    }

    // Devuelve el número de horas de las asignaturas
    public int getNumeroHorasMatriculadas(){
        int horasMatriculadas = 0;
        for (int i = 0; i < this.listaAsignaturas.length; i++) {
            horasMatriculadas += this.listaAsignaturas[i].getHoras();
        }
        return horasMatriculadas;
    }

    public Asignatura getAsignatura(int posicion){
        if (posicion < 0 || posicion > listaAsignaturas.length){
            throw new IllegalArgumentException("La posicion debe de estar en rango.");
        }
        return this.listaAsignaturas[posicion];
    }

    /*-----------------------
        Overrides
    -----------------------*/

    @Override
    public String toString() {
        String asignaturas = "";
        if (listaAsignaturas.length != 0){
            for (Asignatura asignatura : listaAsignaturas) {
                asignaturas += asignatura.getNombre()+", ";
            }
            asignaturas = asignaturas.substring(0,asignaturas.length()-2);
        } else {
            asignaturas = "No posee por ahora";
        }

        return "Estudiantes: "+this.nombre+" "+this.apellido1+" "+this.apellido2+"\n    Asignaturas: "+asignaturas;
    }

    @Override
    public boolean equals(Object obj) {
        Estudiante e = (Estudiante) obj;
        return this.nombre.equalsIgnoreCase(e.nombre) &&
                this.apellido1.equalsIgnoreCase(e.apellido1) &&
                this.apellido2.equalsIgnoreCase(e.apellido2);
    }

    /*-----------------------
        Validaciones
    -----------------------*/
    private boolean validarString(String cadena){
        return !cadena.isBlank();
    }

}
