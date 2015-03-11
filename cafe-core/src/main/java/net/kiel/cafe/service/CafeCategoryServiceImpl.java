package net.kiel.cafe.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import net.kiel.cafe.dto.CafeCategoryDto;
import net.kiel.cafe.entity.CafeCategory;
import net.kiel.cafe.repository.CafeCategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CafeCategoryServiceImpl implements CafeCategoryService {
    @Autowired
    private CafeCategoryRepository cafeCategoryRepository;
    
    @Override
    public List<CafeCategoryDto> findAll() {
        List<CafeCategoryDto> results = new ArrayList<CafeCategoryDto>();
        
        List<CafeCategory> categories = cafeCategoryRepository.findAll();
        for(CafeCategory cafeCategoryEntity : categories) {
            CafeCategoryDto cafeCategoryVO = new CafeCategoryDto();
            cafeCategoryVO.setId(cafeCategoryEntity.getId());
            cafeCategoryVO.setName(cafeCategoryEntity.getName());
            results.add(cafeCategoryVO);
        }        
        
        return results;
    }

}
