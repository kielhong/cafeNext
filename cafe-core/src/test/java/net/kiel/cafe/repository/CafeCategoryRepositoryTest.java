package net.kiel.cafe.repository;

import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.transaction.Transactional;

import net.kiel.cafe.CafeNextCoreApplication;
import net.kiel.cafe.entity.CafeCategoryEntity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CafeNextCoreApplication.class)
@Transactional
public class CafeCategoryRepositoryTest {
    @Autowired
    private CafeCategoryRepository cafeCategoryRepository;
    
    @Test
    public void testSelectAll() {
        List<CafeCategoryEntity> cafeCategories = cafeCategoryRepository.selectAll();
        
        assertTrue(cafeCategories.size() > 10);
    }
}
