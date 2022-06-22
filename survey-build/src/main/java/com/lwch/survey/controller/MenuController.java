package com.lwch.survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lwch.survey.controller.utils.Utils;
import com.lwch.survey.model.Menu;
import com.lwch.survey.service.MenuService;

@RestController
@RequestMapping("/menu")
public class MenuController {
    
    @Autowired
    private MenuService menuService;
    
    @GetMapping
    public List<Menu> getResource() {
        return menuService.selectMenuList();
    }
    
    @GetMapping("/byUsername")
    public List<Menu> getMenuByUsername() {
        return menuService.selectMenuByRoleByName(Utils.getCurrentUsername());
    }
    
}
