package com.es.lepelka.controller;

import com.es.lepelka.model.TestStat;
import com.es.lepelka.repository.TestStatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private TestStatRepository testStatRepository;

    @GetMapping
    public String showTestResults(Model model) {
        List<TestStat> testStatRepositoryAll = testStatRepository.findAll();
        model.addAttribute("results", testStatRepositoryAll);
        return "testResults";
    }
}
