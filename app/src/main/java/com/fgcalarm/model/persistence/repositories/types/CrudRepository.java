package com.fgcalarm.model.persistence.repositories.types;

import com.fgcalarm.model.entities.base.Entity;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Biel on 24/11/2016.
 */

public interface CrudRepository<T extends Entity, ID extends Serializable> extends Repository {
    <S extends T> S save(S entity);
    T findOne(ID primaryKey);
    Collection<T> findAll();
    Long count();
    void delete(T entity);
    boolean exists(ID primaryKey);
}
