package com.fgcalarm2.model.entities;

import android.support.annotation.NonNull;

import com.fgcalarm2.model.entities.base.Entity;

/**
 * Created by Biel on 24/11/2016.
 */

public class Journey extends Entity {
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
