package net.kiel.cafe.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import net.kiel.cafe.entity.CafeEntity;
import net.kiel.cafe.repository.CafeRepository;
import net.kiel.cafe.vo.Cafe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CafeService {
    @Autowired
    private CafeRepository cafeRepository;
    
    public List<Cafe> findAll() {
        List<Cafe> results = new ArrayList<Cafe>();
        
        List<CafeEntity> cafes = cafeRepository.selectAll();
        for (CafeEntity cafeEntity : cafes) {
            Cafe cafeVO = new Cafe();
            cafeVO.setId(cafeEntity.getId());
            cafeVO.setName(cafeEntity.getName());
            cafeVO.setNickname(cafeEntity.getNickname());
            cafeVO.setDescription(cafeEntity.getDescription());
            cafeVO.setCreatedAt(cafeEntity.getCreatedAt());
        }
        
        return results;
    }

    public List<Cafe> findByCategory(Integer categoryId) {
        List<Cafe> results = new ArrayList<Cafe>();
        
        List<CafeEntity> cafes = cafeRepository.selectByCategoryId(categoryId);
        
        for (CafeEntity cafeEntity : cafes) {
            Cafe cafeVO = new Cafe();
            cafeVO.setId(cafeEntity.getId());
            cafeVO.setName(cafeEntity.getName());
            cafeVO.setNickname(cafeEntity.getNickname());
            cafeVO.setDescription(cafeEntity.getDescription());
            cafeVO.setCreatedAt(cafeEntity.getCreatedAt());
            
            results.add(cafeVO);
        }
        
        return results;
    }
    
    public Cafe findById(Integer cafeId) {
        CafeEntity cafeEntity= cafeRepository.selectById(cafeId);
        
        Cafe cafeVO = new Cafe();
        cafeVO.setId(cafeEntity.getId());
        cafeVO.setName(cafeEntity.getName());
        cafeVO.setNickname(cafeEntity.getNickname());
        cafeVO.setDescription(cafeEntity.getDescription());
        cafeVO.setCreatedAt(cafeEntity.getCreatedAt());
        cafeVO.setBoards(cafeEntity.getBoards());
        
        return cafeVO;
    }
}