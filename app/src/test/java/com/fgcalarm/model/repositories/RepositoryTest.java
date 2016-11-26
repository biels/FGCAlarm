package com.fgcalarm.model.repositories;

import com.fgcalarm.model.entities.base.Entity;
import com.fgcalarm.model.persistence.RepositoryManager;
import com.fgcalarm.model.persistence.repositories.types.Repository;

import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;

import static junit.framework.Assert.fail;

/**
 * Created by Biel on 26/11/2016.
 */

public abstract class RepositoryTest<T extends Repository<E, ID>, E extends Entity<ID>, ID extends Serializable> {
    T repository;
    int seq = 0;
    @Before
    public void setUp() throws Exception {
        repository = getInstanceFromManager();
        if(repository == null)fail("Failed to instantiate repository");
    }
    abstract T getInstanceFromManager();
    abstract E getRandomEntity();
    protected int getNextSequential(){
        return seq++;
    }

}
