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
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import net.kiel.cafe.dto.CafeDto;
import net.kiel.cafe.entity.converter.LocalDateTimePersistenceConverter;

@Entity
@Table(name = "cafe")
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
    
    @OneToMany(mappedBy = "cafe", cascade={CascadeType.ALL})
    @OrderBy("id")
    @Getter @Setter
    private List<Board> boards;
    
    @Column(name = "created_at", nullable = false)
    @Convert(converter = LocalDateTimePersistenceConverter.class)
    @Getter @Setter
    private LocalDateTime createdAt = LocalDateTime.now(); 
    
    public CafeDto toCafeVO(boolean includeBoard) {
        CafeDto cafeVO = new CafeDto();
        
        cafeVO.setId(id);
        cafeVO.setName(name);
        cafeVO.setNickname(domain);
        cafeVO.setDescription(description);
        cafeVO.setCreatedAt(createdAt);
        if (includeBoard) {
            for (Board boardEntity : boards) {
                cafeVO.getBoards().add(boardEntity.toBoardVO());
            }
        }
        
        return cafeVO;
    }
}
