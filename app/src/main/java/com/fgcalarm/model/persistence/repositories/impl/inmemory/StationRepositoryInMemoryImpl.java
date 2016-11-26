package com.fgcalarm.model.persistence.repositories.impl.inmemory;

import com.fgcalarm.model.entities.Line;
import com.fgcalarm.model.entities.Station;
import com.fgcalarm.model.persistence.repositories.StationRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Biel on 26/11/2016.
 */

public class StationRepositoryInMemoryImpl extends CrudRepositoryInMemoryImpl<Station> implements StationRepository {
    @Override
    public List<Station> findByLine(Long lineId) {
        List<Station> r = new ArrayList<>();
        for (Station s : findAll()) {
            boolean found = false;
            for(Line l : s.getLines()){
                if(l.getId() == lineId){
                    found = true;
                    break;
                }
            }
            if(found)r.add(s);
        }
        return r;
    }
}
