package com.mdpustudio.proyectobuy4you;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.mdpustudio.proyectobuy4you.models.Persona;
import com.mdpustudio.proyectobuy4you.models.TipoUsuario;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ArrayList<Persona> peronas = new ArrayList<>();
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final TextInputLayout usernameLayout = findViewById(R.id.loginusername_layout);
        final TextInputEditText usernameEdit = findViewById(R.id.loginusername_edittext);

        final TextInputLayout passwordLayout = findViewById(R.id.logincontrasena_layout);
        final TextInputEditText passwordEdit = findViewById(R.id.logincontrasena_edittext);
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

                boolean flag = true;
                boolean correct = false;

                if(Objects.requireNonNull(usernameEdit.getText()).toString().isEmpty()){
                    flag = false;
                    usernameLayout.setError("Tiene que ingresar su usuario.");
                }
                if (Objects.requireNonNull(passwordEdit.getText()).toString().isEmpty()){
                    flag = false;
                    passwordLayout.setError("Tiene que ingresasr su contraseña.");
                }

                if (flag){
                    for (int i=0; i<peronas.size(); i++){
                        if (usernameEdit.getText().toString().equals(peronas.get(i).getUsername()) && passwordEdit.getText().toString().equals(peronas.get(i).getPassword())){
                            correct = true;
                            Intent intent = new Intent(getApplicationContext(), MainNavigationActivity.class);
                            intent.putExtra("loggedUser", peronas.get(i));
                            startActivity(intent);
                        }
                    }
                    if (!correct){
                        usernameLayout.setError("Credenciales incorrectas.");
                        passwordLayout.setError("Credenciales incorrectas.");
                    }

                }
            }
        });
    }

    public void createData(){

        peronas.add(new Persona(1, "testuser", "root", TipoUsuario.Consumidor,"test@email.com"));
        peronas.add(new Persona(2, "user", "root", TipoUsuario.Consumidor,"testuser@email.com"));
        peronas.add(new Persona(3, "testprov", "root", TipoUsuario.Tienda,"testprov@email.com"));
        peronas.add(new Persona(4, "proveedor", "root", TipoUsuario.Tienda,"testprov2@email.com"));
        peronas.add(new Persona(5, "proveedor2", "root", TipoUsuario.Tienda,"testprov3@email.com"));

    }

}
