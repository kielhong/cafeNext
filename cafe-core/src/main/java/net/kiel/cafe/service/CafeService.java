package net.kiel.cafe.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import net.kiel.cafe.entity.Cafe;
import net.kiel.cafe.repository.CafeRepositoryImpl;
import net.kiel.cafe.vo.CafeVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CafeService {
    @Autowired
    private CafeRepositoryImpl cafeRepository;
    
    public List<CafeVO> findAll() {
        List<CafeVO> results = new ArrayList<CafeVO>();
        
        List<Cafe> cafes = cafeRepository.selectAll();
        for (Cafe cafeEntity : cafes) {
            results.add(cafeEntity.toCafeVO(false));
        }
        
        return results;
    }

    public List<CafeVO> findByCategory(Integer categoryId) {
        List<CafeVO> results = new ArrayList<CafeVO>();
        
        List<Cafe> cafes = cafeRepository.selectByCategoryId(categoryId);
        
        for (Cafe cafeEntity : cafes) {            
            results.add(cafeEntity.toCafeVO(false));
        }
        
        return results;
    }
    

    public CafeVO findById(Integer id) {
        CafeVO cafe = cafeRepository.selectById(id).toCafeVO(true);
        
        return cafe;
    }
    
    public CafeVO findByNickname(String nickname) {
        Cafe cafe = cafeRepository.selectByNickname(nickname);
        System.out.println("nickname : " + nickname);
        //System.out.println("Cafe:" + cafe);
        
        return cafe.toCafeVO(true);
    }
}