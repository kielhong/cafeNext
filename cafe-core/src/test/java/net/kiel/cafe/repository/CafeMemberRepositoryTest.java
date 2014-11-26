package net.kiel.cafe.repository;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.transaction.Transactional;

import net.kiel.cafe.config.AppConfig;
import net.kiel.cafe.config.RepositoryConfig;
import net.kiel.cafe.entity.CafeMemberEntity;
import net.kiel.cafe.entity.RoleEntity.Role;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, RepositoryConfig.class})
@Transactional
public class CafeMemberRepositoryTest {
    @Autowired
    private CafeMemberRepository cafeMemberRepository;
    
    @Test
    public void testSelectByCafe() {
        final Integer cafeId = 1;
        List<CafeMemberEntity> cafeMembers = cafeMemberRepository.selectListByCafe(cafeId);
        
        assertThat(cafeMembers, notNullValue());
        for (CafeMemberEntity cafeMemberEntity : cafeMembers) {
            assertThat(cafeMemberEntity.getCafe().getId(), is(cafeId));
        }
    }
    
    @Test
    public void testSelectCafeManager() {
        final Integer cafeId = 1;
        CafeMemberEntity cafeMember = cafeMemberRepository.selectCafeManager(cafeId);
        
        assertThat(cafeMember, notNullValue());
        assertThat(cafeMember.getCafe().getId(), is(cafeId));
        assertThat(cafeMember.getRole().getRole(), is(Role.MANAGER));
    }

}
