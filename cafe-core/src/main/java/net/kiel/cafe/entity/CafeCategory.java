package net.kiel.cafe.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cafe_category")
public class CafeCategory {
    @Id
    @Getter @Setter
    private Integer id;
    
    @Column(nullable = false)
    @Getter @Setter
    private String name;
    
    @OneToMany(mappedBy = "category")
    @Getter @Setter
    private Set<Cafe> cafes;
}
