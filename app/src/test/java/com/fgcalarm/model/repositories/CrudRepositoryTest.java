package com.fgcalarm.model.repositories;

import com.fgcalarm.model.entities.base.Entity;
import com.fgcalarm.model.persistence.RepositoryManager;
import com.fgcalarm.model.persistence.repositories.types.CrudRepository;
import com.fgcalarm.model.persistence.repositories.types.Repository;

import org.junit.Assert;
import org.junit.Test;

import java.io.Serializable;

import static junit.framework.Assert.*;

/**
 * Created by Biel on 26/11/2016.
 */

public abstract class CrudRepositoryTest<T extends CrudRepository<E, ID>, E extends Entity<ID>, ID extends Serializable> extends RepositoryTest<T, E, ID> {
    @Test
    public void save() throws Exception {
        E e1 = getRandomEntity();
        E saved = repository.save(e1);
        if(RepositoryManager.getImplementationType() == RepositoryManager.ImplementationType.SQL_LITE)assertNotSame(e1, saved);
            assertNotNull(saved);
        try {
            repository.save(e1);
            //fail("Saved two items with same primary key without throwing an exception");
        } catch (Exception e) {

        }
    }

    @Test
    public void findOne() throws Exception {
        E e1 = getRandomEntity();
        E saved = repository.save(e1);
        repository.findOne(saved.getId());

    }

    @Test
    public void delete() throws Exception {
        E saved = repository.save(getRandomEntity());
        repository.delete(saved);
        assertNull(repository.findOne(saved.getId()));
    }

    protected void fillRandomly(int n){
        for (int i = 0; i < n; i++) {
            repository.save(getRandomEntity());
        }
    }

}
