package net.kiel.cafe.service;

import net.kiel.cafe.entity.Cafe;
import net.kiel.cafe.entity.CafeCategory;
import net.kiel.cafe.entity.CafeUser;
import net.kiel.cafe.entity.User;
import net.kiel.cafe.repository.ArticleRepository;
import net.kiel.cafe.repository.CafeCategoryRepository;
import net.kiel.cafe.repository.CafeUserRepository;
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
    private CafeUserRepository cafeUserRepository;
    
    public Cafe findCafeWithDataByDomain(String domain) {
        Cafe cafe = cafeRepository.findByDomain(domain);
        cafe.setArticleCount(articleRepository.countByBoardCafe(cafe));
        
        return cafe;
    }
    
    public Cafe createCafe(String domain, String name, CafeCategory category, String description, User user) {
        Cafe cafe = new Cafe(domain, name, category, description);
        cafeRepository.save(cafe);
        
        CafeUser cafeuser = new CafeUser(cafe, user, CafeUser.Role.MANAGER);
        cafeUserRepository.save(cafeuser);
        
        return cafe;
    }
}
