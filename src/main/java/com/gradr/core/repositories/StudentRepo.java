package com.gradr.core.repositories;

import com.gradr.core.models.entities.Student;

import java.util.List;

/**
 * Created by r.harkins on 10/3/2014.
 */
public interface StudentRepo {
    public List<Student> findAllStudents();
    public Student findStudent(Long studentId);
    public Student createStudent(Student data);
}
