package com.lwch.survey.model;

public class CustomizationGroupMembers {
    private String customizationId;

    private Long groupId;

    public String getCustomizationId() {
        return customizationId;
    }

    public void setCustomizationId(String customizationId) {
        this.customizationId = customizationId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", customizationId=").append(customizationId);
        sb.append(", groupId=").append(groupId);
        sb.append("]");
        return sb.toString();
    }
}