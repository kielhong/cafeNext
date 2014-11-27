package net.kiel.cafe.service;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.transaction.Transactional;

import net.kiel.cafe.config.AppConfig;
import net.kiel.cafe.config.RepositoryConfig;
import net.kiel.cafe.vo.Cafe;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, RepositoryConfig.class})
@Transactional
public class CafeServiceTest {
    @Autowired
    private CafeService cafeService;
    
    @Test
    public void testFindAll() {
        List<Cafe> cafes = cafeService.findAll();
        
        assertThat(cafes, notNullValue());
    }
    
    @Test
    public void testFindById() {
        final Integer id = 1;
        Cafe cafe = cafeService.findById(id);
        
        assertThat(cafe, notNullValue());
    }
    
    @Test
    public void testFindByNickname() {
        final String nickname = "first";
        Cafe cafe = cafeService.findByNickname(nickname);
        
        assertThat(cafe, notNullValue());
    }

}
