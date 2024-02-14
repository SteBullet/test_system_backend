package com.example.demo.controller;


import com.example.demo.model.Answer;
import com.example.demo.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answer")
public class AnswerController {
    @Autowired
    AnswerService answerService;

    @PostMapping("/{question_text}")
    public Answer save(@PathVariable("question_text") String question_text,
                       @RequestBody Answer answer){
        return answerService.save(answer, question_text);
    }

    @PostMapping("/{email}/{answer_text}")
    public Answer addAnswerFromClient(@PathVariable("email") String email,
                                      @PathVariable("answer_text") String answer_text){
        return answerService.addClientToAnswer(email, answer_text);
    }

    @GetMapping("/{test_name}/{email}")
    public List<Answer> getMyAnswers(@PathVariable("test_name") String test_name,
                                     @PathVariable("email") String email){
        return answerService.findMyAnswers(test_name, email);
    }

    @GetMapping("/{test_name}")
    public List<Answer> getAnswersFromTest(@PathVariable("test_name") String test_name){
        return answerService.findAnswers(test_name);
    }
}
