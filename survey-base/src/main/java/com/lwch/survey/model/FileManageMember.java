package com.lwch.survey.model;

public class FileManageMember {
    private Integer fileManageId;

    private String businessId;
    
    private FileManage fileManage;

    public FileManage getFileManage() {
		return fileManage;
	}

	public void setFileManage(FileManage fileManage) {
		this.fileManage = fileManage;
	}

	public Integer getFileManageId() {
		return fileManageId;
	}

	public void setFileManageId(Integer fileManageId) {
		this.fileManageId = fileManageId;
	}

	public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fileManageId=").append(fileManageId);
        sb.append(", businessId=").append(businessId);
        sb.append("]");
        return sb.toString();
    }
}