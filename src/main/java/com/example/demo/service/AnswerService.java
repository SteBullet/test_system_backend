package com.example.demo.service;

import com.example.demo.model.Answer;
import com.example.demo.model.Client;
import com.example.demo.model.Question;
import com.example.demo.model.Test;
import com.example.demo.repository.AnswerRepository;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnswerService {
    @Autowired
    AnswerRepository answerRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    TestRepository testRepository;

    public List<Answer> findMyAnswers(String test_name, String email){
        Client innerClient = clientRepository.findByEmail(email);
        Test test = testRepository.findByTitle(test_name);
        List<Question> questions = test.getQuestions();
        List<Answer> answers = new ArrayList<>();
        for (Question q : questions){
            answers.addAll(q.getAnswers());
        };
        return answers.stream()
                .filter(answer -> answer.getClients()
                        .stream()
                        .anyMatch(client -> client.equals(innerClient))
                ).toList();
    }

    public List<Answer> findAnswers(String test_name){
        Test test = testRepository.findByTitle(test_name);
        List<Question> questions = test.getQuestions();
        List<Answer> answers = new ArrayList<>();
        for (Question q : questions){
            answers.addAll(q.getAnswers());
        }
        return answers;
    }

    public Answer save(Answer answer, String question_text) {
        answer.setQuestion(questionRepository.findByText(question_text));
        return answerRepository.save(answer);
    }

    public Answer addClientToAnswer(String email, String answer_text){
        Answer answer = answerRepository.findByText(answer_text);
        Client client = clientRepository.findByEmail(email);
        List<Client> clients = answer.getClients().isEmpty() ? new ArrayList<>() : answer.getClients();
        clients.add(client);
        answer.setClients(clients);
        return answerRepository.save(answer);
    }
}
