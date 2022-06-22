package com.lwch.survey.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Component
public class CustomRoleVoter implements AccessDecisionVoter<FilterInvocation>  {

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;
    
    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }
    
    @Override
    public boolean supports(Class<?> clazz) {
        return (FilterInvocation.class.isAssignableFrom(clazz));
    }
    
    public int vote(Authentication authentication, FilterInvocation filterInvocation, Collection<ConfigAttribute> attributes) {
        if(authentication == null) {
            return ACCESS_DENIED;
        }
        
        try {
            HandlerExecutionChain handlerExecutionChain = requestMappingHandlerMapping.getHandler(filterInvocation.getRequest());
            if (handlerExecutionChain != null) {
                Object handler = handlerExecutionChain.getHandler();
                System.out.println(handler);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        System.out.println(filterInvocation.getRequestUrl());
        
//        int result = ACCESS_ABSTAIN;
//        Collection<? extends GrantedAuthority> authorities = extractAuthorities(authentication);
//
//        for (ConfigAttribute attribute : attributes) {
//            if (this.supports(attribute)) {
//                result = ACCESS_DENIED;
//
//                // Attempt to find a matching granted authority
//                for (GrantedAuthority authority : authorities) {
//                    if (attribute.getAttribute().equals(authority.getAuthority())) {
//                        return ACCESS_GRANTED;
//                    }
//                }
//            }
//        }

        return ACCESS_GRANTED;
    }
    
    Collection<? extends GrantedAuthority> extractAuthorities(
            Authentication authentication) {
        return authentication.getAuthorities();
    }

    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
        return requestMappingHandlerMapping;
    }

    public void setRequestMappingHandlerMapping(RequestMappingHandlerMapping requestMappingHandlerMapping) {
        this.requestMappingHandlerMapping = requestMappingHandlerMapping;
    }
}
