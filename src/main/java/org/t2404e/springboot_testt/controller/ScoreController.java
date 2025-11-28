package org.t2404e.springboot_testt.controller;

import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.t2404e.springboot_testt.entity.Score;
import org.t2404e.springboot_testt.entity.Student;
import org.t2404e.springboot_testt.entity.Subject;
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

    @GetMapping("/add")
    public String addScoreForm(Model model) {
        model.addAttribute("students", studentService.getAll());
        model.addAttribute("subjects", subjectService.getAllSubjects());
        return "add-score";
    }

    @PostMapping("/add")
    public String addScore(
            @RequestParam Long studentId,
            @RequestParam Long subjectId,
            @RequestParam Double score1,
            @RequestParam Double score2
    ) {
        Student s = studentService.get(studentId);
        Subject sub = subjectService.getSubjectById(subjectId);

        if (s == null || sub == null) {
            return "redirect:/score/add?error=invalid";
        }

        Score score = new Score();
        score.setStudent(s);
        score.setSubject(sub);
        score.setScore1(score1);
        score.setScore2(score2);
        scoreService.saveScore(score);
        return "redirect:/scores";
    }


}
