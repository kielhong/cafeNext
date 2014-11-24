package net.kiel.cafe.entity;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import net.kiel.cafe.entity.converter.LocalDateTimePersistenceConverter;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cafe")
@Data
public class CafeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false)
    private String nickname;
    
    @Column(nullable = false)
    private String name;
    
    private String description;
    
    @ManyToOne
    @JsonIgnore
    private CafeCategoryEntity category;
    
    @OneToMany(mappedBy = "cafe", cascade={CascadeType.ALL})
    private Set<BoardEntity> boards;
    
//    @OneToMany
//    private Set<Article> articles;
    
    @Column(name = "created_at", nullable = false)
    @Convert(converter = LocalDateTimePersistenceConverter.class)
    private LocalDateTime createdAt = LocalDateTime.now(); 
}
