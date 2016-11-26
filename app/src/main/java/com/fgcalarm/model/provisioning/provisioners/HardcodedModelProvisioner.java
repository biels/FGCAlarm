package com.fgcalarm.model.provisioning.provisioners;

import android.graphics.Color;

import com.fgcalarm.model.entities.Line;
import com.fgcalarm.model.entities.Station;
import com.fgcalarm.model.persistence.RepositoryManager;
import com.fgcalarm.model.persistence.repositories.LineRepository;
import com.fgcalarm.model.provisioning.ModelProvisioner;

import java.util.ArrayList;

/**
 * Created by Biel on 26/11/2016.
 */

public class HardcodedModelProvisioner extends ModelProvisioner {
    @Override
    void provision() {

        //
        Line l1 = new Line("L1", new Color(), new ArrayList<Station>());
        lineRepository.save(l1);
    }
}
