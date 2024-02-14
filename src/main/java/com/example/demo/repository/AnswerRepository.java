package com.example.demo.repository;


import com.example.demo.model.Answer;
import com.example.demo.model.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {
    List<Answer> findByQuestion(Question question);

    Answer findByText(String text);
}
