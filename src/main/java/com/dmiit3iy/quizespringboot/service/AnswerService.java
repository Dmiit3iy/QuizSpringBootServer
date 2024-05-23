package com.dmiit3iy.quizespringboot.service;

import com.dmiit3iy.quizespringboot.model.Answer;
import com.dmiit3iy.quizespringboot.model.Gamer;

import java.util.List;

public interface AnswerService {
    void add(Answer answer);
    Answer get(long id);
    List<Answer> get(Gamer gamer);
}
