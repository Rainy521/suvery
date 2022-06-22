package com.lwch.survey.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Ownership {
    private String id;

    private String originalLocation;

    private String location;

    private String certificate;

    private String processType;

    private String applicant;

    private Date updateTime;
    
    private String serialNo;
    
    private double areas;
    
    private List<Subject> listSubject = new ArrayList<>();
    
    private List<House> listHouse = new ArrayList<>();
    
    private List<FileTypeApplyMember> listFileType = new ArrayList<>();

    public double getAreas() {
        return areas;
    }

    public void setAreas(double areas) {
        this.areas = areas;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public List<Subject> getListSubject() {
        return listSubject;
    }

    public void setListSubject(List<Subject> listSubject) {
        this.listSubject = listSubject;
    }

    public List<House> getListHouse() {
        return listHouse;
    }

    public void setListHouse(List<House> listHouse) {
        this.listHouse = listHouse;
    }

    public List<FileTypeApplyMember> getListFileType() {
        return listFileType;
    }

    public void setListFileType(List<FileTypeApplyMember> listFileType) {
        this.listFileType = listFileType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOriginalLocation() {
        return originalLocation;
    }

    public void setOriginalLocation(String originalLocation) {
        this.originalLocation = originalLocation;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getProcessType() {
        return processType;
    }

    public void setProcessType(String processType) {
        this.processType = processType;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", originalLocation=").append(originalLocation);
        sb.append(", location=").append(location);
        sb.append(", certificate=").append(certificate);
        sb.append(", processType=").append(processType);
        sb.append(", applicant=").append(applicant);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}