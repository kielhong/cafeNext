package net.kiel.cafe.domain;

import static org.junit.Assert.assertNotNull;

import javax.transaction.Transactional;

import net.kiel.cafe.entity.Member;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {RepositoryConfig.class})
@Transactional
public class MemberTest {
    @Autowired
    private SessionFactory sessionFactory;
    
    private Session session;
    
    @Before
    public void setUp() {
        session = sessionFactory.getCurrentSession();
    }
    
    @Test
    public void testInsert() {
        Member member = new Member();
        member.setNickname("testmember");
        
        session.save(member);
        
        assertNotNull(member.getId());
    }

}
