package com.fgcalarm.model.entities;

import java.util.Date;

/**
 * Created by Biel on 14/11/2016.
 */

public class NodeWaypoint {
    int id;
    Date tempsinici;

    public NodeWaypoint(int id, Date tempsinici) {
        this.id = id;
        this.tempsinici = tempsinici;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTempsinici() {
        return tempsinici;
    }

    public void setTempsinici(Date tempsinici) {
        this.tempsinici = tempsinici;
    }
}
