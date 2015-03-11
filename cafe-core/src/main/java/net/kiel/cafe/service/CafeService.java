package net.kiel.cafe.service;

import net.kiel.cafe.entity.Cafe;
import net.kiel.cafe.repository.ArticleRepository;
import net.kiel.cafe.repository.CafeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CafeService {
    @Autowired
    private CafeRepository cafeRepository;
    
    @Autowired
    private ArticleRepository articleRepository;
    
    public Cafe findCafeWithDataByDomain(String domain) {
        Cafe cafe = cafeRepository.findByDomain(domain);
        cafe.setArticleCount(articleRepository.countByBoardCafe(cafe));
        
        return cafe;
    }
}
