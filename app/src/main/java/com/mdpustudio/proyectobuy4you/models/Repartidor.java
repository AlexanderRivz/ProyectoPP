package com.mdpustudio.proyectobuy4you.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Repartidor implements Serializable {

    private int idRepartidor;
    private int idPersona;
    private String nombre;
    private String apellido;
    private ArrayList<PeticionEntrega> pedidos;
    private String numeroContacto;
    private boolean disponible;

    public Repartidor(int idRepartidor, int idPersona, String nombre, String apellido, ArrayList<PeticionEntrega> pedidos, String numeroContacto, boolean disponible) {
        this.idRepartidor = idRepartidor;
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.pedidos = pedidos;
        this.numeroContacto = numeroContacto;
        this.disponible = disponible;
    }

    public int getIdRepartidor() {
        return idRepartidor;
    }

    public void setIdRepartidor(int idRepartidor) {
        this.idRepartidor = idRepartidor;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumeroContacto() {
        return numeroContacto;
    }

    public void setNumeroContacto(String numeroContacto) {
        this.numeroContacto = numeroContacto;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public ArrayList<PeticionEntrega> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<PeticionEntrega> pedidos) {
        this.pedidos = pedidos;
    }
}
