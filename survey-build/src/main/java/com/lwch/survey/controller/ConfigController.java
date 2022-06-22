package com.lwch.survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lwch.survey.model.Config;
import com.lwch.survey.service.ConfigService;

@RestController
@RequestMapping("/configs")
public class ConfigController {
    
    @Autowired
    private ConfigService configService;
    
    @GetMapping
    public List<Config> getConfigs(@RequestParam String prefix) {
        return configService.selectConfigs(prefix);
    }
    
    @GetMapping("/names/{name:.+}")
    public List<Config> getUser(@PathVariable String name) {
        return configService.selectConfigs(name);
    }
    
    @GetMapping("/{name}")
    public Config getConfigByName(@PathVariable String name) {
        return configService.selectConfig(name);
    }
}
