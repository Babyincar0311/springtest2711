package org.t2404e.springboot_testt.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.t2404e.springboot_testt.entity.Subject;
import org.t2404e.springboot_testt.repository.SubjectRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService {
    private final SubjectRepository subjectRepository;

    // Lấy tất cả môn học
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    // Lấy môn học theo ID
    public Subject getSubjectById(Long id) {  // ✅ Long
        return subjectRepository.findById(id).orElse(null);
    }
}


