package com.dmiit3iy.quizespringboot.repository;

import com.dmiit3iy.quizespringboot.model.Exercise;
import com.dmiit3iy.quizespringboot.model.Gamer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    List<Exercise> findByGamer(Gamer gamer);
}
