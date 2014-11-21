package net.kiel.cafe.web.controller;

import net.kiel.cafe.service.CafeService;
import net.kiel.cafe.vo.Cafe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CafeController {
    @Autowired
    private CafeService cafeService;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        
        return "index";
    }
    
    @RequestMapping(value = "/{cafeId}", method = RequestMethod.GET)
    public String findById(
            @PathVariable Integer cafeId,
            Model model) {
        
        Cafe cafe = cafeService.findById(cafeId);
        model.addAttribute("cafe", cafe);
        
        return "cafe";
    }
    

}
