package com.fgcalarm.model.entities.base;

import android.support.annotation.NonNull;

import java.io.Serializable;

/**
 * Created by Biel on 22/11/2016.
 */

public abstract class Entity<ID extends Serializable> {
    @NonNull
    private ID id;

    public Entity(@NonNull ID id) {
        this.id = id;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }
}
