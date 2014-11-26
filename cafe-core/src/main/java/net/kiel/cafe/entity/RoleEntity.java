package net.kiel.cafe.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "role")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;
    
    @ManyToOne
    @Getter @Setter
    private CafeEntity cafe;
    
    @Getter @Setter
    private Role role;    
    
    public enum Role {
        MANAGER(0),
        STAFF(1),
        MEMBER(2);
        
        @Getter private final int value;
        
        Role (int value) {
            this.value = value;
        }
    }

}
