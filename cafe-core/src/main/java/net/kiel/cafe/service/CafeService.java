package net.kiel.cafe.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import net.kiel.cafe.dto.CafeDto;
import net.kiel.cafe.entity.Cafe;
import net.kiel.cafe.repository.CafeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CafeService {
    @Autowired
    private CafeRepository cafeRepository;
    
    public List<CafeDto> findAll() {
        List<CafeDto> results = new ArrayList<CafeDto>();
        
        List<Cafe> cafes = cafeRepository.findAll();
        for (Cafe cafeEntity : cafes) {
            results.add(cafeEntity.toCafeVO(false));
        }
        
        return results;
    }

    public List<CafeDto> findByCategory(Integer categoryId) {
        List<CafeDto> results = new ArrayList<CafeDto>();
        
        List<Cafe> cafes = cafeRepository.findByCategoryId(categoryId);
        
        for (Cafe cafeEntity : cafes) {            
            results.add(cafeEntity.toCafeVO(false));
        }
        
        return results;
    }
    

    public CafeDto findById(Integer id) {
        CafeDto cafe = cafeRepository.findOne(id).toCafeVO(true);
        
        return cafe;
    }
    
    public CafeDto findByNickname(String domain) {
        Cafe cafe = cafeRepository.findByDomain(domain);
        System.out.println("nickname : " + domain);
        //System.out.println("Cafe:" + cafe);
        
        return cafe.toCafeVO(true);
    }
}