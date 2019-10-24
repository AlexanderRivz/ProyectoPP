package com.mdpustudio.proyectobuy4you.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Proveedor implements Serializable {

    private String empresa;
    private String sucursal;
    private String idUsuario;
    private String descripcionUsuario;
    //private String Imagen;
    private ArrayList<Producto> productosInventario;
    private TipoUsuario tipoUsuario;
    private String numeroTelefonico;
    private double longitud;
    private double latitud;


    public Proveedor(String empresa, String sucursal, String idUsuario, String descripcionUsuario,/*String imagen, */ArrayList<Producto> productosInventario,
                     TipoUsuario tipoUsuario, String numeroTelefonico, double longitud, double latitud){
        this.setEmpresa(empresa);
        this.setSucursal(sucursal);
        this.setIdUsuario(idUsuario);
        this.setDescripcionUsuario(descripcionUsuario);
        //this.setImagen(imagen);
        this.setProductosInventario(productosInventario);
        this.setTipoUsuario(tipoUsuario);
        this.setNumeroTelefonico(numeroTelefonico);
        this.setLongitud(longitud);
        this.setLatitud(latitud);
    }



    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }


    /*public String getImagen() {
        return Imagen;
    }

    public void setImagen(String imagen) {
        Imagen = imagen;
    }*/

    /*public List<Producto> getCarritoCompras() {
        return carritoCompras;
    }

    public void setCarritoCompras(List<Producto> carritoCompras) {
        this.carritoCompras = carritoCompras;
    }*/

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public ArrayList<Producto> getProductosInventario() {
        return productosInventario;
    }

    public void setProductosInventario(ArrayList<Producto> productosInventario) {
        this.productosInventario = productosInventario;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public String getDescripcionUsuario() {
        return descripcionUsuario;
    }

    public void setDescripcionUsuario(String descripcionUsuario) {
        this.descripcionUsuario = descripcionUsuario;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

}
