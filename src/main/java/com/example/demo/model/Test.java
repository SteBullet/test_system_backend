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
@Table(name = "test")
public class Test {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "title")
    String title;

    @Column(name = "visible")
    Boolean visible;

    @JsonIgnore
    @OneToMany(mappedBy = "test")
    List<Question> questions;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "test_client",
            joinColumns = @JoinColumn(name = "test_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id"))
    List<Client> clients;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "discipline_id")
    Discipline discipline;






}
