package net.kiel.cafe.api.controller;

import java.util.List;

import net.kiel.cafe.domain.Cafe;
import net.kiel.cafe.service.CafeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cafe")
public class CafeController {
    @Autowired
    private CafeService cafeService;
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Cafe> findAll() {
        List<Cafe> cafes = cafeService.listAll();
                
        return cafes;
    }
}
