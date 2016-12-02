package com.fgcalarm2.model.repositories;

import com.fgcalarm2.model.entities.Line;
import com.fgcalarm2.model.persistence.RepositoryManager;
import com.fgcalarm2.model.persistence.repositories.LineRepository;
import com.fgcalarm2.model.persistence.repositories.StationRepository;
import com.fgcalarm2.model.provisioning.ProvisioningManager;

import org.junit.Before;

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
