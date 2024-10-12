package com.example.pmpm_tarea2_ijg;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetalleActivity extends AppCompatActivity {
    private TextView nombreTextView ;
    private TextView    descripcionTextView ;
    private TextView    skillTextView ;
    private ImageView fotoGrande;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detalle);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

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