package com.lwch.survey.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.provisioning.GroupManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lwch.survey.model.GroupRole;
import com.lwch.survey.model.Menu;
import com.lwch.survey.model.UserGroup;
import com.lwch.survey.model.UserGroupExample;
import com.lwch.survey.pojo.PageParm;
import com.lwch.survey.service.UserGroupService;


@RestController
@RequestMapping("/usergroups")
public class UserGroupController {
    
    @Autowired
    private GroupManager groupManager;
    
    @Autowired
    private UserGroupService userGroupService;
    
    @GetMapping
    public List<UserGroup> getUserGroups(@RequestParam(required=false, defaultValue="1") int pageNum, @RequestParam(required=false, defaultValue="10") int pageSize) {
        UserGroupExample example = new UserGroupExample();
        
        return userGroupService.selectByExample(example, new PageParm(pageNum, pageSize, "id"));
    }
    
    @GetMapping("/count")
    public int getCount() {
        return userGroupService.getCount();
    }
    
    @GetMapping("/{id}")
    public UserGroup get(@PathVariable Long id) {
        return userGroupService.selectByPrimaryKey(id);
    }
    
    @GetMapping("/{name}/users")
    public List<String> getUsers(@PathVariable String name) {
        return groupManager.findUsersInGroup(name);
    }
    
    @GetMapping("/{name}/roles")
    public List<GrantedAuthority> getRoles(@PathVariable String name) {
        return groupManager.findGroupAuthorities(name);
    }
    
    @GetMapping("/{id}/menus")
    public List<Menu> getMenus(@PathVariable Long id) {
        List<Menu> menus = userGroupService.selectMenus(id);
        return menus;
    }
    
    @GetMapping("/selectRoles")
    public List<GroupRole> selectGroupRoles(){
        return userGroupService.selectByGroupRoles();
    }
}
