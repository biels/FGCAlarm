package com.fgcalarm2.model.entities;

import com.fgcalarm2.model.ModelTest;
import com.fgcalarm2.model.entities.base.Entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public abstract class EntityTest<E extends Entity> extends ModelTest {
    protected E entity;
    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        entity = getOneFromRepository();
        assertNotNull("Did not get entity from repository", entity);
    }
    abstract E getOneFromRepository();

    @Test
    public void hasId() throws Exception {
        assertNotNull("Entity without ID was saved to database", entity.getId());
    }
}