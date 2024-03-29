package com.mdpustudio.proyectobuy4you.fragments.proveedores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.mdpustudio.proyectobuy4you.R;
import com.mdpustudio.proyectobuy4you.models.Proveedor;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ProveedorAdapter extends RecyclerView.Adapter<ProveedorAdapter.ViewHolder> {

    private ArrayList<Proveedor> listaProveedores;
    ProveedorFragmentCommunication pCommunicator;


    ProveedorAdapter(ArrayList<Proveedor> listaProveedores, ProveedorFragmentCommunication communication){
        this.listaProveedores = listaProveedores;
        pCommunicator = communication;
    }

    @Override
    public int getItemCount() {
        return listaProveedores.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view_proveedor, viewGroup, false);
        ViewHolder pvh = new ViewHolder(v, pCommunicator);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.nombreProveedor.setText(listaProveedores.get(i).getEmpresa());
        viewHolder.idProveedor.setText(listaProveedores.get(i).getIdUsuario());
        viewHolder.tipoUsuario.setText(listaProveedores.get(i).getTipoUsuario().toString());
        viewHolder.currentUser = listaProveedores.get(i);
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CardView cv;
        TextView nombreProveedor;
        TextView idProveedor;
        TextView tipoUsuario;
        Button buttonInfo;
        Proveedor currentUser;
        ProveedorFragmentCommunication pCommunication;

        ViewHolder(final View itemView, ProveedorFragmentCommunication communicator){
            super(itemView);

            cv = itemView.findViewById(R.id.proveedor_card_view);
            nombreProveedor = itemView.findViewById(R.id.nombreProveedor_textview);
            idProveedor = itemView.findViewById(R.id.idproveedor_textview);
            tipoUsuario = itemView.findViewById(R.id.tipoUsuario_textview);
            buttonInfo = itemView.findViewById(R.id.infoproveedor_button);

            pCommunication = communicator;

            buttonInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    pCommunication.sendProveedor(currentUser);
                }
            });

        }
    }
}
