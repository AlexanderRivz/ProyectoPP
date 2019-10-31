package com.mdpustudio.proyectobuy4you.fragments.consumidor.shoppingcart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mdpustudio.proyectobuy4you.R;
import com.mdpustudio.proyectobuy4you.models.CarritoCompra;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ShoppingCartAdapter extends RecyclerView.Adapter<ShoppingCartAdapter.ViewHolder> {

    private ArrayList<CarritoCompra> carritoProductos;

    ShoppingCartAdapter(ArrayList<CarritoCompra> carritoProductos){
        this.carritoProductos = carritoProductos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_cart, parent, false);
        ViewHolder pvh = new ViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nombreProducto.setText(carritoProductos.get(position).getItemProducto().getNombreProducto());
        holder.cantidadProducto.setText(String.valueOf(carritoProductos.get(position).getCantidadProductos()));
        holder.totalProductos.setText(String.valueOf(carritoProductos.get(position).getPrecioProducto()));
    }

    @Override
    public int getItemCount() {
        return carritoProductos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView nombreProducto;
        TextView cantidadProducto;
        TextView totalProductos;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nombreProducto = itemView.findViewById(R.id.nombreProductocart_textView);
            cantidadProducto = itemView.findViewById(R.id.cantidadtotalproducto_textview);
            totalProductos = itemView.findViewById(R.id.preciototalproducto_textview);

        }
    }
}
