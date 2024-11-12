package com.example.pmpm_tarea2_ijg;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import com.example.pmpm_tarea2_ijg.databinding.ActivityDetalleBinding;

/**
 * Clase tipo actividad que muestra los detalles de un personaje concreto cuando es
 * pulsado en el recycledView con uso de databinding
 */
public class DetalleActivity extends AppCompatActivity {


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ActivityDetalleBinding binding;
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detalle);
        setContentView(binding.getRoot());
        /*toolbar para retroceder*/
        configToolbar();
        binding.toolbarDetails.setNavigationOnClickListener(this::retroceso);

        /*recupero datos del Intent*/
        Intent intent = getIntent();
        Personaje personaje = (Personaje) intent.getSerializableExtra("Personaje");

        /*vinculo los datos en las vistas*/
        if (personaje != null) {
            binding.setPersonajeDB(personaje);
        }
        super.onCreate(savedInstanceState);


    }

    private void retroceso(View view) {
        finish();

    }

/*configuracion de la toolbar de la pantalla de detalle. como buena practica quizas podria haber utilizado una activity que
* tubiera un contenedor de fragmentos para mantener la misma barra como indicaba la videoclase3, pero ya tenia implementada
* la tarea con dos activity's*/
    public void configToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbarDetails);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }


}