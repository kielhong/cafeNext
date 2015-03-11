package net.kiel.cafe.web.controller;

import java.util.List;

import net.kiel.cafe.entity.CafeCategory;
import net.kiel.cafe.repository.CafeCategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
    @Autowired
    private CafeCategoryRepository cafeCategoryRepository;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        List<CafeCategory> categories = cafeCategoryRepository.findAll();
        
        model.addAttribute("categories", categories);
        
        return "index";
    }

}
