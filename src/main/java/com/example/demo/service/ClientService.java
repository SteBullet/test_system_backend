package com.example.demo.service;

import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private RoleRepository roleRepository;

    public Client save(Client client){
        client.setRole(roleRepository.findByTitle("STUDENT"));
        return clientRepository.save(client);
    }

    public String getRole(String email){
        return clientRepository.findByEmail(email).getRole().getTitle();
    }
}
