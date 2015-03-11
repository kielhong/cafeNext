package net.kiel.cafe.service;

import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.transaction.Transactional;

import net.kiel.cafe.CafeNextCoreApplication;
import net.kiel.cafe.dto.CafeCategoryDto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CafeNextCoreApplication.class)
@Transactional
public class CafeCategoryServiceTest {
    @Autowired
    private CafeCategoryService cafeCategoryService;
    
    @Test
    public void testFindAll() {
        List<CafeCategoryDto> cafeCategories = cafeCategoryService.findAll();
        
        assertTrue(cafeCategories.size() > 10);
    }
    

}
