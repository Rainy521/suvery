package com.lwch.survey.model;

import java.util.Date;

public class Subject {
    private String id;

    private String mold;

    private String name;

    private String certificateMold;

    private String certificate;

    private String phone;

    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMold() {
        return mold;
    }

    public void setMold(String mold) {
        this.mold = mold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCertificateMold() {
        return certificateMold;
    }

    public void setCertificateMold(String certificateMold) {
        this.certificateMold = certificateMold;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
        sb.append(", mold=").append(mold);
        sb.append(", name=").append(name);
        sb.append(", certificateMold=").append(certificateMold);
        sb.append(", certificate=").append(certificate);
        sb.append(", phone=").append(phone);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}