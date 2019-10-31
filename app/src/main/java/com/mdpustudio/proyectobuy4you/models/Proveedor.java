package com.mdpustudio.proyectobuy4you.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Proveedor implements Serializable {

    private int idproveedor;
    private int idpersona;
    private String empresa;
    private String sucursal;
    private String descripcionProveedor;
    //private String Imagen;
    private ArrayList<Producto> productosInventario;
    private String numeroTelefonico;
    private double longitud;
    private double latitud;

    public Proveedor(int idproveedor, int idpersona, String empresa, String sucursal, String descripcionProveedor, ArrayList<Producto> productosInventario, String numeroTelefonico, double longitud, double latitud) {
        this.idproveedor = idproveedor;
        this.idpersona = idpersona;
        this.empresa = empresa;
        this.sucursal = sucursal;
        this.descripcionProveedor = descripcionProveedor;
        this.productosInventario = productosInventario;
        this.numeroTelefonico = numeroTelefonico;
        this.longitud = longitud;
        this.latitud = latitud;
    }


    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public String getDescripcionProveedor() {
        return descripcionProveedor;
    }

    public void setDescripcionProveedor(String descripcionProveedor) {
        this.descripcionProveedor = descripcionProveedor;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /*public String getImagen() {
        return Imagen;
    }

    public void setImagen(String imagen) {
        Imagen = imagen;
    }*/

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
