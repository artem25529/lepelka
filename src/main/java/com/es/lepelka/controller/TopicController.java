package com.es.lepelka.controller;

import com.es.lepelka.model.Test;
import com.es.lepelka.model.Topic;
import com.es.lepelka.repository.TestRepository;
import com.es.lepelka.repository.TopicRepository;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/topic")
public class TopicController {
    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private TestRepository testRepository;

    @GetMapping("/{section}")
    public String findTopics(@PathVariable String section, Model model) {
        final String subsection = "theory";
        model.addAttribute("activeTab", subsection);
        model.addAttribute("section", section);
        List<Topic> topics = topicRepository.findAllBySectionAndSubsection(section, subsection);
        model.addAttribute("topics", topics);
        return "topic";
    }

    @GetMapping("/{section}/{subsection}")
    public String findTopicsBySubsection(@PathVariable String section, @PathVariable String subsection, Model model) {
        model.addAttribute("activeTab", subsection);
        model.addAttribute("section", section);

        if (subsection.equals("test")) {
            List<Test> tests = testRepository.findAllBySection(section);
            model.addAttribute("tests", tests);
        } else {
            List<Topic> topics = topicRepository.findAllBySectionAndSubsection(section, subsection);
            model.addAttribute("topics", topics);
        }

        return "topic";
    }

    @PostMapping("/add")
    public String addNewTopic(@RequestParam String section,
                              @RequestParam String subsection,
                              @RequestParam String title,
                              @RequestPart MultipartFile file) throws IOException {
        topicRepository.save(new Topic(title, section, subsection, file.getBytes()));
        return "redirect:/topic/" + section + "/" + subsection;
    }

    @GetMapping(value = "/get/{id}", produces = "application/msword")
    @ResponseBody
    public byte[] getTopic(@PathVariable Long id) {
        Topic topic = topicRepository.findById(id).get();
        return topic.getData();
    }

    @PostMapping("/delete")
    @ResponseBody
    public String deleteTopic(@RequestParam Long id) throws IOException {
        topicRepository.deleteById(id);
        return "success";
    }
}
