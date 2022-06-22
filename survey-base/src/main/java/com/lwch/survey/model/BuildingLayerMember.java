package com.lwch.survey.model;

public class BuildingLayerMember {
    private String lpzid;

    private String cid;

    private String cgyid;

    public String getLpzid() {
        return lpzid;
    }

    public void setLpzid(String lpzid) {
        this.lpzid = lpzid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCgyid() {
        return cgyid;
    }

    public void setCgyid(String cgyid) {
        this.cgyid = cgyid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", lpzid=").append(lpzid);
        sb.append(", cid=").append(cid);
        sb.append(", cgyid=").append(cgyid);
        sb.append("]");
        return sb.toString();
    }
}