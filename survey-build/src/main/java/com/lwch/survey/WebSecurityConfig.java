package com.lwch.survey;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.lwch.survey.security.ADAuthenticationProvider;
import com.lwch.survey.security.MyJdbcUserDetailsManager;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  /*  @Autowired
    private CustomRoleVoter customRoleVoter;*/
    
    private MyJdbcUserDetailsManager jdbcUserDetailsManager = new MyJdbcUserDetailsManager();
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().frameOptions().sameOrigin();
        
        http.authorizeRequests().antMatchers("/css/**").permitAll();
        http.authorizeRequests().antMatchers("/img/**").permitAll();
        http.authorizeRequests().antMatchers("/js/**").permitAll();
        
        /*http.authorizeRequests().antMatchers("/v2/api-docs","/configuration/ui",
                "/swagger-resources","/configuration/security","swagger-ui.html","/webjars/**");*/
        
        http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().antMatchers("/error").permitAll();
        
        http.authorizeRequests().antMatchers("/error").permitAll();
        
        http.authorizeRequests().antMatchers("/open/**").permitAll();
        
        http.authorizeRequests().anyRequest().authenticated();
        
        http.authorizeRequests().and().rememberMe().tokenValiditySeconds(86400);
        
        http.sessionManagement().maximumSessions(1).maxSessionsPreventsLogin(false).expiredUrl("/login?expired");;
                
        http.formLogin().loginPage("/login").defaultSuccessUrl("/", true);
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
         web.ignoring().antMatchers("/css/**", "/js/**");
    }
    
    @Autowired
    public void configure(AuthenticationManagerBuilder auth, AuthenticationEventPublisher authenticationEventPublisher) throws Exception {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(jdbcUserDetailsManager);
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        authenticationProvider.setPostAuthenticationChecks(new UserDetailsChecker() {
            @Override
            public void check(UserDetails toCheck) {
            }
        });
        
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("i18n/messages");
        messageSource.setCacheSeconds(-1);
        
        authenticationProvider.setMessageSource(messageSource);
        
        auth.authenticationProvider(authenticationProvider);
        
        auth.authenticationEventPublisher(authenticationEventPublisher);
    }
    
    @Override
    protected UserDetailsService userDetailsService() {
        return jdbcUserDetailsManager;
    }
    
    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
    @Bean
    public MyJdbcUserDetailsManager getUserDetailsManager(@Qualifier("localDataSource") DataSource dataSource, AuthenticationManager authenticationManager) {
        jdbcUserDetailsManager.setDataSource(dataSource);
        jdbcUserDetailsManager.setAuthenticationManager(authenticationManager);
        return jdbcUserDetailsManager;
    }
    

    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return passwordEncoder;
    }
    
    @Bean
    public ADAuthenticationProvider adAuthenticationProvider() {
        return new ADAuthenticationProvider();
    }
    
/*    @Bean
    @Autowired
    public TokenStoreUserApprovalHandler userApprovalHandler(TokenStore tokenStore){
        TokenStoreUserApprovalHandler handler = new TokenStoreUserApprovalHandler();
        handler.setTokenStore(tokenStore);
        handler.setRequestFactory(new DefaultOAuth2RequestFactory(clientDetailsService));
        handler.setClientDetailsService(clientDetailsService);
        return handler;
    }*/
    
    /*@Bean
    @Autowired
    public ApprovalStore approvalStore(TokenStore tokenStore) throws Exception {
        TokenApprovalStore store = new TokenApprovalStore();
        store.setTokenStore(tokenStore);
        return store;
    }*/
    
 /*   @Override
    public void configure(WebSecurity web) throws Exception {
      web.ignoring()
        .antMatchers("/login");
    }*/
    
    /*
    protected AccessDecisionManager accessDecisionManager() {
        List<AccessDecisionVoter<? extends Object>> decisionVoters = new ArrayList<AccessDecisionVoter<? extends Object>>();
        decisionVoters.add(new RoleVoter());
        decisionVoters.add(new AuthenticatedVoter());
        decisionVoters.add(customRoleVoter);
        return new AffirmativeBased(decisionVoters);
    }*/
}
