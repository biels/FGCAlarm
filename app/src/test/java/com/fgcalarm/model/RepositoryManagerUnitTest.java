package com.fgcalarm.model;

import com.fgcalarm.model.entities.Circulation;
import com.fgcalarm.model.persistence.RepositoryManager;
import com.fgcalarm.model.persistence.repositories.CirculationRepository;
import com.fgcalarm.model.persistence.repositories.LineRepository;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class RepositoryManagerUnitTest {
    @Before
    public void setUp() throws Exception {
        RepositoryManager.attatchImplementation(RepositoryManager.ImplementationType.IN_MEMORY);
    }

    @Test
    public void getLineRepository() throws Exception {
        LineRepository lineRepository = RepositoryManager.getLineRepository();
        if(lineRepository == null)fail();
        if(lineRepository != RepositoryManager.getLineRepository())fail();
    }

}