package com.dmiit3iy.quizespringboot.repository;

import com.dmiit3iy.quizespringboot.model.Answer;
import com.dmiit3iy.quizespringboot.model.Gamer;
import com.dmiit3iy.quizespringboot.model.ResponseResultTrivia;
import com.dmiit3iy.quizespringboot.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    Answer findByResult(Result result);
    List<Answer> findAllByGamer(Gamer gamer);
    List<Answer> findAllByGamerAndGamer_ResponseResults (Gamer gamer, ResponseResultTrivia responseResult);
}
