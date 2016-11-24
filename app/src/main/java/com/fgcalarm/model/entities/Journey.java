package com.fgcalarm.model.entities;

import com.fgcalarm.model.entities.base.Entity;

/**
 * Created by Biel on 24/11/2016.
 */

public class Journey extends Entity {
    private Station destination;

    public Journey(Station destination) {
        this.destination = destination;
    }

    public Station getDestination() {
        return destination;
    }

    public void setDestination(Station destination) {
        this.destination = destination;
    }


}
