package com.gradr.rest.mvc;

import com.gradr.core.models.entities.Student;
import com.gradr.core.services.StudentService;
import com.gradr.rest.resources.StudentResource;
import com.gradr.rest.resources.asm.StudentResourceAsm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.URI;
import java.util.NoSuchElementException;

/**
 * Created by r.harkins on 10/3/2014.
 */
@Controller
@RequestMapping("/rest/students")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<StudentResource> createStudent(
            @RequestBody StudentResource sentStudent
    ) {
        try {
            Student createdStudent = studentService.createStudent(sentStudent.toStudent());
            StudentResource res = new StudentResourceAsm().toResource(createdStudent);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(res.getLink("self").getHref()));
            return new ResponseEntity<StudentResource>(res, headers, HttpStatus.CREATED);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @RequestMapping(value = "/{studentId}", method = RequestMethod.GET)
    public ResponseEntity<StudentResource> getStudent(
            @PathVariable Long studentId
    ) {
        Student student = studentService.findStudent(studentId);
        if(student != null) {
            StudentResource res = new StudentResourceAsm().toResource(student);
            return new ResponseEntity<StudentResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<StudentResource>(HttpStatus.NOT_FOUND);
        }
    }
}
