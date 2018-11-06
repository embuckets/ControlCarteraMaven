/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.embuckets.controlcarteramaven.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author emilio
 */
public class Asegurado {

    private int id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private List<Telefono> telefonos;
    private List<Email> emails;
    private String rfc;
    private Domicilio domicilio;
    private LocalDate nacimiento;
    private List<Poliza> polizas;
    //TODO: private File[] documentos ? se pone aqui o solo en la base de datos

    public Asegurado(String nombre, String apellidoPaterno, String apellidoMaterno) {

        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        telefonos = new ArrayList<>();
        emails = new ArrayList<>();
        polizas = new ArrayList<>();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Asegurado other = (Asegurado) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellidoPaterno, other.apellidoPaterno)) {
            return false;
        }
        if (!Objects.equals(this.apellidoMaterno, other.apellidoMaterno)) {
            return false;
        }
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public List<Telefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public LocalDate getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento;
    }

    public List<Poliza> getPolizas() {
        return polizas;
    }

    public void setPolizas(List<Poliza> polizas) {
        this.polizas = polizas;
    }

    public void agregarTelefono(Telefono telefono) {
        telefonos.add(telefono);
    }

    public void agregarEmail(Email email) {
        emails.add(email);
    }

    public void agregarPoliza(Poliza poliza) {
        polizas.add(poliza);
    }

}
