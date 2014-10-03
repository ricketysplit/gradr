package com.gradr.mvc;

import com.gradr.core.models.entities.Student;
import com.gradr.core.services.StudentService;
import com.gradr.rest.mvc.StudentController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by r.harkins on 10/3/2014.
 */
public class StudentControllerTest {
    @InjectMocks
    private StudentController controller;

    @Mock
    private StudentService service;

    private MockMvc mockMvc;

    private ArgumentCaptor<Student> studentCaptor;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        studentCaptor = ArgumentCaptor.forClass(Student.class);
    }

    @Test
    public void createStudentNonExisting() throws Exception {
        Student createdStudent = new Student();
        createdStudent.setId(1L);
        createdStudent.setFirstName("Ricky");
        createdStudent.setLastName("Harkins");

        when(service.createStudent(any(Student.class))).thenReturn(createdStudent);

        mockMvc.perform(post("/rest/students")
                .content("{\"firstName\":\"Ricky\",\"lastName\":\"Harkins\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(header().string("Location", endsWith("/rest/students/1")))
                .andExpect(jsonPath("$.firstName", is(createdStudent.getFirstName())))
                .andExpect(status().isCreated());

        verify(service).createStudent(studentCaptor.capture());

        String lastName = studentCaptor.getValue().getLastName();
        assertEquals("Harkins", lastName);
    }

}
