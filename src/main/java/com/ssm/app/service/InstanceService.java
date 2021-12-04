//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ssm.app.service;

import com.ssm.app.exception.ResourceNotFoundException;
import com.ssm.app.model.Instance;
import com.ssm.app.repository.InstanceRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class InstanceService {
    private InstanceRepository instanceRepository;

    public InstanceService(InstanceRepository instanceRepository) {
        this.instanceRepository = instanceRepository;
    }

    public Instance saveModel(Instance instance) {
        return (Instance)this.instanceRepository.save(instance);
    }

    public List<Instance> getAllModels() {
        List<Instance> instances = this.instanceRepository.findAll();
        List<Instance> newList = new ArrayList();
        int i;
        if (instances.size() > 10) {
            for(i = instances.size() - 1; i > instances.size() - 11; --i) {
                newList.add((Instance)instances.get(i));
            }

            return newList;
        } else {
            for(i = instances.size() - 1; i >= 0; --i) {
                newList.add((Instance)instances.get(i));
            }

            return newList;
        }
    }

    public Instance getModelByInstanceName(String instanceName) {
        List<Instance> instances = this.instanceRepository.findAll();

        for(int i = 0; i < instances.size(); ++i) {
            if (((Instance)instances.get(i)).getInstanceName().equals(instanceName)) {
                return (Instance)instances.get(i);
            }
        }

        throw new ResourceNotFoundException("AppModel", "InstanceName", instanceName);
    }

    public Instance updateModel(Instance instance, String instanceName) {
        try {
            Instance existingInstance = this.getModelByInstanceName(instanceName);
            existingInstance.setCurrentState(instance.getCurrentState());
            this.instanceRepository.save(existingInstance);
            return existingInstance;
        } catch (ResourceNotFoundException var4) {
            throw new ResourceNotFoundException("AppModel", "InstanceName", instanceName);
        }
    }

    public void deleteModel(String instanceName) {
        try {
            Instance instance = this.getModelByInstanceName(instanceName);
            long id = instance.getId();
            this.instanceRepository.deleteById(id);
        } catch (ResourceNotFoundException var5) {
            throw new ResourceNotFoundException("AppModel", "InstanceName", instanceName);
        }
    }
}
