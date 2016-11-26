package com.fgcalarm.model.provisioning;

import com.fgcalarm.exceptions.NotImplementedException;
import com.fgcalarm.model.provisioning.provisioners.HardcodedModelProvisioner;

/**
 * Created by Biel on 26/11/2016.
 */

public class ProvisioningManager {
    public enum ProvisioningStrategy{HARDCODED};
    public static void provisionModel(ProvisioningStrategy strategy){
        getProvisionerInstance(strategy).provision();
    }
    private static ModelProvisioner getProvisionerInstance(ProvisioningStrategy strategy){
        switch (strategy){
            case HARDCODED:
                return new HardcodedModelProvisioner();
        }
        throw new NotImplementedException("Strategy " + strategy.name() + " is not registered as an implemented provisioning strategy.");
    }
}
