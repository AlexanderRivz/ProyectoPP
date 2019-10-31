package com.mdpustudio.proyectobuy4you;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mdpustudio.proyectobuy4you.fragments.consumidor.shoppingcart.ShoppingCartFragment;
import com.mdpustudio.proyectobuy4you.fragments.consumidor.mainpageusuario.MainPageUsuarioFragment;
import com.mdpustudio.proyectobuy4you.fragments.consumidor.profile.ProfileFragment;
import com.mdpustudio.proyectobuy4you.fragments.consumidor.settings.SettingsFragment;
import com.mdpustudio.proyectobuy4you.fragments.proveedor.mainpageproveedor.MainPageProveedorFragment;
import com.mdpustudio.proyectobuy4you.models.CarritoCompra;
import com.mdpustudio.proyectobuy4you.models.Categoria;
import com.mdpustudio.proyectobuy4you.models.Persona;
import com.mdpustudio.proyectobuy4you.models.Producto;
import com.mdpustudio.proyectobuy4you.models.Proveedor;
import com.mdpustudio.proyectobuy4you.models.TipoUsuario;
import com.mdpustudio.proyectobuy4you.models.Usuario;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;

import java.util.ArrayList;

public class MainNavigationActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    ActionBarDrawerToggle t;
    Persona loggedUser;
    Usuario infoUser;
    Proveedor infoProveedor;
    ArrayList<Usuario> userList = new ArrayList<>();
    ArrayList<Proveedor> proveedorList = new ArrayList<>();
    private ArrayList<Producto> productos1 = new ArrayList<>();
    private ArrayList<Producto> productos2 = new ArrayList<>();
    private ArrayList<Producto> productos3 = new ArrayList<>();
    ArrayList<CarritoCompra> carrito = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_navigation);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        loggedUser = (Persona) getIntent().getSerializableExtra("loggedUser");

        generateData();

        assert loggedUser != null;
        if (loggedUser.getTipoUsuario() == TipoUsuario.Consumidor){
            for (int i=0; i<userList.size();i++){
                if (userList.get(i).getIdpersona() == loggedUser.getIdpersona()){
                    infoUser = userList.get(i);
                }
            }

            Fragment homeFragment = MainPageUsuarioFragment.newInstance(loggedUser, infoUser);
            doFragmentTransaction(homeFragment);
        }else if (loggedUser.getTipoUsuario() == TipoUsuario.Tienda){
            for (int i=0; i<proveedorList.size();i++){
                if (proveedorList.get(i).getIdpersona() == loggedUser.getIdpersona()){
                    infoProveedor = proveedorList.get(i);
                }
            }
            Fragment homeFragmentProveedor = MainPageProveedorFragment.newInstance(loggedUser, infoProveedor);
            doFragmentTransaction(homeFragmentProveedor);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        BottomNavigationView bnv = findViewById(R.id.bottom_navigation);
        if (loggedUser.getTipoUsuario() == TipoUsuario.Consumidor) {
            bnv.inflateMenu(R.menu.main_botton_menu);
            bnv.setOnNavigationItemSelectedListener(
                    new BottomNavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                            switch (item.getItemId()) {
                                case R.id.action_home:
                                    // TODO
                                    Fragment homeFragment = MainPageUsuarioFragment.newInstance(loggedUser, infoUser);
                                    doFragmentTransaction(homeFragment);
                                    return true;
                                case R.id.action_shopping_cart:
                                    // TODO
                                    Fragment shoppingCart = ShoppingCartFragment.newInstance(infoUser);
                                    doFragmentTransaction(shoppingCart);
                                    return true;
                                case R.id.action_profile:
                                    // TODO
                                    Fragment profileFragment = ProfileFragment.newInstance(loggedUser, infoUser);
                                    doFragmentTransaction(profileFragment);
                                    return true;
                                case R.id.action_settings:
                                    // TODO
                                    Fragment settingsFragent = new SettingsFragment();
                                    doFragmentTransaction(settingsFragent);
                                    return true;
                            }
                            return false;
                        }
                    });
        }else if(loggedUser.getTipoUsuario() == TipoUsuario.Tienda){
            bnv.inflateMenu(R.menu.main_botton_menu_prov);
            bnv.setOnNavigationItemSelectedListener(
                    new BottomNavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                            switch (item.getItemId()) {
                                case R.id.action_home:
                                    // TODO
                                    Fragment homeFragment = MainPageProveedorFragment.newInstance(loggedUser, infoProveedor);
                                    doFragmentTransaction(homeFragment);
                                    return true;
                                case R.id.action_profile:
                                    // TODO
                                    Fragment profileFragment = ProfileFragment.newInstance(loggedUser, infoUser);
                                    doFragmentTransaction(profileFragment);
                                    return true;
                                case R.id.action_settings:
                                    // TODO
                                    Fragment settingsFragent = new SettingsFragment();
                                    doFragmentTransaction(settingsFragent);
                                    return true;
                            }
                            return false;
                        }
                    });
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    public void doFragmentTransaction(Fragment selectedFragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
        transaction.replace(R.id.nav_host_fragment, selectedFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    //esto al final se tiene que borrar cuando se conecte con la base, por ahora es solo para hacer la informacion quemada
    public void generateData(){
        //productos proveedores
        if (productos1 != null){
            productos1.clear();
        }
        productos1.add(new Producto(1,"Shampoo Head&Shoulders","Shampoo que te deja el cabello muy limpio", 20,Categoria.CuidadoPersonal,10.00));
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
        userList.add(new Usuario(1,1, "Christian Alexander", "Rivera Rivas", carrito));
        userList.add(new Usuario(2,2,"test nombre", "test apellido", carrito));

    }
}
