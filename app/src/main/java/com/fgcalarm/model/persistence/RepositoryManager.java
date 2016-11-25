package com.fgcalarm.model.persistence;

import com.fgcalarm.model.persistence.repositories.LineRepository;
import com.fgcalarm.model.persistence.repositories.impl.LineRepositoryImpl;
import com.fgcalarm.model.persistence.repositories.types.Repository;

/**
 * Created by Biel on 22/11/2016.
 */

public class RepositoryManager {
    private static LineRepository lineRepository;

    private RepositoryManager() {
    }

    public static LineRepository getLineRepository() {
        if(lineRepository == null)lineRepository = new LineRepositoryImpl();
        return lineRepository;
    }
}
