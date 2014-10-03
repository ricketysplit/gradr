package com.gradr.core.services.impl;

import com.gradr.core.models.entities.Student;
import com.gradr.core.repositories.StudentRepo;
import com.gradr.core.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by r.harkins on 10/3/2014.
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Student findStudent(Long studentId) {
        return studentRepo.findStudent(studentId);
    }

    @Override
    public Student createStudent(Student data) {
        return studentRepo.createStudent(data);
    }
}
