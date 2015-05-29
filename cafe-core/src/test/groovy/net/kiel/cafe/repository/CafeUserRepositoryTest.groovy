package net.kiel.cafe.repository

import net.kiel.cafe.CafeCoreApplication
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
class CafeUserRepositoryTest extends Specification {
    @Autowired
    CafeUserRepository cafeUserRepository
    @Autowired
    CafeRepository cafeRepository
    @Autowired
    UserRepository userRepository


    def "카페 회원 정보 가져오기"() {
        setup:
        def cafe = cafeRepository.findOne(1)
        def user = userRepository.findOne(1)

        when:
        def cafeUser = cafeUserRepository.findOneByCafeAndUser(cafe, user)

        then:
        cafeUser != null
        cafeUser.cafe == cafe
        cafeUser.user == user


    }

    def "카페 회원 여부 확인"() {
        setup:
        def cafe = cafeRepository.findOne(1)
        def user = userRepository.findOne(1)

        expect:
        cafeUserRepository.existsByCafeAndUser(cafe, user) == true
    }

    def "카페 비회원 여부 확인"() {
        setup:
        def cafe = cafeRepository.findOne(1)
        def user = userRepository.findOne(2)

        expect:
        cafeUserRepository.existsByCafeAndUser(cafe, user) == false
    }
}
