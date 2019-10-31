package com.mdpustudio.proyectobuy4you.fragments.proveedor;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mdpustudio.proyectobuy4you.R;

public class ProveedorModificarProductoFragment extends Fragment {

    private ProveedorModificarProductoViewModel mViewModel;

    public static ProveedorModificarProductoFragment newInstance() {
        return new ProveedorModificarProductoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.proveedor_fragment_modificar_producto, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ProveedorModificarProductoViewModel.class);
        // TODO: Use the ViewModel
    }

}
