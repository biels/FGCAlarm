package com.fgcalarm2.model.entities;

import com.fgcalarm2.model.entities.base.Entity;
import com.fgcalarm2.model.entities.types.Location;

import java.util.List;

/**
 * Created by Biel on 24/11/2016.
 */

public class Station extends Entity {
    private String name;
    private Location location;
    private List<Line> lines;

    //Lazy links


    public Station(Long id, String name, Location location, List<Line> lines) {
        super(id);
        this.name = name;
        this.location = location;
        this.lines = lines;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }
}
