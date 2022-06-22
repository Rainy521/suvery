package com.lwch.survey.model;

public class CustomizationMembers {
    private String customizationId;

    private String username;

    private String type;

    public String getCustomizationId() {
        return customizationId;
    }

    public void setCustomizationId(String customizationId) {
        this.customizationId = customizationId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", customizationId=").append(customizationId);
        sb.append(", username=").append(username);
        sb.append(", type=").append(type);
        sb.append("]");
        return sb.toString();
    }
}