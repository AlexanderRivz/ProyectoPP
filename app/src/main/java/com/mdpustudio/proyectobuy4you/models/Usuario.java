package com.mdpustudio.proyectobuy4you.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable {

    private String nombreUsuario;
    private String apellidoUsuario;
    private String username;
    private String password;
    private String email;
    private ArrayList<CarritoCompra> carritoCompras;

    public Usuario(String nombreUsuario, String apellidoUsuario, String username, String password, String email, ArrayList<CarritoCompra> carritoCompras) {
        this.setNombreUsuario(nombreUsuario);
        this.setApellidoUsuario(apellidoUsuario);
        this.setUsername(username);
        this.setPassword(password);
        this.setEmail(email);
        this.setCarritoCompras(carritoCompras);
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<CarritoCompra> getCarritoCompras() {
        return carritoCompras;
    }

    public void setCarritoCompras(ArrayList<CarritoCompra> carritoCompras) {
        this.carritoCompras = carritoCompras;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
