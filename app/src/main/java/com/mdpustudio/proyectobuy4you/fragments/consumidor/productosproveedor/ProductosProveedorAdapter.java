package com.mdpustudio.proyectobuy4you.fragments.consumidor.productosproveedor;

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

public class ProductosProveedorAdapter extends RecyclerView.Adapter<ProductosProveedorAdapter.ViewHolder> {
    private ArrayList<Producto> listaProductos;
    ProductosProveedorFragmentCommunication pCommunication;

    ProductosProveedorAdapter(ArrayList<Producto> listaProductos, ProductosProveedorFragmentCommunication communication){
        this.listaProductos = listaProductos;
        pCommunication = communication;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_producto, parent, false);
        ViewHolder pvh = new ViewHolder(v, pCommunication);

        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nombreProducto.setText(listaProductos.get(position).getNombreProducto());
        holder.precioProducto.setText("$"+listaProductos.get(position).getPrecioBase());
        holder.categoriaProducto.setText(listaProductos.get(position).getCategoriaProducto().toString());
        holder.descripcionProducto.setText(listaProductos.get(position).getDescripcion());
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
        TextView descripcionProducto;
        Button buttonInfo;
        Producto currentProduct;
        Boolean isExpanded = false;
        ProductosProveedorFragmentCommunication pCommunicator;

        public ViewHolder(@NonNull View itemView, ProductosProveedorFragmentCommunication communication) {
            super(itemView);

            nombreProducto = itemView.findViewById(R.id.nombreProducto_textView);
            precioProducto = itemView.findViewById(R.id.precioProducto_textView);
            categoriaProducto = itemView.findViewById(R.id.categoriaProducot_textView);
            descripcionProducto = itemView.findViewById(R.id.descripcionproducto_textView);
            buttonInfo = itemView.findViewById(R.id.infoproducto_button);
            descripcionProducto.setVisibility(View.GONE);

            pCommunicator = communication;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isExpanded) {
                        isExpanded = collapse(v); // returns false
                    } else {
                        isExpanded = expand(v); // returns True
                    }
                }
            });

            buttonInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    pCommunicator.sendProducto(currentProduct);
                }
            });

        }

        // Expand the CardView
        private boolean expand(View cardView) {
            // Make the intro text invisible and make the full text visible
            descripcionProducto.setVisibility(View.VISIBLE);
            return true;
        }

        // Collapse the CardView
        private boolean collapse(View cardView) {
            // Make the intro text visible and make the full text invisible
            descripcionProducto.setVisibility(View.GONE);
            return false;
        }
    }
}
