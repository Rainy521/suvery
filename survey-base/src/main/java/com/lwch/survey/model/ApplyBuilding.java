package com.lwch.survey.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApplyBuilding {
    private String id;

    private String applyId;

    private String projectNo;

    private String lpzh;

    private String lpmc;

    private String ghyt;

    private String fwlx;

    private String jznd;

    private String jzcc;

    private Double jzzmj;

    private Double wwjzmj;

    private Double hsjzmj;

    private Integer zts;

    private Integer zcs;

    private Integer dscs;

    private Integer dxcs;

    private String chlx;

    private String siffFileid;

    private String jzjg;

    private Date updateTime;
    
    private byte[] files;
    
    private List<BuildingLayer> layers = new ArrayList<>();
    
    private List<House> houses = new ArrayList<>();
    
    private List<BuildingShare> shares = new ArrayList<>();
    
    private List<BuildingDomain> domains = new ArrayList<>();
    
    private List<BuildingDomain> funcs = new ArrayList<>();

    public byte[] getFiles() {
        return files;
    }

    public void setFiles(byte[] files) {
        this.files = files;
    }

    public List<BuildingLayer> getLayers() {
        return layers;
    }

    public void setLayers(List<BuildingLayer> layers) {
        this.layers = layers;
    }

    public List<House> getHouses() {
        return houses;
    }

    public void setHouses(List<House> houses) {
        this.houses = houses;
    }

    public List<BuildingShare> getShares() {
        return shares;
    }

    public void setShares(List<BuildingShare> shares) {
        this.shares = shares;
    }

    public List<BuildingDomain> getDomains() {
        return domains;
    }

    public void setDomains(List<BuildingDomain> domains) {
        this.domains = domains;
    }

    public List<BuildingDomain> getFuncs() {
        return funcs;
    }

    public void setFuncs(List<BuildingDomain> funcs) {
        this.funcs = funcs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getLpzh() {
        return lpzh;
    }

    public void setLpzh(String lpzh) {
        this.lpzh = lpzh;
    }

    public String getLpmc() {
        return lpmc;
    }

    public void setLpmc(String lpmc) {
        this.lpmc = lpmc;
    }

    public String getGhyt() {
        return ghyt;
    }

    public void setGhyt(String ghyt) {
        this.ghyt = ghyt;
    }

    public String getFwlx() {
        return fwlx;
    }

    public void setFwlx(String fwlx) {
        this.fwlx = fwlx;
    }

    public String getJznd() {
        return jznd;
    }

    public void setJznd(String jznd) {
        this.jznd = jznd;
    }

    public String getJzcc() {
        return jzcc;
    }

    public void setJzcc(String jzcc) {
        this.jzcc = jzcc;
    }

    public Double getJzzmj() {
        return jzzmj;
    }

    public void setJzzmj(Double jzzmj) {
        this.jzzmj = jzzmj;
    }

    public Double getWwjzmj() {
        return wwjzmj;
    }

    public void setWwjzmj(Double wwjzmj) {
        this.wwjzmj = wwjzmj;
    }

    public Double getHsjzmj() {
        return hsjzmj;
    }

    public void setHsjzmj(Double hsjzmj) {
        this.hsjzmj = hsjzmj;
    }

    public Integer getZts() {
        return zts;
    }

    public void setZts(Integer zts) {
        this.zts = zts;
    }

    public Integer getZcs() {
        return zcs;
    }

    public void setZcs(Integer zcs) {
        this.zcs = zcs;
    }

    public Integer getDscs() {
        return dscs;
    }

    public void setDscs(Integer dscs) {
        this.dscs = dscs;
    }

    public Integer getDxcs() {
        return dxcs;
    }

    public void setDxcs(Integer dxcs) {
        this.dxcs = dxcs;
    }

    public String getChlx() {
        return chlx;
    }

    public void setChlx(String chlx) {
        this.chlx = chlx;
    }

    public String getSiffFileid() {
        return siffFileid;
    }

    public void setSiffFileid(String siffFileid) {
        this.siffFileid = siffFileid;
    }

    public String getJzjg() {
        return jzjg;
    }

    public void setJzjg(String jzjg) {
        this.jzjg = jzjg;
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
        sb.append(", applyId=").append(applyId);
        sb.append(", projectNo=").append(projectNo);
        sb.append(", lpzh=").append(lpzh);
        sb.append(", lpmc=").append(lpmc);
        sb.append(", ghyt=").append(ghyt);
        sb.append(", fwlx=").append(fwlx);
        sb.append(", jznd=").append(jznd);
        sb.append(", jzcc=").append(jzcc);
        sb.append(", jzzmj=").append(jzzmj);
        sb.append(", wwjzmj=").append(wwjzmj);
        sb.append(", hsjzmj=").append(hsjzmj);
        sb.append(", zts=").append(zts);
        sb.append(", zcs=").append(zcs);
        sb.append(", dscs=").append(dscs);
        sb.append(", dxcs=").append(dxcs);
        sb.append(", chlx=").append(chlx);
        sb.append(", siffFileid=").append(siffFileid);
        sb.append(", jzjg=").append(jzjg);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}