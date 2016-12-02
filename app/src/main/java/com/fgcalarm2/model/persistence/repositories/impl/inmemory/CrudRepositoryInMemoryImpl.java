package com.fgcalarm2.model.persistence.repositories.impl.inmemory;

import com.fgcalarm2.model.entities.base.Entity;
import com.fgcalarm2.model.persistence.repositories.types.CrudRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Biel on 26/11/2016.
 */

public abstract class CrudRepositoryInMemoryImpl<T extends Entity> implements CrudRepository<T> {
    @SuppressWarnings("WeakerAccess")
    protected List<T> collection;
    Long lastAutoincremental = 0L;

    public CrudRepositoryInMemoryImpl() {
        this.collection = new ArrayList<>();
    }

    private Long getNextAutoIncremental(){
        return lastAutoincremental++;
    }
    @Override
    public <S extends T> S save(S entity) {
        Long id = entity.getId();
        if(id == null)id = getNextAutoIncremental();
        entity.setId(id);
        T findResult = findOne(id);
        if (findResult != null){
            collection.remove(findResult);
        }
        boolean addded = collection.add(entity);
        return (addded ? entity : null);
    }

    @Override
    public T findOne(Long primaryKey) {
        for (T e : collection){
            Long id = e.getId();
            if (id.equals(primaryKey))return e;
        }
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
        collection.remove(findOne(entity.getId()));
    }

    @Override
    public boolean exists(Long primaryKey) {
        return false;
    }
}
