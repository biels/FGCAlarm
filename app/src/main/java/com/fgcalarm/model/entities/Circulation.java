package com.fgcalarm.model.entities;

import com.fgcalarm.model.entities.base.Entity;

import java.util.Date;
import java.util.List;

/**
 * Created by Biel on 24/11/2016.
 */

public class Circulation extends Entity {
    private List<Date> timetable;

    public Circulation(List<Date> timetable) {
        this.timetable = timetable;
    }
}
