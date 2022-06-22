package com.lwch.survey.page.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {
    
    @Autowired
    HttpServletRequest httpServletRequest;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {
        ModelAndView model = new ModelAndView();
        
        if (logout != null) {
            model.addObject("msg", "您已成功注销系统.");
        }
        
        Principal principal = httpServletRequest.getUserPrincipal();
        
        if (principal != null) {
            model.setViewName("redirect:/");
        } else {
            model.setViewName("login.html");
        }
        
        return model;
    }
}
