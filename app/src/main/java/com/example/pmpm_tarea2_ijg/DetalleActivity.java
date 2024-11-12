package com.example.pmpm_tarea2_ijg;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
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

        /*enlazar vistas*/


        /*recupero datos del Intent*/
        Intent intent = getIntent();
        Personaje personaje = (Personaje) intent.getSerializableExtra("Personaje");



        /*vinculo los datos en las vistas*/
        if (personaje != null) {
            binding.setPersonajeDB(personaje);
        }
        super.onCreate(savedInstanceState);
    }
}