package com.lwch.survey.service.activiti;

import org.activiti.engine.impl.interceptor.Session;
import org.activiti.engine.impl.interceptor.SessionFactory;
import org.activiti.engine.impl.persistence.entity.GroupEntityManager;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomGroupEntityManagerFactory implements SessionFactory{
    
    @Autowired
    private GroupEntityManager groupEntityManager;
    
    public void setGroupEntityManager(GroupEntityManager groupEntityManager) {  
        this.groupEntityManager = groupEntityManager;  
    }  
  
    public Class<?> getSessionType() {  
        return GroupEntityManager.class;  
    }  
  
    public Session openSession() {  
        return groupEntityManager;  
    }  
}
