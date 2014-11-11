package net.kiel.cafe.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import net.kiel.cafe.entity.CafeCategoryEntity;
import net.kiel.cafe.repository.CafeCategoryRepository;
import net.kiel.cafe.vo.CafeCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CafeCategoryServiceImpl implements CafeCategoryService {
    @Autowired
    private CafeCategoryRepository cafeCategoryRepository;
    
    @Override
    public List<CafeCategory> findAll() {
        List<CafeCategory> results = new ArrayList<CafeCategory>();
        
        List<CafeCategoryEntity> categories = cafeCategoryRepository.selectAll();
        for(CafeCategoryEntity cafeCategoryEntity : categories) {
            CafeCategory cafeCategoryVO = new CafeCategory();
            cafeCategoryVO.setId(cafeCategoryEntity.getId());
            cafeCategoryVO.setName(cafeCategoryEntity.getName());
            results.add(cafeCategoryVO);
        }        
        
        return results;
    }

}
