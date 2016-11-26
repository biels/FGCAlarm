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
import com.fgcalarm.model.provisioning.ProvisioningManager;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Biel on 26/11/2016.
 */

public class LineRepositoryTest extends CrudRepositoryTest<LineRepository, Line> {

    StationRepository stationRepository;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        stationRepository = RepositoryManager.getStationRepository();
        ProvisioningManager.provisionModel(ProvisioningManager.ProvisioningStrategy.SAMPLE_HARDCODED);
    }

    @Override
    LineRepository getInstanceFromManager() {
        return RepositoryManager.getLineRepository();
    }



}
