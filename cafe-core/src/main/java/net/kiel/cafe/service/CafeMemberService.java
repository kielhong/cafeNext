package net.kiel.cafe.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import net.kiel.cafe.entity.CafeMember;
import net.kiel.cafe.entity.RoleEntity.Role;
import net.kiel.cafe.repository.CafeMemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CafeMemberService {
    @Autowired
    private CafeMemberRepository cafeMemberRepository;
    
    public List<CafeMember> listByCafe(Integer cafeId) {
        List<CafeMember> results = new ArrayList<CafeMember>();
        
        return results;
    }
    
    public CafeMember findCafeManager(Integer cafeId) {
        List<CafeMember> cafeMembers = cafeMemberRepository.findByCafeIdAndRoleRole(cafeId, Role.MANAGER);
        
        
        return cafeMembers.get(0);
    }
}
