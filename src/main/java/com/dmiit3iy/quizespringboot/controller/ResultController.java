package com.dmiit3iy.quizespringboot.controller;

import com.dmiit3iy.quizespringboot.model.ResponseResultTrivia;
import com.dmiit3iy.quizespringboot.service.ResponseResultTriviaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/result")

public class ResultController {
    private ResponseResultTriviaService responseResultTriviaService;

    @Autowired
    public void setResponseResultService(ResponseResultTriviaService responseResultService) {
        this.responseResultTriviaService = responseResultService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseResultTrivia> get(@PathVariable("id") long id, @RequestParam String amount, @RequestParam String category,
                                                    @RequestParam String difficulty) {
        ResponseResultTrivia responseResult = responseResultTriviaService.getWithId(id, amount, category, difficulty);
        return new ResponseEntity<>(responseResult, HttpStatus.OK);
    }
}
