package net.kiel.cafe.web.controller.cafe;

import lombok.extern.slf4j.Slf4j;
import net.kiel.cafe.entity.Board;
import net.kiel.cafe.entity.Cafe;
import net.kiel.cafe.entity.CafeUser;
import net.kiel.cafe.entity.User;
import net.kiel.cafe.service.CafeService;
import net.kiel.cafe.service.CafeServiceImpl;
import net.kiel.cafe.service.CafeUserService;
import net.kiel.cafe.service.UserService;
import net.kiel.cafe.web.controller.cafe.dto.BoardDto;
import net.kiel.cafe.web.controller.cafe.dto.CafeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by 1001982(kielhong@sk.com)
 * Date : 15. 5. 27.
 */
@Controller
@RequestMapping("{domain}/users")
@Slf4j
public class CafeUserController {
    @Autowired
    CafeService cafeService;
    @Autowired
    UserService userService;
    @Autowired
    CafeUserService cafeUserService;

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String newCafeUser(
            @PathVariable String domain,
            Model model) {
        Cafe cafe = cafeService.findCafeWithDataByDomain(domain);

        model.addAllAttributes(getCafeInfo(domain));

        return "cafe_user_new";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String createCafeUser(
            @PathVariable String domain,
            Model model) {
        Cafe cafe = cafeService.findCafeWithDataByDomain(domain);
        User user = userService.getUserByContext();

        cafeService.addUser(cafe, user);

        return "redirect:/" + cafe.getDomain();
    }


    private Map<String, Object> getCafeInfo(String domain) {
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
