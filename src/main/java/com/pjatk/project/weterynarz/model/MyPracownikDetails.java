package com.pjatk.project.weterynarz.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MyPracownikDetails implements UserDetails {

    private String userName;
    private String password;
    private List<GrantedAuthority> authorities;

    public MyPracownikDetails(Pracownik pracownik){
        this.userName = pracownik.getLogin();
        this.password = pracownik.getHaslo();
        this.authorities = Arrays.stream(pracownik.getRola().split(","))
                .map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    public MyPracownikDetails(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public MyPracownikDetails(String userName) {
        this.userName = userName;
    }

    public MyPracownikDetails() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
