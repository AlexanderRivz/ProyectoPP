package com.mdpustudio.proyectobuy4you.fragments.productosproveedor;

import androidx.fragment.app.FragmentTransaction;

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

import com.google.android.material.snackbar.Snackbar;
import com.mdpustudio.proyectobuy4you.R;
import com.mdpustudio.proyectobuy4you.fragments.infoproducto.InfoProductoFragment;
import com.mdpustudio.proyectobuy4you.models.Producto;
import com.mdpustudio.proyectobuy4you.models.Proveedor;
import com.mdpustudio.proyectobuy4you.models.Usuario;

import java.util.Objects;

public class ProductosProveedorFragment extends Fragment {

    private Proveedor selectedProveedor;
    private RecyclerView recyclerView;
    private Usuario selectedUser;

    public static ProductosProveedorFragment newInstance(Usuario user, Proveedor proveedor) {

        ProductosProveedorFragment productosProveedorFragment = new ProductosProveedorFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("selectedUser", user);
        bundle.putSerializable("selectedProveedor", proveedor);
        productosProveedorFragment.setArguments(bundle);

        return productosProveedorFragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_productos_proveedor, container, false);

        assert getArguments() != null;
        selectedUser = (Usuario) getArguments().getSerializable("selectedUser");
        selectedProveedor = (Proveedor) getArguments().getSerializable("selectedProveedor");

        recyclerView = root.findViewById(R.id.fragmentproductosproveedor_recyclerview);
        TextView sucursal = root.findViewById(R.id.sucursalProveedor_textView);
        TextView nombreProveedor = root.findViewById(R.id.nombreProveedor_textView);
        TextView descripcionProveedor = root.findViewById(R.id.descripcionProveedor_textView);
        TextView idProveedor = root.findViewById(R.id.idProveedor2_textView);
        TextView telefonoProveedor = root.findViewById(R.id.telefonoProveedor_textView);
        Button locacion = root.findViewById(R.id.verlocacion_button);

        sucursal.setText("Sucursal " + selectedProveedor.getSucursal());
        nombreProveedor.setText(selectedProveedor.getEmpresa());
        descripcionProveedor.setText(selectedProveedor.getDescripcionUsuario());
        idProveedor.setText(selectedProveedor.getIdUsuario());
        telefonoProveedor.setText(selectedProveedor.getNumeroTelefonico());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);


        RecyclerView.Adapter mAdapter = new ProductosProveedorAdapter(selectedProveedor.getProductosInventario(), pCommunication);
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

    ProductosProveedorFragmentCommunication pCommunication = new ProductosProveedorFragmentCommunication() {
        @Override
        public void sendProducto(Producto productoSent) {
            Fragment infoProducto = InfoProductoFragment.newInstance(selectedUser, productoSent);
            FragmentTransaction transaction = Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction();
            transaction.setCustomAnimations(android.R.animator.fade_in,android.R.animator.fade_out);
            transaction.replace(R.id.nav_host_fragment, infoProducto);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    };

}
