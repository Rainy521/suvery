package com.lwch.survey.controller;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.GroupManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lwch.survey.model.Groups;
import com.lwch.survey.service.MenuService;
import com.lwch.survey.service.UserGroupService;


@PreAuthorize("hasAuthority('ADMIN')")
@RestController
@RequestMapping("/manage/usergroup")
public class UserGroupManageController {
    @Autowired
    private GroupManager groupManager;
    
    @Autowired
    private UserGroupService userGroupService;
    
    @Autowired
    private MenuService resourceService;
    
    @Autowired
    private UserDetailsManager userDetailsManager;
    

    @PostMapping("/{name}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createUserGroup(@PathVariable String name) {
        
        List<Groups> record = userGroupService.selectGroupInfo(name);
        if(!CollectionUtils.isEmpty(record)) {
            throw new RuntimeException("该用户组【"+ name+"】已存在！！！");
        }
        groupManager.createGroup(name, Collections.emptyList());
    }
    
    @DeleteMapping("/{name}")
    public void deleteUserGroup(@PathVariable String name) {
        
        userGroupService.deleteUserGroup(name);
    }
    
    @PutMapping("/{name}/name/{newname}")
    public void renameGroup(@PathVariable String name, @PathVariable String newname) {
        
        List<Groups> record = userGroupService.selectGroupInfo(newname);
        if(!CollectionUtils.isEmpty(record)) {
            throw new RuntimeException("该用户组【"+ newname+"】已存在！！！");
        }
        
        groupManager.renameGroup(name, newname);
    }
    
    @PutMapping("/{name}/roles")
    public void saveRoles(@PathVariable String name, @RequestBody Set<String> roles) {
        
        Collection<String> oldRoles = getRoles(name);
        
        Collection<String> needToRemoveRoles = new HashSet<>(oldRoles);
        needToRemoveRoles.removeAll(roles);
        
        for (String role : needToRemoveRoles) {
            groupManager.removeGroupAuthority(name, new SimpleGrantedAuthority(role));
        }
        
        Collection<String> needToAddRoles = new HashSet<>(roles);
        needToAddRoles.removeAll(oldRoles);
        
        for (String role : needToAddRoles) {
            groupManager.addGroupAuthority(name, new SimpleGrantedAuthority(role));
        }
    }
    
    @PostMapping("/{id}/menus/add")
    public void addMenus(@PathVariable Long id, @RequestBody List<Long> menuIds) {
        
        resourceService.insertMenus(id, menuIds);
    }
    
    @PostMapping("/{id}/menus/remove")
    public void removeMenus(@PathVariable Long id, @RequestBody List<Long> menuIds) {
        
        userGroupService.deleteMenus(id, menuIds);
    }
    
    @PostMapping("/{id}/users/add/{isAdmin}")
    public void addUsers(@PathVariable Long id, @RequestBody List<String> userNames, @PathVariable boolean isAdmin) {
        
        for(String name : userNames){
            if(isAdmin){
                Set<String> roles = new HashSet<>();
                roles.add("ADMIN");
                updateRoles(name, roles);
            }
        }
        userGroupService.insertUsers(id, userNames);
    }
    
    @PostMapping("/{id}/users/remove/{isAdmin}")
    public void removeUsers(@PathVariable Long id, @RequestBody List<String> userNames, @PathVariable boolean isAdmin) {
        
        for(String name : userNames){
            if(isAdmin){
                Set<String> roles = new HashSet<>();
                roles.add("USER");
                updateRoles(name, roles);
            }
        }
        userGroupService.deleteUsers(id, userNames);
    }
    
    @PostMapping("/{groupName}/users/roles/add")
    public void addGroupRoles(@PathVariable String groupName, @RequestBody Set<String> groupRoles) {
        
        Set<String> set = new HashSet<>(groupRoles);
        for(String str : set) {
            groupManager.addGroupAuthority(groupName, new SimpleGrantedAuthority(str));
        }
    }
    
    @PostMapping("/{groupName}/{groupRole}/users/roles/remove")
    public void deleteGroupRoles(@PathVariable String groupName, @PathVariable String groupRole) {
        
        groupManager.removeGroupAuthority(groupName, new SimpleGrantedAuthority(groupRole));
    }
    
    private Collection<String> getRoles(@PathVariable String name) {
        Collection<? extends GrantedAuthority> authorities = groupManager.findGroupAuthorities(name);
        List<String> roles = new LinkedList<>();
        
        for (GrantedAuthority authority : authorities) {
            roles.add(authority.getAuthority());
        }
        
        return roles;
    }
    
    private void updateRoles(String name, Set<String> roles) {
        
        UserDetails userDetails = userDetailsManager.loadUserByUsername(name);
        
        List<SimpleGrantedAuthority> authorities = new LinkedList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        
        org.springframework.security.core.userdetails.User user = 
                new org.springframework.security.core.userdetails.User(
                        name, userDetails.getPassword(), authorities);
        
        userDetailsManager.updateUser(user);
    }
}
