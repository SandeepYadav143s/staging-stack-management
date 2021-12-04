//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ssm.app.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
        name = "instances"
)
public class Instance {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;
    private String currentState;
    @Column(
            nullable = false
    )
    private String teamName;
    @Column(
            nullable = false
    )
    private String instanceName;
    private String enggName;
    private Date createdAt;
    private String purpose;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCurrentState() {
        return this.currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    public Instance(long id, String currentState, String teamName, String instanceName, String enggName, Date createdAt, String purpose) {
        this.id = id;
        this.currentState = currentState;
        this.teamName = teamName;
        this.instanceName = instanceName;
        this.enggName = enggName;
        this.createdAt = createdAt;
        this.purpose = purpose;
    }

    public Instance() {
    }

    public String getTeamName() {
        return this.teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getInstanceName() {
        return this.instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public String getEnggName() {
        return this.enggName;
    }

    public void setEnggName(String enggName) {
        this.enggName = enggName;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getPurpose() {
        return this.purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}
