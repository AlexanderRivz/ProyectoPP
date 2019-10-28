package com.mdpustudio.proyectobuy4you.fragments.modificardatosuser;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.mdpustudio.proyectobuy4you.R;
import com.mdpustudio.proyectobuy4you.models.Usuario;

import java.util.Objects;

public class ModificarDatosFragment extends Fragment {

    public static ModificarDatosFragment newInstance(Usuario user) {

        Bundle args = new Bundle();
        args.putSerializable("selectedUser", user);
        ModificarDatosFragment fragment = new ModificarDatosFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private ModificarDatosViewModel modificarDatosViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        modificarDatosViewModel =
                ViewModelProviders.of(this).get(ModificarDatosViewModel.class);
        View root = inflater.inflate(R.layout.fragment_modificar_datos, container, false);

        assert getArguments() != null;
        final Usuario selectedUser = (Usuario) getArguments().getSerializable("selectedUser");

        final TextInputEditText nombreedit= root.findViewById(R.id.nombremod_editext);
        final TextInputLayout nombrelayout  = root.findViewById(R.id.nombremod_layout);
        assert selectedUser != null;
        nombreedit.setText(selectedUser.getNombreUsuario());

        final TextInputEditText apellidoedit= root.findViewById(R.id.apellidosmod_edittext);
        final TextInputLayout apellidolayout  = root.findViewById(R.id.apellidosmod_layout);
        apellidoedit.setText(selectedUser.getApellidoUsuario());

        final TextInputEditText emailedit= root.findViewById(R.id.emailmod_edittext);
        final TextInputLayout emaillayout  = root.findViewById(R.id.emailmod_layout);
        emailedit.setText(selectedUser.getEmail());

        final TextInputEditText useredit= root.findViewById(R.id.usernamemod_edittext);
        final TextInputLayout userlayout  = root.findViewById(R.id.usernamemod_layout);
        useredit.setText(selectedUser.getUsername());

        final TextInputEditText currentpassedit= root.findViewById(R.id.currentpassmod_edittext);
        final TextInputLayout currentpasslayout  = root.findViewById(R.id.currentpassmod_layout);

        final TextInputEditText newpassedit= root.findViewById(R.id.newpass_edittext);
        final TextInputLayout newpasslayout  = root.findViewById(R.id.newpass_layout);

        final TextInputEditText confnewpassedit= root.findViewById(R.id.confnewpass_edittext);
        final TextInputLayout confnewpasslayout  = root.findViewById(R.id.confnewpass_layout);


        Button modificar = root.findViewById(R.id.modificarDatos_button);

        modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean flag = true;

                if (Objects.requireNonNull(nombreedit.getText()).toString().isEmpty()){
                    flag = false;
                    nombrelayout.setError("Tiene que ingresar sus nombres.");
                }
                if (Objects.requireNonNull(apellidoedit.getText()).toString().isEmpty()){
                    flag = false;
                    apellidolayout.setError("Tiene que ingresar sus apellidos.");
                }
                if (Objects.requireNonNull(emailedit.getText()).toString().isEmpty()){
                    flag = false;
                    emaillayout.setError("Tiene que ingresar un email.");
                }
                if (Objects.requireNonNull(useredit.getText()).toString().isEmpty()){
                    flag = false;
                    userlayout.setError("Tiene que ingresar un nombre de usuario.");
                }
                if (Objects.requireNonNull(currentpassedit.getText()).toString().isEmpty()){
                    flag = false;
                    currentpasslayout.setError("Tiene que ingresar su contraseña.");
                }
                if (currentpassedit.getText().toString() == (selectedUser.getPassword())){
                    flag = false;
                    currentpasslayout.setError("Las contrañas no concuerdan.");
                }
                if (Objects.requireNonNull(newpassedit.getText()).toString().isEmpty()){
                    flag = false;
                    newpasslayout.setError("Tiene que ingresar su contraseña.");
                }
                if (Objects.requireNonNull(confnewpassedit.getText()).toString().isEmpty()){
                    flag = false;
                    confnewpasslayout.setError("Tiene que confirmar la contraseña.");
                }
                if (!newpassedit.getText().toString().equals(confnewpassedit.getText().toString())){
                    flag = false;
                    newpasslayout.setError("Las contraseñas no concuerdan.");
                    confnewpasslayout.setError("Las contraseñas no concuerdan,");
                }


                if (flag){
                    selectedUser.setNombreUsuario(Objects.requireNonNull(nombreedit.getText().toString()));
                    selectedUser.setApellidoUsuario(Objects.requireNonNull(apellidoedit.getText()).toString());
                    selectedUser.setEmail(Objects.requireNonNull(emailedit.getText()).toString());
                    selectedUser.setUsername(Objects.requireNonNull(useredit.getText()).toString());
                    selectedUser.setPassword(Objects.requireNonNull(confnewpassedit.getText()).toString());
                    Snackbar.make(view, "Se han guardado los cambios", Snackbar.LENGTH_SHORT).show();

                }

            }
        });


        return root;
    }
}