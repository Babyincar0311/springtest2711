package org.t2404e.springboot_testt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.t2404e.springboot_testt.entity.Score;

public interface ScoreRepository extends JpaRepository<Score,Long> {
}
