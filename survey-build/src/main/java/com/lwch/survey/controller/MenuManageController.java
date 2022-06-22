package com.lwch.survey.controller;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lwch.survey.model.Menu;
import com.lwch.survey.service.MenuService;

@PreAuthorize("hasAuthority('ADMIN')")
@RestController
@RequestMapping("/manage/menus")
public class MenuManageController {
    
    @Autowired
    private MenuService menuService;
    
    @PostMapping
    public void createResource(@RequestBody Menu menu){
        
        /**
         * 菜单去重，菜单名称，菜单路径
         */
        List<Menu> menus = menuService.selectByExample(menu.getName());
        if(!CollectionUtils.isEmpty(menus)){
        	throw new RuntimeException("菜单名称  "+menu.getName()+" 已存在,请重新编辑!"); 
        }
        menuService.saveMenu(menu);
    }
    
    @PostMapping("/remove")
    public void removeMenus(@RequestBody List<Long> menuIds) {
        
        menuService.deleteMenus(menuIds);
    }
}
