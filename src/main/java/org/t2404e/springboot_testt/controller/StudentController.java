package org.t2404e.springboot_testt.controller;

import org.springframework.ui.Model;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.t2404e.springboot_testt.entity.Student;
import org.t2404e.springboot_testt.service.StudentService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("student", new Student());
        return "add-student";
    }

    @PostMapping("/add")
    public String save(
            @RequestParam String student_code,
            @RequestParam String full_name,
            @RequestParam String address
    ) {
        Student s = new Student();
        s.setStudent_code(student_code);
        s.setFull_name(full_name);
        s.setAddress(address);
        studentService.save(s);
        return "redirect:/scores";
    }

}
