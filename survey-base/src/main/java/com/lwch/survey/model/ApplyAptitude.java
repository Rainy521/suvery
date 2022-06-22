package com.lwch.survey.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApplyAptitude {
    private String id;

    private String cname;

    private String phone;

    private String contacts;

    private String aptitude;

    private String expiryTime;

    private String qyyyzhNo;

    private String qyzycs;

    private String qyzzNo;

    private String files;

    private Integer status;

    private Integer applyStatus;

    private Date updateTime;
    
    private List<ApplyEmployee> listEmployee = new ArrayList<>();
    
    private List<ApplyInstrument> instruments = new ArrayList<>();
    
    private List<FileTypeApplyMember> listFileType = new ArrayList<>();

    public List<ApplyEmployee> getListEmployee() {
        return listEmployee;
    }

    public void setListEmployee(List<ApplyEmployee> listEmployee) {
        this.listEmployee = listEmployee;
    }

    public List<ApplyInstrument> getInstruments() {
        return instruments;
    }

    public void setInstruments(List<ApplyInstrument> instruments) {
        this.instruments = instruments;
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

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getAptitude() {
        return aptitude;
    }

    public void setAptitude(String aptitude) {
        this.aptitude = aptitude;
    }

    public String getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(String expiryTime) {
        this.expiryTime = expiryTime;
    }

    public String getQyyyzhNo() {
        return qyyyzhNo;
    }

    public void setQyyyzhNo(String qyyyzhNo) {
        this.qyyyzhNo = qyyyzhNo;
    }

    public String getQyzycs() {
        return qyzycs;
    }

    public void setQyzycs(String qyzycs) {
        this.qyzycs = qyzycs;
    }

    public String getQyzzNo() {
        return qyzzNo;
    }

    public void setQyzzNo(String qyzzNo) {
        this.qyzzNo = qyzzNo;
    }

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(Integer applyStatus) {
        this.applyStatus = applyStatus;
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
        sb.append(", cname=").append(cname);
        sb.append(", phone=").append(phone);
        sb.append(", contacts=").append(contacts);
        sb.append(", aptitude=").append(aptitude);
        sb.append(", expiryTime=").append(expiryTime);
        sb.append(", qyyyzhNo=").append(qyyyzhNo);
        sb.append(", qyzycs=").append(qyzycs);
        sb.append(", qyzzNo=").append(qyzzNo);
        sb.append(", files=").append(files);
        sb.append(", status=").append(status);
        sb.append(", applyStatus=").append(applyStatus);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}