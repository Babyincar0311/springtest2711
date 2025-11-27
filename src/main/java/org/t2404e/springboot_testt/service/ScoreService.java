package org.t2404e.springboot_testt.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.t2404e.springboot_testt.DTO.StudentScoreDTO;
import org.t2404e.springboot_testt.entity.Score;
import org.t2404e.springboot_testt.repository.ScoreRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScoreService {
    private final ScoreRepository scoreRepository;

    // Lấy tất cả điểm sinh viên + tính grade
    public List<StudentScoreDTO> getAllStudentScores() {
        List<Score> scores = scoreRepository.findAll();

        return scores.stream().map(score -> {
            String grade = GradeUtils.calculate(score.getScore1(), score.getScore2());
            return new StudentScoreDTO(
                    score.getStudent().getStudentCode(),
                    score.getStudent().getFullName(),
                    score.getStudent().getAddress(),
                    score.getSubject().getSubjectName(),
                    score.getScore1(),
                    score.getScore2(),
                    grade
            );
        }).toList();
    }

    // Thêm điểm mới
    public Score saveScore(Score score) {
        return scoreRepository.save(score);
    }
}
