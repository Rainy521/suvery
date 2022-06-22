package com.lwch.survey.model;

import java.util.Date;

public class CompanyHistory {
    private String id;

    private String companyOld;

    private String companyNew;

    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyOld() {
        return companyOld;
    }

    public void setCompanyOld(String companyOld) {
        this.companyOld = companyOld;
    }

    public String getCompanyNew() {
        return companyNew;
    }

    public void setCompanyNew(String companyNew) {
        this.companyNew = companyNew;
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
        sb.append(", companyOld=").append(companyOld);
        sb.append(", companyNew=").append(companyNew);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}