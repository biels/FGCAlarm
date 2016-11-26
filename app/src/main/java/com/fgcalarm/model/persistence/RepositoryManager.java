package com.fgcalarm.model.persistence;

import com.fgcalarm.exceptions.NotImplementedException;
import com.fgcalarm.model.persistence.repositories.CirculationRepository;
import com.fgcalarm.model.persistence.repositories.LineRepository;
import com.fgcalarm.model.persistence.repositories.impl.inmemory.LineRepositoryInMemoryImpl;
import com.fgcalarm.model.persistence.repositories.impl.sqlite.LineRepositorySQLImpl;


/**
 * Created by Biel on 22/11/2016.
 */

public class RepositoryManager {
    private static CirculationRepository circulationRepository;
    private static LineRepository lineRepository;
    private static Implementation implementation = Implementation.NONE;
    public enum Implementation{NONE, IN_MEMORY, SQL_LITE};

    private RepositoryManager() {
        attatchImplementation(Implementation.IN_MEMORY);
    }
    public static void attatchImplementation(Implementation implementation){
        switch (implementation){
            case IN_MEMORY:
                lineRepository = new LineRepositoryInMemoryImpl();
                break;
            case SQL_LITE:
                lineRepository = new LineRepositorySQLImpl();
                break;
        }
        RepositoryManager.implementation = implementation;
    }

    public static Implementation getImplementation() {
        return implementation;
    }

    public static CirculationRepository getCirculationRepository() {
        throw new NotImplementedException();
        //return circulationRepository;
    }

    public static LineRepository getLineRepository() {
        return lineRepository;
    }

}
