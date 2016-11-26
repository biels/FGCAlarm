package com.fgcalarm.model.persistence.repositories.impl.inmemory;

import com.fgcalarm.model.entities.Line;
import com.fgcalarm.model.persistence.RepositoryManager;
import com.fgcalarm.model.persistence.repositories.LineRepository;
import com.fgcalarm.model.persistence.repositories.StationRepository;

import java.util.Collection;
import java.util.List;

/**
 * Created by Biel on 26/11/2016.
 */

public class LineRepositoryInMemoryImpl extends CrudRepositoryInMemoryImpl<Line, String> implements LineRepository {
    @Override
    public List<Line> findByStation(Long stationId) {
        return RepositoryManager.getStationRepository().findOne(stationId).getLines();
    }
}
