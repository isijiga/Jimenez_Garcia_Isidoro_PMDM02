package com.example.pmpm_tarea2_ijg;

import java.util.ArrayList;
import java.util.List;

/**
 * La Clase es creada como fuente de datos para el adaptador con el fin de separarlo de la actividad principal
 */
public class Datos {

    static List<Personaje> datos = new ArrayList<>();

    static {
        datos.add(new Personaje(R.drawable.mario, R.string.mario_descripcion, "Mario Bros", R.string.mario_skill));
        datos.add(new Personaje(R.drawable.luigi, R.string.luigi_descripcion, "Luigi Bros", R.string.luigi_skill));
        datos.add(new Personaje(R.drawable.peach, R.string.peach_descripcion, "Peach", R.string.peach_skill));
        datos.add(new Personaje(R.drawable.toad, R.string.toad_descripcion, "Toad", R.string.toad_skill));
        datos.add(new Personaje(R.drawable.bowser, R.string.bowser_descripcion, "Bowser", R.string.bowser_skill));
        datos.add(new Personaje(R.drawable.yoshi, R.string.yoshi_descripcion, "Yoshi", R.string.yoshi_skill));
        datos.add(new Personaje(R.drawable.daisy, R.string.daisy_descripcion, "Daisy", R.string.daisy_skill));
        datos.add(new Personaje(R.drawable.wario, R.string.wario_descripcion, "Wario", R.string.wario_skill));
        datos.add(new Personaje(R.drawable.waluigi, R.string.waluigi_descripcion, "Waluigi", R.string.waluigi_skill));
        datos.add(new Personaje(R.drawable.rosalina, R.string.rosalina_descripcion, "Rosalina", R.string.rosalina_skill));
        datos.add(new Personaje(R.drawable.bowser_jr, R.string.bowser_jr_descripcion, "Bowser JR", R.string.bowser_jr_skill));
        datos.add(new Personaje(R.drawable.boo, R.string.boo_descripcion, "Boo", R.string.boo_skill));
        datos.add(new Personaje(R.drawable.donkey_kong, R.string.donkey_kong_descripcion, "Donkey Kong", R.string.donkey_kong_skill));
        datos.add(new Personaje(R.drawable.diddy_kong, R.string.diddy_kong_descripcion, "Diddy Kong", R.string.diddy_kong_skill));
    }

    /**
     * Metodo que obtiene la lista de datos completa que se usara en la app
     *
     * @return lista de datos tipo Personaje
     */
    public static List<Personaje> getDatos() {
        return datos;
    }
}
