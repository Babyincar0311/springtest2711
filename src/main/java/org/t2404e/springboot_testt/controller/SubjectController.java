package org.t2404e.springboot_testt.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.t2404e.springboot_testt.entity.Subject;
import org.t2404e.springboot_testt.service.SubjectService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/subject")
public class SubjectController {

    private final SubjectService subjectService;

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("subject", new Subject());
        return "add-subject";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute Subject subject) {
        subjectService.save(subject);
        return "redirect:/score/add";
    }
}
