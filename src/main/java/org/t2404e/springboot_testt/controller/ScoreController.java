package org.t2404e.springboot_testt.controller;

import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.t2404e.springboot_testt.entity.Score;
import org.t2404e.springboot_testt.service.ScoreService;
import org.t2404e.springboot_testt.service.StudentService;
import org.t2404e.springboot_testt.service.SubjectService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/score")
public class ScoreController {
    private final ScoreService scoreService;
    private final StudentService studentService;
    private final SubjectService subjectService;
    // Form thêm điểm
    @GetMapping("/add")
    public String addScoreForm(Model model) {
        model.addAttribute("score", new Score());
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("subjects", subjectService.getAllSubjects());
        return "add-score"; // Thymeleaf template
    }

    // Xử lý submit form
    @PostMapping("/add")
    public String addScore(
            @RequestParam Long studentId,
            @RequestParam Long subjectId,
            @RequestParam Double score1,
            @RequestParam Double score2
    ) {
        Score score = new Score();
        score.setStudent(studentService.getStudentById(studentId));
        score.setSubject(subjectService.getSubjectById(subjectId));
        score.setScore1(score1);
        score.setScore2(score2);

        scoreService.saveScore(score);
        return "redirect:/scores"; // Quay về trang hiển thị danh sách
    }
}
