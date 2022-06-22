package com.lwch.survey.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Archive {
    private String id;

    private String name;

    private String next;

    private Integer isempty;

    private String pid;

    private String casenumber;

    private Date updateTime;
    
    private List<Archive> children = new ArrayList<>();

    public List<Archive> getChildren() {
        return children;
    }

    public void setChildren(List<Archive> children) {
        this.children = children;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public Integer getIsempty() {
        return isempty;
    }

    public void setIsempty(Integer isempty) {
        this.isempty = isempty;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getCasenumber() {
        return casenumber;
    }

    public void setCasenumber(String casenumber) {
        this.casenumber = casenumber;
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
        sb.append(", name=").append(name);
        sb.append(", next=").append(next);
        sb.append(", isempty=").append(isempty);
        sb.append(", pid=").append(pid);
        sb.append(", casenumber=").append(casenumber);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}