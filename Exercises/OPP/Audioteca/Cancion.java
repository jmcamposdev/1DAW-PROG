package poo.EjerciciosSencillos_2.Audioteca;

public class Cancion {
    private String titulo, autor;

    /*-----------------------
       Constructores
    -----------------------*/
    public Cancion(){
        this("","");
    }
    public Cancion(String titulo, String autor){
        this.titulo = titulo;
        this.autor = autor;

    }

    /*-----------------------
       Getters and Setters
    -----------------------*/

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Titulo: "+this.titulo+" - Autor: "+this.autor;
    }

    /*-----------------------
               Validaciones
            -----------------------*/
    private boolean validarString(String cadena){
        return !cadena.isBlank();
    }
}
