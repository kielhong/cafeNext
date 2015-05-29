package net.kiel.cafe.service;

import java.util.List;

import javax.transaction.Transactional;

import net.kiel.cafe.entity.Cafe;
import net.kiel.cafe.entity.CafeUser;
import net.kiel.cafe.entity.CafeUser.Role;
import net.kiel.cafe.entity.User;
import net.kiel.cafe.repository.CafeUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CafeUserServiceImpl implements CafeUserService {

    @Autowired
    private CafeUserRepository cafeUserRepository;

    public List<CafeUser> findAllByCafe(Integer cafeId) {
        List<CafeUser> results = cafeUserRepository.findByCafeId(cafeId);

        return results;
    }

    public CafeUser findCafeManager(Integer cafeId) {
        List<CafeUser> cafeMembers = cafeUserRepository.findByCafeIdAndRole(cafeId, Role.MANAGER);

        return cafeMembers.get(0);
    }

    public CafeUser getCafeUser(Cafe cafe, User user) {
        CafeUser cafeUser = cafeUserRepository.findOneByCafeAndUser(cafe, user);

        return cafeUser;
    }

    @Override
    public Boolean isCafeUser(Cafe cafe, User user) {
        Boolean isCafeUser = cafeUserRepository.existsByCafeAndUser(cafe, user);

        return isCafeUser;
    }
}
