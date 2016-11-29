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

    //Lazy links
    private List<Station> stations;

    public Line(Long id, String tag) {
        super(id);
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public List<Station> getStations() {
        if(stations == null)stations = RepositoryManager.getStationRepository()
                .findByLine(getId());
        return stations;
    }
}
