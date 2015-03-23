package net.kiel.cafe.web.controller;

import net.kiel.cafe.repository.CafeCategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cafe")
public class CafeController {
    @Autowired
    private CafeCategoryRepository categoryRepository;
    
    @RequestMapping("create")
    public String create(Model model) {
        
        model.addAttribute("categories", categoryRepository.findAll());
        return "create_cafe";
    }
}
