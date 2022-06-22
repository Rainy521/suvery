package com.lwch.survey.security;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.lwch.survey.service.UserService;

@Component
public class AuthenticationListener implements AuthenticationEventPublisher{
    
    private ConcurrentMap<String, AtomicInteger> lockUsers = new ConcurrentHashMap<>();
    
    @Autowired
    private UserService userService;
    
    @Override
    public void publishAuthenticationFailure(AuthenticationException exception, Authentication authentication) {
        if (exception instanceof BadCredentialsException && authentication.getPrincipal() instanceof String) {
            String username = (String)authentication.getPrincipal();
            addCount(username);
        }
    }
    
    @Override
    public void publishAuthenticationSuccess(Authentication authentication) {
        String username = ((UserDetails)authentication.getPrincipal()).getUsername();
        cleanCount(username);
    }
    
    private void addCount(String username) {
        AtomicInteger count = lockUsers.get(username);
        if (count == null) {
            lockUsers.putIfAbsent(username, new AtomicInteger(0));
            count = lockUsers.get(username);
        }
        
        if (count.get() > 3) {
            userService.lockUser(username);
            cleanCount(username);
        } else {
            count.incrementAndGet();
        }
    }
    
    private void cleanCount(String username) {
        lockUsers.remove(username);
    }
}
