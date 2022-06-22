package com.lwch.survey.service.activiti;

import org.activiti.engine.impl.interceptor.Session;
import org.activiti.engine.impl.interceptor.SessionFactory;
import org.activiti.engine.impl.persistence.entity.TaskEntityManager;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomTaskEntityManagerFactory implements SessionFactory{
    
    @Autowired
    private TaskEntityManager taskEntityManager;
    
    public void setGroupEntityManager(TaskEntityManager taskEntityManager) {  
        this.taskEntityManager = taskEntityManager;  
    }  
  
    public Class<?> getSessionType() {  
        return TaskEntityManager.class;  
    }  
  
    public Session openSession() {  
        return taskEntityManager;  
    }  
}
