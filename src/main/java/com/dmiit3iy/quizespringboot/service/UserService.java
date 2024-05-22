package com.dmiit3iy.quizespringboot.service;

import com.dmiit3iy.quizespringboot.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    User get (long id);
    List<User> get();
    User delete(long id);
    User update(User user);
}
