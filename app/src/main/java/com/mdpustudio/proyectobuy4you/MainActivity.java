package com.mdpustudio.proyectobuy4you;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.mdpustudio.proyectobuy4you.models.CarritoCompra;
import com.mdpustudio.proyectobuy4you.models.Usuario;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Usuario> users = new ArrayList<>();
    ArrayList<CarritoCompra> carritoCompras = new ArrayList<>();
    EditText username;
    EditText password;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        username = findViewById(R.id.username_edittext);
        password = findViewById(R.id.password_edittext);
        loginButton = findViewById(R.id.login_button);

        createData();

        toolbar.setTitle(getString(R.string.app_name));
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        FloatingActionButton fab = findViewById(R.id.fablogin);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intent);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i=0; i<users.size(); i++){
                    if (username.getText().toString().equals(users.get(i).getUsername())){
                        Intent intent = new Intent(getApplicationContext(), MainNavigationActivity.class);
                        intent.putExtra("loggedUser", users.get(i));
                        startActivity(intent);
                    }
                }
                Snackbar.make(view,"Los datos son incorrectos" ,Snackbar.LENGTH_LONG).show();

            }
        });
    }

    public void createData(){

        users.add(new Usuario("Christian Alexander", "Rivera Rivas", "AlexanderRivz", "root", "00353514@uca.edu.sv" ,carritoCompras));
        users.add(new Usuario("Test User", "Test User", "", "", "tesmail@mail.com" ,carritoCompras));

    }

}
