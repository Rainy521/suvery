package com.lwch.survey.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lwch.survey.model.User;
import com.lwch.survey.model.UserGroup;
import com.lwch.survey.security.ExtendUser;
import com.lwch.survey.security.MyUser;
import com.lwch.survey.service.UserService;

//@PreAuthorize("hasAuthority('ADMIN')")
@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserDetailsManager userDetailsManager;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private UserService userService;
    
    @GetMapping
    public List<User> getUsers(@RequestParam(required=false) String q,
                               @RequestParam(required=false, defaultValue="-1") int userType,
                               @RequestParam(required=false, defaultValue="1") int pageNum, 
                               @RequestParam(required=false, defaultValue="10") int pageSize) {
        List<User> users =  userService.selectALLUsers(q, userType, pageNum, pageSize);
        for (User user : users) {
            user.setPassword("");
        }
        return users;
    }
    
    @GetMapping("/count")
    public long getCount(@RequestParam(required=false) String q ,@RequestParam(required=false, defaultValue="-1") int userType) {
        return userService.getCount(q ,userType);
    }
    
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        
        if (StringUtils.isBlank(user.getPassword())) {
            user.setPassword("pwd123456");
        }
        
        MyUser userDetails = 
               new MyUser(user.getUsername(), 
                        passwordEncoder.encode(user.getPassword()),
                        Collections.singleton(new SimpleGrantedAuthority("USER")));
        
        ExtendUser extendUser = new ExtendUser();
        
        extendUser.setRealname(user.getRealname());
        extendUser.setEmail(user.getEmail());
        extendUser.setPhone(user.getPhone());
        extendUser.setUserType(user.getUserType());
        
        userDetails.setExtendUser(extendUser);
        
        if(getUser(user.getUsername()) == null){
            userDetailsManager.createUser(userDetails);
        }
        else {
        	userService.updateUser(user);
            //throw new RuntimeException("该用户已存在");
        }
        return getUser(user.getUsername());
    }
    
    @GetMapping("/{username}")
    public User getUser(@PathVariable String username) {
        try {
            UserDetails userDetails = userDetailsManager.loadUserByUsername(username);
            User user = convert(userDetails);
            return user;
        } catch (UsernameNotFoundException e) {
            return null;
        }
    }
    
    @GetMapping("/getOne/{username}")
    public User getOne(@PathVariable String username) {
        try {
            User user = userService.selectByPrimaryKey(username);
            return user;
        } catch (UsernameNotFoundException e) {
            return null;
        }
    }
    
    @PutMapping("/{username}")
    public User saveUser(@PathVariable String username, @RequestBody User user) {
        
        org.springframework.security.core.userdetails.User userDetails = 
                new org.springframework.security.core.userdetails.User(username, 
                        passwordEncoder.encode(user.getPassword()), 
                        Collections.singleton(new SimpleGrantedAuthority("USER")));
        userDetailsManager.updateUser(userDetails);
        
        return getUser(user.getUsername());
    }
    
    @DeleteMapping("/{username}")
    public void deleteUser(@PathVariable String username) {
        
        List<UserGroup> groups = getGroups(username);
        List<Long> groupIds = new ArrayList<>(groups.size());
        for (UserGroup group : groups) {
            groupIds.add(group.getId());
        }
        
        userService.deleteGroups(username, groupIds);
        
        userDetailsManager.deleteUser(username);
    }
    
    @PutMapping("/{username}/restPassword")
    public void restPassword(@PathVariable String username) {
        
        userService.resetPassword(username, passwordEncoder.encode("pwd123456"));
    }
    
    @PutMapping("/{username}/resetNonLocked")
    public void resetNonLocked(@PathVariable String username) {
        
        userService.unlockUser(username);
    }
    
    @GetMapping("/{username}/roles")
    public Collection<String> getRoles(@PathVariable String username) {
        try {
            UserDetails userDetails = userDetailsManager.loadUserByUsername(username);
            Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
            List<String> roles = new LinkedList<>();
            
            for (GrantedAuthority authority : authorities) {
                roles.add(authority.getAuthority());
            }
            
            return roles;
        } catch (UsernameNotFoundException e) {
            return null;
        }
    }
    
    @PutMapping("/{username}/roles")
    public void saveRoles(@PathVariable String username, @RequestBody Set<String> roles) {
        try {
            
            UserDetails userDetails = userDetailsManager.loadUserByUsername(username);
            
            roles.add("USER");
            
            List<SimpleGrantedAuthority> authorities = new LinkedList<>();
            for (String role : roles) {
                authorities.add(new SimpleGrantedAuthority(role));
            }
            
            org.springframework.security.core.userdetails.User user = 
                    new org.springframework.security.core.userdetails.User(
                            username, userDetails.getPassword(), authorities);
            
            userDetailsManager.updateUser(user);
        } catch (UsernameNotFoundException e) {
        }
    }
    
    @GetMapping("/{username}/groups")
    public List<UserGroup> getGroups(@PathVariable String username) {
        List<UserGroup> userGroups = userService.selectUserGroupByName(username);
        return userGroups;
    }
    
    @PutMapping("/{name}/{nickName}/changeNickname")
    public void changeNickname(@PathVariable String name, @PathVariable String nickName) {
        
        userService.resetNickname(name, nickName);
    }
    
    private User convert(UserDetails userDetails) {
        User user = new User();
        user.setUsername(userDetails.getUsername());
        user.setEnabled(userDetails.isEnabled());
        
        return user;
    }
}
