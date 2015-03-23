package net.kiel.cafe.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cafe_member")
public class CafeMember {
    public CafeMember() {}
    
    public CafeMember(Cafe cafe, Member member, Role role) {
        this.cafe = cafe;
        this.member = member;
        this.role = role;
    }
    
    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne
    @Getter @Setter
    private Member member;
    
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
        MEMBER;
    }
}
