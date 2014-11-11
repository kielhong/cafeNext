package net.kiel.cafe.repository;

import java.util.List;

import net.kiel.cafe.entity.CafeEntity;

public interface CafeRepository {
    public List<CafeEntity> selectAll();
    
    public List<CafeEntity> selectByCategoryId(Integer categoryId);
}
