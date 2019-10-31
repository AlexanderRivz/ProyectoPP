package com.mdpustudio.proyectobuy4you.fragments.proveedor.mainpageproveedor;

import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.net.Uri;
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

import com.mdpustudio.proyectobuy4you.R;
import com.mdpustudio.proyectobuy4you.fragments.proveedor.proovedorinfoproduct.ProveedorInfoProductFragment;
import com.mdpustudio.proyectobuy4you.models.Persona;
import com.mdpustudio.proyectobuy4you.models.Producto;
import com.mdpustudio.proyectobuy4you.models.Proveedor;

import java.util.Objects;

public class MainPageProveedorFragment extends Fragment {

    private MainPageProveedorViewModel mViewModel;
    private Persona selectedPersona;
    private Proveedor selectedProveedor;

    public static MainPageProveedorFragment newInstance(Persona persona, Proveedor proveedor) {

        Bundle args = new Bundle();
        args.putSerializable("selectedPersona", persona);
        args.putSerializable("selectedProveedor", proveedor);

        MainPageProveedorFragment fragment = new MainPageProveedorFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.proveedor_fragment_main_page, container, false);

        assert getArguments() != null;
        selectedPersona = (Persona) getArguments().getSerializable("selectedPersona");
        selectedProveedor = (Proveedor) getArguments().getSerializable("selectedProveedor");

        TextView nombre = root.findViewById(R.id.proveedornombre_textView);
        TextView sucursal = root.findViewById(R.id.proveedorsucursal_textView);
        TextView idproveedor = root.findViewById(R.id.proveedorid_textView);
        TextView telefono = root.findViewById(R.id.proveedortelefono_textView);
        TextView descripcion = root.findViewById(R.id.proveedordescripcion_textView);
        Button locacion = root.findViewById(R.id.proveedorverlocacion_button);
        RecyclerView recyclerView = root.findViewById(R.id.proveedorproductos_recyclerview);

        nombre.setText(selectedProveedor.getEmpresa());
        sucursal.setText(selectedProveedor.getSucursal());
        idproveedor.setText(String.valueOf(selectedProveedor.getIdproveedor()));
        telefono.setText(selectedProveedor.getNumeroTelefonico());
        descripcion.setText(selectedProveedor.getDescripcionProveedor());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        RecyclerView.Adapter mAdapter = new MainPageProveedorAdapter(selectedProveedor.getProductosInventario(), pCommunication);
        recyclerView.setAdapter(mAdapter);

        locacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.google.com/maps/search/?api=1&query=" + selectedProveedor.getLatitud() + "," + selectedProveedor.getLongitud();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                Objects.requireNonNull(getContext()).startActivity(intent);
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainPageProveedorViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onDetach() {
        Objects.requireNonNull(getActivity()).moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
        super.onDetach();
    }


    MainPageProveedorFragmentCommunication pCommunication = new MainPageProveedorFragmentCommunication() {
        @Override
        public void sendProducto(Producto productoSent) {
            Fragment infoProducto = ProveedorInfoProductFragment.newInstance(selectedPersona, selectedProveedor, productoSent);
            FragmentTransaction transaction = Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction();
            transaction.setCustomAnimations(android.R.animator.fade_in,android.R.animator.fade_out);
            transaction.replace(R.id.nav_host_fragment, infoProducto);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    };

}
