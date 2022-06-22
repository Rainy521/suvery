package com.lwch.survey.controller.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class Utils {
    public static String getCurrentUsername() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        
        Authentication authentication = securityContext.getAuthentication();
        
        if (authentication == null) {
            return "noauthentication";
        }
        
        Object principal = authentication.getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        
        return username;
    }
}
