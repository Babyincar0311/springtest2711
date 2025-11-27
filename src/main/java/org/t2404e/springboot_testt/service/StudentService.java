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

    // Lấy tất cả sinh viên
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Thêm sinh viên mới
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
    // Xóa sinh viên
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    // Lấy sinh viên theo ID
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

}
