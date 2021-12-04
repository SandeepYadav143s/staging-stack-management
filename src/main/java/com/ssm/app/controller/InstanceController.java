//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ssm.app.controller;

import com.ssm.app.model.Instance;
import com.ssm.app.service.InstanceService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/instances"})
public class InstanceController {
    private InstanceService instanceService;

    public InstanceController(InstanceService instanceService) {
        this.instanceService = instanceService;
    }

    @PostMapping
    public ResponseEntity<Instance> saveModel(@RequestBody Instance instance) {
        try {
            return new ResponseEntity(this.instanceService.saveModel(instance), HttpStatus.CREATED);
        } catch (RuntimeException var3) {
            return new ResponseEntity(new Instance(), HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping
    public List<Instance> getAllModels() {
        return this.instanceService.getAllModels();
    }

    @GetMapping({"{instanceName}"})
    public ResponseEntity<Instance> getAppModelByInstanceName(@PathVariable("instanceName") String instanceName) {
        return new ResponseEntity(this.instanceService.getModelByInstanceName(instanceName), HttpStatus.OK);
    }

    @PutMapping({"{instanceName}"})
    public ResponseEntity<Instance> updateModel(@PathVariable("instanceName") String instanceName, @RequestBody Instance instance) {
        return new ResponseEntity(this.instanceService.updateModel(instance, instanceName), HttpStatus.OK);
    }

    @DeleteMapping({"{instanceName}"})
    public ResponseEntity<String> deleteModel(@PathVariable("instanceName") String instanceName) {
        this.instanceService.deleteModel(instanceName);
        return new ResponseEntity("Model deleted successfully", HttpStatus.OK);
    }
}
