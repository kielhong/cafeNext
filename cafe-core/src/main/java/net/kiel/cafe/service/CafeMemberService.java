package net.kiel.cafe.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.kiel.cafe.entity.CafeMemberEntity;
import net.kiel.cafe.repository.CafeMemberRepository;
import net.kiel.cafe.vo.CafeMember;

@Service
@Transactional
public class CafeMemberService {
    @Autowired
    private CafeMemberRepository cafeMemberRepository;
    
    public List<CafeMember> listByCafe(Integer cafeId) {
        List<CafeMember> results = new ArrayList<CafeMember>();
        
        List<CafeMemberEntity> cafeMemberEntities = cafeMemberRepository.selectListByCafe(cafeId);
        for (CafeMemberEntity cafeMemberEntity : cafeMemberEntities) {
            results.add(cafeMemberEntity.toCafeMemberVO());
        }
        
        return results;
    }
    
    public CafeMember findCafeManager(Integer cafeId) {
        CafeMemberEntity cafeMemberEntity = cafeMemberRepository.selectCafeManager(cafeId);
        
        return cafeMemberEntity.toCafeMemberVO();
    }
}
