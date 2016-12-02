package com.fgcalarm2.model.entities;

import com.fgcalarm2.model.persistence.RepositoryManager;

import org.junit.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CirculationEntityTest extends EntityTest<Circulation> {

    @Override
    Circulation getOneFromRepository() {
        return RepositoryManager.getCirculationRepository().findAll().get(0);
    }

    @Test
    public void stationsLazyLink() throws Exception {
        assertNotNull(entity.getLine());
    }
}