package net.kiel.cafe.service

import net.kiel.cafe.CafeCoreApplication
import net.kiel.cafe.entity.Article
import net.kiel.cafe.entity.Board
import net.kiel.cafe.entity.Cafe
import net.kiel.cafe.repository.ArticleRepository
import net.kiel.cafe.repository.BoardRepository
import net.kiel.cafe.repository.CafeRepository
import net.kiel.cafe.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import javax.transaction.Transactional

/**
 * Created by 1001982(kielhong@sk.com)
 * Date : 15. 5. 22.
 */
@ContextConfiguration(loader = SpringApplicationContextLoader.class, classes = CafeCoreApplication)
@Transactional
class ArticleServiceTest extends Specification {
    @Autowired
    ArticleService articleService
    @Autowired
    ArticleRepository articleRepository
    @Autowired
    CafeRepository cafeRepository
    @Autowired
    BoardRepository boardRepository
    @Autowired
    UserRepository userRepository

    def "게시물 작성 테스트"() {
        setup:
        def cafe = cafeRepository.findOne(1)
        def board = boardRepository.findByCafe(cafe).get(0)
        def user = userRepository.findOne(1)
        def title = "test title"
        def content = "test content"
        def articleCount = articleRepository.countByBoard(board)

        when:
        def article = articleService.create(board.id, title, content)

        then:
        article.user == user
        article.board == board
        article.title == title
        article.content == content
        articleRepository.countByBoard(board) == articleCount + 1

    }
}
