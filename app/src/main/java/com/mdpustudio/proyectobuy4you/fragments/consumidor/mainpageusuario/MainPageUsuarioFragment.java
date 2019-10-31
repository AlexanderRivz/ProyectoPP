package com.mdpustudio.proyectobuy4you.fragments.consumidor.mainpageusuario;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mdpustudio.proyectobuy4you.R;
import com.mdpustudio.proyectobuy4you.fragments.consumidor.productosproveedor.ProductosProveedorFragment;
import com.mdpustudio.proyectobuy4you.models.Categoria;
import com.mdpustudio.proyectobuy4you.models.Persona;
import com.mdpustudio.proyectobuy4you.models.Producto;
import com.mdpustudio.proyectobuy4you.models.Proveedor;
import com.mdpustudio.proyectobuy4you.models.Usuario;

import java.util.ArrayList;
import java.util.Objects;

public class MainPageUsuarioFragment extends Fragment {

    private ProveedorViewModel proveedorViewModel;
    private Usuario selectedUser = null;
    Persona selectedPersona = null;

    private ArrayList<Proveedor> proveedoresList = new ArrayList<>();
    private ArrayList<Producto> productos1 = new ArrayList<>();
    private ArrayList<Producto> productos2 = new ArrayList<>();
    private ArrayList<Producto> productos3 = new ArrayList<>();
    private ArrayList<Producto> productos4 = new ArrayList<>();

    public static MainPageUsuarioFragment newInstance(Persona persona, Usuario user) {

        MainPageUsuarioFragment mainPageUsuarioFragment = new MainPageUsuarioFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("selectedPersona", persona);
        bundle.putSerializable("selectedUser", user);
        mainPageUsuarioFragment.setArguments(bundle);

        return mainPageUsuarioFragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_proveedor, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.fragmentproveedor_recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        assert getArguments() != null;
        selectedUser = (Usuario) getArguments().getSerializable("selectedUser");
        selectedPersona = (Persona) getArguments().getSerializable("selectedPersona");

        proveedoresList.clear();

        createData();

        RecyclerView.Adapter mAdapter = new MainPageUsuarioAdapter(proveedoresList, pCommunication);
        recyclerView.setAdapter(mAdapter);

        return root;
    }

    private void  createData(){

        //productos proveedores
        if (productos1 != null){
            productos1.clear();
        }
        productos1.add(new Producto("Shampoo Head&Shoulders","Shampoo que te deja el cabello muy limpio", 20,Categoria.CuidadoPersonal,10.00));
        productos1.add(new Producto("PanCakes don Ariel","PanCakes con un rico sabor a chocolate", 15,Categoria.Harinas, 5.00));
        productos1.add(new Producto("Manzanas don Merino","Manzana roja traida directamente del huerto de don Merino",8 ,Categoria.FrutasyVerduras, 0.25));
        productos1.add(new Producto("Aceite de Oliva don Josseh","Aceite de la mejor calidad", 7,Categoria.AceiteyPasta, 10.00));
        productos1.add(new Producto("Huevos la Gallinita","Huevos de la mejor calidad.", 5,Categoria.HuevosyLacteos, 3.25));

        if (productos2 != null){
            productos2.clear();
        }
        productos2.add(new Producto("Conserva de Coco \"Cocolito\"","Rica conserva de coco directamente de cocolito", 13,Categoria.Conservas,0.50));
        productos2.add(new Producto("Semita \"La Mieluda\"", "Deliciosa semita, asi como le gusta a la gente, bien mieluda",14,Categoria.PanaderiayDulces,0.50));
        productos2.add(new Producto("Carde de cerdo el Cerdito", "La mejor carde directa de los mejores cerdos", 20,Categoria.CarnesyEmbutidos, 1.00));
        productos2.add(new Producto("Jugo de Sandia don Rodrigo","Jugo de Sandia de los campos de don Rodrigo", 15,Categoria.Bebidas, 2.50));
        productos2.add(new Producto("Aperitivo de Chicharron \"El puerquito Feliz\"","El mas rico chicharron, que tiene ese saber peculiar de los cerditos felices",8,Categoria.Aperitivos,0.75));

        if (productos3 != null){
            productos3.clear();
        }
        productos3.add(new Producto("Juguete de accion Ariel ChocoGamer", "El juguete de accion de tu streamer favorito Ariel ChocoGamer.", 5,Categoria.Infantil,15.00));
        productos3.add(new Producto("Pollo Rostizado \"Don Roberto\"", "Rico pollo rostizado que seguro calmara tu hambre.", 13,Categoria.Preparados, 7.00));
        productos3.add(new Producto("Detergente Ajax","Detergente Ajax, dejara tu ropa bien limpia", 2,Categoria.HogaryLimpieza, 5.00));
        productos3.add(new Producto("Cereal de chocolate \"Ariel ChocoGamer\"","Rico cereal de chocolate de tu streamer favorito Ariel ChocoGamer.", 13,Categoria.Cereales, 5.00));
        productos3.add(new Producto("Gaseosa sabor Toronja \"El Soplado\"","Gaseosa de toronja de tu marca favorita, \"El Soplado\"", 13,Categoria.Bebidas, 0.50));

        //info proveedores
        if (proveedoresList != null){
            proveedoresList.clear();
        }
        proveedoresList.add(new Proveedor(1,3,"Super Selectos","El Encuentro","Super Selectos sucursal Centro Comercial \"El Encuentro\"",productos1,"2319-6010",-89.36028047621716,13.736546158980348));
        proveedoresList.add(new Proveedor(2,4,"Despensa de Don Juan","Holanda","Despensa de Don Juan surcursal por definir.",productos2,"2319 6010",1,1));
        proveedoresList.add(new Proveedor(3,5,"Walmart","Las Cascadas","Walmart la mejor tienda.",productos3,"2319 6010",1,1));
    }

    @Override
    public void onDetach() {
        Objects.requireNonNull(getActivity()).moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
        super.onDetach();
    }

    MainPageUsuarioFragmentCommunication pCommunication = new MainPageUsuarioFragmentCommunication() {
        @Override
        public void sendProveedor(Proveedor selectedProveedor) {
            Fragment productosProveedorFragment = ProductosProveedorFragment.newInstance(selectedPersona, selectedUser, selectedProveedor);
            FragmentTransaction transaction = Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction();
            transaction.setCustomAnimations(android.R.animator.fade_in,android.R.animator.fade_out);
            transaction.replace(R.id.nav_host_fragment, productosProveedorFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    };

}