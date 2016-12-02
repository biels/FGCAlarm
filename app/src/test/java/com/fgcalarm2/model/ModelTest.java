package com.fgcalarm2.model;

import com.fgcalarm2.model.persistence.RepositoryManager;
import com.fgcalarm2.model.provisioning.ProvisioningManager;

import org.junit.Before;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public abstract class ModelTest {
    @Before
    public void setUp() throws Exception {
        RepositoryManager.attatchImplementation(RepositoryManager.ImplementationType.IN_MEMORY);
        ProvisioningManager.provisionModel(ProvisioningManager.ProvisioningStrategy.SAMPLE_HARDCODED);
    }
}