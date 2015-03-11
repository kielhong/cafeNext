package net.kiel.cafe.api.controller.dto;

import java.time.ZoneId;
import java.util.Date;

import net.kiel.cafe.entity.Cafe;

import com.fasterxml.jackson.annotation.JsonFormat;

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
}
