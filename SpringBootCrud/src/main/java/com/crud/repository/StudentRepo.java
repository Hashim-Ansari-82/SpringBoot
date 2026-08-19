package com.crud.repository;

import com.crud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student, Integer> {

    Optional<Student> findByIdAndDeletedFalse(Integer id);

    List<Student> findByDeletedFalse();
}