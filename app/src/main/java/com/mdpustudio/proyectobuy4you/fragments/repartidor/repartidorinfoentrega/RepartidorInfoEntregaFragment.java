package com.mdpustudio.proyectobuy4you.fragments.repartidor.repartidorinfoentrega;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.mdpustudio.proyectobuy4you.R;
import com.mdpustudio.proyectobuy4you.models.Persona;
import com.mdpustudio.proyectobuy4you.models.PeticionEntrega;
import com.mdpustudio.proyectobuy4you.models.Repartidor;

public class RepartidorInfoEntregaFragment extends Fragment {

    private RepartidorInfoEntregaViewModel mViewModel;

    public static RepartidorInfoEntregaFragment newInstance(Persona persona, Repartidor repartidor, PeticionEntrega peticion) {

        Bundle args = new Bundle();
        args.putSerializable("selectedPersona", persona);
        args.putSerializable("selectedRepartidor", repartidor);
        args.putSerializable("selectedEntrega", peticion);
        RepartidorInfoEntregaFragment fragment = new RepartidorInfoEntregaFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.repartidor_fragment_info_entrega, container, false);

        assert getArguments() != null;
        Persona selectedPersona = (Persona)getArguments().getSerializable("selectedPersona");
        Repartidor selectedRepartidor = (Repartidor)getArguments().getSerializable("selectedRepartidor");
        PeticionEntrega selectedEntrega = (PeticionEntrega)getArguments().getSerializable("selectedEntrega");

        TextView nombreUser = root.findViewById(R.id.nombreentregausuario_textview);
        TextView idUsuario = root.findViewById(R.id.idusuarioentrega_textview);
        TextView idEntrega = root.findViewById(R.id.identrega_textview);
        TextView costoTotal = root.findViewById(R.id.costototalarticulos_textview);
        TextView cantidadArticulos = root.findViewById(R.id.cantidadarticulosrepartidor_textView);
        Button verLocacion = root.findViewById(R.id.terminado_button);
        Button marcarEntregado = root.findViewById(R.id.locacion_button);
        RecyclerView recyclerView = root.findViewById(R.id.informacioncompra_recyclerview);

        double total = 0;
        int totalarticulos = 0;

        for (int i=0; i<selectedEntrega.getPedido().size(); i++){
            total = total + selectedEntrega.getPedido().get(i).getPrecioProducto();
            totalarticulos = totalarticulos + selectedEntrega.getPedido().get(i).getCantidadProductos();
        }

        nombreUser.setText(selectedEntrega.getNombreUser());
        idUsuario.setText(String.valueOf(selectedEntrega.getIdUsuario()));
        idEntrega.setText(String.valueOf(selectedEntrega.getIdEntrega()));
        costoTotal.setText(String.valueOf(total));
        cantidadArticulos.setText(String.valueOf(totalarticulos));

        verLocacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "aca se implementara la funcionalidad de ver la locacion", Snackbar.LENGTH_SHORT).show();
            }
        });

        marcarEntregado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "aca se implementara la funcionalidad de marca la entrega como finalizada", Snackbar.LENGTH_SHORT).show();
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.Adapter adapter = new RepartidorInfoEntregaAdapter(selectedEntrega.getPedido());
        recyclerView.setAdapter(adapter);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(RepartidorInfoEntregaViewModel.class);
        // TODO: Use the ViewModel
    }

}
