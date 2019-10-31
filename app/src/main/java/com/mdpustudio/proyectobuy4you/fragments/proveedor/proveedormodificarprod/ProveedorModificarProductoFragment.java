package com.mdpustudio.proyectobuy4you.fragments.proveedor.proveedormodificarprod;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.mdpustudio.proyectobuy4you.R;
import com.mdpustudio.proyectobuy4you.models.Persona;
import com.mdpustudio.proyectobuy4you.models.Producto;
import com.mdpustudio.proyectobuy4you.models.Proveedor;

public class ProveedorModificarProductoFragment extends Fragment {

    private ProveedorModificarProductoViewModel mViewModel;

    public static ProveedorModificarProductoFragment newInstance(Persona persona, Proveedor proveedor, Producto producto) {

        Bundle args = new Bundle();
        args.putSerializable("selectedPersona", persona);
        args.putSerializable("selectedProveedor", proveedor);
        args.putSerializable("selectedProducto", producto);
        ProveedorModificarProductoFragment fragment = new ProveedorModificarProductoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.proveedor_fragment_modificar_producto, container, false);

        assert getArguments() != null;

        Persona selectedPersona = (Persona) getArguments().getSerializable("selectedPersona");
        Proveedor selectedProveedor = (Proveedor) getArguments().getSerializable("selectedProveedor");
        final Producto selectedProducto = (Producto) getArguments().getSerializable("selectedProducto");

        final TextInputEditText nombreprodedit= root.findViewById(R.id.nombreprodmod_editext);
        final TextInputLayout nombreprodlayout= root.findViewById(R.id.nombreprodmod_layout);
        nombreprodedit.setText(selectedProducto.getNombreProducto());

        final TextInputEditText descprodedit= root.findViewById(R.id.descprodmod_edittext);
        final TextInputLayout descprodlayout= root.findViewById(R.id.descprodmod_layout);
        descprodedit.setText(selectedProducto.getDescripcion());

        final TextInputEditText invprodedit= root.findViewById(R.id.cantprodmod_edittext);
        final TextInputLayout invprodlayout= root.findViewById(R.id.cantprodmod_layout);
        invprodedit.setText(String.valueOf(selectedProducto.getCantidadInventario()));

        final TextInputEditText precioprodedit= root.findViewById(R.id.precioprodmod_edittext);
        final TextInputLayout precioprodlayout= root.findViewById(R.id.precioprodmod_layout);
        precioprodedit.setText(String.valueOf(selectedProducto.getPrecioBase()));

        Spinner spinnerCategorias = root.findViewById(R.id.spinnercategoria_spinner);
        Button buttonConfirmar = root.findViewById(R.id.modificarDatosProducto_button);

        buttonConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean flag = true;
                if (nombreprodedit.getText().toString().isEmpty()){
                    flag = false;
                    nombreprodlayout.setError("Tiene que ingresar un nombre de producto.");
                }
                if (descprodedit.getText().toString().isEmpty()){
                    flag = false;
                    descprodlayout.setError("Tiene que ingresar una descripcion.");
                }
                if (invprodedit.getText().toString().isEmpty()){
                    flag = false;
                    invprodlayout.setError("Tiene que ingresar una cantidad en inventario.");
                }
                if (precioprodedit.getText().toString().isEmpty()){
                    flag = false;
                    precioprodlayout.setError("Tiene que ingresar un precio.");
                }
                if (Double.valueOf(precioprodedit.getText().toString()) == 0){
                    flag = false;
                    precioprodlayout.setError("El producto no puede valer $0.00");
                }

                if (flag){
                    selectedProducto.setNombreProducto(nombreprodedit.getText().toString());
                    selectedProducto.setDescripcion(descprodedit.getText().toString());
                    selectedProducto.setCantidadInventario(Integer.parseInt(invprodedit.getText().toString()));
                    selectedProducto.setPrecioBase(Double.parseDouble(precioprodedit.getText().toString()));

                    Snackbar.make(view, "Se edito el producto con exito", Snackbar.LENGTH_SHORT).show();
                }

            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ProveedorModificarProductoViewModel.class);
        // TODO: Use the ViewModel
    }

}
