package com.fgcalarm.model.provisioning;

import com.fgcalarm.model.persistence.RepositoryManager;
import com.fgcalarm.model.persistence.repositories.CirculationRepository;
import com.fgcalarm.model.persistence.repositories.JourneyRepository;
import com.fgcalarm.model.persistence.repositories.LineRepository;
import com.fgcalarm.model.persistence.repositories.StationRepository;

/**
 * Created by Biel on 26/11/2016.
 */

public abstract class ModelProvisioner {
    protected CirculationRepository circulationRepository = RepositoryManager.getCirculationRepository();
    protected JourneyRepository journeyRepository = RepositoryManager.getJourneyRepository();
    protected LineRepository lineRepository = RepositoryManager.getLineRepository();
    protected StationRepository stationRepository = RepositoryManager.getStationRepository();

    public abstract void provision();
}
