package com.dmiit3iy.quizespringboot.repository;

import com.dmiit3iy.quizespringboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
