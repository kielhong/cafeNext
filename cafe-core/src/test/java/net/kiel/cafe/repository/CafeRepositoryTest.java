package net.kiel.cafe.repository;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.transaction.Transactional;

import net.kiel.cafe.CafeCoreApplication;
import net.kiel.cafe.entity.Cafe;
import net.kiel.cafe.entity.CafeCategory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CafeCoreApplication.class)
@Transactional
public class CafeRepositoryTest {
    @Autowired
    private CafeRepository cafeRepository;
    
    @Test
    public void testSelectAll() {
        List<Cafe> cafes = cafeRepository.findAll();
        
        assertThat(cafes, notNullValue());
        assertTrue("Cafe list shoud have more than 0", cafes.size() > 0);
    }
    
    @Test
    public void testSelectByCategoryId() {
        final Integer categoryId = 1;
        CafeCategory category = new CafeCategory();
        category.setId(categoryId);
        List<Cafe> cafes = cafeRepository.findByCategory(category);
        
        assertThat(cafes, notNullValue());
        for (Cafe cafeEntity : cafes) {
            assertThat(cafeEntity.getCategory().getId(), is(categoryId));
        }
    }
    
    @Test
    public void testSelectByNickname() {
        final String nickname = "first";
        Cafe cafe = cafeRepository.findByDomain(nickname);
        
        assertThat(cafe, notNullValue());
        assertThat(cafe.getDomain(), is(nickname));
    }
}
