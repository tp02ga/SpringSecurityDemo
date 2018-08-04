package com.coderscampus.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
  
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth
      .inMemoryAuthentication()
      .withUser("trevor@craftycodr.com")
      .password("password123")
      .roles("USER", "ADMIN");
  }
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .csrf().disable()
      .authorizeRequests()
        .antMatchers("/admin/**").hasAnyRole("ADMIN")
        .anyRequest().hasAnyRole("USER").and()
      .formLogin()
        .loginPage("/login")
        .defaultSuccessUrl("/dashboard")
        .permitAll();
      
  }
}
