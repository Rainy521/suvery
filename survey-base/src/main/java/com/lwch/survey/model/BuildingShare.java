package com.lwch.survey.model;

import java.util.Date;

public class BuildingShare {
    private String id;
    
    private String cname;

    private String gybwmc;

    private String ssgnq;

    private Double gymj;

    private Date updateTime;
    
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGybwmc() {
        return gybwmc;
    }

    public void setGybwmc(String gybwmc) {
        this.gybwmc = gybwmc;
    }

    public String getSsgnq() {
        return ssgnq;
    }

    public void setSsgnq(String ssgnq) {
        this.ssgnq = ssgnq;
    }

    public Double getGymj() {
        return gymj;
    }

    public void setGymj(Double gymj) {
        this.gymj = gymj;
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
        sb.append(", gybwmc=").append(gybwmc);
        sb.append(", ssgnq=").append(ssgnq);
        sb.append(", gymj=").append(gymj);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}