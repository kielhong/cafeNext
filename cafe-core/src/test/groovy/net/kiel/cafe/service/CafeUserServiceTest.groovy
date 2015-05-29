package net.kiel.cafe.service

import net.kiel.cafe.CafeCoreApplication
import net.kiel.cafe.repository.CafeRepository
import net.kiel.cafe.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import javax.transaction.Transactional

/**
 * Created by 1001982(kielhong@sk.com)
 * Date : 15. 5. 27.
 */
@ContextConfiguration(loader = SpringApplicationContextLoader.class, classes = CafeCoreApplication)
@Transactional
class CafeUserServiceTest extends Specification {
    @Autowired
    CafeUserService cafeUserService
    @Autowired
    CafeRepository cafeRepository
    @Autowired
    UserRepository userRepository


    def "카페 회원의 정보 가져오기"() {
        setup:
        def cafe = cafeRepository.findOne(1)
        def user = userRepository.findOne(1)

        when:
        def cafeUser = cafeUserService.getCafeUser(cafe, user)

        then:
        cafeUser.cafe == cafe
        cafeUser.user == user
    }

    def "카페 비회원 정보 처리"() {
        setup:
        def cafe = cafeRepository.findOne(1)
        def user = userRepository.findOne(2)

        when:
        def cafeUser = cafeUserService.getCafeUser(cafe, user)

        then:
        cafeUser == null
    }

}
