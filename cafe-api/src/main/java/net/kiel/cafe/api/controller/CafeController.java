package net.kiel.cafe.api.controller;

import java.util.List;

import net.kiel.cafe.service.CafeService;
import net.kiel.cafe.vo.CafeVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cafe")
public class CafeController {
    @Autowired
    private CafeService cafeService;
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<CafeVO> findAll() {
        List<CafeVO> cafes = cafeService.findAll();
                
        return cafes;
    }
    
    @RequestMapping(value = "/listByCategory", method = RequestMethod.GET)
    public List<CafeVO> findByCafetory(
            @RequestParam("categoryId") Integer categoryId) {
        List<CafeVO> cafes = cafeService.findByCategory(categoryId);
                
        return cafes;
    }
}
