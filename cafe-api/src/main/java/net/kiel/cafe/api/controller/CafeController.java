package net.kiel.cafe.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import net.kiel.cafe.api.controller.dto.CafeDto;
import net.kiel.cafe.entity.Cafe;
import net.kiel.cafe.repository.CafeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "cafe")
public class CafeController {
    @Autowired
    private CafeRepository cafeRepository;
    
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<CafeDto> getAllCafes() {
        List<Cafe> cafes = cafeRepository.findAll();
                
        return cafes.stream().map(CafeDto::new).collect(Collectors.toList());
    }
    

}
