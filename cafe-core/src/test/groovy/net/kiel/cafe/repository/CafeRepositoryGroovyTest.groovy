package net.kiel.cafe.repository

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import net.kiel.cafe.CafeCoreApplication;
import net.kiel.cafe.entity.Cafe
import net.kiel.cafe.entity.CafeCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;

import spock.lang.Specification;


//http://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-testing.html#boot-features-testing-spring-boot-applications-with-spock
@ContextConfiguration(loader = SpringApplicationContextLoader.class, classes = CafeCoreApplication)
@Transactional
class CafeRepositoryGroovyTest extends Specification {
    @Autowired
    CafeRepository cafeRepository
    
    def "cafe category에 속한 카페 조회"() {
        when:
        def category = new CafeCategory();
        category.id = 1
        def cafes = cafeRepository.findByCategory(category)
        
        then:
        cafes.each {assert it.category.id == 1}
     }
    
    def "cafe domain으로 카페 조회"() {
        when:
        def nickname = "first"
        def cafe = cafeRepository.findByDomain(nickname)
        
        then:
        cafe != null
        cafe.domain == nickname
     }
    
}
