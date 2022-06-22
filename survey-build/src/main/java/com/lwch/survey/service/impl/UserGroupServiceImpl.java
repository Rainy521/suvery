package com.lwch.survey.service.impl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.lwch.survey.dao.mapper.GroupMemberMapper;
import com.lwch.survey.dao.mapper.GroupRoleMapper;
import com.lwch.survey.dao.mapper.GroupsMapper;
import com.lwch.survey.dao.mapper.MenuMapper;
import com.lwch.survey.dao.mapper.MenuUsergroupMemberMapper;
import com.lwch.survey.dao.mapper.UserGroupMapper;
import com.lwch.survey.model.GroupMember;
import com.lwch.survey.model.GroupMemberExample;
import com.lwch.survey.model.GroupRole;
import com.lwch.survey.model.GroupRoleExample;
import com.lwch.survey.model.Groups;
import com.lwch.survey.model.GroupsExample;
import com.lwch.survey.model.Menu;
import com.lwch.survey.model.MenuExample;
import com.lwch.survey.model.MenuUsergroupMember;
import com.lwch.survey.model.MenuUsergroupMemberExample;
import com.lwch.survey.model.UserGroup;
import com.lwch.survey.model.UserGroupExample;
import com.lwch.survey.pojo.PageParm;
import com.lwch.survey.service.UserGroupService;
import com.lwch.survey.utils.ServiceUtils;


@Service
public class UserGroupServiceImpl implements UserGroupService{

    @Autowired
    private UserGroupMapper userGroupMapper;
    
    @Autowired
    private MenuUsergroupMemberMapper menuUsergroupMemberMapper;
    
    @Autowired
    private MenuMapper menuMapper;
    
    @Autowired
    private GroupMemberMapper groupMemberMapper;
    
    @Autowired
    private GroupRoleMapper groupRoleMapper;
    
    @Autowired
    private GroupsMapper groupsMapper;
    
    
    @Override
    public UserGroup selectByPrimaryKey(Long id) {
        return userGroupMapper.selectByPrimaryKey(id);
    }
    
    @Override
    public  List<UserGroup> selectByExample(UserGroupExample userGroupExample, PageParm pageParm) {
        ServiceUtils.startPage(pageParm);
        return userGroupMapper.selectByExample(userGroupExample);
    }
    
    @Override
    public List<UserGroup> selectByExample() {
        return userGroupMapper.selectByExample(new UserGroupExample());
    }
    
    @Override
    public List<Menu> selectMenus(Long id) {
        MenuUsergroupMemberExample userGroupMenuExample = new MenuUsergroupMemberExample();
        userGroupMenuExample.createCriteria().andGroupIdEqualTo(id);
        
        List<MenuUsergroupMember> userGroupMenus = menuUsergroupMemberMapper.selectByExample(userGroupMenuExample);
        
        List<Long> menuIds = new ArrayList<>();
        for (MenuUsergroupMember userGroupMenu : userGroupMenus) {
            menuIds.add(userGroupMenu.getMenuId());
        }
        
        if (menuIds.isEmpty()) {
            return Collections.emptyList();
        }
        
        MenuExample menuExample = new MenuExample();
        menuExample.createCriteria().andIdIn(menuIds);
        
        List<Menu> menus = menuMapper.selectByExample(menuExample);
        
        return menus;
    }

    @Override
    public int deleteMenus(Long id, List<Long> menuIds) {
        if (menuIds == null || menuIds.isEmpty()) {
            return 0;
        }
        
        MenuUsergroupMemberExample menuUsergroupMemberExample = new MenuUsergroupMemberExample();
        menuUsergroupMemberExample.createCriteria().andGroupIdEqualTo(id).andMenuIdIn(menuIds);
        
        return menuUsergroupMemberMapper.deleteByExample(menuUsergroupMemberExample);
    }

    @Override
    public int getCount() {
        UserGroupExample usergroupsExample = new UserGroupExample();
        
        return (int) userGroupMapper.countByExample(usergroupsExample);
    }

    @Override
    public int insertUsers(Long id, List<String> userNames) {
        if (CollectionUtils.isEmpty(userNames)) {
            return 0;
        }
        
        GroupMemberExample groupMemberExample = new GroupMemberExample();
        groupMemberExample.createCriteria().andGroupIdEqualTo(id).andUsernameIn(userNames);
        
        List<GroupMember> existGroupMember = groupMemberMapper.selectByExample(groupMemberExample);
        
        Set<String> needInsertUsernames = new HashSet<>(userNames);
        
        for (GroupMember groupMember : existGroupMember) {
            needInsertUsernames.remove(groupMember.getUsername());
        }
        
        for (String userName : needInsertUsernames) {
            GroupMember groupMember = new GroupMember();
            groupMember.setGroupId(id);
            groupMember.setUsername(userName);
            
            groupMemberMapper.insert(groupMember);
        }
        
        return needInsertUsernames.size();
    }

    @Override
    public int deleteUsers(Long id, List<String> userNames) {
        if (CollectionUtils.isEmpty(userNames)) {
            return 0;
        }
        
        GroupMemberExample groupMemberExample = new GroupMemberExample();
        groupMemberExample.createCriteria().andGroupIdEqualTo(id).andUsernameIn(userNames);
        
        return groupMemberMapper.deleteByExample(groupMemberExample);
    }

    @Override
    public int deleteUserGroup(String name) {
        if(!StringUtils.isNotBlank(name)){
            return 0;
        }
        
        UserGroupExample usergroupsExample = new UserGroupExample();
        usergroupsExample.createCriteria().andGroupNameEqualTo(name);
        
        List<UserGroup> groups = userGroupMapper.selectByExample(usergroupsExample);
        List<Long> groupids = groups.stream().map(group -> group.getId()).collect(Collectors.toList());
        
        GroupMemberExample memberExample = new GroupMemberExample();
        memberExample.createCriteria().andGroupIdIn(groupids);
        groupMemberMapper.deleteByExample(memberExample);
        
        MenuUsergroupMemberExample menuExample = new MenuUsergroupMemberExample();
        menuExample.createCriteria().andGroupIdIn(groupids);
        menuUsergroupMemberMapper.deleteByExample(menuExample);
        
        return userGroupMapper.deleteByExample(usergroupsExample);
    }

    @Override
    public List<GroupRole> selectByGroupRoles() {
        GroupRoleExample example = new GroupRoleExample();
        return groupRoleMapper.selectByExample(example);
    }

    @Override
    public List<Groups> selectGroupInfo(String name) {
        
        GroupsExample groupsExample = new GroupsExample();
        groupsExample.createCriteria().andGroupNameEqualTo(name);
        List<Groups> groupRecord = groupsMapper.selectByExample(groupsExample);
        if(!CollectionUtils.isEmpty(groupRecord)) {
            return groupRecord;
        }
        return Collections.emptyList();
    }

}
