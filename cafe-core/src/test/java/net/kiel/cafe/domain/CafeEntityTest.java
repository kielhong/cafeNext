package net.kiel.cafe.domain;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.transaction.Transactional;

import net.kiel.cafe.config.RepositoryConfig;
import net.kiel.cafe.entity.CafeCategoryEntity;
import net.kiel.cafe.entity.CafeEntity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RepositoryConfig.class})
@Transactional
public class CafeEntityTest {
    @Autowired
    private SessionFactory sessionFactory;
    
    private Session session;
    
    @Before
    public void setUp() {
        session = sessionFactory.getCurrentSession();
    }
    
    
    @Test
    public void testInsert() {
        CafeEntity cafe = new CafeEntity();
        cafe.setName("test");
        cafe.setNickname("testcafe");
        cafe.setDescription("test description");
        cafe.setCategory((CafeCategoryEntity)session.get(CafeCategoryEntity.class, 1));
        
        session.save(cafe);
        
        assertNotNull(cafe.getId());
    }
    
    @Test
    public void testSelectAll() {
        CafeEntity cafe = new CafeEntity();
        cafe.setName("test");
        cafe.setNickname("testcafe");
        cafe.setDescription("test description");
        cafe.setCategory((CafeCategoryEntity)session.get(CafeCategoryEntity.class, 1));
        
        session.save(cafe);
        
        @SuppressWarnings("unchecked")
        List<CafeEntity> cafes = (List<CafeEntity>)session.createCriteria(CafeEntity.class).list();
        
        assertNotNull(cafes);
    }
    
    @Test
    public void testSelectById() {
        CafeEntity cafe = new CafeEntity();
        cafe.setName("test");
        cafe.setNickname("testcafe");
        cafe.setDescription("test description");
        cafe.setCategory((CafeCategoryEntity)session.get(CafeCategoryEntity.class, 1));
        
        session.save(cafe);
        
        CafeEntity cafe2 = (CafeEntity)session.get(CafeEntity.class, cafe.getId());
        
        assertNotNull(cafe2);
    }
    
}