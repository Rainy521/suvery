package com.lwch.survey.model;

import java.util.Date;

public class User {
    private String username;

    private String realname;

    private String phone;

    private String email;

    private Integer userType;

    private String password;

    private Boolean enabled;

    private Boolean accountNonExpired;

    private Date accountEffectiveTime;

    private Boolean credentialsNonExpired;

    private Date credentialsEffectiveTime;

    private Boolean accountNonLocked;

    private Date accountLockedTime;

    private Date updateTime;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public Date getAccountEffectiveTime() {
        return accountEffectiveTime;
    }

    public void setAccountEffectiveTime(Date accountEffectiveTime) {
        this.accountEffectiveTime = accountEffectiveTime;
    }

    public Boolean getCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public Date getCredentialsEffectiveTime() {
        return credentialsEffectiveTime;
    }

    public void setCredentialsEffectiveTime(Date credentialsEffectiveTime) {
        this.credentialsEffectiveTime = credentialsEffectiveTime;
    }

    public Boolean getAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public Date getAccountLockedTime() {
        return accountLockedTime;
    }

    public void setAccountLockedTime(Date accountLockedTime) {
        this.accountLockedTime = accountLockedTime;
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
        sb.append(", username=").append(username);
        sb.append(", realname=").append(realname);
        sb.append(", phone=").append(phone);
        sb.append(", email=").append(email);
        sb.append(", userType=").append(userType);
        sb.append(", password=").append(password);
        sb.append(", enabled=").append(enabled);
        sb.append(", accountNonExpired=").append(accountNonExpired);
        sb.append(", accountEffectiveTime=").append(accountEffectiveTime);
        sb.append(", credentialsNonExpired=").append(credentialsNonExpired);
        sb.append(", credentialsEffectiveTime=").append(credentialsEffectiveTime);
        sb.append(", accountNonLocked=").append(accountNonLocked);
        sb.append(", accountLockedTime=").append(accountLockedTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}