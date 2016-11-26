package com.fgcalarm.model.persistence.repositories;

import com.fgcalarm.model.entities.Line;
import com.fgcalarm.model.persistence.repositories.types.CrudRepository;

import java.util.List;

/**
 * Created by Biel on 24/11/2016.
 */

public interface LineRepository extends CrudRepository<Line> {
    List<Line> findByStation(Long stationId);
}
