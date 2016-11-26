package com.fgcalarm.model.provisioning.provisioners;

import android.graphics.Color;

import com.fgcalarm.model.entities.Line;
import com.fgcalarm.model.entities.Station;
import com.fgcalarm.model.entities.types.Location;
import com.fgcalarm.model.provisioning.ModelProvisioner;

import java.util.ArrayList;

/**
 * Created by Biel on 26/11/2016.
 */

public class SampleHardcodedModelProvisioner extends ModelProvisioner {
    @Override
    public void provision() {
        //Lines
        Line l1 = lineRepository.save(new Line(null, "L1", Color.RED));
        Line l2 = lineRepository.save(new Line(null, "L2", Color.CYAN));
        Line l3 = lineRepository.save(new Line(null, "L3", Color.GREEN));

        //Stations
        ArrayList<Line> linesE1 = new ArrayList<>();
        linesE1.add(l1);
        linesE1.add(l2);
        Station e1 = stationRepository.save(new Station(null, "Estació1", new Location(41.345D, 42.443D), linesE1));

        ArrayList<Line> linesE2 = new ArrayList<>();
        linesE1.add(l2);
        linesE1.add(l3);
        Station e2 = stationRepository.save(new Station(null, "Estació2", new Location(41.345D, 42.443D), linesE2));

        ArrayList<Line> linesE3 = new ArrayList<>();
        linesE1.add(l1);
        Station e3 = stationRepository.save(new Station(null, "Estació3", new Location(41.345D, 42.443D), linesE3));


    }
}
