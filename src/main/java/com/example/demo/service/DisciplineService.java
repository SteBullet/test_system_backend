package com.example.demo.service;

import com.example.demo.model.Client;
import com.example.demo.model.Discipline;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DisciplineService {
    @Autowired
    private DisciplineRepository disciplineRepository;
    @Autowired
    private ClientRepository clientRepository;
    public Discipline save(Discipline discipline){
        return disciplineRepository.save(discipline);
    }
    public List<Discipline> findAll(){
        return (List<Discipline>) disciplineRepository.findAll();
    }
    public Discipline addClient(String disc_title, String email){
        Client client = clientRepository.findByEmail(email);
        Discipline discipline = disciplineRepository.findByTitle(disc_title);
        List<Client> clients = discipline.getClients().isEmpty() ? new ArrayList<>() : discipline.getClients();
        clients.add(client);
        discipline.setClients(clients);
        return disciplineRepository.save(discipline);
    }
    public List<Discipline> findMyDisc(String email){
        Client client = clientRepository.findByEmail(email);
        return client.getDisciplines();
    }
}
