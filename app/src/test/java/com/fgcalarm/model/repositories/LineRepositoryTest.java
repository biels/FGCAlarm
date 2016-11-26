package com.fgcalarm.model.repositories;

import android.graphics.Color;

import com.fgcalarm.model.entities.Line;
import com.fgcalarm.model.entities.Station;
import com.fgcalarm.model.entities.base.Entity;
import com.fgcalarm.model.persistence.RepositoryManager;
import com.fgcalarm.model.persistence.repositories.LineRepository;
import com.fgcalarm.model.persistence.repositories.types.Repository;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Biel on 26/11/2016.
 */

public class LineRepositoryTest extends CrudRepositoryTest<LineRepository, Line, String> {

    @Override
    LineRepository getInstanceFromManager() {
        return RepositoryManager.getLineRepository();
    }

    @Override
    Line getRandomEntity() {
        return new Line("L" + getNextSequential(), "tag", new Color(), new ArrayList<Station>());
    }
}
