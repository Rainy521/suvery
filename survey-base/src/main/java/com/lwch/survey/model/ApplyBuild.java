package com.lwch.survey.model;

public class ApplyBuild {
    private String slbh;

    private String slsj;

    private String chlx;

    private String sbr;

    private String lpzh;

    private String bdcqzh;

    private String ghxkzh;

    private String jzjg;

    private Integer zcs;

    private Integer dxcs;

    private Integer dscs;

    private String ghyt;

    private Double zjzmj;

    private String xmzl;

    private String xmbh;

    public String getSlbh() {
        return slbh;
    }

    public void setSlbh(String slbh) {
        this.slbh = slbh;
    }

    public String getSlsj() {
        return slsj;
    }

    public void setSlsj(String slsj) {
        this.slsj = slsj;
    }

    public String getChlx() {
        return chlx;
    }

    public void setChlx(String chlx) {
        this.chlx = chlx;
    }

    public String getSbr() {
        return sbr;
    }

    public void setSbr(String sbr) {
        this.sbr = sbr;
    }

    public String getLpzh() {
        return lpzh;
    }

    public void setLpzh(String lpzh) {
        this.lpzh = lpzh;
    }

    public String getBdcqzh() {
        return bdcqzh;
    }

    public void setBdcqzh(String bdcqzh) {
        this.bdcqzh = bdcqzh;
    }

    public String getGhxkzh() {
        return ghxkzh;
    }

    public void setGhxkzh(String ghxkzh) {
        this.ghxkzh = ghxkzh;
    }

    public String getJzjg() {
        return jzjg;
    }

    public void setJzjg(String jzjg) {
        this.jzjg = jzjg;
    }

    public Integer getZcs() {
        return zcs;
    }

    public void setZcs(Integer zcs) {
        this.zcs = zcs;
    }

    public Integer getDxcs() {
        return dxcs;
    }

    public void setDxcs(Integer dxcs) {
        this.dxcs = dxcs;
    }

    public Integer getDscs() {
        return dscs;
    }

    public void setDscs(Integer dscs) {
        this.dscs = dscs;
    }

    public String getGhyt() {
        return ghyt;
    }

    public void setGhyt(String ghyt) {
        this.ghyt = ghyt;
    }

    public Double getZjzmj() {
        return zjzmj;
    }

    public void setZjzmj(Double zjzmj) {
        this.zjzmj = zjzmj;
    }

    public String getXmzl() {
        return xmzl;
    }

    public void setXmzl(String xmzl) {
        this.xmzl = xmzl;
    }

    public String getXmbh() {
        return xmbh;
    }

    public void setXmbh(String xmbh) {
        this.xmbh = xmbh;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", slbh=").append(slbh);
        sb.append(", slsj=").append(slsj);
        sb.append(", chlx=").append(chlx);
        sb.append(", sbr=").append(sbr);
        sb.append(", lpzh=").append(lpzh);
        sb.append(", bdcqzh=").append(bdcqzh);
        sb.append(", ghxkzh=").append(ghxkzh);
        sb.append(", jzjg=").append(jzjg);
        sb.append(", zcs=").append(zcs);
        sb.append(", dxcs=").append(dxcs);
        sb.append(", dscs=").append(dscs);
        sb.append(", ghyt=").append(ghyt);
        sb.append(", zjzmj=").append(zjzmj);
        sb.append(", xmzl=").append(xmzl);
        sb.append(", xmbh=").append(xmbh);
        sb.append("]");
        return sb.toString();
    }
}