package com.sebnsab.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
            .csrf().disable()
            .headers().frameOptions().disable().and() //This is so h2-console will show up properly

            .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS).and()

            .authorizeRequests()
                //.antMatchers("/h2-console*").permitAll()
                //.antMatchers("/console**").permitAll()
                //.antMatchers("/login*").permitAll()
                //.antMatchers("/anonymous*").anonymous()

                .antMatchers("/*").permitAll() //Permit all URLS, just leave the authorization on the Service Beans @PreAuthorize.
                .anyRequest().authenticated().and()

            .formLogin()
                .permitAll();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user1").password(passwordEncoder.encode("user1Pass")).roles("USER").authorities("auth1")
                .and()
                .withUser("user2").password(passwordEncoder.encode("user2Pass")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder.encode("adminPass")).roles("ADMIN");


        //if you set both roles and authorities, the roles is ignored like for user1 above.
        //So  if you have @PreAuthorize("hasRole('USER'") it will not work for user1 because it has authorities setup
        //But it will work for user2.
    }






}
