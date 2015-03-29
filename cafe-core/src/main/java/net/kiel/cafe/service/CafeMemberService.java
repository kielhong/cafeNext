package net.kiel.cafe.service;

import java.util.List;

import javax.transaction.Transactional;

import net.kiel.cafe.entity.CafeUser;
import net.kiel.cafe.entity.CafeUser.Role;
import net.kiel.cafe.repository.CafeUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CafeMemberService {
    
    @Autowired
    private CafeUserRepository cafeMemberRepository;
    
    public List<CafeUser> findAllByCafe(Integer cafeId) {
        List<CafeUser> results = cafeMemberRepository.findByCafeId(cafeId);
        
        return results;
    }
    
    public CafeUser findCafeManager(Integer cafeId) {
        List<CafeUser> cafeMembers = cafeMemberRepository.findByCafeIdAndRole(cafeId, Role.MANAGER);
        
        
        return cafeMembers.get(0);
    }
}
