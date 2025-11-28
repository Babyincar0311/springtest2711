package org.t2404e.springboot_testt.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.t2404e.springboot_testt.DTO.StudentScoreDTO;
import org.t2404e.springboot_testt.entity.Score;
import org.t2404e.springboot_testt.entity.Student;
import org.t2404e.springboot_testt.repository.ScoreRepository;
import org.t2404e.springboot_testt.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScoreService {

    private final StudentRepository studentRepo;
    private final ScoreRepository scoreRepo; // cần để save điểm

    // Method lưu điểm
    public void saveScore(Score score) {
        scoreRepo.save(score);
    }

    // Method hiển thị tất cả sinh viên + điểm
    public List<StudentScoreDTO> getAllStudentScores() {
        List<Student> students = studentRepo.findAll();
        List<StudentScoreDTO> result = new ArrayList<>();

        for (Student student : students) {
            List<Score> scores = student.getScores(); // lấy danh sách điểm
            if (scores == null || scores.isEmpty()) {
                // Sinh viên chưa có điểm
                StudentScoreDTO dto = new StudentScoreDTO();
                dto.setStudentCode(student.getStudent_code());
                dto.setFullName(student.getFull_name());
                dto.setSubjectName("-");
                dto.setScore1(null);
                dto.setScore2(null);
                dto.setGradeChar("-");
                result.add(dto);
            } else {
                // Sinh viên có điểm
                for (Score sc : scores) {
                    StudentScoreDTO dto = new StudentScoreDTO();
                    dto.setStudentCode(student.getStudent_code());
                    dto.setFullName(student.getFull_name());
                    dto.setSubjectName(sc.getSubject().getSubject_name());
                    dto.setScore1(sc.getScore1());
                    dto.setScore2(sc.getScore2());

                    double grade = 0.3 * sc.getScore1() + 0.7 * sc.getScore2();
                    String g;
                    if (grade >= 8) g = "A";
                    else if (grade >= 6) g = "B";
                    else if (grade >= 4) g = "D";
                    else g = "F";

                    dto.setGradeChar(g);
                    result.add(dto);
                }
            }
        }

        return result;
    }
}
