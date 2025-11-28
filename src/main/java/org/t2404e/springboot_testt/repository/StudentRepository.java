package org.t2404e.springboot_testt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.t2404e.springboot_testt.entity.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    // Left join fetch scores để lấy luôn score nếu có
    @Query("SELECT s FROM Student s LEFT JOIN FETCH s.scores")
    List<Student> findAllWithScores();

}
