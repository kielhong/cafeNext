package net.kiel.cafe.domain;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.transaction.Transactional;

import net.kiel.cafe.config.RepositoryConfig;

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
public class CafeTest {
    @Autowired
    private SessionFactory sessionFactory;
    
    private Session session;
    
    @Before
    public void setUp() {
        session = sessionFactory.getCurrentSession();
    }
    
    
    @Test
    public void testInsert() {
        Cafe cafe = new Cafe();
        cafe.setName("test");
        cafe.setNickname("testcafe");
        cafe.setDescription("test description");
        
        session.save(cafe);
        
        assertNotNull(cafe.getId());
    }
    
    @Test
    public void testSelectAll() {
        Cafe cafe = new Cafe();
        cafe.setName("test");
        cafe.setNickname("testcafe");
        cafe.setDescription("test description");
        
        session.save(cafe);
        
        @SuppressWarnings("unchecked")
        List<Cafe> cafes = (List<Cafe>)session.createCriteria(Cafe.class).list();
        
        assertNotNull(cafes);
    }
    
    @Test
    public void testSelectById() {
        Cafe cafe = new Cafe();
        cafe.setName("test");
        cafe.setNickname("testcafe");
        cafe.setDescription("test description");
        
        session.save(cafe);
        
        Cafe cafe2 = (Cafe)session.get(Cafe.class, cafe.getId());
        
        assertNotNull(cafe2);
    }
    
}