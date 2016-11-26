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
    private Line line;

    public Circulation(@NonNull Long aLong, List<Date> timetable, Line line) {
        super(aLong);
        this.timetable = timetable;
        this.line = line;
    }

    public List<Date> getTimetable() {
        return timetable;
    }

    public void setTimetable(List<Date> timetable) {
        this.timetable = timetable;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }
}
