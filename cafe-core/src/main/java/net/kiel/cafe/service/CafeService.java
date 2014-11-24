package net.kiel.cafe.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import net.kiel.cafe.entity.BoardEntity;
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
    
    private Cafe findBy(CafeEntity cafeEntity) {       
        Cafe cafeVO = new Cafe();
        
        if (cafeEntity == null) {
            return cafeVO; 
        }
        
        
        cafeVO.setId(cafeEntity.getId());
        cafeVO.setName(cafeEntity.getName());
        cafeVO.setNickname(cafeEntity.getNickname());
        cafeVO.setDescription(cafeEntity.getDescription());
        cafeVO.setCreatedAt(cafeEntity.getCreatedAt());
        for (BoardEntity boardEntity : cafeEntity.getBoards()) {
            cafeVO.getBoards().add(boardEntity.toBoard());
        }
        
        return cafeVO;
    }
    public Cafe findById(Integer id) {
        Cafe cafe = findBy(cafeRepository.selectById(id));
        
        return cafe;
    }
    
    public Cafe findByNickname(String nickname) {
        Cafe cafe = findBy(cafeRepository.selectByNickname(nickname));
        
        return cafe;
    }
    
    
}