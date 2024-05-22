package com.dmiit3iy.quizespringboot.service;

import com.dmiit3iy.quizespringboot.model.Gamer;

import java.util.List;

public interface GamerService {
    void add(Gamer gamer);

    Gamer get(long id);

    List<Gamer> get();

    Gamer update(Gamer gamer);

    Gamer delete(long id);
}
