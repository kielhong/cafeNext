package net.kiel.cafe.domain;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.transaction.Transactional;

import net.kiel.cafe.config.RepositoryConfig;
import net.kiel.cafe.entity.CafeMemberEntity;
import net.kiel.cafe.entity.RoleEntity.Role;

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
public class CafeMemberEntityTest {
    @Autowired
    private SessionFactory sessionFactory;
    
    private Session session;
    
    @Before
    public void setUp() {
        session = sessionFactory.getCurrentSession();
    }
    
    @Test
    public void testCafeMemberRole() {
        Integer cafeId = 1;
        Integer role = Role.MANAGER.getValue();
        String query = "FROM CafeMemberEntity";
        
        @SuppressWarnings("unchecked")
        List<CafeMemberEntity> cafeMembers = session.createQuery(query)
                                .setParameter("cafeId", cafeId)
                                .setParameter("role", role)
                                .list();
        
        assertNotNull(cafeMembers);
    }

}
