package com.example.demo.controller;

import com.example.demo.model.Client;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/role/{email}")
    public String getRole(@PathVariable String email){
        return clientService.getRole(email);
    }

    @PostMapping
    public Client save(@RequestBody Client client){
        return clientService.save(client);
    }

}
