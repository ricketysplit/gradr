package com.gradr.rest.resources;

import com.gradr.core.models.entities.Student;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by r.harkins on 10/3/2014.
 */
public class StudentResource extends ResourceSupport{
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Student toStudent() {
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        return student;
    }
}
