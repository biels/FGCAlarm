package com.fgcalarm.model.entities;

import android.graphics.Color;
import android.support.annotation.NonNull;

import com.fgcalarm.model.entities.base.Entity;

import java.util.List;

/**
 * Created by Biel on 24/11/2016.
 */

public class Line extends Entity<String> {
    private String name;
    private Color color;
    private List<Station> stations;

    public Line(@NonNull String id, String name, Color color, List<Station> stations) {
        super(id);
        this.name = name;
        this.color = color;
        this.stations = stations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
