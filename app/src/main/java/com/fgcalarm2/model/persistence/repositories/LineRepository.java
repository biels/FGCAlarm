package com.fgcalarm2.model.persistence.repositories;

import com.fgcalarm2.model.entities.Line;
import com.fgcalarm2.model.persistence.repositories.types.CrudRepository;

import java.util.List;

/**
 * Created by Biel on 24/11/2016.
 */

public interface LineRepository extends CrudRepository<Line> {
    List<Line> findByStation(Long stationId);
}
