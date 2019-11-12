package com.mdpustudio.proyectobuy4you.fragments.repartidor.mainpagerepartidor;

import androidx.fragment.app.FragmentTransaction;
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

import com.mdpustudio.proyectobuy4you.R;
import com.mdpustudio.proyectobuy4you.fragments.repartidor.repartidorinfoentrega.RepartidorInfoEntregaFragment;
import com.mdpustudio.proyectobuy4you.models.Persona;
import com.mdpustudio.proyectobuy4you.models.PeticionEntrega;
import com.mdpustudio.proyectobuy4you.models.Repartidor;

import java.util.Objects;

public class MainPageRepartidorFragment extends Fragment {

    private MainPageRepartidorViewModel mViewModel;
    private Persona selectedPersona;
    private Repartidor selectedRepartidor;

    public static MainPageRepartidorFragment newInstance(Persona persona, Repartidor repartidor) {

        Bundle args = new Bundle();
        args.putSerializable("selectedPersona", persona);
        args.putSerializable("selectedRepartidor", repartidor);
        MainPageRepartidorFragment fragment = new MainPageRepartidorFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.repartidor_fragment_main_page, container, false);

        assert getArguments() != null;
        selectedPersona = (Persona)getArguments().getSerializable("selectedPersona");
        selectedRepartidor = (Repartidor) getArguments().getSerializable("selectedRepartidor");

        RecyclerView recyclerView = root.findViewById(R.id.entregaspendientes_recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.Adapter mAdapter = new MainPageRepartidorAdapter(selectedRepartidor.getPedidos(), pCommunication);
        recyclerView.setAdapter(mAdapter);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainPageRepartidorViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onDetach() {
        Objects.requireNonNull(getActivity()).moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
        super.onDetach();
    }

    MainPageRepartidorFragmentCommunication pCommunication = new MainPageRepartidorFragmentCommunication() {
        @Override
        public void sendProveedor(PeticionEntrega compraselect) {
            Fragment infoEntrega = RepartidorInfoEntregaFragment.newInstance(selectedPersona, selectedRepartidor, compraselect);
            FragmentTransaction transaction = Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction();
            transaction.setCustomAnimations(android.R.animator.fade_in,android.R.animator.fade_out);
            transaction.replace(R.id.nav_host_fragment, infoEntrega);
            transaction.addToBackStack(null);
            transaction.commit();
        }

    };
}
