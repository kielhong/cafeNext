package net.kiel.cafe.service;

import net.kiel.cafe.entity.Cafe;
import net.kiel.cafe.entity.CafeCategory;
import net.kiel.cafe.entity.CafeUser;
import net.kiel.cafe.entity.User;
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
    
    public Cafe createCafe(String domain, String name, CafeCategory category, String description, User member) {
        Cafe cafe = new Cafe(domain, name, category, description);
        cafeRepository.save(cafe);
        
        CafeUser cafeMember = new CafeUser(cafe, member, CafeUser.Role.MANAGER);
        cafeMemberRepository.save(cafeMember);
        
        return cafe;
    }
}
