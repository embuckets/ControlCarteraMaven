/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.embuckets.controlcarteramaven.dominio;

/**
 *
 * @author emilio
 */
public class Telefono {

    private int id;
    private int aseguradoId;
    private String telefono;

    public Telefono(int aseguradoId, String telefono) {
        this.aseguradoId = aseguradoId;
        this.telefono = telefono;
    }

    public Telefono(String telefono) {
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAseguradoId() {
        return aseguradoId;
    }

    public void setAseguradoId(int aseguradoId) {
        this.aseguradoId = aseguradoId;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
