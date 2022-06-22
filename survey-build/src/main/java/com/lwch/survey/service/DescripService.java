package com.lwch.survey.service;

import java.util.List;

import com.lwch.survey.model.Descrip;
import com.lwch.survey.model.DescripExample;

public interface DescripService {

    List<Descrip> selectByExample(DescripExample example);
    
    Descrip selectByPrimaryKey(String id);
    
    int updateByPrimaryKeySelective(Descrip record);
    
    int insertDescrip(Descrip record);
    
    int deleteByPrimaryKey(String id);
    
    long getCount();
}
