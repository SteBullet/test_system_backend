package com.example.demo.controller;

import com.example.demo.model.Test;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;

    @PostMapping("/{discipline_title}")
    public Test saveTest(@RequestBody Test test,
                         @PathVariable String discipline_title){
        return testService.save(test, discipline_title);
    }

    @GetMapping
    public List<Test> getAllTests(){
        return testService.findAll();
    }

    @PostMapping("/{test_name}/{visible}")
    public Test changeVisible(@PathVariable("visible") String visible,
                              @PathVariable("test_name") String test_name){
        return testService.changeVisible(test_name, visible);
    }

    @PostMapping("/passed/{test_name}/{email}")
    public Test passTest(@PathVariable("test_name") String test_name,
                         @PathVariable("email") String email){
        return testService.passTest(test_name, email);
    }

    @GetMapping("/passedOrNot/{test_name}/{email}")
    public String passedOrNot(@PathVariable("test_name") String test_name,
                              @PathVariable("email") String email){
        return testService.passedOrNot(test_name, email);
    }
}
