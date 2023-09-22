package com.pranali.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration

public class Security extends WebSecurityConfigurerAdapter {

    @Autowired
    protected <HttpSecurity> void configure(HttpSecurity http) throws Exception {

        getHttp().httpBasic().and().authorizeRequests()

                .antMatchers(HttpMethod.GET, "/doctor/doctorappointment").hasAnyRole("DOCTOR")

                .antMatchers(HttpMethod.POST, "doctor/save").hasAnyRole("DOCTOR")

                .antMatchers(HttpMethod.POST, "/patient/save").hasAnyRole("PATIENT")

                .antMatchers(HttpMethod.GET, "/patient/myappointment").hasAnyRole("PATIENT")

                .antMatchers(HttpMethod.POST, "/saveprescription").hasAnyRole("DOCTOR")

                .antMatchers(HttpMethod.GET, "/viewprescription").hasAnyRole("DOCTOR")

                //.antMatchers(HttpMethod.POST, "/saveprescription").hasAnyRole("PATIENT")

                //.antMatchers(HttpMethod.GET, "/viewprescription").hasAnyRole("PATIENT")

                .and().csrf().disable().headers().frameOptions().disable();

    }

    @Autowired

    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication().withUser("doc123").password("{noop}password").roles("DOCTOR").

                and().withUser("pat123").password("{noop}password").roles("PATIENT");

    }





}
