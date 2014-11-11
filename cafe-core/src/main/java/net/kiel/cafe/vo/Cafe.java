package net.kiel.cafe.vo;

import java.time.LocalDateTime;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import net.kiel.cafe.entity.Board;

public class Cafe {
    @Getter @Setter
    private Integer id;
    
    @Getter @Setter
    private String nickname;
    
    @Getter @Setter
    private String name;
    
    @Getter @Setter
    private String description;
    
    @Getter @Setter
    private Set<Board> boards;
    
    @Getter @Setter
    private LocalDateTime createdAt; 
}
