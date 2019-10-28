package com.mdpustudio.proyectobuy4you.fragments.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.snackbar.Snackbar;
import com.mdpustudio.proyectobuy4you.R;
import com.mdpustudio.proyectobuy4you.fragments.modificardatosuser.ModificarDatosFragment;
import com.mdpustudio.proyectobuy4you.models.Usuario;

import java.util.Objects;

public class ProfileFragment extends Fragment {

    private ProfileViewModel profileViewModel;
    private Usuario selectedUser;

    public static ProfileFragment newInstance(Usuario user) {

        Bundle args = new Bundle();

        ProfileFragment fragment = new ProfileFragment();
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
        selectedUser = (Usuario)getArguments().getSerializable("selectedUser");

        TextView firstName = root.findViewById(R.id.nombreprofile_textview);
        TextView lastName = root.findViewById(R.id.apellidosprofile_textview);
        TextView username = root.findViewById(R.id.nombreUsuarioProfile_textview);
        TextView emailUser = root.findViewById(R.id.emailprofile_textview);
        Button buttonModificar = root.findViewById(R.id.modificarDatos_button);

        firstName.setText(selectedUser.getNombreUsuario());
        lastName.setText(selectedUser.getApellidoUsuario());
        username.setText(selectedUser.getUsername());
        emailUser.setText(selectedUser.getEmail());

        buttonModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment modificarFragment = ModificarDatosFragment.newInstance(selectedUser);
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