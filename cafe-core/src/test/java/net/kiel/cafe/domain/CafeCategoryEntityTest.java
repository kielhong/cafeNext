package net.kiel.cafe.domain;

import javax.transaction.Transactional;

import net.kiel.cafe.config.RepositoryConfig;
import net.kiel.cafe.entity.CafeCategoryEntity;

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
public class CafeCategoryEntityTest {
    @Autowired
    private SessionFactory sessionFactory;
    
    private Session session;
    
    @Before
    public void setUp() {
        session = sessionFactory.getCurrentSession();
    }
    
    @Test
    public void testInsert() {
        CafeCategoryEntity category = new CafeCategoryEntity();
        category.setId(100);
        category.setName("test category");
        
        session.save(category);
    }

}