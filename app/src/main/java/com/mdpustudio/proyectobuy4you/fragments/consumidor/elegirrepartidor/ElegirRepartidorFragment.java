package com.mdpustudio.proyectobuy4you.fragments.consumidor.elegirrepartidor;

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
import com.mdpustudio.proyectobuy4you.models.CarritoCompra;
import com.mdpustudio.proyectobuy4you.models.Categoria;
import com.mdpustudio.proyectobuy4you.models.Persona;
import com.mdpustudio.proyectobuy4you.models.PeticionEntrega;
import com.mdpustudio.proyectobuy4you.models.Producto;
import com.mdpustudio.proyectobuy4you.models.Proveedor;
import com.mdpustudio.proyectobuy4you.models.Repartidor;
import com.mdpustudio.proyectobuy4you.models.Usuario;

import java.util.ArrayList;

public class ElegirRepartidorFragment extends Fragment {

    private ElegirRepartidorViewModel mViewModel;
    ArrayList<Usuario> userList = new ArrayList<>();
    ArrayList<Proveedor> proveedorList = new ArrayList<>();
    private ArrayList<Producto> productos1 = new ArrayList<>();
    private ArrayList<Producto> productos2 = new ArrayList<>();
    private ArrayList<Producto> productos3 = new ArrayList<>();
    private ArrayList<Repartidor> repartidores = new ArrayList<>();
    private ArrayList<CarritoCompra> rep1 = new ArrayList<>();
    private ArrayList<CarritoCompra> rep2 = new ArrayList<>();
    private ArrayList<CarritoCompra> rep3 = new ArrayList<>();
    ArrayList<PeticionEntrega> ent1 = new ArrayList<>();
    ArrayList<PeticionEntrega> ent2 = new ArrayList<>();
    ArrayList<PeticionEntrega> ent3 = new ArrayList<>();
    ArrayList<CarritoCompra> carrito = new ArrayList<>();

    public static ElegirRepartidorFragment newInstance(Persona persona, Usuario usuario) {

        Bundle args = new Bundle();
        args.putSerializable("selectedPersona", persona);
        args.putSerializable("selectedUsuario", usuario);
        ElegirRepartidorFragment fragment = new ElegirRepartidorFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_elegir_repartidor, container, false);

        assert getArguments() != null;
        Persona selectedPersona = (Persona) getArguments().getSerializable("selectedPersona");
        Usuario selectedUser = (Usuario) getArguments().getSerializable("selectedUsuario");

        createData();

