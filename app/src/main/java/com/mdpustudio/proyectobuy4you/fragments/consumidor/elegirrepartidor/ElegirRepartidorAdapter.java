package com.mdpustudio.proyectobuy4you.fragments.consumidor.elegirrepartidor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mdpustudio.proyectobuy4you.R;
import com.mdpustudio.proyectobuy4you.models.CarritoCompra;
import com.mdpustudio.proyectobuy4you.models.Repartidor;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ElegirRepartidorAdapter extends RecyclerView.Adapter<ElegirRepartidorAdapter.ViewHolder> {

    private ArrayList<Repartidor> selectedRepartidor;

    ElegirRepartidorAdapter(ArrayList<Repartidor> selectedRepartidor){
        this.selectedRepartidor = selectedRepartidor;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_elegir_repartidor, parent, false);
        ViewHolder pvh = new ViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.numeroContacto.setText(selectedRepartidor.get(position).getNumeroContacto());
        holder.nombreRepartidor.setText(selectedRepartidor.get(position).getNombre() + " " + selectedRepartidor.get(position).getApellido());
        holder.calificacion.setText(String.valueOf(5));
    }

    @Override
    public int getItemCount() {
        return selectedRepartidor.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView numeroContacto;
        TextView nombreRepartidor;
        TextView calificacion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            numeroContacto = itemView.findViewById(R.id.numeroContacto_textView);
            nombreRepartidor= itemView.findViewById(R.id.nombrerepartidor_textview);
            calificacion = itemView.findViewById(R.id.puntuacionrepartidor_textview);


        }
    }
}
