package org.t2404e.springboot_testt.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentScoreDTO {
    private String studentCode;   // Mã sinh viên
    private String fullName;      // Tên sinh viên
    private String address;       // Địa chỉ
    private String subjectName;   // Tên môn học
    private Double score1;        // Điểm 1
    private Double score2;        // Điểm 2
    private String grade;         // Grade (A, B, D, F)
}
