package net.kiel.cafe.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import net.kiel.cafe.domain.converter.LocalDateTimePersistenceConverter;

@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;
    
    @ManyToOne
    @Getter @Setter
    @JsonIgnore
    private Cafe cafe;
    
    @Column(nullable = false)
    @Getter @Setter
    private String title;
    
    @Getter @Setter
    private String description;

    @Getter @Setter
    @Column(nullable = false)
    private Type type;

    @Column(name = "created_at")
    @Getter @Setter
    @Convert(converter = LocalDateTimePersistenceConverter.class)
    private LocalDateTime createdAt = LocalDateTime.now();
    
    public enum Type {
        UNKNOWN(0),
        GENERAL(1);
        
        @Getter private final int value;
        
        Type (int value) {
            this.value = value;
        }
    }

    @Override
    public String toString() {
        return "Board [id=" + id + ", cafe.id=" + cafe.getId() + ", title=" + title + ", description=" + description + ", type="
                + type + ", createdAt=" + createdAt + "]";
    }
}
