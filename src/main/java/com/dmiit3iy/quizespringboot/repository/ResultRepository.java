package com.dmiit3iy.quizespringboot.repository;

import com.dmiit3iy.quizespringboot.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result,Long> {
}
