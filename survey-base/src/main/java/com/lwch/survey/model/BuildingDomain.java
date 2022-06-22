package com.lwch.survey.model;

import java.util.Date;

public class BuildingDomain {
    private String id;

    private String buildId;

    private String gnqh;

    private String gnqlb;

    private String gnqmc;

    private Double ftxs;

    private Double jzmj;

    private Double tnmj;

    private Double ftmj;

    private Integer ts;

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

    public String getGnqh() {
        return gnqh;
    }

    public void setGnqh(String gnqh) {
        this.gnqh = gnqh;
    }

    public String getGnqlb() {
        return gnqlb;
    }

    public void setGnqlb(String gnqlb) {
        this.gnqlb = gnqlb;
    }

    public String getGnqmc() {
        return gnqmc;
    }

    public void setGnqmc(String gnqmc) {
        this.gnqmc = gnqmc;
    }

    public Double getFtxs() {
        return ftxs;
    }

    public void setFtxs(Double ftxs) {
        this.ftxs = ftxs;
    }

    public Double getJzmj() {
        return jzmj;
    }

    public void setJzmj(Double jzmj) {
        this.jzmj = jzmj;
    }

    public Double getTnmj() {
        return tnmj;
    }

    public void setTnmj(Double tnmj) {
        this.tnmj = tnmj;
    }

    public Double getFtmj() {
        return ftmj;
    }

    public void setFtmj(Double ftmj) {
        this.ftmj = ftmj;
    }

    public Integer getTs() {
        return ts;
    }

    public void setTs(Integer ts) {
        this.ts = ts;
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
        sb.append(", gnqh=").append(gnqh);
        sb.append(", gnqlb=").append(gnqlb);
        sb.append(", gnqmc=").append(gnqmc);
        sb.append(", ftxs=").append(ftxs);
        sb.append(", jzmj=").append(jzmj);
        sb.append(", tnmj=").append(tnmj);
        sb.append(", ftmj=").append(ftmj);
        sb.append(", ts=").append(ts);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}