package com.lwch.survey.security;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.util.Assert;

public class MyJdbcUserDetailsManager extends JdbcUserDetailsManager{
    
    private String usersByUsernameQuery = "select username,realname,user_type,email,phone,password,account_non_expired,credentials_non_expired,account_non_locked,enabled from users where username = ?";
    
    public String createUserSql = "insert into users (username, realname, email, phone, user_type, password, enabled) values (?,?,?,?,?,?,?)";
    
    public String createAuthoritySql = "insert into authorities (username, authority) values (?,?)";
    
    public MyJdbcUserDetailsManager() {
        setChangePasswordSql("update users set credentials_non_expired = 1, credentials_effective_time = CURRENT_TIMESTAMP, password = ? where username = ?");
    }
    
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        List<UserDetails> users = null;
        
        try{
            users = loadUsersByUsername(username);
        }catch(RuntimeException ex){
            throw new CannotGetJdbcConnectionException("登录异常！", null);
        }

        if (users.size() == 0) {
            this.logger.debug("Query returned no results for user '" + username + "'");

            throw new UsernameNotFoundException(
                    this.messages.getMessage("JdbcDaoImpl.notFound",
                            new Object[] { username }, "Username {0} not found"));
        }

        MyUser user = (MyUser)users.get(0); // contains no GrantedAuthority[]

        Set<GrantedAuthority> dbAuthsSet = new HashSet<GrantedAuthority>();

        if (getEnableAuthorities()) {
            dbAuthsSet.addAll(loadUserAuthorities(user.getUsername()));
        }

        if (getEnableGroups()) {
            dbAuthsSet.addAll(loadGroupAuthorities(user.getUsername()));
        }

        List<GrantedAuthority> dbAuths = new ArrayList<GrantedAuthority>(dbAuthsSet);

        addCustomAuthorities(user.getUsername(), dbAuths);

        if (dbAuths.size() == 0) {
            this.logger.debug("User '" + username
                    + "' has no authorities and will be treated as 'not found'");

            throw new UsernameNotFoundException(this.messages.getMessage(
                    "JdbcDaoImpl.noAuthority", new Object[] { username },
                    "User {0} has no GrantedAuthority"));
        }

        return createUserDetails(username, user, dbAuths);
    }
    
    public void createUser(final UserDetails user) {
        MyUser myUser = (MyUser)user;
        validateUserDetails(myUser);
        getJdbcTemplate().update(createUserSql, new PreparedStatementSetter() {
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, myUser.getUsername());
                ps.setString(2, myUser.getExtendUser().getRealname());
                ps.setString(3, myUser.getExtendUser().getEmail());
                ps.setString(4, myUser.getExtendUser().getPhone());
                ps.setInt(5, myUser.getExtendUser().getUserType());
                ps.setString(6, myUser.getPassword());
                ps.setBoolean(7, myUser.isEnabled());
            }

        });

        if (getEnableAuthorities()) {
            insertUserAuthorities(myUser);
        }
    }
    
    protected List<UserDetails> loadUsersByUsername(String username) {
        return getJdbcTemplate().query(this.usersByUsernameQuery,
                new String[] { username }, new RowMapper<UserDetails>() {
                    public UserDetails mapRow(ResultSet rs, int rowNum)
                            throws SQLException {
                        String username = rs.getString(1);
                        String password = rs.getString(6);
                        boolean accountNonExpired = rs.getBoolean(7);
                        boolean credentialsNonExpired = rs.getBoolean(8);
                        boolean accountNonLocked = rs.getBoolean(9);
                        boolean enabled = rs.getBoolean(10);
                        
                        MyUser user = new MyUser(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, AuthorityUtils.NO_AUTHORITIES);
                        
                        user.setExtendUser(new BeanPropertyRowMapper<ExtendUser>(
                        ExtendUser.class).mapRow(rs, rowNum));
                        return user;
                    }
                });
    }
    
    protected UserDetails createUserDetails(String username,
            MyUser userFromUserQuery, List<GrantedAuthority> combinedAuthorities) {
        String returnUsername = userFromUserQuery.getUsername();
        
        MyUser newUser = new MyUser(returnUsername, userFromUserQuery.getPassword(),
                        userFromUserQuery.isEnabled(), userFromUserQuery.isAccountNonExpired(), 
                        userFromUserQuery.isCredentialsNonExpired(), userFromUserQuery.isAccountNonLocked(), 
                        combinedAuthorities);
        
        newUser.setExtendUser(userFromUserQuery.getExtendUser());
        
        return newUser;
    }
    
    private void validateUserDetails(UserDetails user) {
        Assert.hasText(user.getUsername(), "Username may not be empty or null");
        validateAuthorities(user.getAuthorities());
    }

    private void validateAuthorities(Collection<? extends GrantedAuthority> authorities) {
        Assert.notNull(authorities, "Authorities list must not be null");

        for (GrantedAuthority authority : authorities) {
            Assert.notNull(authority, "Authorities list contains a null entry");
            Assert.hasText(authority.getAuthority(),
                    "getAuthority() method must return a non-empty string");
        }
    }
    
    private void insertUserAuthorities(UserDetails user) {
        for (GrantedAuthority auth : user.getAuthorities()) {
            getJdbcTemplate().update(createAuthoritySql, user.getUsername(),
                    auth.getAuthority());
        }
    }
}
