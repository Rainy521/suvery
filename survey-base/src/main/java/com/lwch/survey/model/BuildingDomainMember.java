package com.lwch.survey.model;

public class BuildingDomainMember {
    private String lpzid;

    private String gnqid;

    public String getLpzid() {
        return lpzid;
    }

    public void setLpzid(String lpzid) {
        this.lpzid = lpzid;
    }

    public String getGnqid() {
        return gnqid;
    }

    public void setGnqid(String gnqid) {
        this.gnqid = gnqid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", lpzid=").append(lpzid);
        sb.append(", gnqid=").append(gnqid);
        sb.append("]");
        return sb.toString();
    }
}