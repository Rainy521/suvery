package com.lwch.survey.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lwch.survey.dao.mapper.GroupRoleMapper;
import com.lwch.survey.model.GroupRole;
import com.lwch.survey.model.GroupRoleExample;
import com.lwch.survey.pojo.PageParm;
import com.lwch.survey.service.GroupRoleService;
import com.lwch.survey.utils.ServiceUtils;

@Service
public class GroupRoleServiceImpl implements GroupRoleService {
    
    @Autowired
    private GroupRoleMapper groupRoleMapper;

    @Override
    public int save(GroupRole record) {
        
        GroupRole groupRole = groupRoleMapper.selectByPrimaryKey(record.getId());
        if (groupRole != null) {
            return groupRoleMapper.updateByPrimaryKey(record);
        }
        
        return groupRoleMapper.insert(record);
    }
    
    @Override
    public GroupRole selectByPrimaryKey(Long id) {
        return groupRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<GroupRole> selectByExample(GroupRoleExample example, PageParm pageParm) {
        ServiceUtils.startPage(pageParm);
        return groupRoleMapper.selectByExample(example);
    }

    @Override
    public long getCount() {
        GroupRoleExample groupRolesExample = new GroupRoleExample();
        
        return groupRoleMapper.countByExample(groupRolesExample);
    }

    @Override
    public int deleteGroupRole(String name) {
        if(!StringUtils.isNotBlank(name)){
            return 0;
        }
        
        GroupRoleExample groupRoleExample = new GroupRoleExample();
        groupRoleExample.createCriteria().andRoleNameEqualTo(name);
        
        return groupRoleMapper.deleteByExample(groupRoleExample);
    }
}
