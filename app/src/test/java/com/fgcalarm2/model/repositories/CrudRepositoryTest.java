package com.fgcalarm2.model.repositories;

import com.fgcalarm2.model.entities.base.Entity;
import com.fgcalarm2.model.persistence.RepositoryManager;
import com.fgcalarm2.model.persistence.repositories.types.CrudRepository;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static junit.framework.Assert.*;

/**
 * Created by Biel on 26/11/2016.
 */

public abstract class CrudRepositoryTest<T extends CrudRepository<E>, E extends Entity> extends RepositoryTest<T, E> {
    @Override
    E getRandomEntity() {
        List<E> all = repository.findAll();
        Collections.shuffle(all);
        return all.get(0);
    }

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
