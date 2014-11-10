package net.kiel.cafe.domain;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import net.kiel.cafe.domain.converter.LocalDateTimePersistenceConverter;

@Entity
@Data
public class Cafe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false)
    private String nickname;
    
    @Column(nullable = false)
    private String name;
    
    private String description;
    
    @OneToMany(mappedBy = "cafe", fetch = FetchType.EAGER, cascade={CascadeType.ALL})
    private Set<Board> boards;
    
//    @OneToMany
//    private Set<Article> articles;
    
    @Column(name = "created_at", nullable = false)
    @Convert(converter = LocalDateTimePersistenceConverter.class)
    private LocalDateTime createdAt = LocalDateTime.now(); 
}
