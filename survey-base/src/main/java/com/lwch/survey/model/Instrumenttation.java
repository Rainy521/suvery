package com.lwch.survey.model;

import java.util.Date;

public class Instrumenttation {
    private String id;

    private String name;

    private String model;

    private String factoryNo;

    private Integer number;

    private String verificationDate;

    private String mechanism;

    private String certificateNo;

    private String invoiceNo;

    private String files;

    private String cognizance;

    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getVerificationDate() {
        return verificationDate;
    }

    public void setVerificationDate(String verificationDate) {
        this.verificationDate = verificationDate;
    }

    public String getMechanism() {
        return mechanism;
    }

    public void setMechanism(String mechanism) {
        this.mechanism = mechanism;
    }

    public String getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files;
    }

    public String getCognizance() {
        return cognizance;
    }

    public void setCognizance(String cognizance) {
        this.cognizance = cognizance;
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
        sb.append(", name=").append(name);
        sb.append(", model=").append(model);
        sb.append(", factoryNo=").append(factoryNo);
        sb.append(", number=").append(number);
        sb.append(", verificationDate=").append(verificationDate);
        sb.append(", mechanism=").append(mechanism);
        sb.append(", certificateNo=").append(certificateNo);
        sb.append(", invoiceNo=").append(invoiceNo);
        sb.append(", files=").append(files);
        sb.append(", cognizance=").append(cognizance);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}