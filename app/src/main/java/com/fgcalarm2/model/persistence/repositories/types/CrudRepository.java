package com.fgcalarm2.model.persistence.repositories.types;

import com.fgcalarm2.model.entities.base.Entity;

import java.util.List;

/**
 * Created by Biel on 24/11/2016.
 */

public interface CrudRepository<T extends Entity> extends Repository<T> {
    <S extends T> S save(S entity);
    T findOne(Long primaryKey);
    List<T> findAll();
    Long count();
    void delete(T entity);
    boolean exists(Long primaryKey);
}
