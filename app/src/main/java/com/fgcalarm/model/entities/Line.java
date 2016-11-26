package com.fgcalarm.model.entities;

import android.graphics.Color;
import android.support.annotation.NonNull;

import com.fgcalarm.model.entities.base.Entity;
import com.fgcalarm.model.persistence.RepositoryManager;

import java.util.List;

/**
 * Created by Biel on 24/11/2016.
 */

public class Line extends Entity {
    String tag;
    private Integer color;

    //Lazy links
    private List<Station> stations;

    public Line(Long id, String tag, Integer color) {
        super(id);
        this.tag = tag;
        this.color = color;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public List<Station> getStations() {
        if(stations == null)stations = RepositoryManager.getStationRepository()
                .findByLine(getId());
        return stations;
    }
}
