package net.kiel.cafe.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.kiel.cafe.dto.CafeMemberDto;
import net.kiel.cafe.entity.CafeMember;
import net.kiel.cafe.repository.hibernate.CafeMemberRepositoryImpl;

@Service
@Transactional
public class CafeMemberService {
    @Autowired
    private CafeMemberRepositoryImpl cafeMemberRepository;
    
    public List<CafeMemberDto> listByCafe(Integer cafeId) {
        List<CafeMemberDto> results = new ArrayList<CafeMemberDto>();
        
        List<CafeMember> cafeMemberEntities = cafeMemberRepository.selectListByCafe(cafeId);
        for (CafeMember cafeMemberEntity : cafeMemberEntities) {
            results.add(cafeMemberEntity.toCafeMemberVO());
        }
        
        return results;
    }
    
    public CafeMemberDto findCafeManager(Integer cafeId) {
        CafeMember cafeMemberEntity = cafeMemberRepository.selectCafeManager(cafeId);
        
        return cafeMemberEntity.toCafeMemberVO();
    }
}
