package com.fgcalarm.model.apiclient.response;

/**
 * Created by Biel on 14/11/2016.
 */

public class CirculacioResponse {
    int recorregut_id;
    int node_id;
    double latitud;
    double longitud;

    //TODO implement function to retrieve as java.util.Date
    String dia;
    String tempsreal;

    public CirculacioResponse(int recorregut_id, int node_id, double latitud, double longitud, String dia, String tempsreal) {
        this.recorregut_id = recorregut_id;
        this.node_id = node_id;
        this.latitud = latitud;
        this.longitud = longitud;
        this.dia = dia;
        this.tempsreal = tempsreal;
    }

    public int getRecorregut_id() {
        return recorregut_id;
    }

    public void setRecorregut_id(int recorregut_id) {
        this.recorregut_id = recorregut_id;
    }

    public int getNode_id() {
        return node_id;
    }

    public void setNode_id(int node_id) {
        this.node_id = node_id;
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

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getTempsreal() {
        return tempsreal;
    }

    public void setTempsreal(String tempsreal) {
        this.tempsreal = tempsreal;
    }
}
