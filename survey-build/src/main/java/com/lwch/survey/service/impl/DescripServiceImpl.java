package com.lwch.survey.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lwch.survey.dao.mapper.DescripMapper;
import com.lwch.survey.model.Descrip;
import com.lwch.survey.model.DescripExample;
import com.lwch.survey.service.DescripService;

@Service
public class DescripServiceImpl implements DescripService {
    
    @Autowired
    private DescripMapper descripMapper;

    @Override
    public List<Descrip> selectByExample(DescripExample example) {
        return descripMapper.selectByExample(example);
    }

    @Override
    public Descrip selectByPrimaryKey(String id) {
        return descripMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Descrip record) {
        return descripMapper.updateByPrimaryKey(record);
    }

    @Override
    public int insertDescrip(Descrip record) {
        record.setUpdateTime(new Date());
        return descripMapper.insert(record);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return descripMapper.deleteByPrimaryKey(id);
    }

    @Override
    public long getCount() {
        DescripExample descripExample = new DescripExample();
        return descripMapper.countByExample(descripExample);
    }
}
