package net.kiel.cafe.repository;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.transaction.Transactional;

import net.kiel.cafe.CafeNextCoreApplication;
import net.kiel.cafe.entity.CafeMember;
import net.kiel.cafe.entity.RoleEntity.Role;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CafeNextCoreApplication.class)
@Transactional
public class CafeMemberRepositoryTest {
    @Autowired
    private CafeMemberRepository cafeMemberRepository;
    
    @Test
    public void testSelectByCafe() {
        final Integer cafeId = 1;
        List<CafeMember> cafeMembers = cafeMemberRepository.selectListByCafe(cafeId);
        
        assertThat(cafeMembers, notNullValue());
        for (CafeMember cafeMemberEntity : cafeMembers) {
            assertThat(cafeMemberEntity.getCafe().getId(), is(cafeId));
        }
    }
    
    @Test
    public void testSelectCafeManager() {
        final Integer cafeId = 1;
        CafeMember cafeMember = cafeMemberRepository.selectCafeManager(cafeId);
        
        assertThat(cafeMember, notNullValue());
        assertThat(cafeMember.getCafe().getId(), is(cafeId));
        assertThat(cafeMember.getRole().getRole(), is(Role.MANAGER));
    }

}
