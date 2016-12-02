package com.fgcalarm2.model.repositories;

import com.fgcalarm2.model.entities.base.Entity;
import com.fgcalarm2.model.persistence.RepositoryManager;
import com.fgcalarm2.model.persistence.repositories.types.Repository;

import org.junit.Before;

import static junit.framework.Assert.fail;

/**
 * Created by Biel on 26/11/2016.
 */
public abstract class RepositoryTest<T extends Repository<E>, E extends Entity> {
    T repository;
    int seq = 0;
    @Before
    public void setUp() throws Exception {
        RepositoryManager.attatchImplementation(RepositoryManager.ImplementationType.IN_MEMORY);
        repository = getInstanceFromManager();
        if(repository == null)fail("Failed to instantiate repository");
    }
    abstract T getInstanceFromManager();
    abstract E getRandomEntity();
    protected int getNextSequential(){
        return seq++;
    }

}
