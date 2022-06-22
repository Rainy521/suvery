package com.lwch.survey.page.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {
    
    @Autowired
    HttpServletRequest httpServletRequest;

    @RequestMapping("/**")
    public String page() {
        return httpServletRequest.getServletPath().substring(5);
    }
}
