package com.example.pmpm_tarea2_ijg;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.List;

/**
 * Clase responsable de cargar los datos en el recycledView.
 * Esta coordinado con la clase  MyViewHolder que vincula los datos con la vista.
 * Ambas clases tienen que estar trabajando en conjunto para que funcione el recycledView.
 */

public class Adaptador extends RecyclerView.Adapter<Adaptador.MyViewHolder> {
    private static List<Personaje> listaPersonajes;

    public Adaptador(List<Personaje> listaPersonajes) {
        this.listaPersonajes = listaPersonajes;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.personaje_cardview, null, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Personaje itemActual = listaPersonajes.get(position);
        holder.foto.setImageResource(itemActual.getImagen());
        holder.nombre.setText(itemActual.getNombre());


    }

    @Override
    public int getItemCount() {
        return listaPersonajes.size();
    }

    /**
     * Clase encargada de contener los datos de cada elemento del recycledView.
     */
    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        private final ImageView  foto;
        private final TextView  nombre;

        /**
         * Clase constructora de la clase MyViewHolder donde se referencia la vista del CardView
         *
         * @param itemView
         */
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            foto = itemView.findViewById(R.id.fotoCardView);
            nombre = itemView.findViewById(R.id.textCardView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getPosition();
            if (position != RecyclerView.NO_POSITION) {
                Context context = view.getContext();
                Intent intent = new Intent(context, DetalleActivity.class);
                Toast toast = Toast.makeText(context, context.getString(R.string.toast) + listaPersonajes.get(position).getNombre(), Toast.LENGTH_SHORT);
                toast.show();
                intent.putExtra("Personaje", listaPersonajes.get(position));
                context.startActivity(intent);
            }
        }
    }
}
