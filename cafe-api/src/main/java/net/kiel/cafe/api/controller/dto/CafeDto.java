package net.kiel.cafe.api.controller.dto;

import java.time.LocalDateTime;

import net.kiel.cafe.entity.Cafe;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

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
    
    @JsonSerialize(using=LocalDateTimeSerializer.class)
    public LocalDateTime getCreateDatetime() {
        return cafe.getCreateDatetime();
    }
    
    @JsonSerialize(using=LocalDateTimeSerializer.class)
    public LocalDateTime getUpdateDatetime() {
        
        return cafe.getUpdateDatetime();
    }
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
//    public Date getCreatedDate() {
//        return Date.from(cafe.getCreatedAt().atZone(ZoneId.systemDefault()).toInstant());
//    }
}
