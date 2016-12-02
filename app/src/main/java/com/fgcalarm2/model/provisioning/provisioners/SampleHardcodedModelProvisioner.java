package com.fgcalarm2.model.provisioning.provisioners;

import com.fgcalarm2.model.entities.Line;
import com.fgcalarm2.model.entities.Station;
import com.fgcalarm2.model.entities.types.Location;
import com.fgcalarm2.model.provisioning.ModelProvisioner;

import java.util.ArrayList;

/**
 * Created by Biel on 26/11/2016.
 */

public class SampleHardcodedModelProvisioner extends ModelProvisioner {
    @Override
    public void provision() {
        //Lines
        Line l1 = lineRepository.save(new Line(null, "L1",0));
        Line l2 = lineRepository.save(new Line(null, "L2",1));
        Line l3 = lineRepository.save(new Line(null, "L3",2));

        //Stations
        ArrayList<Line> linesE1 = new ArrayList<>();
        linesE1.add(l1);
        linesE1.add(l2);
        Station e1 = stationRepository.save(new Station(null, "AF", new Location(41.345D, 42.443D), linesE1));
        Station e11 = stationRepository.save(new Station(null, "DF", new Location(41.345D, 42.443D), linesE1));

        ArrayList<Line> linesE2 = new ArrayList<>();
        linesE1.add(l2);
        linesE1.add(l3);
        Station e2 = stationRepository.save(new Station(null, "Estació2", new Location(41.345D, 42.443D), linesE2));

        ArrayList<Line> linesE3 = new ArrayList<>();
        linesE1.add(l1);
        Station e3 = stationRepository.save(new Station(null, "Estació3", new Location(41.345D, 42.443D), linesE3));


    }
}
