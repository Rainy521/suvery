package com.lwch.survey.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lwch.survey.dao.mapper.FileMapper;
import com.lwch.survey.model.File;
import com.lwch.survey.model.FileExample;
import com.lwch.survey.service.FileService;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileMapper fileMapper;
    
    @Override
    public int insertFile(File file) {
        file.setUpdateTime(new Date());
        return fileMapper.insert(file);
    }

    @Override
    public File selectByPrimaryKey(String id) {
        return fileMapper.selectByPrimaryKey(id);
    }

    @Override
    public File selectByFileName(String name) {
        if(StringUtils.isBlank(name)){
            return null;
        }
        
        FileExample example = new FileExample();
        example.createCriteria().andNameEqualTo(name);
        
        List<File> files = fileMapper.selectByExample(example);
        
        if(!CollectionUtils.isEmpty(files)){
            files.get(0);
        }
        
        return null;
    }

}
