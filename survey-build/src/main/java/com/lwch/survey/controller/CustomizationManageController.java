package com.lwch.survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lwch.survey.controller.utils.Utils;
import com.lwch.survey.model.Customization;
import com.lwch.survey.service.CustomizationService;

@RestController
@RequestMapping("/manage/customization")
public class CustomizationManageController {

    @Autowired
    private CustomizationService customizationService;
    
//    @Autowired
//    private UserService userService;
    
    @PostMapping("/{id}/{type}/customization/add")
    public void save(@PathVariable String id, @PathVariable String type, @RequestBody Customization customization){
        
        customizationService.saveCustomizationt(customization, id, Utils.getCurrentUsername(), type);
    }
    
    @GetMapping("/{id}/customization/remove")
    public void remove(@PathVariable String id){
        
        customizationService.deleteCustomizationt(id);
    }
    
    @PostMapping("/{id}/customization/share")
    public void share(@PathVariable String id, @RequestBody List<Long> groups){
        
        customizationService.insertShareCustomizationt(id, groups);
    }
    
    @GetMapping("/{id}/share/remove")
    public void removeShare(@PathVariable String id) {
        
        customizationService.deleteShareByCusId(id);
//        List<UserGroup> groups = userService.selectUserGroupByName(Utils.getCurrentUsername());
//        customizationService.deleteShare(groups.stream().map(group -> group.getId()).collect(Collectors.toList()), id);
    }
}
