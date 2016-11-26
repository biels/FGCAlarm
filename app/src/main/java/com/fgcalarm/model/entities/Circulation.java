package com.fgcalarm.model.entities;

import android.support.annotation.NonNull;

import com.fgcalarm.model.entities.base.Entity;

import java.util.Date;
import java.util.List;

/**
 * Created by Biel on 24/11/2016.
 */

public class Circulation extends Entity<Long> {
    private List<Date> timetable;

    public Circulation(@NonNull Long aLong, List<Date> timetable) {
        super(aLong);
        this.timetable = timetable;
    }

    public List<Date> getTimetable() {
        return timetable;
    }

    public void setTimetable(List<Date> timetable) {
        this.timetable = timetable;
    }
}
