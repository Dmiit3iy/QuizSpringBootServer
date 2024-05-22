package com.dmiit3iy.quizespringboot.controller;

import com.dmiit3iy.quizespringboot.model.Gamer;
import com.dmiit3iy.quizespringboot.model.ResponseResultTrivia;
import com.dmiit3iy.quizespringboot.model.Result;
import com.dmiit3iy.quizespringboot.service.GamerService;
import com.dmiit3iy.quizespringboot.service.ResponseResultTriviaService;

import com.dmiit3iy.quizespringboot.service.ResultService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/result")

public class ResultController {

    private static final Logger logger = LoggerFactory.getLogger(ResultController.class);
    private ResponseResultTriviaService responseResultTriviaService;
    private GamerService gamerService;

    private ResultService resultService;

    @Autowired
    public void setResultService(ResultService resultService) {
        this.resultService = resultService;
    }

    @Autowired
    public void setGamerService(GamerService gamerService) {
        this.gamerService = gamerService;
    }

    @Autowired
    public void setResponseResultService(ResponseResultTriviaService responseResultService) {
        this.responseResultTriviaService = responseResultService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseResultTrivia> get(@PathVariable("id") long id, @RequestParam String amount, @RequestParam String category,
                                                    @RequestParam String difficulty) {
        Gamer gamer = gamerService.get(id);
        ResponseResultTrivia responseResult = responseResultTriviaService.get(amount, category, difficulty);
        responseResult.setGamer(gamer);
       ResponseResultTrivia responseResultTriviaNew= responseResultTriviaService.add(responseResult);
        List<Result> list = responseResult.getResults();
        LocalDateTime ld = LocalDateTime.now();
        logger.info("Туц",ld);
        for (Result x : list) {
            logger.trace("Зашли в метод добавления");
            x.setResponseResult(responseResultTriviaNew);
            resultService.add(x);
        }

        responseResult.setGamer(gamer);
        gamerService.update(gamer);
        return new ResponseEntity<>(responseResult, HttpStatus.OK);

    }
}
