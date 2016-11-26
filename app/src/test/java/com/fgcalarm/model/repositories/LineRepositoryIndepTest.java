package com.fgcalarm.model.repositories;

import android.graphics.Color;

import com.fgcalarm.model.entities.Line;
import com.fgcalarm.model.entities.Station;
import com.fgcalarm.model.persistence.RepositoryManager;
import com.fgcalarm.model.persistence.repositories.LineRepository;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class LineRepositoryIndepTest {
    LineRepository lineRepository;
    @Before
    public void setUp() throws Exception {
        lineRepository = RepositoryManager.getLineRepository();
        if(lineRepository == null)fail();
    }
    Line generateLine(){
        return new Line("L1", new Color(), new ArrayList<Station>());
    }

    @Test
    public void save() throws Exception {
        lineRepository.save(generateLine());
        assertNotEquals(lineRepository.findAll().size(), 0);
    }

    @Test
    public void findByName() throws Exception {

    }
}