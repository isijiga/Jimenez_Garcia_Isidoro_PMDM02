package com.example.pmpm_tarea2_ijg;

import java.io.Serializable;

public class Personaje implements Serializable {

    private String nombre;
    private String descripcion;
    private int imagen;
    private String habilidad;

    public Personaje(int imagen, String descripcion, String nombre, String habilidad)  {
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.habilidad = habilidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getImagen() {
        return imagen;
    }

    public String getHabilidad() {
        return habilidad;
    }
}

