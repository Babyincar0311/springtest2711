package org.t2404e.springboot_testt.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentScoreDTO {
    private String studentCode;
    private String fullName;
    private String subjectName;
    private Double score1;
    private Double score2;
    private String gradeChar;
}
