package com.fgcalarm2.model.persistence;

import com.fgcalarm2.model.persistence.repositories.CirculationRepository;
import com.fgcalarm2.model.persistence.repositories.JourneyRepository;
import com.fgcalarm2.model.persistence.repositories.LineRepository;
import com.fgcalarm2.model.persistence.repositories.StationRepository;
import com.fgcalarm2.model.persistence.repositories.impl.inmemory.CirculationRepositoryInMemoryImpl;
import com.fgcalarm2.model.persistence.repositories.impl.inmemory.JourneyRepositoryInMemeoryImpl;
import com.fgcalarm2.model.persistence.repositories.impl.inmemory.LineRepositoryInMemoryImpl;
import com.fgcalarm2.model.persistence.repositories.impl.inmemory.StationRepositoryInMemoryImpl;


/**
 * Created by Biel on 22/11/2016.
 */

public class RepositoryManager {
    private static CirculationRepository circulationRepository;
    private static JourneyRepository journeyRepository;
    private static LineRepository lineRepository;
    private static StationRepository stationRepository;

    private static ImplementationType implementationType = ImplementationType.NONE;
    public enum ImplementationType {NONE, IN_MEMORY, SQL_LITE};

    private RepositoryManager() {
        attatchImplementation(ImplementationType.IN_MEMORY);
    }
    public static void attatchImplementation(ImplementationType implementationType){
        switch (implementationType){
            case IN_MEMORY:
                circulationRepository = new CirculationRepositoryInMemoryImpl();
                journeyRepository = new JourneyRepositoryInMemeoryImpl();
                lineRepository = new LineRepositoryInMemoryImpl();
                stationRepository = new StationRepositoryInMemoryImpl();
                break;
            case SQL_LITE:
                //lineRepository = new LineRepositorySQLImpl();
                break;
        }
        RepositoryManager.implementationType = implementationType;
    }

    public static ImplementationType getImplementationType() {
        return implementationType;
    }

    public static CirculationRepository getCirculationRepository() {
        return circulationRepository;
    }

    public static JourneyRepository getJourneyRepository() {
        return journeyRepository;
    }

    public static LineRepository getLineRepository() {
        return lineRepository;
    }

    public static StationRepository getStationRepository() {
        return stationRepository;
    }
}
