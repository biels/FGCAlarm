package com.fgcalarm.model.entities;

import com.fgcalarm.model.persistence.RepositoryManager;

import org.junit.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class SationEntityTest extends EntityTest<Station> {

    @Override
    Station getOneFromRepository() {
        return RepositoryManager.getStationRepository().findAll().get(0);
    }

    @Test
    public void lines() throws Exception {
        assertNotNull(entity.getLines());
        assertNotNull(entity.getLocation()); //Must be provided and refilled from database
        assertNotEquals(entity.getLines().size(), 0); //All lines are at least part of 1 line
    }
}