package com.es.lepelka.controller;

import com.es.lepelka.model.User;
import com.es.lepelka.repository.UserRepository;
import com.es.lepelka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @GetMapping("/info")
    public String info(Principal principal, Model model) {
        User userById = userService.findUserById(principal.getName());
        model.addAttribute("user", userById);
        return "userInfo";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable String id) {
        userRepository.deleteById(id);

        return "redirect:/logout";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@ModelAttribute User user) {
        userRepository.save(user);

        return "redirect:/user/info";
    }
}
