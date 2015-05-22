package net.kiel.cafe.web.controller.api;

import java.util.List;
import java.util.stream.Collectors;

import net.kiel.cafe.web.controller.api.dto.CafeDto;
import net.kiel.cafe.entity.Cafe;
import net.kiel.cafe.repository.CafeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/cafes")
public class ApiCafeController {
    @Autowired
    private CafeRepository cafeRepository;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<CafeDto> getAllCafes() {
        List<Cafe> cafes = cafeRepository.findAll();
        
        return cafes.stream().map(CafeDto::new).collect(Collectors.toList());
    }
    

}
