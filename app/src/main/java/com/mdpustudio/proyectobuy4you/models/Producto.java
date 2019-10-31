package com.mdpustudio.proyectobuy4you.models;

import java.io.Serializable;

public class Producto implements Serializable {

    private String nombreProducto;
    private String descripcion;
    //List<UnidadMedida> unidadMedida;
    private int cantidadInventario;
    private Categoria categoriaProducto;
    private double precioBase;

    public Producto(String nombreProducto, String descripcion, int cantidadInventario, Categoria categoriaProducto, double precioBase) {
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.cantidadInventario = cantidadInventario;
        this.categoriaProducto = categoriaProducto;
        this.precioBase = precioBase;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Categoria getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(Categoria categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidadInventario() {
        return cantidadInventario;
    }

    public void setCantidadInventario(int cantidadInventario) {
        this.cantidadInventario = cantidadInventario;
    }
}
