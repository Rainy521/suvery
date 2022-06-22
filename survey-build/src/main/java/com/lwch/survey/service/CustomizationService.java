package com.lwch.survey.service;

import java.util.List;
import java.util.Map;

import com.lwch.survey.model.Customization;
import com.lwch.survey.model.CustomizationGroupMembers;
import com.lwch.survey.model.CustomizationMembers;

public interface CustomizationService {
    
    /**
     * 根据id查询首页配置信息
     * @param id 配置ID
     * @return Customization 首页配置对象
     */
    Customization selectByPrimaryKey(String id);
    
    /**
     * 新增配置信息
     * @param customization 配置项对象
     * @param id 配置ID
     * @param userName 用户名
     * @param type 配置页类型
     * @return int
     */
    void saveCustomizationt(Customization customization, String id, String userName, String type);
    
    /**
     * 删除配置信息
     * @param id 配置ID
     * @return int
     */
    int deleteCustomizationt(String id);
    
    /**
     * 查询配置类型
     * @param isAll 判断条件，是否为全部
     * @param userName 用户名
     * @param ids 配置ID集合
     * @return Map 查询结果
     */
    Map<String, String> getCustomizationtTypes(boolean isAll, String userName, List<String> ids);
    
    /**
     * 新增用户组关系配置
     * @param id 配置ID
     * @param groups 用户组
     * @return int
     */
    int insertShareCustomizationt(String id, List<Long> groups);
    
    /**
     * 根据组id查询配置项集合
     * @param groups 用户组集合
     * @return List 配置ID集合
     */
    List<String> getCustomizationtByGroup(List<Long> groups);
    
    /**
     * 根据id查询配置项
     * @param id 配置ID
     * @return String
     */
    String getCustomization(String id);
    
    /**
     * 根据用户组id查找配置类型，用户页等信息
     * @param group 用户组集合
     * @return List 返回配置集合
     */
    List<CustomizationMembers> selectCustomizationMemberByGroup(List<Long> group);
    
    /**
     * 删除用户组-配置id关系
     * @param group 用户组
     * @param customizationIds 配置ID
     * @return int
     */
    int deleteShare(List<Long> group, String customizationIds);
    
    /**
     * 删除用户组-配置id关系
     * @param customizationIds
     * @return
     */
    int deleteShareByCusId(String customizationIds);
    
    /**
     * 根据id查询用户组与配置id关系
     * @param id 配置ID
     * @return List 返回配置集合
     */
    List<CustomizationGroupMembers> selectAssignedGroup(String id);
}
