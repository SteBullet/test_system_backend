package com.example.demo.service;


import com.example.demo.model.Question;
import com.example.demo.model.Test;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    TestRepository testRepository;

    public Question save(Question question, String test_name){
        Test test = testRepository.findByTitle(test_name);
        question.setTest(test);
        return questionRepository.save(question);
    }
    public List<Question> findByTest(String test_title){
        return questionRepository.findByTest_title(test_title);
    }
}
