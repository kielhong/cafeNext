package net.kiel.cafe.service;

import java.util.List;

import javax.transaction.Transactional;

import net.kiel.cafe.domain.Cafe;
import net.kiel.cafe.repository.CafeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CafeServiceImpl implements CafeService {
    @Autowired
    private CafeRepository cafeRepository;
    
    @Override
    public List<Cafe> listAll() {
    
        return cafeRepository.selectAll();
    }

}
