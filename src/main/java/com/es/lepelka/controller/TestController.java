package com.es.lepelka.controller;

import com.es.lepelka.model.QuestionResult;
import com.es.lepelka.model.Test;
import com.es.lepelka.model.TestResult;
import com.es.lepelka.model.TestStat;
import com.es.lepelka.repository.TestRepository;
import com.es.lepelka.repository.TestStatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestRepository testRepository;

    @Autowired
    private TestStatRepository testStatRepository;

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm");

    @PostMapping("/save")
    @ResponseBody
    public String saveTest(@RequestBody Test test) {
        testRepository.save(test);
        return "seccess";
    }

    @PostMapping("/delete")
    @ResponseBody
    public String deleteTest(@RequestParam Long id) {
        testRepository.deleteById(id);
        return "seccess";
    }

    @GetMapping("/{id}")
    public String getTest(@PathVariable Long id, Model model) {
        Test test = testRepository.findById(id).get();
        model.addAttribute("test", test);
        return "test";
    }

    @PostMapping("/process")
    public String processTest(@RequestParam Map<String, String> results, Model model, Principal principal) {
        Test test = testRepository.findById(Long.valueOf(results.get("testId"))).get();
        int questionsQty = test.getQuestions().size();
        int rightAnswers = 0;

        model.addAttribute("test", test);

        List<QuestionResult> errors = new ArrayList<>();


        List<String> answers = results.keySet().stream().filter(k -> !k.equals("testId")).toList();

        for (int i = 0; i < test.getQuestions().size(); i++) {
            if (test.getQuestions().get(i).getRightAnswer() != Integer.parseInt(results.get(answers.get(i)))) {
                errors.add(new QuestionResult(i + 1, test.getQuestions().get(i).getRightAnswer(), Integer.parseInt(results.get(answers.get(i)))));
            } else {
                rightAnswers++;
            }
        }

        testStatRepository.save(new TestStat(dateFormat.format(new Date()),test.getName(), "" + rightAnswers + '/' + questionsQty, principal.getName()));

        model.addAttribute("testResult", new TestResult(questionsQty, rightAnswers, errors));
        return "test";
    }
}
