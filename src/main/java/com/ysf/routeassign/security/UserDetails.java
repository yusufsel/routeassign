package com.ysf.routeassign.security;

import com.ysf.routeassign.user.UserDAO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {

    private final UserDAO userDAO;
    public UserDetails(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.userDAO.getRole().name()));
    }

    @Override
    public String getPassword() {
        return this.userDAO.getPassword();
    }

    @Override
    public String getUsername() {
        return this.userDAO.getUsername();
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
