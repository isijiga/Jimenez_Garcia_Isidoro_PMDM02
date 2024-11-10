package com.example.pmpm_tarea2_ijg;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesHelper {

    private static final String PREF_NAME = "app_preferences";
    private static final String KEY_LANG = "language";


    public static void saveLanguage(Context context, boolean modSpanish){

    SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = prefs.edit();
    editor.putBoolean(KEY_LANG, modSpanish);
    editor.apply();
    }

    public static boolean getLanguage(Context context){

    SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    return prefs.getBoolean(KEY_LANG, false);
    }

}
