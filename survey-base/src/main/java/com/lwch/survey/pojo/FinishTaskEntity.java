package com.lwch.survey.pojo;

import java.io.Serializable;
import java.util.Date;

public class FinishTaskEntity implements Serializable{
    private static final long serialVersionUID = 3745591499444903649L;

    private String id;
    private Date startTime;
    private Date endTime;
    private String username;
    private String businessKey;
    private String bsname;
    private String deploymentId;
    private String processDefinitionId;
    private String processDefinitionKey;
    private String name;
    private String applyName;
    private String applyId;
    private String formKey;
    private String score;
    
    public String getScore() {
        return score;
    }
    public void setScore(String score) {
        this.score = score;
    }
    public String getFormKey() {
        return formKey;
    }
    public void setFormKey(String formKey) {
        this.formKey = formKey;
    }
    public String getApplyName() {
        return applyName;
    }
    public void setApplyName(String applyName) {
        this.applyName = applyName;
    }
    public String getApplyId() {
        return applyId;
    }
    public void setApplyId(String applyId) {
        this.applyId = applyId;
    }
    public String getBsname() {
        return bsname;
    }
    public void setBsname(String bsname) {
        this.bsname = bsname;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Date getStartTime() {
        return startTime;
    }
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    public Date getEndTime() {
        return endTime;
    }
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getBusinessKey() {
        return businessKey;
    }
    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }
    public String getDeploymentId() {
        return deploymentId;
    }
    public void setDeploymentId(String deploymentId) {
        this.deploymentId = deploymentId;
    }
    public String getProcessDefinitionId() {
        return processDefinitionId;
    }
    public void setProcessDefinitionId(String processDefinitionId) {
        this.processDefinitionId = processDefinitionId;
    }
    public String getProcessDefinitionKey() {
        return processDefinitionKey;
    }
    public void setProcessDefinitionKey(String processDefinitionKey) {
        this.processDefinitionKey = processDefinitionKey;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    
}
