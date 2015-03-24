package net.kiel.cafe;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class MemberRole {
    @Id
    @GeneratedValue
    @Getter @Setter
    private Long id;
    
    @Getter @Setter
    private String username;

    @Enumerated(EnumType.STRING)
    @Getter @Setter
    private Role role;
        
    public enum Role {
        ROLE_ADMIN,
        ROLE_USER;
    }
}
