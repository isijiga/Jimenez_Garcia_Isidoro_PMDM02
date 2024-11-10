package com.example.pmpm_tarea2_ijg;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;


public class DetalleActivity extends AppCompatActivity {
    private TextView nombreTextView ;
    private TextView    descripcionTextView ;
    private TextView    skillTextView ;
    private ImageView fotoGrande;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detalle);



        //enlazar vistas
        nombreTextView = findViewById(R.id.textViewDetails);
        descripcionTextView = findViewById(R.id.textViewDescripcion);
        fotoGrande = findViewById(R.id.imageViewfotoGrande);
        skillTextView = findViewById(R.id.skillTextView);
        // Obtengo datos del Intent
        Intent intent = getIntent();
        Personaje personaje = (Personaje) intent.getSerializableExtra("Personaje");

        // Establecer los datos en las vistas
        if (personaje != null) {
            nombreTextView.setText(personaje.getNombre());
            descripcionTextView.setText(personaje.getDescripcion());
            fotoGrande.setImageResource(personaje.getImagen());
            skillTextView.setText(personaje.getHabilidad());

        }

    }


}