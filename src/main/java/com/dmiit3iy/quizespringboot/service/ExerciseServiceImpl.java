package com.dmiit3iy.quizespringboot.service;

import com.dmiit3iy.quizespringboot.model.Exercise;
import com.dmiit3iy.quizespringboot.model.Gamer;
import com.dmiit3iy.quizespringboot.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService {
    private ExerciseRepository exerciseRepository;

    @Autowired
    public void setExerciseRepository(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public void add(Exercise exercise) {
        try {
            exerciseRepository.save(exercise);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Ошибка запроса");
        }
    }

    @Override
    public Exercise get(long id) {
        return exerciseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Заданий с таким Id не было"));
    }

    @Override
    public List<Exercise> get(Gamer gamer) {
        return exerciseRepository.findByGamer(gamer);
    }
}
