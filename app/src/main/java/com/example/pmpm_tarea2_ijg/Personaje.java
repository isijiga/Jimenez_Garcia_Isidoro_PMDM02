package com.example.pmpm_tarea2_ijg;

import java.io.Serializable;

/**
 * Clase que contiene los datos correspondientes a cada Personaje común de Mario
 */
public class Personaje implements Serializable {

    private final String nombre;
    private final int descripcion;
    private final int imagen;
    private final int habilidad;

    /**
     * Constructor de la clase Personaje
     *
     * @param imagen      imagen del personaje
     * @param descripcion descripcion detallada del personaje
     * @param nombre      el nombre del personaje de Mario
     * @param habilidad   habilidad especial
     */
    public Personaje(int imagen, int descripcion, String nombre, int habilidad) {
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.habilidad = habilidad;
    }

    /**
     * Metodo que obtiene el nombre del personaje
     *
     * @return el nombre del personaje
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que obtiene la descripcion del personaje
     *
     * @return la descripción detallada del personaje
     */
    public int getDescripcion() {
        return descripcion;
    }

    /**
     * Obtiene la imagen
     *
     * @return entero que corespondonde al id de la imagen
     */
    public int getImagen() {
        return imagen;
    }

    /**
     * Metodo que obtiene la habilidad del personaje
     *
     * @return habilidad del personaje
     */
    public int getHabilidad() {
        return habilidad;
    }
}

