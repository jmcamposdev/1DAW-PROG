/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author deifont
 */
public class Cancion {
    private String nombre;
    private String autor;
    private int duracion;

    public Cancion(String nombre, String autor, int duracion) {
        this.nombre = nombre;
        this.autor = autor;
        this.duracion = duracion;
    }
    
    public Cancion (Cancion cancion) {
        this.nombre = cancion.nombre;
        this.autor = cancion.autor;
        this.duracion = cancion.duracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
    
    
}
