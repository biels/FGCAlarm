package com.fgcalarm.model.persistence.repositories.impl.inmemory;

import com.fgcalarm.model.entities.base.Entity;
import com.fgcalarm.model.persistence.repositories.types.CrudRepository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Biel on 26/11/2016.
 */

public abstract class CrudRepositoryInMemoryImpl<T extends Entity<ID>, ID extends Serializable> implements CrudRepository<T, ID> {
    @SuppressWarnings("WeakerAccess")
    protected List<T> collection;

    public CrudRepositoryInMemoryImpl() {
        this.collection = new ArrayList<>();
    }

    @Override
    public <S extends T> S save(S entity) {
        T findResult = findOne(entity.getId());
        if (findResult != null){
            collection.remove(findResult);
        }
        boolean addded = collection.add(entity);
        return (addded ? entity : null);
    }

    @Override
    public T findOne(ID primaryKey) {
        for (T e : collection)
        if (e.getId().equals(primaryKey))return e;
        return null;
    }

    @Override
    public List<T> findAll() {
        return collection;
    }

    @Override
    public Long count() {
        return Long.valueOf(collection.size());
    }

    @Override
    public void delete(T entity) {
        //This will be implemented using ids instead of object references in SQL
        collection.remove(collection.remove(entity));
    }

    @Override
    public boolean exists(ID primaryKey) {
        return false;
    }
}
