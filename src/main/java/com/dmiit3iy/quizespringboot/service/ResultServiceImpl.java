package com.dmiit3iy.quizespringboot.service;

import com.dmiit3iy.quizespringboot.model.Result;
import com.dmiit3iy.quizespringboot.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class ResultServiceImpl implements ResultService {
    private ResultRepository resultRepository;

    @Autowired
    public void setResultRepository(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @Override
    public void add(Result result) {
        try {
            resultRepository.save(result);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Такой вопрос уже добавлен!");
        }
    }
}

