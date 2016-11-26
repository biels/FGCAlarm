package com.fgcalarm.model.entities;

import android.support.annotation.NonNull;

import com.fgcalarm.model.entities.base.Entity;
import com.fgcalarm.model.entities.types.Location;
import com.fgcalarm.model.persistence.RepositoryManager;

import java.util.List;

/**
 * Created by Biel on 24/11/2016.
 */

public class Station extends Entity<Long> {
    private String name;
    private Location location;
    private List<Line> lines;

    //Lazy links

    public Station(@NonNull Long aLong, String name, Location location) {
        super(aLong);
        this.name = name;
        this.location = location;
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
