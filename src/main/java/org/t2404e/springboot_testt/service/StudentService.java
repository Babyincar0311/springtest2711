package org.t2404e.springboot_testt.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.t2404e.springboot_testt.entity.Student;
import org.t2404e.springboot_testt.repository.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public void save(Student student) {
        studentRepository.save(student);
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student get(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

}
