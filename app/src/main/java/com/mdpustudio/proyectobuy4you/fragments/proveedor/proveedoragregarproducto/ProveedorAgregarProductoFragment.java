package com.mdpustudio.proyectobuy4you.fragments.proveedor.proveedoragregarproducto;

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
import com.mdpustudio.proyectobuy4you.models.Categoria;
import com.mdpustudio.proyectobuy4you.models.Persona;
import com.mdpustudio.proyectobuy4you.models.Producto;
import com.mdpustudio.proyectobuy4you.models.Proveedor;

public class ProveedorAgregarProductoFragment extends Fragment {

    private ProveedorAgregarProductoViewModel mViewModel;

    public static ProveedorAgregarProductoFragment newInstance(Persona persona, Proveedor proveedor) {

        Bundle args = new Bundle();
        args.putSerializable("selectedPersona", persona);
        args.putSerializable("selectedProveedor", proveedor);
        ProveedorAgregarProductoFragment fragment = new ProveedorAgregarProductoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.proveedor_fragment_agregar_producto, container, false);

        assert getArguments() != null;
        Persona selectedPersona = (Persona) getArguments().getSerializable("selectedPersona");
        final Proveedor selectedProveedor = (Proveedor) getArguments().getSerializable("selectedProveedor");
        final Producto newProduct = new Producto();

        final TextInputEditText nombreprodedit= root.findViewById(R.id.nombreprod_editext);
        final TextInputLayout nombreprodlayout= root.findViewById(R.id.nombreprod_layout);

        final TextInputEditText descprodedit= root.findViewById(R.id.descprod_edittext);
        final TextInputLayout descprodlayout= root.findViewById(R.id.descprod_layout);

        final TextInputEditText invprodedit= root.findViewById(R.id.cantprod_edittext);
        final TextInputLayout invprodlayout= root.findViewById(R.id.cantprod_layout);

        final TextInputEditText precioprodedit= root.findViewById(R.id.precioprod_edittext);
        final TextInputLayout precioprodlayout= root.findViewById(R.id.precioprod_layout);

        Spinner spinnerCategorias = root.findViewById(R.id.spinnercategorianew_spinner);
        Button buttonConfirmar = root.findViewById(R.id.nuevoDatosProducto_button);

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
                    newProduct.setIdproducto(selectedProveedor.getProductosInventario().size()+1);
                    newProduct.setNombreProducto(nombreprodedit.getText().toString());
                    newProduct.setDescripcion(descprodedit.getText().toString());
                    newProduct.setCantidadInventario(Integer.parseInt(invprodedit.getText().toString()));
                    newProduct.setPrecioBase(Double.parseDouble(precioprodedit.getText().toString()));
                    newProduct.setCategoriaProducto(Categoria.AceiteyPasta);

                    selectedProveedor.getProductosInventario().add(newProduct);
                    Snackbar.make(view, "Se agrego el nuevo producto con exito", Snackbar.LENGTH_SHORT).show();
                }

            }
        });


        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ProveedorAgregarProductoViewModel.class);
        // TODO: Use the ViewModel
    }

}
