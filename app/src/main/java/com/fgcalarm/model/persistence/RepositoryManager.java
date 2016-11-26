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
    private static ImplementationType implementationType = ImplementationType.NONE;
    public enum ImplementationType {NONE, IN_MEMORY, SQL_LITE};

    private RepositoryManager() {
        attatchImplementation(ImplementationType.IN_MEMORY);
    }
    public static void attatchImplementation(ImplementationType implementationType){
        switch (implementationType){
            case IN_MEMORY:
                lineRepository = new LineRepositoryInMemoryImpl();
                break;
            case SQL_LITE:
                lineRepository = new LineRepositorySQLImpl();
                break;
        }
        RepositoryManager.implementationType = implementationType;
    }

    public static ImplementationType getImplementationType() {
        return implementationType;
    }

    public static CirculationRepository getCirculationRepository() {
        throw new NotImplementedException();
        //return circulationRepository;
    }

    public static LineRepository getLineRepository() {
        return lineRepository;
    }

}
