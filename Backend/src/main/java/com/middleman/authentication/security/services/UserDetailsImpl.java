package com.middleman.authentication.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.middleman.authentication.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * UserDetailsImpl implements UserDetails to integrate with Spring Security.
 */
public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    private String id;
    private String email;

    @JsonIgnore // Prevents password from being exposed in API responses
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    /**
     * Constructor to initialize user details.
     */
    public UserDetailsImpl(String id, String email, String password,
                           Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    /**
     * Converts a `User` entity into `UserDetailsImpl`.
     */
    public static UserDetailsImpl build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole().name()))
                .collect(Collectors.toList());

        return new UserDetailsImpl(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                authorities);
    }

    /**
     * Returns the authorities (roles) assigned to the user.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    /**
     * Returns the user ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the email of the user (Used as the unique identifier).
     */
    @Override
    public String getUsername() {
        return email; // Since username is not present, we use email instead
    }

    /**
     * Returns the encrypted password.
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Indicates whether the account is expired (Always true).
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indicates whether the account is locked (Always true).
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indicates whether the credentials (password) are expired (Always true).
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is enabled (Always true).
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     * Compares two UserDetailsImpl objects by ID.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(id, user.id);
    }
}
