package com.example.demo.repository;

import com.example.demo.model.Discipline;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplineRepository extends CrudRepository<Discipline, Long> {
    Discipline findByTitle(String title);
}
