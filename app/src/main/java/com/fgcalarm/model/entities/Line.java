package com.fgcalarm.model.entities;

import android.graphics.Color;

import com.fgcalarm.model.entities.base.Entity;

import java.util.List;

/**
 * Created by Biel on 24/11/2016.
 */

public class Line extends Entity {
    private String name;
    private String tag;
    private Color color;
    private List<Station> stations;

    public Line(String name, String tag, Color color, List<Station> stations) {
        this.setName(name);
        this.setTag(tag);
        this.setColor(color);
        this.setStations(stations);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }
}
