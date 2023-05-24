package conversorlistacanciones;

import java.io.Serializable;

public class Cancion implements Serializable, Comparable<Cancion> {
    private String titulo;
    private String autor;
    private int duracion;

    public Cancion(String titulo, String autor, int duracion) {
        if (duracion <= 0) throw new IllegalArgumentException("La duración no puede ser negativa");
        if (titulo.isBlank()) throw new IllegalArgumentException("El título no puede estar vacío");
        if (autor.isBlank()) throw new IllegalArgumentException("El autor no puede estar vacío");

        this.titulo = titulo;
        this.autor = autor;
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (!titulo.isBlank())
            this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (!autor.isBlank())
            this.autor = autor;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        if (duracion > 0)
            this.duracion = duracion;
    }

    @Override
    public String toString() {
        return titulo + " - " + autor + " (" + duracion + " segundos)";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Cancion)) return false;

        Cancion c = (Cancion) obj;
        return titulo.equals(c.titulo) && autor.equals(c.autor) && duracion == c.duracion;
    }

    @Override
    public int compareTo(Cancion o) {
        return o.duracion - duracion;
    }
}
