package net.kiel.cafe.api.controller.dto;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import net.kiel.cafe.dto.BoardDto;
import net.kiel.cafe.entity.Cafe;

public class CafeDto {
    private Cafe cafe;
    
    public CafeDto(Cafe cafe) {
        this.cafe = cafe;
    }
    
    public Integer getId() {
        return cafe.getId();
    }
    
    public String getDomain() {
        return cafe.getDomain();
    }
    
    public String getName() {
        return cafe.getName();
    }
    
    public String getDescription() {
        return cafe.getDescription();
    }
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date getCreatedDate() {
        return Date.from(cafe.getCreatedAt().atZone(ZoneId.systemDefault()).toInstant());
    }
    
//    private LocalDateTime createdAt = LocalDateTime.now();
//    public Date getCreatedAt() {
//        return Date.from(createdAt.atZone(ZoneId.systemDefault()).toInstant());
//    }
}
