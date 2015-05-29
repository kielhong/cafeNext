package net.kiel.cafe.web.controller.cafe;

import net.kiel.cafe.entity.Board;
import net.kiel.cafe.entity.Cafe;
import net.kiel.cafe.entity.CafeUser;
import net.kiel.cafe.entity.User;
import net.kiel.cafe.service.CafeService;
import net.kiel.cafe.service.CafeUserService;
import net.kiel.cafe.service.UserService;
import net.kiel.cafe.web.controller.cafe.dto.BoardDto;
import net.kiel.cafe.web.controller.cafe.dto.CafeDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Hong, Min Hyoung (kielhong@gmail.com)
 * Date : 15. 5. 29.
 */
public class CafeBaseController {
    @Autowired
    CafeService cafeService;
    @Autowired
    UserService userService;
    @Autowired
    CafeUserService cafeUserService;

    protected Map<String, Object> getCafeInfo(String domain) {
        Map<String, Object> cafeBaseAttributes = new HashMap<String, Object>();

        Cafe cafe = cafeService.findCafeWithDataByDomain(domain);
        List<Board> boards = cafe.getBoards();
        CafeUser cafeManager = cafeUserService.findCafeManager(cafe.getId());

        User user = userService.getUserByContext();
        Boolean isCafeUser = cafeUserService.isCafeUser(cafe, user);

        cafeBaseAttributes.put("cafe", new CafeDto(cafe));
        cafeBaseAttributes.put("cafeManager", cafeManager);
        cafeBaseAttributes.put("boards",boards.stream().map(BoardDto::new).collect(Collectors.toList()));
        cafeBaseAttributes.put("isCafeUser", isCafeUser);

        return cafeBaseAttributes;
    }
}