        RecyclerView recyclerView = root.findViewById(R.id.repartidoresDisponibles_recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        assert selectedUser != null;
        RecyclerView.Adapter adapter = new ElegirRepartidorAdapter(repartidores);
        recyclerView.setAdapter(adapter);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ElegirRepartidorViewModel.class);
        // TODO: Use the ViewModel
    }

    public void createData(){
        //productos proveedores
        if (productos1 != null){
            productos1.clear();
        }
        productos1.add(new Producto(1,"Shampoo Head&Shoulders","Shampoo que te deja el cabello muy limpio", 20, Categoria.CuidadoPersonal,10.00));
        productos1.add(new Producto(2,"PanCakes don Ariel","PanCakes con un rico sabor a chocolate", 15,Categoria.Harinas, 5.00));
        productos1.add(new Producto(3,"Manzanas don Merino","Manzana roja traida directamente del huerto de don Merino",8 ,Categoria.FrutasyVerduras, 0.25));
        productos1.add(new Producto(4,"Aceite de Oliva don Josseh","Aceite de la mejor calidad", 7,Categoria.AceiteyPasta, 10.00));
        productos1.add(new Producto(5,"Huevos la Gallinita","Huevos de la mejor calidad.", 5,Categoria.HuevosyLacteos, 3.25));

        if (productos2 != null){
            productos2.clear();
        }
        productos2.add(new Producto(1,"Conserva de Coco \"Cocolito\"","Rica conserva de coco directamente de cocolito", 13,Categoria.Conservas,0.50));
        productos2.add(new Producto(2,"Semita \"La Mieluda\"", "Deliciosa semita, asi como le gusta a la gente, bien mieluda",14,Categoria.PanaderiayDulces,0.50));
        productos2.add(new Producto(3,"Carde de cerdo el Cerdito", "La mejor carde directa de los mejores cerdos", 20,Categoria.CarnesyEmbutidos, 1.00));
        productos2.add(new Producto(4,"Jugo de Sandia don Rodrigo","Jugo de Sandia de los campos de don Rodrigo", 15,Categoria.Bebidas, 2.50));
        productos2.add(new Producto(5,"Aperitivo de Chicharron \"El puerquito Feliz\"","El mas rico chicharron, que tiene ese saber peculiar de los cerditos felices",8,Categoria.Aperitivos,0.75));

        if (productos3 != null){
            productos3.clear();
        }
        productos3.add(new Producto(1,"Juguete de accion Ariel ChocoGamer", "El juguete de accion de tu streamer favorito Ariel ChocoGamer.", 5,Categoria.Infantil,15.00));
        productos3.add(new Producto(2,"Pollo Rostizado \"Don Roberto\"", "Rico pollo rostizado que seguro calmara tu hambre.", 13,Categoria.Preparados, 7.00));
        productos3.add(new Producto(3,"Detergente Ajax","Detergente Ajax, dejara tu ropa bien limpia", 2,Categoria.HogaryLimpieza, 5.00));
        productos3.add(new Producto(4,"Cereal de chocolate \"Ariel ChocoGamer\"","Rico cereal de chocolate de tu streamer favorito Ariel ChocoGamer.", 13,Categoria.Cereales, 5.00));
        productos3.add(new Producto(5,"Gaseosa sabor Toronja \"El Soplado\"","Gaseosa de toronja de tu marca favorita, \"El Soplado\"", 13,Categoria.Bebidas, 0.50));

        //info proveedores
        if (proveedorList != null){
            proveedorList.clear();
        }
        proveedorList.add(new Proveedor(1,3,"Super Selectos","El Encuentro","Super Selectos sucursal Centro Comercial \"El Encuentro\"",productos1,"2319-6010",-89.36028047621716,13.736546158980348));
        proveedorList.add(new Proveedor(2,4,"Despensa de Don Juan","Holanda","Despensa de Don Juan surcursal por definir.",productos2,"2319 6010",1,1));
        proveedorList.add(new Proveedor(3,5,"Walmart","Las Cascadas","Walmart la mejor tienda.",productos3,"2319 6010",1,1));


        //usuarios consumidores
        if (userList != null){
            userList.clear();
        }
        userList.add(new Usuario(1,1, "Christian Alexander", "Rivera Rivas", carrito));
        userList.add(new Usuario(2,2,"test nombre", "test apellido", carrito));

        //usuarios reparditores
        if (rep1 != null){
            rep1.clear();
        }
        rep1.add(new CarritoCompra(productos3.get(1),2,productos3.get(1).getPrecioBase()*2));
        rep1.add(new CarritoCompra(productos3.get(2),4,productos3.get(2).getPrecioBase()*4));
        rep1.add(new CarritoCompra(productos3.get(3),5,productos3.get(3).getPrecioBase()*5));

        if (rep2 != null){
            rep2.clear();
        }
        rep2.add(new CarritoCompra(productos3.get(1),2,productos3.get(1).getPrecioBase()*2));
        rep2.add(new CarritoCompra(productos3.get(2),3,productos3.get(2).getPrecioBase()*3));
        rep2.add(new CarritoCompra(productos3.get(3),4,productos3.get(3).getPrecioBase()*4));

        if (rep3 != null){
            rep3.clear();
        }
        rep3.add(new CarritoCompra(productos3.get(1),2,productos3.get(1).getPrecioBase()*2));
        rep3.add(new CarritoCompra(productos1.get(1),3,productos1.get(1).getPrecioBase()*3));
        rep3.add(new CarritoCompra(productos2.get(1),4,productos2.get(1).getPrecioBase()*4));

        if (ent1 != null){
            ent1.clear();
        }
        ent1.add(new PeticionEntrega(1,1, "Josseh Blanco", rep1));
        ent1.add(new PeticionEntrega(2,2,"Roberto Jose", rep2));
        if (ent2 != null){
            ent2.clear();
        }
        ent2.add(new PeticionEntrega(2,1,"Roberto Jose",rep2));
        if (ent3 != null){
            ent3.clear();
        }
        ent3.add(new PeticionEntrega(3,2,"Karla Esperanza", rep3));

        if (repartidores != null){
            repartidores.clear();
        }
        repartidores.add(new Repartidor(1,6,"Rogelio Jose", "Lopez Blanco", ent1, "5151-5151",true));
        repartidores.add(new Repartidor(2,7,"Franco Manuel", "Canales Reyes", ent2, "2121-5151",true));
        repartidores.add(new Repartidor(3,8,"Josseh Mario", "Blanco Amaya", ent3, "5453-5151",true));
    }
}
