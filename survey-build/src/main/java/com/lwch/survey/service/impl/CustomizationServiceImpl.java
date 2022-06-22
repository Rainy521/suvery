package com.lwch.survey.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.lwch.survey.dao.mapper.CustomizationGroupMembersMapper;
import com.lwch.survey.dao.mapper.CustomizationMapper;
import com.lwch.survey.dao.mapper.CustomizationMembersMapper;
import com.lwch.survey.model.Customization;
import com.lwch.survey.model.CustomizationGroupMembers;
import com.lwch.survey.model.CustomizationGroupMembersExample;
import com.lwch.survey.model.CustomizationMembers;
import com.lwch.survey.model.CustomizationMembersExample;
import com.lwch.survey.model.CustomizationMembersExample.Criteria;
import com.lwch.survey.service.CustomizationService;

@Service
public class CustomizationServiceImpl implements CustomizationService{

    @Autowired
    private CustomizationMapper customizationMapper;
    
    @Autowired
    private CustomizationMembersMapper customizationMembersMapper;
    
    @Autowired
    private CustomizationGroupMembersMapper customizationGroupMembersMapper;
    
    @Override
    public Customization selectByPrimaryKey(String id) {
        return customizationMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveCustomizationt(Customization customization, String id, String userName, String type) {
        if(StringUtils.isNotBlank(id) && customizationMapper.selectByPrimaryKey(id) != null){
            customization.setId(id);
            customizationMapper.updateByPrimaryKeySelective(customization);
        }else{
            id = UUID.randomUUID().toString();
            
            CustomizationMembersExample example = new CustomizationMembersExample();
            example.createCriteria().andUsernameEqualTo(userName).andTypeEqualTo(type);
            
            if(!CollectionUtils.isEmpty(customizationMembersMapper.selectByExample(example))) {
                throw new RuntimeException("仪表盘名称已存在！");
            }
            
            CustomizationMembers customizationMember = new CustomizationMembers();
            customizationMember.setCustomizationId(id);
            customizationMember.setUsername(userName);
            customizationMember.setType(type);
            customizationMembersMapper.insert(customizationMember);
            
            customization.setId(id);
            
            customizationMapper.insert(customization);
        }
    }

    @Override
    public Map<String, String> getCustomizationtTypes(boolean isAll, String userName, List<String> ids) {
        CustomizationMembersExample example = new CustomizationMembersExample();
        Criteria criteria = example.createCriteria();
        
        if(!CollectionUtils.isEmpty(ids) && isAll){
            criteria.andCustomizationIdIn(ids);
        }else {
        	criteria.andUsernameEqualTo(userName);
        }
        
        return customizationMembersMapper.selectByExample(example).stream().collect(Collectors.toMap(CustomizationMembers::getCustomizationId, CustomizationMembers::getType));
    }

    @Override
    public int deleteCustomizationt(String id) {
        CustomizationMembersExample example = new CustomizationMembersExample();
        example.createCriteria().andCustomizationIdEqualTo(id);
        
        customizationMapper.deleteByPrimaryKey(id);
        
        return customizationMembersMapper.deleteByExample(example);
    }

    @Override
    public int insertShareCustomizationt(String id, List<Long> groups) {
        if(CollectionUtils.isEmpty(groups)){
            return 0;
        }
        
        CustomizationGroupMembersExample example = new CustomizationGroupMembersExample();
        example.createCriteria().andCustomizationIdEqualTo(id).andGroupIdIn(groups);
        customizationGroupMembersMapper.deleteByExample(example);
        
        for(Long usergroup : groups){
            CustomizationGroupMembers member = new CustomizationGroupMembers();
            member.setCustomizationId(id);
            member.setGroupId(usergroup);
            
            customizationGroupMembersMapper.insert(member);
        }
        
        return groups.size();
    }

    @Override
    public List<String> getCustomizationtByGroup(List<Long> groups) {
        if(CollectionUtils.isEmpty(groups)){
            return Collections.emptyList();
        }
        
        CustomizationGroupMembersExample example = new CustomizationGroupMembersExample(); 
        example.createCriteria().andGroupIdIn(groups);
        
        return customizationGroupMembersMapper.selectByExample(example).stream().map(member -> member.getCustomizationId()).collect(Collectors.toList());
    }
    
    @Override
    public String getCustomization(String id) {
        CustomizationMembersExample example = new CustomizationMembersExample();
        example.createCriteria().andCustomizationIdEqualTo(id);
        List<CustomizationMembers> customizations = customizationMembersMapper.selectByExample(example);
        
        List<String> ids = customizations.stream().map(customization -> customization.getCustomizationId()).collect(Collectors.toList());
        
        if(!CollectionUtils.isEmpty(ids)){
            return ids.get(0);
        }
        
        return null;
    }

    @Override
    public List<CustomizationMembers> selectCustomizationMemberByGroup(List<Long> groups) {
        CustomizationGroupMembersExample example = new CustomizationGroupMembersExample();
        example.createCriteria().andGroupIdIn(groups);
        List<CustomizationGroupMembers> members = customizationGroupMembersMapper.selectByExample(example);
        
        if(CollectionUtils.isEmpty(members)){
            return Collections.emptyList();
        }
        
        CustomizationMembersExample memberExample = new CustomizationMembersExample();
        memberExample.createCriteria().andCustomizationIdIn(members.stream().map(member -> member.getCustomizationId()).collect(Collectors.toList()));
        
        return customizationMembersMapper.selectByExample(memberExample);
    }

    @Override
    public int deleteShare(List<Long> group, String customizationIds) {
        CustomizationGroupMembersExample example = new CustomizationGroupMembersExample();
        example.createCriteria().andGroupIdIn(group).andCustomizationIdEqualTo(customizationIds);
        
        return customizationGroupMembersMapper.deleteByExample(example);
    }

    @Override
	public int deleteShareByCusId(String customizationIds) {
    	CustomizationGroupMembersExample example = new CustomizationGroupMembersExample();
    	example.createCriteria().andCustomizationIdEqualTo(customizationIds);
    	
    	return customizationGroupMembersMapper.deleteByExample(example);
    	
//    	CustomizationMembersExample memberExample = new CustomizationMembersExample();
//    	memberExample.createCriteria().andCustomizationIdEqualTo(customizationIds);
//    	customizationMembersMapper.deleteByExample(memberExample);
//		return 0;
	}

	@Override
    public List<CustomizationGroupMembers> selectAssignedGroup(String id) {
        CustomizationGroupMembersExample example = new CustomizationGroupMembersExample();
        example.createCriteria().andCustomizationIdEqualTo(id);
        
        return customizationGroupMembersMapper.selectByExample(example);
    }
}
