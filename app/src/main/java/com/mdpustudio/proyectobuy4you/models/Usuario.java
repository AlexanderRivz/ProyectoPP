package com.mdpustudio.proyectobuy4you.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable {

    private int idusuario;
    private int idpersona;
    private String nombreUsuario;
    private String apellidoUsuario;
    private ArrayList<CarritoCompra> carritoCompras;

    public Usuario(int idusuario, int idpersona, String nombreUsuario, String apellidoUsuario, ArrayList<CarritoCompra> carritoCompras) {
        this.idusuario = idusuario;
        this.idpersona = idpersona;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.carritoCompras = carritoCompras;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public ArrayList<CarritoCompra> getCarritoCompras() {
        return carritoCompras;
    }

    public void setCarritoCompras(ArrayList<CarritoCompra> carritoCompras) {
        this.carritoCompras = carritoCompras;
    }

}
