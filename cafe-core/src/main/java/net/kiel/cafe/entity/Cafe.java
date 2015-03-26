package net.kiel.cafe.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import net.kiel.cafe.entity.converter.LocalDateTimePersistenceConverter;

@Entity
public class Cafe {
    public Cafe() {}
    
    public Cafe(String domain, String name, CafeCategory category, String description) {
        this.domain = domain;
        this.name = name;
        this.category = category;
        this.description = description;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;
    
    @Column(nullable = false, length=20, unique = true)
    @NotNull
    @Size(max=20)
    @Getter @Setter
    private String domain;
    
    @Column(nullable = false, length=60)
    @NotNull
    @Size(max=60)
    @Getter @Setter
    private String name;
    
    @Column(length=100)
    @Size(max=100)
    @Getter @Setter
    private String description;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @Getter @Setter
    private CafeCategory category;
    
    @OneToMany(mappedBy = "cafe", cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
    @OrderBy("id")
    @Getter @Setter
    private List<Board> boards;
    
    @Transient
    @Getter @Setter
    private Long articleCount;
    
    @Column(nullable = false)
    @Convert(converter = LocalDateTimePersistenceConverter.class)
    @Getter @Setter
    private LocalDateTime createDatetime;
    
    @Column(nullable = false)
    @Convert(converter = LocalDateTimePersistenceConverter.class)
    @Getter @Setter
    private LocalDateTime updateDatetime;

    @PrePersist 
    private void prePersist() {
        createDatetime = LocalDateTime.now();
        updateDatetime = LocalDateTime.now();
    }
    
    @PreUpdate
    private void preUpdate() {
        updateDatetime = LocalDateTime.now();
    }
    
    @Override
    public String toString() {
        return "Cafe [id=" + id + ", domain=" + domain + ", name=" + name + ", description=" + description
                + ", category=" + category + ", createDatetime=" + createDatetime + ", updateDatetime=" + updateDatetime + "]";
    }
    
    
}
