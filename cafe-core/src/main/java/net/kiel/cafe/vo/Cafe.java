package net.kiel.cafe.vo;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

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
    private List<Board> boards = new ArrayList<Board>();
    
    @Setter
    private LocalDateTime createdAt = LocalDateTime.now();
    public Date getCreatedAt() {
        return Date.from(createdAt.atZone(ZoneId.systemDefault()).toInstant());
    }
}
