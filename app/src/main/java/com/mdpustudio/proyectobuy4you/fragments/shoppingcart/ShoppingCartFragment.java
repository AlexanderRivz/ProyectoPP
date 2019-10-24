package com.mdpustudio.proyectobuy4you.fragments.shoppingcart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.mdpustudio.proyectobuy4you.R;
import com.mdpustudio.proyectobuy4you.models.Usuario;

public class ShoppingCartFragment extends Fragment {

    private ShoppingCartViewModel shoppingCartViewModel;

    public static ShoppingCartFragment newInstance(Usuario user) {
        ShoppingCartFragment fragment = new ShoppingCartFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("selectedUser", user);
        fragment.setArguments(bundle);
        return fragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        shoppingCartViewModel =
                ViewModelProviders.of(this).get(ShoppingCartViewModel.class);
        View root = inflater.inflate(R.layout.fragment_shopping_cart, container, false);

        assert getArguments() != null;
        final Usuario selectedUser = (Usuario) getArguments().getSerializable("selectedUser");
        TextView cantidadArticulos = root.findViewById(R.id.cantidadarticulos_textview);
        TextView totalCarrito = root.findViewById(R.id.totalcompra_textview);
        Button button = root.findViewById(R.id.confirmarcompra_button);
        LinearLayout linearLayout = root.findViewById(R.id.itemscart_layout);
        TextView textView = root.findViewById(R.id.emptycart_layout);

        double total = 0;
        int totalarticulos = 0;

        if (selectedUser.getCarritoCompras().isEmpty()){
            linearLayout.setVisibility(View.GONE);
            textView.setVisibility(View.VISIBLE);
        }else {
            textView.setVisibility(View.GONE);
            linearLayout.setVisibility(View.VISIBLE);

            for (int i=0; i<selectedUser.getCarritoCompras().size(); i++){
                total = total + selectedUser.getCarritoCompras().get(i).getPrecioProducto();
                totalarticulos = totalarticulos + selectedUser.getCarritoCompras().get(i).getCantidadProductos();
            }

            cantidadArticulos.setText(String.valueOf(totalarticulos));
            totalCarrito.setText(String.valueOf(total));
        }

        RecyclerView recyclerView = root.findViewById(R.id.productoscart_recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        assert selectedUser != null;
        RecyclerView.Adapter adapter = new ShoppingCartAdapter(selectedUser.getCarritoCompras());
        recyclerView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Se confirmo la compra del carrito", Snackbar.LENGTH_SHORT).show();
            }
        });

        return root;
    }
}