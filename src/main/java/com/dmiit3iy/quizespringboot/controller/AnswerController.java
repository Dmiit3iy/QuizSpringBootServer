package com.dmiit3iy.quizespringboot.controller;

import com.dmiit3iy.quizespringboot.DTO.ResponseResult;
import com.dmiit3iy.quizespringboot.model.Answer;
import com.dmiit3iy.quizespringboot.model.Gamer;
import com.dmiit3iy.quizespringboot.model.Result;
import com.dmiit3iy.quizespringboot.service.AnswerService;
import com.dmiit3iy.quizespringboot.service.GamerService;
import com.dmiit3iy.quizespringboot.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answer")
public class AnswerController {
    private AnswerService answerService;
    private GamerService gamerService;

    @Autowired
    public void setGamerService(GamerService gamerService) {
        this.gamerService = gamerService;
    }

    @Autowired
    public void setAnswerService(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping("/{idResult}")
    public ResponseEntity<ResponseResult<Answer>> post(@PathVariable("idResult") long idResult, @RequestParam("answer") String answer) {
        try {
            Answer ans = answerService.add(idResult, answer);
            return new ResponseEntity<>(new ResponseResult(ans, null), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(new ResponseResult<>(null, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{idGamer}")
    public ResponseEntity<ResponseResult<List<Answer>>> get(@PathVariable("idGamer") long idGamer) {
        try {
            Gamer gamer = gamerService.get(idGamer);
            List<Answer> list = answerService.get(gamer);
            return new ResponseEntity<>(new ResponseResult<>(list, null), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(new ResponseResult<>(null, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
