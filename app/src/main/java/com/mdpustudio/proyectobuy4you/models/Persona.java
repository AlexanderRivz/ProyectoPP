package com.mdpustudio.proyectobuy4you.models;

import java.io.Serializable;

public class Persona implements Serializable {

    private int idpersona;
    private String username;
    private String password;
    private TipoUsuario tipoUsuario;
    private String email;

    public Persona(int idpersona, String username, String password, TipoUsuario tipoUsuario, String email) {
        this.idpersona = idpersona;
        this.username = username;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
        this.email = email;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
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

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

