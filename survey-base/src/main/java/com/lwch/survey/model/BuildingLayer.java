package com.lwch.survey.model;

import java.util.Date;

public class BuildingLayer {
    private String id;

    private String buildId;

    private String cm;

    private Double cjzmj;

    private Double ctnmj;

    private Double cytmj;

    private Double cgymj;

    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBuildId() {
        return buildId;
    }

    public void setBuildId(String buildId) {
        this.buildId = buildId;
    }

    public String getCm() {
        return cm;
    }

    public void setCm(String cm) {
        this.cm = cm;
    }

    public Double getCjzmj() {
        return cjzmj;
    }

    public void setCjzmj(Double cjzmj) {
        this.cjzmj = cjzmj;
    }

    public Double getCtnmj() {
        return ctnmj;
    }

    public void setCtnmj(Double ctnmj) {
        this.ctnmj = ctnmj;
    }

    public Double getCytmj() {
        return cytmj;
    }

    public void setCytmj(Double cytmj) {
        this.cytmj = cytmj;
    }

    public Double getCgymj() {
        return cgymj;
    }

    public void setCgymj(Double cgymj) {
        this.cgymj = cgymj;
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
        sb.append(", buildId=").append(buildId);
        sb.append(", cm=").append(cm);
        sb.append(", cjzmj=").append(cjzmj);
        sb.append(", ctnmj=").append(ctnmj);
        sb.append(", cytmj=").append(cytmj);
        sb.append(", cgymj=").append(cgymj);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}