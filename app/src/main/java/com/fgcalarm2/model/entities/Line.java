package com.fgcalarm2.model.entities;

import com.fgcalarm2.model.entities.base.Entity;
import com.fgcalarm2.model.persistence.RepositoryManager;

import java.util.List;

/**
 * Created by Biel on 24/11/2016.
 */

public class Line extends Entity {
    String tag;

    private int icon;

    //Lazy links
    private List<Station> stations;

    public Line(Long id, String tag, int icon) {
        super(id);
        this.tag = tag;
        this.icon = icon;
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

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
