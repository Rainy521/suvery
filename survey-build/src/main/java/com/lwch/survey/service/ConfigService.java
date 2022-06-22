package com.lwch.survey.service;

import java.util.List;
import java.util.Map;

import com.lwch.survey.model.Config;

public interface ConfigService {
    /**
     * 根据配置名称查找系统配置信息
     * @param name 配置项名
     * @return Config 系统配置对象
     */
    Config selectConfig(String name);
    
    /**
     * 根据配置名称查找相关的系统配置集合
     * @param configPrefix 配置项名
     * @return List 系统配置集合
     */
    List<Config> selectConfigs(String configPrefix);
    
    /**
     * 获取配置项集合
     * @param configPrefix 配置项名
     * @param removePrefix 判断条件
     * @return Map 配置项集合
     */
    Map<String, Object> getMapConfigs(String configPrefix, boolean removePrefix);
    
    /**
     * 新增配置项
     * @param record 系统配置对象
     * @return int
     */
    int saveConfig(Config record);
    
    /**
     * 修改配置项
     * @param record 系统配置对象
     * @return int
     */
    int updateConfig(Config record);
    
    /**
     * 删除配置项
     * @param name 配置项名
     * @return int
     */
    int deleteConfig(String name);
    
    /**
     * 刷新
     */
    void refresh();
}
