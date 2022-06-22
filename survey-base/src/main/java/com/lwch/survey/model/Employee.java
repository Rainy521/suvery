package com.lwch.survey.model;

import java.util.Date;

public class Employee {
    private String idCard;

    private String cname;

    private String name;

    private String sex;

    private String zzzslx;

    private String ygzzNo;

    private String expiryTime;

    private Integer status;

    private String email;

    private String files;

    private String phone;

    private Date updateTime;

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getZzzslx() {
        return zzzslx;
    }

    public void setZzzslx(String zzzslx) {
        this.zzzslx = zzzslx;
    }

    public String getYgzzNo() {
        return ygzzNo;
    }

    public void setYgzzNo(String ygzzNo) {
        this.ygzzNo = ygzzNo;
    }

    public String getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(String expiryTime) {
        this.expiryTime = expiryTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files;
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
        sb.append(", idCard=").append(idCard);
        sb.append(", cname=").append(cname);
        sb.append(", name=").append(name);
        sb.append(", sex=").append(sex);
        sb.append(", zzzslx=").append(zzzslx);
        sb.append(", ygzzNo=").append(ygzzNo);
        sb.append(", expiryTime=").append(expiryTime);
        sb.append(", status=").append(status);
        sb.append(", email=").append(email);
        sb.append(", files=").append(files);
        sb.append(", phone=").append(phone);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}