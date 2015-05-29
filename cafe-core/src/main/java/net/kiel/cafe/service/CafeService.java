package net.kiel.cafe.service;

import net.kiel.cafe.entity.Cafe;
import net.kiel.cafe.entity.CafeCategory;
import net.kiel.cafe.entity.CafeUser;
import net.kiel.cafe.entity.User;

/**
 * Created by 1001982(kielhong@sk.com)
 * Date : 15. 5. 29.
 */
public interface CafeService {
    public Cafe findCafeWithDataByDomain(String domain);

    public Cafe createCafe(String domain, String name, CafeCategory category, String description, User user);


    public CafeUser addUser(Cafe cafe, User user);

    public void removeUser(Cafe cafe, User user);
}
