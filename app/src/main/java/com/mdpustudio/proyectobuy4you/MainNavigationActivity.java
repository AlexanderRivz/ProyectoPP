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
import com.mdpustudio.proyectobuy4you.fragments.shoppingcart.ShoppingCartFragment;
import com.mdpustudio.proyectobuy4you.fragments.proveedores.ProveedorFragment;
import com.mdpustudio.proyectobuy4you.fragments.profile.ProfileFragment;
import com.mdpustudio.proyectobuy4you.fragments.settings.SettingsFragment;
import com.mdpustudio.proyectobuy4you.models.Usuario;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;

public class MainNavigationActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    ActionBarDrawerToggle t;
    Usuario loggedUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_navigation);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        loggedUser = (Usuario) getIntent().getSerializableExtra("loggedUser");

        Fragment homeFragment = ProveedorFragment.newInstance(loggedUser);
        doFragmentTransaction(homeFragment);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        BottomNavigationView bnv = findViewById(R.id.bottom_navigation);
        bnv.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_home:
                                // TODO
                                Fragment homeFragment = ProveedorFragment.newInstance(loggedUser);
                                doFragmentTransaction(homeFragment);
                                return true;
                            case R.id.action_shopping_cart:
                                // TODO
                                Fragment shoppingCart = ShoppingCartFragment.newInstance(loggedUser);
                                doFragmentTransaction(shoppingCart);
                                return true;
                            case R.id.action_profile:
                                // TODO
                                Fragment profileFragment = new ProfileFragment();
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
}
