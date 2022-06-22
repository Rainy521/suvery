package com.lwch.survey.model;

import java.util.Date;

public class Descrip {
    private String id;

    private String url;

    private String methodDescrip;

    private String paramsDescrip;

    private String username;

    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethodDescrip() {
        return methodDescrip;
    }

    public void setMethodDescrip(String methodDescrip) {
        this.methodDescrip = methodDescrip;
    }

    public String getParamsDescrip() {
        return paramsDescrip;
    }

    public void setParamsDescrip(String paramsDescrip) {
        this.paramsDescrip = paramsDescrip;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        sb.append(", url=").append(url);
        sb.append(", methodDescrip=").append(methodDescrip);
        sb.append(", paramsDescrip=").append(paramsDescrip);
        sb.append(", username=").append(username);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}