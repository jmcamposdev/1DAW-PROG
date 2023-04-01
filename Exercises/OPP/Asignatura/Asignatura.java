package poo.EjerciciosSencillos_1.Academia.Asignatura;

public class Asignatura {
    private String nombre;
    private int horas;

    /*-----------------------
        Constructores
    -----------------------*/
    public Asignatura(String nombre, int horas){
        if (!validarNombre(nombre)){
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (!validarHoras(horas)){
            throw new IllegalArgumentException("Las horas deben de ser positivas");
        }

        this.nombre = nombre;
        this.horas = horas;
    }
    // Constructor Copia
    public Asignatura(Asignatura a){
        this(a.getNombre(),a.getHoras());
    }

    /*-----------------------
        Getters and Setters
    -----------------------*/
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        if (validarNombre(nombre)){
            this.nombre = nombre;
        }
    }

    public int getHoras() {
        return horas;
    }
    public void setHoras(int horas) {
        if (!validarHoras(horas)){
            this.horas = horas;
        }
    }

    /*-----------------------
            Validación
    -----------------------*/
    private boolean validarNombre(String nombre){
        return !nombre.isBlank();
    }
    private boolean validarHoras(int horas){
        return horas > 0;
    }

    /*-----------------------
        Override
    -----------------------*/

    @Override
    public String toString() {
        return "Asignatura: "+this.nombre+" - "+"Horas: "+this.horas;
    }

    @Override
    public boolean equals(Object obj) {
        Asignatura a = (Asignatura) obj;
        return this.nombre.equalsIgnoreCase(a.nombre) && this.horas == a.horas;
    }
}
