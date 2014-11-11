package net.kiel.cafe.repository;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.transaction.Transactional;

import net.kiel.cafe.config.AppConfig;
import net.kiel.cafe.config.RepositoryConfig;
import net.kiel.cafe.entity.CafeEntity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, RepositoryConfig.class})
@Transactional
public class CafeRepositoryTest {
    @Autowired
    private CafeRepository cafeRepository;
    
    @Test
    public void testSelectAll() {
        List<CafeEntity> cafes = cafeRepository.selectAll();
        
        assertThat(cafes, notNullValue());
    }
    
    @Test
    public void testSelectByCategoryId() {
        final Integer categoryId = 11;
        List<CafeEntity> cafes = cafeRepository.selectByCategoryId(categoryId);
        
        assertThat(cafes, notNullValue());
        for (CafeEntity cafeEntity : cafes) {
            assertThat(cafeEntity.getCategory().getId(), is(categoryId));
        }
    }
}
