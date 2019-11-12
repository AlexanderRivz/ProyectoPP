package com.mdpustudio.proyectobuy4you.fragments.repartidor.mainpagerepartidor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mdpustudio.proyectobuy4you.R;
import com.mdpustudio.proyectobuy4you.models.PeticionEntrega;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MainPageRepartidorAdapter extends RecyclerView.Adapter<MainPageRepartidorAdapter.ViewHolder> {

    private ArrayList<PeticionEntrega> listaCompras;
    MainPageRepartidorFragmentCommunication pCommunicator;


    MainPageRepartidorAdapter(ArrayList<PeticionEntrega> listaCompras, MainPageRepartidorFragmentCommunication communication){
        this.listaCompras = listaCompras;
        pCommunicator = communication;
    }

    @Override
    public int getItemCount() {
        return listaCompras.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.repartidor_card_view_main_page, viewGroup, false);
        ViewHolder pvh = new ViewHolder(v, pCommunicator);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.identrega.setText(String.valueOf(listaCompras.get(i).getIdEntrega()));
        viewHolder.nombreUsuario.setText(listaCompras.get(i).getNombreUser());

        viewHolder.currentCompra = listaCompras.get(i);
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CardView cv;
        TextView identrega;
        TextView nombreUsuario;
        Button buttonVerMas;
        PeticionEntrega currentCompra;
        MainPageRepartidorFragmentCommunication pCommunication;

        ViewHolder(final View itemView, MainPageRepartidorFragmentCommunication communicator){
            super(itemView);

            cv = itemView.findViewById(R.id.proveedor_card_view);
            identrega = itemView.findViewById(R.id.identrega);
            nombreUsuario = itemView.findViewById(R.id.nombreusuario);
            buttonVerMas = itemView.findViewById(R.id.buttonvermasrepartidor);

            pCommunication = communicator;

            buttonVerMas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    pCommunication.sendProveedor(currentCompra);
                }
            });

        }
    }
}
