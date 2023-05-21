package com.es.lepelka.controller;

import com.es.lepelka.model.User;
import com.es.lepelka.repository.AuthorityRepository;
import com.es.lepelka.repository.UserRepository;
import com.es.lepelka.service.UserService;
import com.es.lepelka.validator.UserValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reg")
public class UserRegController {
    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserService userService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userValidator);
    }
    @GetMapping
    public String registrationPage(Model model) {
        model.addAttribute("user", new User());
        return "reg";
    }

    @PostMapping
    public String processInput(@ModelAttribute @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "reg";
        }

        userService.registerUser(user);
        return "redirect:/";
    }
}
