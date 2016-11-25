package com.fgcalarm.model.persistence.repositories.impl;

import com.fgcalarm.exceptions.NotImplementedException;
import com.fgcalarm.model.entities.Line;
import com.fgcalarm.model.persistence.repositories.LineRepository;

/**
 * Created by Biel on 24/11/2016.
 */

public class LineRepositoryImpl implements LineRepository {
    public LineRepositoryImpl() {
        //throw new NotImplementedException();
    }

    @Override
    public <S extends Line> S save(S entity) {
        return null;
    }

    @Override
    public Line findOne(Long primaryKey) {
        return null;
    }

    @Override
    public Iterable<Line> findAll() {
        return null;
    }

    @Override
    public Long count() {
        return null;
    }

    @Override
    public void delete(Line entity) {

    }

    @Override
    public boolean exists(Long primaryKey) {
        return false;
    }
}
