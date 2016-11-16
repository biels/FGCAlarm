package com.fgcalarm;

import java.util.ArrayList;

/**
 * Created by jordiae on 16/11/16.
 */

public class Linia {
    private int icon;
    private String name;
    private ArrayList<Estacio> estacions;

    Linia(int icon, String name, ArrayList<Estacio> estacions){
        this.icon = icon;
        this.name = name;
        this.estacions = estacions;

    }
    Linia(){

    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public ArrayList<Estacio> getEstacions() {
        return estacions;
    }

    public void setEstacions(ArrayList<Estacio> estacions) {
        this.estacions = estacions;
    }
}
