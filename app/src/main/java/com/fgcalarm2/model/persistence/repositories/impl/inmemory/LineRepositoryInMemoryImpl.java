package com.fgcalarm2.model.persistence.repositories.impl.inmemory;

import com.fgcalarm2.model.entities.Line;
import com.fgcalarm2.model.persistence.RepositoryManager;
import com.fgcalarm2.model.persistence.repositories.LineRepository;

import java.util.List;

/**
 * Created by Biel on 26/11/2016.
 */

public class LineRepositoryInMemoryImpl extends CrudRepositoryInMemoryImpl<Line> implements LineRepository {
    @Override
    public List<Line> findByStation(Long stationId) {
        return RepositoryManager.getStationRepository().findOne(stationId).getLines();
    }
}
