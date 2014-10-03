package com.gradr.core.services;

import com.gradr.core.models.entities.Student;

/**
 * Created by r.harkins on 10/3/2014.
 */
public interface StudentService {
    public Student findStudent(Long studentId);
    public Student createStudent(Student data);
}
