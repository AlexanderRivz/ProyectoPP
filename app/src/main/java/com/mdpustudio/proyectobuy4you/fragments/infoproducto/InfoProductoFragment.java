package com.mdpustudio.proyectobuy4you.fragments.infoproducto;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.mdpustudio.proyectobuy4you.R;
import com.mdpustudio.proyectobuy4you.models.CarritoCompra;
import com.mdpustudio.proyectobuy4you.models.Producto;
import com.mdpustudio.proyectobuy4you.models.Usuario;

import java.util.Objects;

public class InfoProductoFragment extends Fragment {

    private InfoProductoViewModel mViewModel;
    private Producto selectedProduct;
    private Usuario selectedUser;
    private int cantidad;

    public static InfoProductoFragment newInstance(Usuario user, Producto producto) {
        InfoProductoFragment fragment = new InfoProductoFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("selectedUser", user);
        bundle.putSerializable("selectedProduct", producto);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_info_producto, container, false);

        final Double[] valueProduct = new Double[1];

        selectedUser = (Usuario) getArguments().getSerializable("selectedUser");
        selectedProduct = (Producto) getArguments().getSerializable("selectedProduct");

        TextView nombreProducto = root.findViewById(R.id.nombreProductoInfo_textview);
        TextView categoriaProducto = root.findViewById(R.id.categoriaProductoInfo_textview);
        TextView descripcionProducto = root.findViewById(R.id.descripcionProductoInfo_textview);
        final Spinner spinnerCantidad = root.findViewById(R.id.spinnercantidad_spinner);
        Spinner spinnerUnidad = root.findViewById(R.id.spinnerunidad_spinner);
        final TextView precioTotal = root.findViewById(R.id.preciototal_textview);
        Button buttonComprar = root.findViewById(R.id.agregarcarrito_button);

        final String[] cantidades = new String[]{"1","2","3","4","5","6","7","8","9","10"};
        String[] unidades = new String[]{"Unidad","Docena","Libra","Kilo",};

        ArrayAdapter<String> adapterCantidad = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),android.R.layout.simple_spinner_dropdown_item,cantidades);
        ArrayAdapter<String> adapterUnidades = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),android.R.layout.simple_spinner_dropdown_item,unidades);

        spinnerCantidad.setAdapter(adapterCantidad);
        spinnerUnidad.setAdapter(adapterUnidades);

        nombreProducto.setText(selectedProduct.getNombreProducto());
        categoriaProducto.setText(selectedProduct.getCategoriaProducto().toString());
        descripcionProducto.setText(selectedProduct.getDescripcion());

        spinnerCantidad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                cantidad = Integer.parseInt(parentView.getItemAtPosition(position).toString());
                valueProduct[0] = cantidad*selectedProduct.getPrecioBase();
                precioTotal.setText(String.format("%.2f", valueProduct));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                precioTotal.setText("");
            }

        });

        buttonComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedUser.getCarritoCompras().add(new CarritoCompra(selectedProduct, cantidad, valueProduct[0]));
                Snackbar.make(view, "Se agrego el producto al carrito de compras",Snackbar.LENGTH_LONG ).show();
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(InfoProductoViewModel.class);
        // TODO: Use the ViewModel
    }

}
