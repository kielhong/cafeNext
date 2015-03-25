package net.kiel.cafe.web.controller;

import javax.validation.Valid;

import net.kiel.cafe.entity.Cafe;
import net.kiel.cafe.entity.User;
import net.kiel.cafe.repository.CafeCategoryRepository;
import net.kiel.cafe.repository.MemberRepository;
import net.kiel.cafe.service.CafeService;
import net.kiel.cafe.web.controller.form.CafeForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("cafe")
public class CafeController {
    @Autowired
    private CafeCategoryRepository categoryRepository;
    @Autowired
    private CafeService cafeService;
    @Autowired
    private MemberRepository memberRepository;
    
    
    @RequestMapping(value="create", method=RequestMethod.GET)
    public String create(Model model) {
        
        model.addAttribute("categories", categoryRepository.findAll());
        return "create_cafe";
    }
    
    @RequestMapping(value="create", method=RequestMethod.POST)
    public String create(@Valid CafeForm form, BindingResult bindingResults) {
        if (bindingResults.hasErrors()) {
            System.out.println("errors:" + bindingResults.getFieldErrorCount());
            bindingResults.getAllErrors().stream().forEach(System.out::println);
            return "create_cafe";
        }
        
        System.out.println("domain:" + form.getDomain());
        // TODO : sercurity 
        User member = memberRepository.findOne(1);
        
        Cafe cafe = cafeService.createCafe(form.getDomain(), form.getName(), form.getCategoryId(), form.getDescription(), member);
        
        return "redirect:" + "http://localhost:8081/" + cafe.getDomain();
    }
}
