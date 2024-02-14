package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "client")
public class Client {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "email")
    String email;

    @ManyToOne
    @JoinColumn(name = "role_id")
    Role role;
    @JsonIgnore
    @ManyToMany(mappedBy = "clients")
    List<Test> tests;
    @JsonIgnore
    @ManyToMany(mappedBy = "clients")
    List<Discipline> disciplines;
    @JsonIgnore
    @ManyToMany(mappedBy = "clients")
    List<Answer> answers;
}
