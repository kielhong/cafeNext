package net.kiel.cafe.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import net.kiel.cafe.api.controller.dto.CafeDto;
import net.kiel.cafe.entity.Cafe;
import net.kiel.cafe.repository.CafeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CafeCategoryController {
    @Autowired
    private CafeRepository cafeRepository;
    
    @RequestMapping(value = "/{categoryId}/cafes", method = RequestMethod.GET)
    public List<CafeDto> getAllCafeByCategory(@PathVariable Integer categoryId) {
        List<Cafe> cafes = cafeRepository.findByCategoryId(categoryId);
        
        return cafes.stream().map(CafeDto::new).collect(Collectors.toList());
    }
}
