package com.fgcalarm.model.apiclient.response;

import java.util.Date;
import java.util.List;

/**
 * Created by Biel on 14/11/2016.
 */
//TODO Turn into JPA entity to store route while on the train
public class RecorregutResponse {
    int id;
    Date tempsinici;
    List<NodeWaypointResponse> nodes;

    public RecorregutResponse(int id, Date tempsinici, List<NodeWaypointResponse> nodes) {
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

    public List<NodeWaypointResponse> getNodes() {
        return nodes;
    }

    public void setNodes(List<NodeWaypointResponse> nodes) {
        this.nodes = nodes;
    }
}
