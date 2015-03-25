package net.kiel.cafe.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import lombok.Getter;
import lombok.Setter;

@Entity
public class CafeUser {
    public CafeUser() {}
    
    public CafeUser(Cafe cafe, User user, Role role) {
        this.cafe = cafe;
        this.user = user;
        this.role = role;
    }
    
    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne
    @Getter @Setter
    private User user;
    
    @ManyToOne
    @Getter @Setter
    private Cafe cafe;

    @Enumerated(EnumType.STRING)
    @Getter @Setter
    private Role role;
    
    @Getter @Setter
    private LocalDateTime createDatetime;
    
    @PrePersist
    private void prePersisit() {
        createDatetime = LocalDateTime.now();
    }
    
    public enum Role {
        MANAGER,
        STAFF,
        USER;
    }
}
