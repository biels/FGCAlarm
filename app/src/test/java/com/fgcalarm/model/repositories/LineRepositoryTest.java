package com.fgcalarm.model.repositories;

import android.graphics.Color;

import com.fgcalarm.model.entities.Line;
import com.fgcalarm.model.entities.Station;
import com.fgcalarm.model.entities.base.Entity;
import com.fgcalarm.model.entities.types.Location;
import com.fgcalarm.model.persistence.RepositoryManager;
import com.fgcalarm.model.persistence.repositories.LineRepository;
import com.fgcalarm.model.persistence.repositories.StationRepository;
import com.fgcalarm.model.persistence.repositories.types.Repository;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Biel on 26/11/2016.
 */

public class LineRepositoryTest extends CrudRepositoryTest<LineRepository, Line, String> {
    private final int N_STATIONS = 5;
    StationRepository stationRepository;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        stationRepository = RepositoryManager.getStationRepository();
        for (int i = 0; i < N_STATIONS; i++) {
            stationRepository.save(new Station((long) getNextSequential(), "Sation" + getNextSequential(), new Location(getNextSequential() * 10, getNextSequential() * 10)));
        }
    }

    @Override
    LineRepository getInstanceFromManager() {
        return RepositoryManager.getLineRepository();
    }

    @Override
    Line getRandomEntity() {
        Random random = new Random();
        List<Station> stations = new ArrayList<>();
        for (int i = 0; i < random.nextInt(3); i++) {
            Station station = stationRepository.findAll().get(random.nextInt(N_STATIONS - 1));
        }
        return new Line("L" + getNextSequential(), new Color(), stations);
    }

}
