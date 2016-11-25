package com.fgcalarm.model.persistence;

import com.fgcalarm.exceptions.NotImplementedException;
import com.fgcalarm.model.persistence.repositories.CirculationRepository;
import com.fgcalarm.model.persistence.repositories.LineRepository;
import com.fgcalarm.model.persistence.repositories.impl.LineRepositoryImpl;
import com.fgcalarm.model.persistence.repositories.types.Repository;



/**
 * Created by Biel on 22/11/2016.
 */

public class RepositoryManager {
    private static CirculationRepository circulationRepository;
    private static LineRepository lineRepository;
    private RepositoryManager() {
    }

    public static CirculationRepository getCirculationRepository() {
        throw new NotImplementedException();
        //return circulationRepository;
    }

    public static LineRepository getLineRepository() {
        if(lineRepository == null)lineRepository = new LineRepositoryImpl();
        return lineRepository;
    }

}
