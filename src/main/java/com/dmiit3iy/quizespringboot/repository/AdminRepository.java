package com.dmiit3iy.quizespringboot.repository;

import com.dmiit3iy.quizespringboot.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Long> {
}
