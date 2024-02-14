package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "discipline")
public class Discipline {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "title")
    String title;

    @OneToMany(mappedBy = "discipline")
    List<Test> tests;


    @ManyToMany
    @JoinTable(name = "discipline_client",
            joinColumns = @JoinColumn(name = "discipline_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id"))
    List<Client> clients;

    @Override
    public String toString() {
        return "Discipline{" +
                "title='" + title + '\'' +
                '}';
    }
}
