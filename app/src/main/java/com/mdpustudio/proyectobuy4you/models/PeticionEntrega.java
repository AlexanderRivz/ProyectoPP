package com.mdpustudio.proyectobuy4you.models;

import java.io.Serializable;
import java.util.ArrayList;

public class PeticionEntrega implements Serializable {

    private int idEntrega;
    private int idUsuario;
    private String nombreUser;
    private ArrayList<CarritoCompra> pedido;

    public PeticionEntrega(int idEntrega, int idUsuario, String nombreUser, ArrayList<CarritoCompra> pedido) {
        this.idEntrega = idEntrega;
        this.idUsuario = idUsuario;
        this.nombreUser = nombreUser;
        this.pedido = pedido;
    }

    public int getIdEntrega() {
        return idEntrega;
    }

    public void setIdEntrega(int idEntrega) {
        this.idEntrega = idEntrega;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUser() {
        return nombreUser;
    }

    public void setNombreUser(String nombreUser) {
        this.nombreUser = nombreUser;
    }

    public ArrayList<CarritoCompra> getPedido() {
        return pedido;
    }

    public void setPedido(ArrayList<CarritoCompra> pedido) {
        this.pedido = pedido;
    }
}
