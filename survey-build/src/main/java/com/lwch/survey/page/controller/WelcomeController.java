package com.lwch.survey.page.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lwch.survey.controller.utils.Utils;
import com.lwch.survey.model.Menu;
import com.lwch.survey.service.MenuService;

@Controller
public class WelcomeController {
    @Autowired
    private MenuService menuService;
    
    @RequestMapping("/")
    public String index(Model model) {
        List<Menu> menus = menuService.selectMenuByRole(Utils.getCurrentUsername());
        model.addAttribute("menus", menus);
        return "forward:/page/index.html";
    }
}
