package com.mdpustudio.proyectobuy4you.fragments.consumidor.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.mdpustudio.proyectobuy4you.R;
import com.mdpustudio.proyectobuy4you.fragments.consumidor.modificardatosuser.ModificarDatosFragment;
import com.mdpustudio.proyectobuy4you.models.Persona;
import com.mdpustudio.proyectobuy4you.models.Usuario;

import java.util.Objects;

public class ProfileFragment extends Fragment {

    private ProfileViewModel profileViewModel;
    private Usuario selectedUser;
    Persona selectedPersona;

    public static ProfileFragment newInstance(Persona persona, Usuario user) {

        Bundle args = new Bundle();

        ProfileFragment fragment = new ProfileFragment();
        args.putSerializable("selectedPersona", persona);
        args.putSerializable("selectedUser", user);
        fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profileViewModel =
                ViewModelProviders.of(this).get(ProfileViewModel.class);
            View root = inflater.inflate(R.layout.fragment_profile, container, false);

        assert getArguments() != null;
        selectedPersona = (Persona) getArguments().getSerializable("selectedPersona");
        selectedUser = (Usuario)getArguments().getSerializable("selectedUser");

        TextView firstName = root.findViewById(R.id.nombreprofile_textview);
        TextView lastName = root.findViewById(R.id.apellidosprofile_textview);
        TextView username = root.findViewById(R.id.nombreUsuarioProfile_textview);
        TextView emailUser = root.findViewById(R.id.emailprofile_textview);
        Button buttonModificar = root.findViewById(R.id.modificarDatos_button);

        firstName.setText(selectedUser.getNombreUsuario());
        lastName.setText(selectedUser.getApellidoUsuario());
        username.setText(selectedPersona.getUsername());
        emailUser.setText(selectedPersona.getEmail());

        buttonModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment modificarFragment = ModificarDatosFragment.newInstance(selectedPersona, selectedUser);
                FragmentTransaction transaction = Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
                transaction.replace(R.id.nav_host_fragment, modificarFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return root;
    }
}