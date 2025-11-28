package org.t2404e.springboot_testt.controller;

import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.t2404e.springboot_testt.DTO.StudentScoreDTO;
import org.t2404e.springboot_testt.service.ScoreService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DisplayController {

    private final ScoreService scoreService;

    @GetMapping("/scores")
    public String showScores(Model model) {
        List<StudentScoreDTO> list = scoreService.getAllStudentScores();
        model.addAttribute("list", list);
        return "student-scores";
    }
}
