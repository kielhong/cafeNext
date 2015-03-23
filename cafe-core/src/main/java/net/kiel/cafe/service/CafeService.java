package net.kiel.cafe.service;

import net.kiel.cafe.entity.Cafe;
import net.kiel.cafe.entity.CafeCategory;
import net.kiel.cafe.entity.CafeMember;
import net.kiel.cafe.entity.Member;
import net.kiel.cafe.repository.ArticleRepository;
import net.kiel.cafe.repository.CafeCategoryRepository;
import net.kiel.cafe.repository.CafeMemberRepository;
import net.kiel.cafe.repository.CafeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CafeService {
    @Autowired
    private CafeRepository cafeRepository;
    @Autowired
    private CafeCategoryRepository categoryRepository;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CafeMemberRepository cafeMemberRepository;
    
    public Cafe findCafeWithDataByDomain(String domain) {
        Cafe cafe = cafeRepository.findByDomain(domain);
        cafe.setArticleCount(articleRepository.countByBoardCafe(cafe));
        
        return cafe;
    }
    
    public Cafe createCafe(String domain, String name, Integer categoryId, String description, Member member) {
        CafeCategory category = categoryRepository.findOne(categoryId);
        Cafe cafe = new Cafe(domain, name, category, description);
        cafeRepository.save(cafe);
        
        CafeMember cafeMember = new CafeMember(cafe, member, CafeMember.Role.MANAGER);
        cafeMemberRepository.save(cafeMember);
        
        return cafe;
    }
}
