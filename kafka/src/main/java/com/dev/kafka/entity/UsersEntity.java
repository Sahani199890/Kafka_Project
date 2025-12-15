package com.dev.kafka.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class UsersEntity implements UserDetails {

    @Id
    private String userId;

    private String name;
    private String email;
    private String password;
    private String isAuthSignUp;
    private String provider;
    private Date date;

    public UsersEntity() {
    }

    public UsersEntity(Date date,
                       String email,
                       String isAuthSignUp,
                       String name,
                       String password,
                       String provider,
                       String userId) {
        this.date = date;
        this.email = email;
        this.isAuthSignUp = isAuthSignUp;
        this.name = name;
        this.password = password;
        this.provider = provider;
        this.userId = userId;
    }

    /* =====================
       UserDetails methods
       ===================== */

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(); // add roles later if needed
    }

    @Override
    public String getUsername() {
        return email; // IMPORTANT
    }

    @Override
    public String getPassword() {
        return password;
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

    /* =====================
       Getters & Setters
       ===================== */

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIsAuthSignUp() {
        return isAuthSignUp;
    }

    public void setIsAuthSignUp(String isAuthSignUp) {
        this.isAuthSignUp = isAuthSignUp;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
