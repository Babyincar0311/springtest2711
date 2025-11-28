package org.t2404e.springboot_testt.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "student_score_t")
@Data

public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long student_score_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subject_id")
    private Subject subject;


    private Double score1;
    private Double score2;
}
