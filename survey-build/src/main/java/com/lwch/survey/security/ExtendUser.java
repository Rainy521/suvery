package com.lwch.survey.security;

import java.io.Serializable;

public class ExtendUser implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String realname;
    
    private String email;
    
    private String phone;
    
    private int userType;

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
  }
