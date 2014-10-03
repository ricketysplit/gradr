package com.gradr.rest.resources.asm;

import com.gradr.core.models.entities.Student;
import com.gradr.rest.mvc.StudentController;
import com.gradr.rest.resources.StudentResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by r.harkins on 10/3/2014.
 */
public class StudentResourceAsm extends ResourceAssemblerSupport<Student, StudentResource>{
    public StudentResourceAsm() {
        super(StudentController.class, StudentResource.class);
    }

    @Override
    public StudentResource toResource(Student student) {
        StudentResource res = new StudentResource();
        res.setFirstName(student.getFirstName());
        res.setLastName(student.getLastName());
        res.add(linkTo(methodOn(StudentController.class).getStudent(student.getId())).withSelfRel());
        return res;
    }
}
