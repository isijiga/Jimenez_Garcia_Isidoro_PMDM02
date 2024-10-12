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

public class Adaptador  extends RecyclerView.Adapter <Adaptador.MyViewHolder> {

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

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView foto;
        private TextView nombre;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            foto = itemView.findViewById(R.id.fotoCardView);
            nombre = itemView.findViewById(R.id.textCardView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getPosition();
            if (position != RecyclerView.NO_POSITION){
                Context context = view.getContext();
                Intent intent = new Intent(context, DetalleActivity.class);
                Toast toast = Toast.makeText(context, "Detalles cargados para : " + listaPersonajes.get(position).getNombre(), Toast.LENGTH_SHORT);
                toast.show();
                intent.putExtra("Personaje",listaPersonajes.get(position));
                context.startActivity(intent);

            }


        }
    }
}
