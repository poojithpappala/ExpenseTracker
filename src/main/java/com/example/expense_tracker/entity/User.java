package com.example.expense_tracker.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Table(name = "users")
@Getter 
@Setter 
public class User implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String role;

    private boolean accountNonLocked = true;
    private boolean enabled = true;

    @Override 
    public Collection<? extends GrantedAuthority> getAuthorities(){
        //converts the string role into a GrantedAuthority object spring understands
        return List.of(new SimpleGrantedAuthority(this.role));
    }

    @Override 
    public String getUsername(){
        return this.email;
    }

    @Override
    public boolean isAccountNonLocked(){
        return this.accountNonLocked;
    }

}
