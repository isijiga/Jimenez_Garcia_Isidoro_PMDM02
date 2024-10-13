package com.example.pmpm_tarea2_ijg;

import java.io.Serializable;

public class Personaje implements Serializable {

    private String nombre;
    private int descripcion;
    private int imagen;
    private int habilidad;

    public Personaje(int imagen, int descripcion, String nombre, int habilidad)  {
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.habilidad = habilidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDescripcion() {
        return descripcion;
    }

    public int getImagen() {
        return imagen;
    }

    public int getHabilidad() {
        return habilidad;
    }
}

