package com.lwch.survey.service.impl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.lwch.survey.dao.mapper.GroupMemberMapper;
import com.lwch.survey.dao.mapper.UserGroupMapper;
import com.lwch.survey.dao.mapper.UserMapper;
import com.lwch.survey.model.GroupMember;
import com.lwch.survey.model.GroupMemberExample;
import com.lwch.survey.model.User;
import com.lwch.survey.model.UserExample;
import com.lwch.survey.model.UserGroup;
import com.lwch.survey.model.UserGroupExample;
import com.lwch.survey.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private GroupMemberMapper groupMemberMapper;
    
    @Autowired
    private UserGroupMapper userGroupMapper;
    
    @Override
    public List<User> selectALLUsers(String query, int userType, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageHelper.orderBy("username");
        
        UserExample userExample = new UserExample();
        
        if (StringUtils.isNotBlank(query)) {
            if(userType >= 0){
                userExample.createCriteria().andUsernameLike("%" + query + "%").andUserTypeEqualTo(userType);
            }else{
                userExample.createCriteria().andUsernameLike("%" + query + "%");
            }
        }
        
        if(userType >= 0){
            userExample.createCriteria().andUserTypeEqualTo(userType);
        }
        
        return userMapper.selectByExample(userExample);
    }
    
    @Override
    public List<UserGroup> selectUserGroupByName(String name) {
        GroupMemberExample groupMemberExample = new GroupMemberExample();
        groupMemberExample.createCriteria().andUsernameEqualTo(name);
        
        List<GroupMember> groupMembers = groupMemberMapper.selectByExample(groupMemberExample);
        
        List<Long> groupIds = new ArrayList<>();
        for (GroupMember groupMember : groupMembers) {
            groupIds.add(groupMember.getGroupId());
        }
        
        if (groupIds.isEmpty()) {
            return Collections.emptyList();
        }
        
        UserGroupExample userGroupExample = new UserGroupExample();
        userGroupExample.createCriteria().andIdIn(groupIds);
        
        return userGroupMapper.selectByExample(userGroupExample);
    }
    
    @Override
    public int deleteGroups(String name, List<Long> groupIds) {
        if (groupIds == null || groupIds.isEmpty()) {
            return 0;
        }
        
        GroupMemberExample groupMemberExample = new GroupMemberExample();
        groupMemberExample.createCriteria().andUsernameEqualTo(name).andGroupIdIn(groupIds);
        
        return groupMemberMapper.deleteByExample(groupMemberExample);
    }
    
    @Override
    public long getCount(String query ,int userType) {
        UserExample userExample = new UserExample();
        
        if (StringUtils.isNotBlank(query)) {
            if(userType >= 0){
                userExample.createCriteria().andUsernameLike("%" + query + "%").andUserTypeEqualTo(userType);
            }else{
                userExample.createCriteria().andUsernameLike("%" + query + "%");
            }
        }
        
        if(userType >= 0){
            userExample.createCriteria().andUserTypeEqualTo(userType);
        }
        
        return userMapper.countByExample(userExample);
    }
    
    @Override
    @Transactional
    public void lockUser(String name) {
        User user = new User();
        user.setUsername(name);
        user.setAccountNonLocked(false);
        user.setAccountLockedTime(new Date());
        user.setUpdateTime(new Date());
        
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    @Transactional
    public void unlockUser(String name) {
        User user = new User();
        user.setUsername(name);
        user.setAccountNonLocked(true);
        user.setUpdateTime(new Date());
        
        userMapper.updateByPrimaryKeySelective(user);
    }
    
    @Override
    @Transactional
    public void resetPassword(String username,  String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setAccountNonLocked(true);
        user.setAccountLockedTime(null);
        user.setAccountNonExpired(true);
        user.setAccountEffectiveTime(new Date());
        user.setCredentialsNonExpired(false);
        user.setCredentialsEffectiveTime(new Date());
        user.setEnabled(true);
        user.setUpdateTime(new Date());
        
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    @Transactional
    public void resetNickname(String username, String nickname) {
        User user = new User();
        user.setUsername(username);
        user.setRealname(nickname);
        user.setUpdateTime(new Date());
        
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    @Transactional
	public void updateUser(User user) {
    	User extendUser = new User();
    	extendUser.setUsername(user.getUsername());
    	extendUser.setRealname(user.getRealname());
        extendUser.setEmail(user.getEmail());
        extendUser.setPhone(user.getPhone());
        extendUser.setUpdateTime(new Date());
        
    	userMapper.updateByPrimaryKeySelective(extendUser);
	}

	@Override
    public List<User> selectByExample(UserExample example) {
        return userMapper.selectByExample(example);
    }

    @Override
    public User selectByPrimaryKey(String username) {
        return userMapper.selectByPrimaryKey(username);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }
}
