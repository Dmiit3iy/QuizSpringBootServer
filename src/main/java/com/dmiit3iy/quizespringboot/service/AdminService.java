package com.dmiit3iy.quizespringboot.service;

import com.dmiit3iy.quizespringboot.model.Admin;

import java.util.List;

public interface AdminService {
    void add(Admin admin);

    Admin get(long id);

    List<Admin> get();

    Admin update(Admin admin);

    Admin delete(long id);
}
