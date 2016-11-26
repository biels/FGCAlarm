package com.fgcalarm.model.provisioning.provisioners;

import android.graphics.Color;

import com.fgcalarm.model.entities.Line;
import com.fgcalarm.model.entities.Station;
import com.fgcalarm.model.entities.types.Location;
import com.fgcalarm.model.persistence.RepositoryManager;
import com.fgcalarm.model.persistence.repositories.LineRepository;
import com.fgcalarm.model.provisioning.ModelProvisioner;

import java.util.ArrayList;

/**
 * Created by Biel on 26/11/2016.
 */

public class HardcodedModelProvisioner extends ModelProvisioner {
    @Override
    public void provision() {
        //Stations
        Station e1 = stationRepository.save(new Station(0L, "Estació1", new Location(41.345D, 42.443D)));

        //Lines
        ArrayList<Station> l1Stations = new ArrayList<>();
        l1Stations.add(e1);
        Line l1 = new Line("L1", new Color(), l1Stations);
        lineRepository.save(l1);
    }
}
