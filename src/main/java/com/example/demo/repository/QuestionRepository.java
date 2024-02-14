package com.example.demo.repository;


import com.example.demo.model.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
    Question findByText(String text);

    List<Question> findByTest_title(String title);
}
