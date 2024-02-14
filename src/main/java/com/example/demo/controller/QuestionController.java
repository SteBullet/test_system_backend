package com.example.demo.controller;

import com.example.demo.model.Question;
import com.example.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @PostMapping("/{test_name}")
    public Question save(@RequestBody Question question,
                         @PathVariable("test_name") String test_name){
        return questionService.save(question, test_name);
    }

    @GetMapping("/{test_name}")
    public List<Question> findQuestionsFromTest(@PathVariable("test_name") String test_name){
        return questionService.findByTest(test_name);
    }
}
