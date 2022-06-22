package com.lwch.survey.security;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class MyUser extends User{
    
    private static final long serialVersionUID = -814031798199130344L;
    
    private ExtendUser extendUser;
    
    public ExtendUser getExtendUser() {
        return extendUser;
    }

    public void setExtendUser(ExtendUser extendUser) {
        this.extendUser = extendUser;
    }

    public MyUser(String username, String password, boolean enabled, boolean accountNonExpired,
            boolean credentialsNonExpired, boolean accountNonLocked,
            Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }
      
    public MyUser(String username, String encode, Set<SimpleGrantedAuthority> singleton) {
        super(username, encode, singleton);
    }
    
}
