package com.fgcalarm.model.repositories;

import com.fgcalarm.model.persistence.RepositoryManager;
import com.fgcalarm.model.persistence.repositories.types.Repository;

import org.junit.Before;

import static junit.framework.Assert.fail;

/**
 * Created by Biel on 26/11/2016.
 */

public abstract class RepositoryTest<T extends Repository> {
    Repository repository;

    @Before
    public void setUp() throws Exception {
        repository = getInstanceFromManager();
        if(repository == null)fail("Failed to instantiate repository");
    }
    abstract T getInstanceFromManager();
}
