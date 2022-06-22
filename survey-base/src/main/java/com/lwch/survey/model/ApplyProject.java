package com.lwch.survey.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApplyProject {
    private String id;

    private String projectNo;

    private String projectName;

    private String projectType;

    private String projectFzr;

    private String projectGk;

    private String projectXmzl;

    private String lxr;

    private String lxdh;

    private Date updateTime;

    private String sldw;

    private String slzjhm;

    private String sllxr;

    private String sldh;

    private String creditCode;

    private String slcreditCode;
    
    private ApplyBuild applyBuild = new ApplyBuild();
    
    private List<ApplyBuilding> listBuilding = new ArrayList<>();
    
    private List<House> listHouse = new ArrayList<>();
    
    private List<FileTypeApplyMember> listFiles = new ArrayList<>();

    public ApplyBuild getApplyBuild() {
		return applyBuild;
	}

	public void setApplyBuild(ApplyBuild applyBuild) {
		this.applyBuild = applyBuild;
	}

	public List<ApplyBuilding> getListBuilding() {
		return listBuilding;
	}

	public void setListBuilding(List<ApplyBuilding> listBuilding) {
		this.listBuilding = listBuilding;
	}

	public List<House> getListHouse() {
		return listHouse;
	}

	public void setListHouse(List<House> listHouse) {
		this.listHouse = listHouse;
	}

	public List<FileTypeApplyMember> getListFiles() {
		return listFiles;
	}

	public void setListFiles(List<FileTypeApplyMember> listFiles) {
		this.listFiles = listFiles;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getProjectFzr() {
        return projectFzr;
    }

    public void setProjectFzr(String projectFzr) {
        this.projectFzr = projectFzr;
    }

    public String getProjectGk() {
        return projectGk;
    }

    public void setProjectGk(String projectGk) {
        this.projectGk = projectGk;
    }

    public String getProjectXmzl() {
        return projectXmzl;
    }

    public void setProjectXmzl(String projectXmzl) {
        this.projectXmzl = projectXmzl;
    }

    public String getLxr() {
        return lxr;
    }

    public void setLxr(String lxr) {
        this.lxr = lxr;
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getSldw() {
        return sldw;
    }

    public void setSldw(String sldw) {
        this.sldw = sldw;
    }

    public String getSlzjhm() {
        return slzjhm;
    }

    public void setSlzjhm(String slzjhm) {
        this.slzjhm = slzjhm;
    }

    public String getSllxr() {
        return sllxr;
    }

    public void setSllxr(String sllxr) {
        this.sllxr = sllxr;
    }

    public String getSldh() {
        return sldh;
    }

    public void setSldh(String sldh) {
        this.sldh = sldh;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getSlcreditCode() {
        return slcreditCode;
    }

    public void setSlcreditCode(String slcreditCode) {
        this.slcreditCode = slcreditCode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", projectNo=").append(projectNo);
        sb.append(", projectName=").append(projectName);
        sb.append(", projectType=").append(projectType);
        sb.append(", projectFzr=").append(projectFzr);
        sb.append(", projectGk=").append(projectGk);
        sb.append(", projectXmzl=").append(projectXmzl);
        sb.append(", lxr=").append(lxr);
        sb.append(", lxdh=").append(lxdh);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", sldw=").append(sldw);
        sb.append(", slzjhm=").append(slzjhm);
        sb.append(", sllxr=").append(sllxr);
        sb.append(", sldh=").append(sldh);
        sb.append(", creditCode=").append(creditCode);
        sb.append(", slcreditCode=").append(slcreditCode);
        sb.append("]");
        return sb.toString();
    }
}