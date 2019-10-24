package com.mdpustudio.proyectobuy4you.models;

import java.io.Serializable;

public class CarritoCompra implements Serializable {

    private Producto itemProducto;
    private int cantidadProductos;
    private double precioProducto;

    public CarritoCompra(Producto itemProducto, int cantidadProductos, double precioProducto) {
        this.setItemProducto(itemProducto);
        this.setCantidadProductos(cantidadProductos);
        this.setPrecioProducto(precioProducto);
    }


    public Producto getItemProducto() {
        return itemProducto;
    }

    public void setItemProducto(Producto itemProducto) {
        this.itemProducto = itemProducto;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }
}
