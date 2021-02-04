package com.pjatk.project.weterynarz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Qualifier("myPracownikDetailsService")
    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/cennik").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/kontakt").permitAll()
                .antMatchers("/uslugi").permitAll()
                .antMatchers("/opis").permitAll()
                .antMatchers("/bladdanychuser").permitAll()
                .antMatchers("/bladdanych").hasRole("PRACOWNIK")
                .antMatchers("/pracownik").hasRole("PRACOWNIK")
                .antMatchers("/zwierzeta").hasRole("PRACOWNIK")
                .antMatchers("/dodajUslugi").hasRole("PRACOWNIK")
                .antMatchers("/klienci").hasRole("PRACOWNIK")
                .antMatchers("/wizyty").hasRole("PRACOWNIK")
                .and().formLogin();
        http
                .logout().logoutSuccessUrl("/");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){ return NoOpPasswordEncoder.getInstance();}
}
