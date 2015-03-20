package net.kiel.cafe.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cafe_member")
public class CafeMember {
    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne
    @Getter @Setter
    private Member member;
    
    @ManyToOne
    @Getter @Setter
    private Cafe cafe;

    @ManyToOne
    @Getter @Setter
    private RoleEntity role;
    
    @Getter @Setter
    private LocalDateTime createDatetime;
}
