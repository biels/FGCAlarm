package com.fgcalarm.model.persistence.repositories.impl.sqlite;

import com.fgcalarm.exceptions.NotImplementedException;
import com.fgcalarm.model.entities.Line;
import com.fgcalarm.model.persistence.repositories.LineRepository;

import java.util.Collection;

/**
 * Created by Biel on 24/11/2016.
 */

public class LineRepositorySQLImpl implements LineRepository {
    public LineRepositorySQLImpl() {
        //throw new NotImplementedException();
    }


    @Override
    public <S extends Line> S save(S entity) {
        return null;
    }

    @Override
    public Line findOne(String primaryKey) {
        return null;
    }

    @Override
    public Collection<Line> findAll() {
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
    public boolean exists(String primaryKey) {
        return false;
    }
}
