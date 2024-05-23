package com.dmiit3iy.quizespringboot.service;

import com.dmiit3iy.quizespringboot.model.Answer;
import com.dmiit3iy.quizespringboot.model.Gamer;
import com.dmiit3iy.quizespringboot.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    private AnswerRepository answerRepository;

    @Autowired
    public void setAnswerRepository(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public void add(Answer answer) {
        try {
            this.answerRepository.save(answer);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Данный ответ уже добавлен!");
        }

    }

    @Override
    public Answer get(long id) {
        return this.answerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Ответа с таким Id нет"));
    }

    @Override
    public List<Answer> get(Gamer gamer) {
        return this.answerRepository.findAllByGamer(gamer);
    }
}
