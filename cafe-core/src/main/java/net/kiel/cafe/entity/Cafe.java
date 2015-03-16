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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;
import net.kiel.cafe.entity.converter.LocalDateTimePersistenceConverter;

@Entity
@Table( 
        uniqueConstraints=
            @UniqueConstraint(columnNames={"domain"})
)
public class Cafe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;
    
    @Column(nullable = false)
    @Getter @Setter
    private String domain;
    
    @Column(nullable = false)
    @Getter @Setter
    private String name;
    
    @Lob
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
                + ", category=" + category + ", createDate=" + createDatetime + ", updateDate=" + updateDatetime + "]";
    }
    
    
}
