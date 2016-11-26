package com.fgcalarm.model.entities;

import android.support.annotation.NonNull;

import com.fgcalarm.model.entities.base.Entity;

import java.io.Serializable;

/**
 * Created by Biel on 24/11/2016.
 */

public class Journey extends Entity<Long> {
    private Station destination;

    public Journey(@NonNull Long aLong, Station destination) {
        super(aLong);
        this.destination = destination;
    }

    public Station getDestination() {
        return destination;
    }

    public void setDestination(Station destination) {
        this.destination = destination;
    }


}
