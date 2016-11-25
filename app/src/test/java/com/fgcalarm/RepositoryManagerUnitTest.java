package com.fgcalarm;

import com.fgcalarm.model.entities.Circulation;
import com.fgcalarm.model.persistence.RepositoryManager;
import com.fgcalarm.model.persistence.repositories.CirculationRepository;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class RepositoryManagerUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void getCircualtions(){
        //Any context
        CirculationRepository circulationRepository = RepositoryManager.getCirculationRepository();
        Iterable<Circulation> circulations = circulationRepository.findAll();

    }
}