package net.kiel.cafe.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class UserRole {
    @Id
    @GeneratedValue
    @Getter @Setter
    private Long Id;
    
    @Getter @Setter
    private String username;
    
    @Getter @Setter
    private String role;
}
