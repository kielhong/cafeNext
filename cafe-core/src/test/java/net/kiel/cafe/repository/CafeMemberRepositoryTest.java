package net.kiel.cafe.repository;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.transaction.Transactional;

import net.kiel.cafe.CafeCoreApplication;
import net.kiel.cafe.entity.CafeUser;
import net.kiel.cafe.entity.CafeUser.Role;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CafeCoreApplication.class)
@Transactional
public class CafeMemberRepositoryTest {
    @Autowired
    private CafeUserRepository cafeMemberRepository;
    
    @Test
    public void testSelectByCafe() {
        final Integer cafeId = 1;
        List<CafeUser> cafeMembers = cafeMemberRepository.findByCafeId(cafeId);
        
        assertThat(cafeMembers, notNullValue());
        for (CafeUser cafeMemberEntity : cafeMembers) {
            assertThat(cafeMemberEntity.getCafe().getId(), is(cafeId));
        }
    }
    
    @Test
    public void testSelectCafeManager() {
        final Integer cafeId = 1;
        List<CafeUser> cafeMembers = cafeMemberRepository.findByCafeIdAndRole(cafeId, Role.MANAGER);
        
        CafeUser manager = cafeMembers.get(0);
        
        assertThat(manager, notNullValue());
        assertThat(manager.getCafe().getId(), is(cafeId));
        assertThat(manager.getRole(), is(Role.MANAGER));
    }

}
