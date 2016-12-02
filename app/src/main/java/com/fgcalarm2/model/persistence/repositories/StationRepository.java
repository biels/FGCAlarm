package com.fgcalarm2.model.persistence.repositories;

import com.fgcalarm2.model.entities.Station;
import com.fgcalarm2.model.persistence.repositories.types.CrudRepository;

import java.util.List;

/**
 * Created by Biel on 25/11/2016.
 */

public interface StationRepository extends CrudRepository<Station> {
    List<Station> findByLine(Long lineId);
}
