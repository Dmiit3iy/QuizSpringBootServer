package com.dmiit3iy.quizespringboot.repository;

import com.dmiit3iy.quizespringboot.model.Gamer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GamerRepository extends JpaRepository<Gamer,Long> {
}
