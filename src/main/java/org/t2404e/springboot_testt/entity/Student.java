package org.t2404e.springboot_testt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;

import java.util.List;


@Entity
@Table(name = "student_t")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long student_id;

    @Column(nullable = false)
    private String student_code;

    @Column(nullable = false)
    private String full_name;

    private String address;
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<Score> scores;

}