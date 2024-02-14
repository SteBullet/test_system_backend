package com.example.demo.controller;

import com.example.demo.model.Client;
import com.example.demo.model.Discipline;
import com.example.demo.service.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discipline")
public class DisciplineController {
    @Autowired
    private DisciplineService disciplineService;
    @PostMapping
    public Discipline save(@RequestBody Discipline discipline){
        return disciplineService.save(discipline);
    }
    @GetMapping
    public List<Discipline> allDisc(){
        return disciplineService.findAll();
    }
    @PostMapping("/{disc_title}/{email}")
    public Discipline addClientToDisc(@PathVariable String disc_title,
                                      @PathVariable String email){
        return disciplineService.addClient(disc_title, email);
    }
    @GetMapping("/{email}")
    public List<Discipline> getMyDisc(@PathVariable String email){
        return disciplineService.findMyDisc(email);
    }
}
