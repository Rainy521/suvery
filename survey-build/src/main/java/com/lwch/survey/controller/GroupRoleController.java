package com.lwch.survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lwch.survey.model.GroupRole;
import com.lwch.survey.model.GroupRoleExample;
import com.lwch.survey.pojo.PageParm;
import com.lwch.survey.service.GroupRoleService;

@RestController
@RequestMapping("/grouprole")
public class GroupRoleController {

    @Autowired
    private GroupRoleService groupRoleService;
    
    @GetMapping
    public List<GroupRole> getUserGroupRoles(@RequestParam(required=false, defaultValue="1") int pageNum, @RequestParam(required=false, defaultValue="10") int pageSize) {
        GroupRoleExample example = new GroupRoleExample();
        
        return groupRoleService.selectByExample(example, new PageParm(pageNum, pageSize, "id"));
    }
    
    @GetMapping("/count")
    public long getCount() {
        return groupRoleService.getCount();
    }
    
    @GetMapping("/{id}")
    public GroupRole get(@PathVariable Long id) {
        return groupRoleService.selectByPrimaryKey(id);
    }
}
