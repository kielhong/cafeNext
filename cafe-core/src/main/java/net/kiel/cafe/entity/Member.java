package net.kiel.cafe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Member {
    @Id
    @GeneratedValue
    @Getter @Setter
    private Integer id;
        
    @Column(nullable = false)
    @Getter @Setter
    private String username;
    
    @Column(nullable = false)
    @Getter @Setter
    private String password;
}