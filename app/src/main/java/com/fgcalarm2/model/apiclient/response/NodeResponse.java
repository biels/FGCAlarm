package com.fgcalarm2.model.apiclient.response;

/**
 * Created by Biel on 14/11/2016.
 */

//TODO Turn into JPA entity to store int SQLLite
public class NodeResponse {
    private int id;
    private String nom;
    private double latitud;
    private double longitud;
    private boolean estacio;

    public NodeResponse(int id, String nom, double latitud, double longitud, boolean estacio) {
        this.setId(id);
        this.setNom(nom);
        this.setLatitud(latitud);
        this.setLongitud(longitud);
        this.setEstacio(estacio);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public boolean isEstacio() {
        return estacio;
    }

    public void setEstacio(boolean estacio) {
        this.estacio = estacio;
    }
}
