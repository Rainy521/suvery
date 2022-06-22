package com.lwch.survey.model;

import java.util.Date;

public class FileTypeApplyMember {
    private Integer fileManageId;

    private String fileId;

    private String applyid;
    
    private byte[] files;

    private Date updateTime;

    public byte[] getFiles() {
        return files;
    }

    public void setFiles(byte[] files) {
        this.files = files;
    }

    public Integer getFileManageId() {
		return fileManageId;
	}

	public void setFileManageId(Integer fileManageId) {
		this.fileManageId = fileManageId;
	}

	public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getApplyid() {
        return applyid;
    }

    public void setApplyid(String applyid) {
        this.applyid = applyid;
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
        sb.append(", fileManageId=").append(fileManageId);
        sb.append(", fileId=").append(fileId);
        sb.append(", applyid=").append(applyid);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}