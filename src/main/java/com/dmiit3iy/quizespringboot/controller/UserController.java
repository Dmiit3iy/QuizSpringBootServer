package com.dmiit3iy.quizespringboot.controller;

import com.dmiit3iy.quizespringboot.DTO.ResponseResult;
import com.dmiit3iy.quizespringboot.model.Gamer;
import com.dmiit3iy.quizespringboot.model.User;
import com.dmiit3iy.quizespringboot.service.GamerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private GamerService gamerService;

    @Autowired
    public void setGamerService(GamerService gamerService) {
        this.gamerService = gamerService;
    }

    @PostMapping("/gamer")
    public ResponseEntity<ResponseResult<User>> add(@RequestBody Gamer gamer) {
        try {
            this.gamerService.add(gamer);
            return new ResponseEntity<>(new ResponseResult<>(gamer, null), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(new ResponseResult<>(null, e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }
}
