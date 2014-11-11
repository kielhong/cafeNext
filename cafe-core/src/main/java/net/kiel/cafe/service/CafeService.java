package net.kiel.cafe.service;

import java.util.List;

import net.kiel.cafe.vo.Cafe;

public interface CafeService {
    public List<Cafe> findAll();
    
    public List<Cafe> findByCategory(Integer categoryId);
}
