package com.example.pmpm_tarea2_ijg;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Clase para gestionar las preferencias de la aplicación.
 */
public class PreferencesHelper {

    private static final String PREF_NAME = "app_preferences";
    private static final String KEY_LANG = "language";

    /**
     * Metodo para guardar el idioma en las preferencias.
     *
     * @param context
     * @param modSpanish es True si la aplicación se cambia a Idioma Español, False en caso contrario
     */
    public static void saveLanguage(Context context, boolean modSpanish) {

        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(KEY_LANG, modSpanish);
        editor.apply();
    }

    /**
     * Metodo para recuperar el idioma de las preferencias.
     *
     * @param context
     * @return
     */
    public static boolean getLanguage(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return prefs.getBoolean(KEY_LANG, false);
    }

}
