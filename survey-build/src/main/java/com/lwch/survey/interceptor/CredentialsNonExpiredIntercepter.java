package com.lwch.survey.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CredentialsNonExpiredIntercepter extends HandlerInterceptorAdapter{

    private final String MODIFY_PASSWORD_URL = "/page/firstmodifypassword.html";
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (request.getRequestURI().equals(MODIFY_PASSWORD_URL)
            || request.getRequestURI().equals("/self")
            || request.getRequestURI().equals("/self/changePassword")) {
            return true;
        }
        
        SecurityContext securityContext = SecurityContextHolder.getContext();
        
        Authentication authentication = securityContext.getAuthentication();
        
        if (authentication == null) {
            return true;
        }
        
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails user = (UserDetails) principal;
            if (user.isCredentialsNonExpired()) {
                return true;
            } else {
                response.sendRedirect(MODIFY_PASSWORD_URL);
                
                return false;
            }
        } else {
            return true;
        }
    }
    
}
