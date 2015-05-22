package net.kiel.cafe.web.controller.section;

import javax.validation.Valid;

import net.kiel.cafe.entity.Cafe;
import net.kiel.cafe.entity.User;
import net.kiel.cafe.repository.CafeCategoryRepository;
import net.kiel.cafe.service.CafeService;
import net.kiel.cafe.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("section/cafe")
public class SectionCafeController {
    @Autowired
    private CafeCategoryRepository categoryRepository;
    @Autowired
    private CafeService cafeService;
    @Autowired
    private UserService userService;
    
    
    @RequestMapping(value="create", method=RequestMethod.GET)
    public String create(Model model) {
        
        model.addAttribute("categories", categoryRepository.findAll());
        return "create_cafe";
    }
    
    @RequestMapping(value="create", method=RequestMethod.POST)
    public String create(@Valid Cafe cafe, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("errors:" + result.getFieldErrorCount());
            result.getAllErrors().stream().forEach(System.out::println);
            return "create_cafe";
        }
       
        User user = userService.getUserByContext();
        
        cafe = cafeService.createCafe(cafe.getDomain(), cafe.getName(), cafe.getCategory(), cafe.getDescription(), user);
        
        return "redirect:" + "/cafe/" + cafe.getDomain();
    }
}
