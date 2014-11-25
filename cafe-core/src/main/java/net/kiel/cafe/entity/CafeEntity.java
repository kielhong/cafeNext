package net.kiel.cafe.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import lombok.Data;
import net.kiel.cafe.entity.converter.LocalDateTimePersistenceConverter;
import net.kiel.cafe.vo.Cafe;

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
    @OrderBy("id")
    private List<BoardEntity> boards;
    
    @Column(name = "created_at", nullable = false)
    @Convert(converter = LocalDateTimePersistenceConverter.class)
    private LocalDateTime createdAt = LocalDateTime.now(); 
    
    public Cafe toCafeVO(boolean includeBoard) {
        Cafe cafeVO = new Cafe();
        
        cafeVO.setId(id);
        cafeVO.setName(name);
        cafeVO.setNickname(nickname);
        cafeVO.setDescription(description);
        cafeVO.setCreatedAt(createdAt);
        if (includeBoard) {
            for (BoardEntity boardEntity : boards) {
                cafeVO.getBoards().add(boardEntity.toBoardVO());
            }
        }
        
        return cafeVO;
    }
}
