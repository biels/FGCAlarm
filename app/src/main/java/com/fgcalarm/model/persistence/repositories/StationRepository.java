package com.fgcalarm.model.persistence.repositories;

import com.fgcalarm.model.entities.Station;
import com.fgcalarm.model.persistence.repositories.types.CrudRepository;

import java.util.List;

/**
 * Created by Biel on 25/11/2016.
 */

public interface StationRepository extends CrudRepository<Station, Long> {
    List<Station> findByLine(String lineId);
}
