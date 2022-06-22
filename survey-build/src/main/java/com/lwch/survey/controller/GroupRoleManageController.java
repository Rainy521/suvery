package com.lwch.survey.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.provisioning.GroupManager;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lwch.survey.model.GroupRole;
import com.lwch.survey.model.UserGroup;
import com.lwch.survey.service.GroupRoleService;
import com.lwch.survey.service.UserGroupService;

@PreAuthorize("hasAuthority('ADMIN')")
@RestController
@RequestMapping("/manage/grouprole")
public class GroupRoleManageController {
    
    @Autowired
    private GroupRoleService groupRoleService;
    
    @Autowired
    private GroupManager groupManager;
    
    @Autowired
    private UserGroupService userGroupService;
    
    @PostMapping
    public void save(@RequestBody GroupRole groupRole) {
        
        groupRoleService.save(groupRole);
    }
    
    @DeleteMapping("/{name}")
    public void deleteGroupRole(@PathVariable String name) {
        
        List<UserGroup> groups = userGroupService.selectByExample();
        List<String> names = groups.stream().map(group -> group.getGroupName()).collect(Collectors.toList());
        
        for(String groupName : names){
            groupManager.removeGroupAuthority(groupName, new SimpleGrantedAuthority(name));
        }
        
        groupRoleService.deleteGroupRole(name);
    }
}
