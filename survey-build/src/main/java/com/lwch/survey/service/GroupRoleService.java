package com.lwch.survey.service;

import java.util.List;

import com.lwch.survey.model.GroupRole;
import com.lwch.survey.model.GroupRoleExample;
import com.lwch.survey.pojo.PageParm;

public interface GroupRoleService {
    
    /**
     * 新增用户组角色
     * @param record 用户组角色对象
     * @return int
     */
    int save(GroupRole record);
    
    /**
     * 根据id查询用户组角色信息
     * @param id 用户组角色编号
     * @return GroupRole 用户组角色对象
     */
    GroupRole selectByPrimaryKey(Long id);
    
    /**
     * 查询用户组角色信息
     * @param example 查询条件
     * @param pageParm 分页类
     * @return List 用户组角色集合
     */
    List<GroupRole> selectByExample(GroupRoleExample example, PageParm pageParm);
    
    /**
     * 统计用户组角色数量
     * @return long
     */
    long getCount();
    
    /**
     * 根据用户组角色名删除用户组角色信息
     * @param name 角色名
     * @return int
     */
    int deleteGroupRole(String name);
}
