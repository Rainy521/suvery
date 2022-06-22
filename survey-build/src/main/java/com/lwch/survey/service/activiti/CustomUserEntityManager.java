package com.lwch.survey.service.activiti;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.activiti.engine.identity.Group;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.UserQueryImpl;
import org.activiti.engine.impl.persistence.entity.IdentityInfoEntity;
import org.activiti.engine.impl.persistence.entity.UserEntity;
import org.activiti.engine.impl.persistence.entity.UserEntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.lwch.survey.dao.mapper.GroupMemberMapper;
import com.lwch.survey.model.GroupMemberExample;
import com.lwch.survey.model.User;
import com.lwch.survey.model.UserExample;
import com.lwch.survey.model.UserGroup;
import com.lwch.survey.service.UserService;
import com.lwch.survey.utils.ActivitiUtils;

@Service
public class CustomUserEntityManager extends UserEntityManager{
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private GroupMemberMapper groupMemberMapper;
    
    @Override  
    public UserEntity findUserById(final String userCode) {  
        if (userCode == null)  
            return null;  
  
        try {  
            UserEntity userEntity = null;  
            User bUser = userService.selectByPrimaryKey(userCode);  
            userEntity = ActivitiUtils.toActivitiUser(bUser);  
            return userEntity;  
        } catch (EmptyResultDataAccessException e) {  
            return null;  
        }  
    }  
  
    @Override  
    public List<Group> findGroupsByUser(final String userCode) {  
        if (userCode == null)  
            return null;  
  
            List<UserGroup> bGroups = userService.selectUserGroupByName(userCode);  
              
            List<org.activiti.engine.identity.Group> gs = null;  
            gs = ActivitiUtils.toActivitiGroups(bGroups);
            
            return gs;
    }
  
    @Override  
    public List<org.activiti.engine.identity.User> findUserByQueryCriteria(UserQueryImpl query, Page page) {  
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria(); 
        
        if(query.getGroupId() != null){
            GroupMemberExample memberExample = new GroupMemberExample();
            memberExample.createCriteria().andGroupIdEqualTo(Long.parseLong(query.getGroupId()));
            
            List<String> usernames = groupMemberMapper.selectByExample(memberExample).stream().map(member -> member.getUsername()).collect(Collectors.toList());
            if(CollectionUtils.isEmpty(usernames)){
                return Collections.emptyList();
            }
            
            criteria.andUsernameIn(usernames);
        }
        if(query.getId() != null){
            criteria.andUsernameEqualTo(query.getId());
        }
        
        List<User> users = userService.selectByExample(userExample);
        List<org.activiti.engine.identity.User> activitiUsers = new ArrayList<>();
        if(CollectionUtils.isEmpty(users)){
           return Collections.emptyList(); 
        }
        
        for(User user : users){
            activitiUsers.add(ActivitiUtils.toActivitiUser(user));
        }
        
        return activitiUsers;
    }  
  
    @Override  
    public IdentityInfoEntity findUserInfoByUserIdAndKey(String userId,  
            String key) {  
        throw new RuntimeException("not implement method.");  
    }  
  
    @Override  
    public List<String> findUserInfoKeysByUserIdAndType(String userId,  
            String type) {  
        throw new RuntimeException("not implement method.");  
    }  
  
    @Override  
    public long findUserCountByQueryCriteria(UserQueryImpl query) {  
        throw new RuntimeException("not implement method.");  
    }
    
    @Override
    public Boolean checkPassword(String userId, String password) {
        return true;
    }
}
