package net.kiel.cafe.service;

import net.kiel.cafe.entity.Cafe;
import net.kiel.cafe.entity.CafeUser;
import net.kiel.cafe.entity.User;

import java.util.List;

/**
 * Created by 1001982(kielhong@sk.com)
 * Date : 15. 5. 27.
 */
public interface CafeUserService {
    public List<CafeUser> findAllByCafe(Integer cafeId);

    public CafeUser findCafeManager(Integer cafeId);

    public CafeUser getCafeUser(Cafe cafe, User user);

    public Boolean isCafeUser(Cafe cafe, User user);
}
