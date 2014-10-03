package com.gradr.core.repositories.jpa;

import com.gradr.core.models.entities.Student;
import com.gradr.core.repositories.StudentRepo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by r.harkins on 10/3/2014.
 */
@Repository
public class JpaStudentRepo implements StudentRepo{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Student> findAllStudents() {
        Query query = em.createQuery("SELECT a FROM Account a");
        return query.getResultList();
    }

    @Override
    public Student findStudent(Long studentId) {
        return em.find(Student.class, studentId);
    }

    @Override
    public Student createStudent(Student data) {
        em.persist(data);
        return data;
    }
}
