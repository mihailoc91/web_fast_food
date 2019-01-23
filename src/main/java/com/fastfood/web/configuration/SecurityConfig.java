/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fastfood.web.configuration;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

/**
 *
 * @author Mihailo
 */
@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
    @Autowired
    DataSource dataSource;

    @Override 
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("SELECT ime, lozinka, true FROM zaposleni WHERE ime=? AND tip_zaposlenog=2").
                authoritiesByUsernameQuery("SELECT ime, 'ROLE_MENADZER' from zaposleni where ime=?").and()
                .jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("SELECT ime,lozinka, true FROM zaposleni WHERE ime=? AND tip_zaposlenog=1").
                authoritiesByUsernameQuery("SELECT ime, 'ROLE_RADNIK' from zaposleni where ime=?" );
    }
    
 

    
     @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .formLogin()
                    .loginPage("/login").defaultSuccessUrl("/zaposleni")
                .and()
                .rememberMe()
                    .tokenValiditySeconds(2419200)
                    .key("fastKey")
                .and()
                .logout()
                    .logoutSuccessUrl("/")
                    .logoutUrl("/signout")
                .and()
                .authorizeRequests()
                    .antMatchers("/zaposleni").hasAnyRole("RADNIK","MENADZER")
                    .antMatchers("/zaposleni/**").hasRole("MENADZER")
                    .anyRequest().permitAll();
                
    }
 
}
