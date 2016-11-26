package com.fgcalarm.model.entities;

import android.graphics.Color;
import android.support.annotation.NonNull;

import com.fgcalarm.model.entities.base.Entity;
import com.fgcalarm.model.persistence.RepositoryManager;

import java.util.List;

/**
 * Created by Biel on 24/11/2016.
 */

public class Line extends Entity<String> {
    private Color color;

    //Lazy links
    private List<Station> stations;

    public Line(@NonNull String s, Color color, List<Station> stations) {
        super(s);
        this.color = color;
        this.stations = stations;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public List<Station> getStations() {
        if(stations == null)stations = RepositoryManager.getStationRepository()
                .findByLine(getId());
        return stations;
    }
}
