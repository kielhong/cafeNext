package net.kiel.cafe.vo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

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
    private Set<Board> boards = new HashSet<Board>();
    
    @Getter @Setter
    private LocalDateTime createdAt = LocalDateTime.now();
    
    public String getSince() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return createdAt.format(formatter);
    }
}
