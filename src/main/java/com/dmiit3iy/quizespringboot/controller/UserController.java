package com.dmiit3iy.quizespringboot.controller;

import com.dmiit3iy.quizespringboot.DTO.ResponseResult;
import com.dmiit3iy.quizespringboot.model.Admin;
import com.dmiit3iy.quizespringboot.model.Gamer;
import com.dmiit3iy.quizespringboot.model.User;
import com.dmiit3iy.quizespringboot.service.AdminService;
import com.dmiit3iy.quizespringboot.service.GamerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private GamerService gamerService;
    private AdminService adminService;

    @Autowired
    public void setGamerService(GamerService gamerService) {
        this.gamerService = gamerService;
    }

    @PostMapping("/gamers")
    public ResponseEntity<ResponseResult<User>> add(@RequestParam("login") String login, @RequestParam("password") String password,
                                                    @RequestParam("firstName") String firstName, @RequestParam("surname") String surname) {
        try {
            Gamer gamer = new Gamer(login, password, firstName, surname);
            this.gamerService.add(gamer);
            return new ResponseEntity<>(new ResponseResult<>(gamer, null), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(new ResponseResult<>(null, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/admin")
    public ResponseEntity<ResponseResult<User>> add(@RequestBody Admin admin) {
        try {
            this.adminService.add(admin);
            return new ResponseEntity<>(new ResponseResult<>(admin, null), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(new ResponseResult<>(null, e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }
}
