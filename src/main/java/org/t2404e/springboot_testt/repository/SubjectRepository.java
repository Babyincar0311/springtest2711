package org.t2404e.springboot_testt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.t2404e.springboot_testt.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
