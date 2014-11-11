package net.kiel.cafe.service;

import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.transaction.Transactional;

import net.kiel.cafe.config.AppConfig;
import net.kiel.cafe.config.RepositoryConfig;
import net.kiel.cafe.vo.CafeCategory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, RepositoryConfig.class})
@Transactional
public class CafeCategoryServiceTest {
    @Autowired
    private CafeCategoryService cafeCategoryService;
    
    @Test
    public void testFindAll() {
        List<CafeCategory> cafeCategories = cafeCategoryService.findAll();
        
        assertTrue(cafeCategories.size() > 10);
    }
    

}
