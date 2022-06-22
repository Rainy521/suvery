package com.lwch.survey.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lwch.survey.dao.mapper.ConfigMapper;
import com.lwch.survey.model.Config;
import com.lwch.survey.model.ConfigExample;
import com.lwch.survey.service.ConfigService;
import com.lwch.survey.utils.ConfigUtils;

@Service
public class ConfigServiceImpl implements ConfigService {
    @Autowired
    private ConfigMapper configMapper;
    
    @Override
    public Config selectConfig(String name) {
        return configMapper.selectByPrimaryKey(name);
    }
    
    @Override
    public List<Config> selectConfigs(String configPrefix) {
        ConfigExample example = new ConfigExample();
        example.or().andNameLike(configPrefix + "%");
        
        example.setOrderByClause("name");
        
        return configMapper.selectByExample(example);
    }
    
    @Override
    public Map<String, Object> getMapConfigs(String configPrefix, boolean removePrefix) {
        List<Config> configs = selectConfigs(configPrefix);
        
        if (removePrefix) {
            return ConfigUtils.getMap(configs, configPrefix.length());
        } else {
            return ConfigUtils.getMap(configs);
        }
    }
    
    @Override
    public int saveConfig(Config record) {
        record.setUpdateTime(new Date());
        return configMapper.insert(record);
    }
    
    @Override
    public int updateConfig(Config record) {
        record.setUpdateTime(new Date());
        return configMapper.updateByPrimaryKeySelective(record);
    }
    
    @Override
    public int deleteConfig(String name) {
        return configMapper.deleteByPrimaryKey(name);
    }

    @Override
    public void refresh() {
    }
}
