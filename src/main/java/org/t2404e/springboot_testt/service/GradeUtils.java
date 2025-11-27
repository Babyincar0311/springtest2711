package org.t2404e.springboot_testt.service;

public class GradeUtils {
    // Hàm tính grade từ score1 và score2
    public static String calculate(double score1, double score2) {
        double gradeValue = 0.3 * score1 + 0.7 * score2;

        if (gradeValue >= 8.0) return "A";
        if (gradeValue >= 6.0) return "B";
        if (gradeValue >= 4.0) return "D";
        return "F";
    }
}
