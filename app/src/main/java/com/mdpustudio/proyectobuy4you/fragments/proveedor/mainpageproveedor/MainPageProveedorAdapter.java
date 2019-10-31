package com.mdpustudio.proyectobuy4you.fragments.proveedor.mainpageproveedor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mdpustudio.proyectobuy4you.R;
import com.mdpustudio.proyectobuy4you.models.Producto;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainPageProveedorAdapter extends RecyclerView.Adapter<MainPageProveedorAdapter.ViewHolder> {
    private ArrayList<Producto> listaProductos;
    MainPageProveedorFragmentCommunication pCommunication;

    MainPageProveedorAdapter(ArrayList<Producto> listaProductos, MainPageProveedorFragmentCommunication communication){
        this.listaProductos = listaProductos;
        pCommunication = communication;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.proveedor_card_view_main_page, parent, false);
        ViewHolder pvh = new ViewHolder(v, pCommunication);

        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nombreProducto.setText(listaProductos.get(position).getNombreProducto());
        holder.precioProducto.setText(String.valueOf(listaProductos.get(position).getPrecioBase()));
        holder.categoriaProducto.setText(listaProductos.get(position).getCategoriaProducto().toString());
        holder.cantidadProducto.setText(String.valueOf(listaProductos.get(position).getCantidadInventario()));
        holder.currentProduct = listaProductos.get(position);

    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nombreProducto;
        TextView precioProducto;
        TextView categoriaProducto;
        TextView cantidadProducto;
        Button buttonInfo;
        Producto currentProduct;
        MainPageProveedorFragmentCommunication pCommunicator;

        public ViewHolder(@NonNull View itemView, MainPageProveedorFragmentCommunication communication) {
            super(itemView);

            nombreProducto = itemView.findViewById(R.id.nombreProducto_textView);
            precioProducto = itemView.findViewById(R.id.precioProducto_textView);
            categoriaProducto = itemView.findViewById(R.id.categoriaProducot_textView);
            cantidadProducto = itemView.findViewById(R.id.cantidadproducto_textview);
            buttonInfo = itemView.findViewById(R.id.prveedorinfoproducto_button);


            pCommunicator = communication;

            buttonInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    pCommunicator.sendProducto(currentProduct);
                }
            });

        }
    }
}
