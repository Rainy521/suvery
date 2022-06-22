package com.lwch.survey.controller;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lwch.survey.model.Config;
import com.lwch.survey.service.ConfigService;
import com.lwch.survey.utils.ConfigUtils;

@PreAuthorize("hasAuthority('ADMIN')")
@RestController
@RequestMapping("/manage/configs")
public class ConfigManageController {
    
    @Autowired
    private ConfigService configService;
    
    @PutMapping("/{name:.+}")
    public void saveConfig(@PathVariable String name, @RequestBody Config config) {
        
        config.setName(name);
        
        if (!ConfigUtils.validation(config.getValue(), config.getType(), config.getIsArray())) {
            throw new ValidationException("配置不合法。");
        }
        
        if (configService.selectConfig(name) != null) {
            configService.updateConfig(config);
        } else {
            configService.saveConfig(config);
        }
    }
    
    @DeleteMapping("/{name:.+}")
    public void deleteConfig(@PathVariable String name) {
        
        configService.deleteConfig(name);
    }
}
