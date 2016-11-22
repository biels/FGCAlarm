package com.fgcalarm.model.entities;

import java.util.Date;
import java.util.List;

/**
 * Created by Biel on 14/11/2016.
 */
//TODO Turn into JPA entity to store route while on the train
public class Recorregut {
    int id;
    Date tempsinici;
    List<NodeWaypoint> nodes;

    public Recorregut(int id, Date tempsinici, List<NodeWaypoint> nodes) {
        this.id = id;
        this.tempsinici = tempsinici;
        this.nodes = nodes;
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

    public List<NodeWaypoint> getNodes() {
        return nodes;
    }

    public void setNodes(List<NodeWaypoint> nodes) {
        this.nodes = nodes;
    }
}
