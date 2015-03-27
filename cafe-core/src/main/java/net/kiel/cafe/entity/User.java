package net.kiel.cafe.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
public class User implements UserDetails {
    public User() {}
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    @Id
    @GeneratedValue
    @Getter @Setter
    private Integer id;
        
    @Column(nullable = false, unique = true)
    @Getter @Setter
    private String username;
    
    @Column(nullable = false)
    @Getter @Setter
    private String password;
    
    @Getter @Setter
    private Boolean enabled;
    
    
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return authorities;
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
        return this.enabled;
    }
}