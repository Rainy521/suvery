package com.lwch.survey.service;

import java.util.Map;

import com.lwch.survey.model.Descrip;
import com.lwch.survey.model.OperationLog;


public interface OperationLogService {

    Map<String, Object> getOperationList(String url, int currentPage, int pageSize, String...condition);
    
    Map<String, Object> getDescripList(int currentPage, int pageSize, String...condition);
    
    void createOpreationTable(String tableName);
    
    void createDescripTable(String tableName);
    
    OperationLog selectByOperationPrimaryKey(String id, String time);
    
    Descrip selectByDescriptionPrimaryKey(String id, String time); 
}
