package com.lwch.survey.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lwch.survey.model.Menu;
import com.lwch.survey.service.MenuService;

@RestController
@RequestMapping("/self")
public class SelfController {
    @Autowired
    private UserDetailsManager userDetailsManager;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private MenuService resourceService;
    
    
    @GetMapping
    Object get() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal;
    }
    
    @GetMapping("/selectBsName")
    public Map<String, String> getUserAttribute() {
        Map<String, String> userAttribute = new HashMap<>();
        
        userAttribute.put("bsName", "测试平台管理员");
        
        return userAttribute;
    }
    
    @PostMapping("/changePassword")
    public void changePassword(@RequestParam(required=true) String oldPassword, @RequestParam(required=true) String newPassword) {
        if (!validatePWD(newPassword)) {
            throw new RuntimeException("密码不满足要求，请设置新密码。");
        }
        
        try {
            userDetailsManager.changePassword(oldPassword, passwordEncoder.encode(newPassword));
        } catch (BadCredentialsException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    /**
     * 密码必须大于8位，必须包含数字、大小写字母以及其他特殊字符
     */
    public static boolean validatePWD(String pwd) {
        if (StringUtils.isBlank(pwd)) {
            return false;
        }
        
        if (pwd.length() < 8) {
            return false;
        }
        
        int r = 0;
        for (int i = 0; i < pwd.length(); i++) {
            char c = pwd.charAt(i);
            
            if (c >= 'a' && c <= 'z') {
                r = r | 1;
            } else if (c >= 'A' && c <= 'Z') {
                r = r | 2;
            } else if (c >= '0' && c <= '9') {
                r = r | 4;
            } else {
                r = r | 8;
            }
        }
        
        return r == 15;
    }
    
    @GetMapping(value="/{username}/distributed")
    public List<Menu> getResourceByRole(@PathVariable String username) {
        return resourceService.selectMenuByRole(username);
    }
    
    @GetMapping(value="/{groupId}/undistributed")
    public List<Menu> getUnDistributedResource(@PathVariable Long groupId) {
        return resourceService.selectUnDistributed(groupId);
    }
}
