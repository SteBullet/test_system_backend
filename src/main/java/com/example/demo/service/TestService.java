package com.example.demo.service;


import com.example.demo.model.Client;
import com.example.demo.model.Discipline;
import com.example.demo.model.Test;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.DisciplineRepository;
import com.example.demo.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestService {
    @Autowired
    private TestRepository testRepository;
    @Autowired
    private DisciplineRepository disciplineRepository;

    @Autowired
    private ClientRepository clientRepository;

    public Test save(Test test, String discipline_title){
        Discipline discipline = disciplineRepository.findByTitle(discipline_title);
        test.setDiscipline(discipline);
        return testRepository.save(test);
    }

    public Test findByTitle(String title){
        return testRepository.findByTitle(title);
    }

    public List<Test> findAll(){
        return (List<Test>) testRepository.findAll();
    }

    public Test findById(Long id){
        return testRepository.findById(id).get();
    }

    public Test changeVisible(String test_name, String visible) {
        Test test = testRepository.findByTitle(test_name);

        if (visible.equals("true")){
            test.setVisible(Boolean.TRUE);
        } else test.setVisible(Boolean.FALSE);

        return testRepository.save(test);
    }

    public Test passTest(String test_name, String email) {
        Test test = testRepository.findByTitle(test_name);
        Client client = clientRepository.findByEmail(email);
        List<Client> clients;
        if (test.getClients().isEmpty()){
            clients = new ArrayList<>();
        } else {
            clients = test.getClients();
        }
        clients.add(client);
        test.setClients(clients);
        return testRepository.save(test);
    }

    public String passedOrNot(String test_name, String email) {
        Test test = testRepository.findByTitle(test_name);
        Client client = clientRepository.findByEmail(email);
        if (test.getClients().contains(client))
            return "true";
        else return "false";
    }
}
