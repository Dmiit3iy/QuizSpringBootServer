package com.dmiit3iy.quizespringboot.service;

import com.dmiit3iy.quizespringboot.model.Exercise;
import com.dmiit3iy.quizespringboot.model.Gamer;

import java.util.List;

public interface ExerciseService {
    void add(Exercise exercise);

    Exercise get(long id);

    List<Exercise> get(Gamer gamer);

}
