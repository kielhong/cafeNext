package net.kiel.cafe.entity;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.transaction.Transactional;

import net.kiel.cafe.CafeCoreApplication;
import net.kiel.cafe.entity.CafeMember.Role;
import net.kiel.cafe.repository.CafeMemberRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CafeCoreApplication.class)
@Transactional
public class CafeMemberTest {
    @Autowired private CafeMemberRepository cafeMemberRepository;
    @Test
    public void testCafeMemberRole() {
        Integer cafeId = 1;
        
        List<CafeMember> cafeMembers = cafeMemberRepository.findByCafeIdAndRole(cafeId, Role.MANAGER);
        
        assertNotNull(cafeMembers);
    }

}
