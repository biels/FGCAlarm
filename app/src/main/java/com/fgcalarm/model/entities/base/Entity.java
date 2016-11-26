package com.fgcalarm.model.entities.base;

import android.support.annotation.NonNull;

import java.io.Serializable;

/**
 * Created by Biel on 22/11/2016.
 */

public abstract class Entity {

    private Long id;

    public Entity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
