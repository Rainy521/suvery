package com.lwch.survey.page.controller;

import org.springframework.stereotype.Controller;

@Controller
public class PluginManagerWelcomeController {
    /*@Autowired
    private MenuService resourceService;
    
    @RequestMapping("/pm")
    public String index(Model model) {
        List<Menu> menus = resourceService.selectMenuByRole(Utils.getCurrentUsername());
        Menu menu = menus.stream().filter(m -> (m.getId() == 110000)).findFirst().orElse(null);
        
        model.addAttribute("menus", menu == null ? Collections.emptyList() : menu.getChildren());
        return "forward:/page/index.html";
    }*/
}
