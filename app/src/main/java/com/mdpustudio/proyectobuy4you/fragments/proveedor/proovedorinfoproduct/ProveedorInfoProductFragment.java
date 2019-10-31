package com.mdpustudio.proyectobuy4you.fragments.proveedor.proovedorinfoproduct;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.mdpustudio.proyectobuy4you.R;
import com.mdpustudio.proyectobuy4you.models.Persona;
import com.mdpustudio.proyectobuy4you.models.Producto;
import com.mdpustudio.proyectobuy4you.models.Proveedor;

public class ProveedorInfoProductFragment extends Fragment {

    private ProveedorInfoProductFragmentViewModel mViewModel;
    private Persona selectedPersona;
    private Proveedor selectedProveedor;
    private Producto selectedProducto;

    public static ProveedorInfoProductFragment newInstance(Persona persona, Proveedor proveedor, Producto producto) {

        Bundle args = new Bundle();
        args.putSerializable("selectedPersona", persona);
        args.putSerializable("selectedProveedor", proveedor);
        args.putSerializable("selectedProducto", producto);
        ProveedorInfoProductFragment fragment = new ProveedorInfoProductFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.proveedor_fragment_info_product, container, false);

        assert getArguments()!= null;
        selectedPersona = (Persona) getArguments().getSerializable("selectedPersona");
        selectedProveedor = (Proveedor) getArguments().getSerializable("selectedProveedor");
        selectedProducto = (Producto) getArguments().getSerializable("selectedProducto");

        TextView nombreProd = root.findViewById(R.id.proveedorpinfonombre_textview);
        TextView categoriaProd = root.findViewById(R.id.proveedorpinfocategoria_textview);
        TextView descripcionProd = root.findViewById(R.id.proveedorpinfodescripcion_textview);
        TextView cantidadProd = root.findViewById(R.id.proveedorpinfocantidad_textview);
        TextView precioProd = root.findViewById(R.id.proveedorpinfoprecio_textview);
        Button editarProd = root.findViewById(R.id.editarproducto_button);

        nombreProd.setText(selectedProducto.getNombreProducto());
        categoriaProd.setText(selectedProducto.getCategoriaProducto().toString());
        descripcionProd.setText(selectedProducto.getDescripcion());
        cantidadProd.setText(String.valueOf(selectedProducto.getCantidadInventario()));
        precioProd.setText(String.format("%.2f", selectedProducto.getPrecioBase()));

        editarProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "uffff prro " + selectedPersona.getUsername(), Snackbar.LENGTH_SHORT).show();
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ProveedorInfoProductFragmentViewModel.class);
        // TODO: Use the ViewModel
    }

}
