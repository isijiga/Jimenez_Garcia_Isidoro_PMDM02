package com.example.pmpm_tarea2_ijg;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Clase tipo actividad que muestra los detalles de un personaje concreto cuando es
 * pulsado en el recycledView
 */
public class DetalleActivity extends AppCompatActivity {
/*gracias a las ultimas videoclases podria haber utilizado como buena practica el uso de databinding para simplificar el codigo
* y el enlazar los datos con la vista*/

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView nombreTextView;
        TextView skillTextView;
        ImageView fotoGrande;
        TextView descripcionTextView;
        setContentView(R.layout.activity_detalle);

        /*enlazar vistas*/
        nombreTextView = findViewById(R.id.textViewDetails);
        descripcionTextView = findViewById(R.id.textViewDescripcion);
        fotoGrande = findViewById(R.id.imageViewfotoGrande);
        skillTextView = findViewById(R.id.skillTextView);

        /*recupero datos del Intent*/
        Intent intent = getIntent();
        Personaje personaje = (Personaje) intent.getSerializableExtra("Personaje");

        /*vinculo los datos en las vistas*/
        if (personaje != null) {
            nombreTextView.setText(personaje.getNombre());
            descripcionTextView.setText(personaje.getDescripcion());
            fotoGrande.setImageResource(personaje.getImagen());
            skillTextView.setText(personaje.getHabilidad());
        }
        super.onCreate(savedInstanceState);
    }
}