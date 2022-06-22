package com.lwch.survey.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lwch.survey.controller.utils.Utils;
import com.lwch.survey.model.Customization;
import com.lwch.survey.model.CustomizationGroupMembers;
import com.lwch.survey.model.CustomizationMembers;
import com.lwch.survey.model.UserGroup;
import com.lwch.survey.service.CustomizationService;
import com.lwch.survey.service.UserService;

@RestController
@RequestMapping("/customization")
public class CustomizationController {
    
    @Autowired
    private CustomizationService customizationService;
    
    @Autowired
    private UserService userService;

    @GetMapping("/{id}/customization")
    public Customization getCustomization(@PathVariable String id) {
        Customization customization = customizationService.selectByPrimaryKey(id);
        
        return customization;
    }
    
    @GetMapping("/{isAll}/types")
    public Map<String, String> getCustomizationTypes(@PathVariable boolean isAll) {
        List<UserGroup> groups = userService.selectUserGroupByName(Utils.getCurrentUsername());
        return customizationService.getCustomizationtTypes(isAll, Utils.getCurrentUsername(), 
        		customizationService.getCustomizationtByGroup(groups.stream().map(group -> group.getId()).collect(Collectors.toList())));
    }
    
    @GetMapping("/{id}/assigned")
    public List<CustomizationGroupMembers> getAssignedGroup(@PathVariable String id) {
        return customizationService.selectAssignedGroup(id);
    }
    
    @GetMapping("/share")
    public List<CustomizationMembers> getShareCustomizations() {
        List<UserGroup> groups = userService.selectUserGroupByName(Utils.getCurrentUsername());
        return customizationService.selectCustomizationMemberByGroup(groups.stream().map(group -> group.getId()).collect(Collectors.toList()));
    }
}
